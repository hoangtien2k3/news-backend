package com.hoangtien2k3.userservice.service;

import com.hoangtien2k3.userservice.dto.request.UserCreationRequest;
import com.hoangtien2k3.userservice.dto.request.UserUpdateRequest;
import com.hoangtien2k3.userservice.dto.response.IntrospectResponse;
import com.hoangtien2k3.userservice.dto.response.UserResponse;
import com.hoangtien2k3.userservice.entity.Timestamps;
import com.hoangtien2k3.userservice.entity.User;
import com.hoangtien2k3.userservice.enums.Role;
import com.hoangtien2k3.userservice.exception.EnumConfig.ErrorCode;
import com.hoangtien2k3.userservice.exception.payload.AppException;
import com.hoangtien2k3.userservice.mapper.UserMapper;
import com.hoangtien2k3.userservice.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public UserResponse createRequest(UserCreationRequest userCreationRequest) {
        if (userRepository.existsByUsername(userCreationRequest.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = userMapper.toUser(userCreationRequest);
        user.setPassword(passwordEncoder.encode(userCreationRequest.getPassword()));

        HashSet<String> role = new HashSet<>();
        role.add(Role.USER.name());

        user.setRoles(role);
        user.setTimestamps(Timestamps.builder()
                .created_at(LocalDateTime.now())
                .updated_at(LocalDateTime.now())
                .build());

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getAllUser() {
        log.info("In method get User");

        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    public UserResponse getUserMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));

        return userMapper.toUserResponse(user);
    }

    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse getUserById(Long id) {
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND)));
    }

    public UserResponse updateUser(UserUpdateRequest userUpdateRequest, Long id) {
        User currentUser = userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));

        LocalDateTime create_at = currentUser.getTimestamps().getCreated_at();

        log.info("Name: {}", currentUser.getName());
        log.info("Password: {}", currentUser.getPassword());
        log.info("Email: {}", currentUser.getEmail());

        userMapper.updateUser(currentUser, userUpdateRequest);
        currentUser.setPassword(passwordEncoder.encode(userUpdateRequest.getPassword()));
        currentUser.setTimestamps(Timestamps.builder()
                        .created_at(create_at)
                        .updated_at(LocalDateTime.now())
                .build());

        log.info("Name1: {}", userUpdateRequest.getName());
        log.info("Password1: {}", userUpdateRequest.getPassword());
        log.info("Email1: {}", userUpdateRequest.getEmail());

        return userMapper.toUserResponse(userRepository.save(currentUser));
    }

    @Modifying
    public IntrospectResponse deleteUserById(Long id) {
        try {
            User currentUser = userRepository.findById(id)
                    .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));

            if (currentUser != null) {
                userRepository.deleteById(id);
                return IntrospectResponse.builder().valid(true).build();
            } else {
                throw new AppException(ErrorCode.NOT_FOUND);
            }

        } catch (DataAccessException exception) {
            throw new AppException(ErrorCode.DATABASE_ERROR);
        }
    }

}
