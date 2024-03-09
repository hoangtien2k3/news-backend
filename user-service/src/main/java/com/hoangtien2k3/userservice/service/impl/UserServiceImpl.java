package com.hoangtien2k3.userservice.service.impl;

import com.hoangtien2k3.userservice.dto.request.ChangePasswordRequest;
import com.hoangtien2k3.userservice.dto.request.SignInForm;
import com.hoangtien2k3.userservice.dto.request.SignUpFrom;
import com.hoangtien2k3.userservice.dto.response.JwtResponse;
import com.hoangtien2k3.userservice.dto.response.ResponseMessge;
import com.hoangtien2k3.userservice.entity.Role;
import com.hoangtien2k3.userservice.entity.RoleName;
import com.hoangtien2k3.userservice.entity.User;
import com.hoangtien2k3.userservice.exception.wrapper.EmailOrUsernameNotFoundException;
import com.hoangtien2k3.userservice.exception.wrapper.PasswordNotFoundException;
import com.hoangtien2k3.userservice.exception.wrapper.UserNotFoundException;
import com.hoangtien2k3.userservice.repository.IUserRepository;
import com.hoangtien2k3.userservice.security.jwt.JwtProvider;
import com.hoangtien2k3.userservice.security.userprinciple.UserDetailService;
import com.hoangtien2k3.userservice.security.userprinciple.UserPrinciple;
import com.hoangtien2k3.userservice.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final RoleServiceImpl roleService;
    private final UserDetailService userDetailsService;
    private final JwtProvider jwtProvider;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, RoleServiceImpl roleService, UserDetailService userDetailsService, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.userDetailsService = userDetailsService;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public ResponseMessge register(SignUpFrom signUpFrom) {
        if (existsByUsername(signUpFrom.getUsername())) {
            return new ResponseMessge("Username thực sự đã tồn tại, hãy thử lại.");
        }
        if (existsByEmail(signUpFrom.getEmail())) {
            return new ResponseMessge("Email thực sự đã tồn tại, hãy thử lại.");
        }

        User user = User.builder()
                .name(signUpFrom.getName())
                .username(signUpFrom.getUsername())
                .email(signUpFrom.getEmail())
                .password(passwordEncoder.encode(signUpFrom.getPassword()))
                .build();

        Set<String> strRoles = signUpFrom.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin": case "Admin": case "ADMIN": {
                    Role adminRole = roleService
                            .findByName(RoleName.ADMIN)
                            .orElseThrow(() -> new RuntimeException("Không tìm thấy quyền"));
                    roles.add(adminRole);
                    break;
                }
                case "user": case "USER": case "User": {
                    Role userRole = roleService
                            .findByName(RoleName.USER)
                            .orElseThrow(() -> new RuntimeException("Không tìm thấy quyền"));
                    roles.add(userRole);
                    break;
                }
                default: {

                }
            }
        });

        user.setRoles(roles);
        save(user);

        return new ResponseMessge("Tạo tài khoản user thành công.");
    }

    @Override
    public JwtResponse login(SignInForm signInForm) {
        String usernameOrEmail = signInForm.getUsername();
        boolean isEmail = usernameOrEmail.contains("@gmail.com");

        UserDetails userDetails;
        if (isEmail) {
            userDetails = userDetailsService.loadUserByEmail(usernameOrEmail);
        } else {
            userDetails = userDetailsService.loadUserByUsername(usernameOrEmail);
        }
        if (userDetails == null) {
            throw new UserNotFoundException("User không tồn tại.");
        }
        if (!passwordEncoder.matches(signInForm.getPassword(), userDetails.getPassword())) {
            throw new PasswordNotFoundException("Mật khẩu không chính xác.");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                signInForm.getPassword(),
                userDetails.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) userDetails;

        return new JwtResponse(token, userPrinciple.getId(), userPrinciple.getName(), userPrinciple.getUsername(), userPrinciple.getEmail(), userPrinciple.getAuthorities());
    }


    @Override
    public Optional<User> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    @Override
    public String changePassword(ChangePasswordRequest request) {
        try {
            UserDetails userDetails = getCurrentUserDetails();
            String username = userDetails.getUsername();
            User existingUser = findByUsername(username)
                    .orElseThrow(() -> new UserNotFoundException("Không tìm thấy user với username " + username));

            if (passwordEncoder.matches(request.getOldPassword(), userDetails.getPassword())) {
                if (validateNewPassword(request.getNewPassword(), request.getConfirmPassword())) {
                    existingUser.setPassword(passwordEncoder.encode(request.getNewPassword()));
                    userRepository.save(existingUser);
                }

                return "Mật khẩu thay đổi sai.";
            } else {
                return "Sai mật khẩu đăng nhập.";
            }
        } catch (Exception e) {
            return "Thay đổi âm thầm quay trở lại";
        }
    }

    @Transactional
    @Override
    public User update(Long userId, SignUpFrom update) {
        try {
            User existingUser = userRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("User không tìm thấy với userId: " + userId + " để cập nhật"));

            modelMapper.map(update, existingUser);
            existingUser.setPassword(passwordEncoder.encode(update.getPassword()));

            return userRepository.save(existingUser);
        } catch (Exception e) {
            throw new UserNotFoundException("Lỗi khi cập nhật lại với userId: " + userId, e);
        }
    }

    @Override
    public String delete(Long id) {
        userRepository.findById(id)
                .ifPresentOrElse(
                        user -> {
                            try {
                                userRepository.delete(user);
                            } catch (DataAccessException e) {
                                throw new RuntimeException("Lỗi khi xoá User với userId: " + id, e);
                            }
                        },
                        () -> {
                            throw new UserNotFoundException("User không tìm thấy userId: " + id);
                        }
                );
        return "User với id: " + id + " xoá thành công.";
    }

    private UserDetails getCurrentUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
            return (UserDetails) authentication.getPrincipal();
        } else {
            throw new UserNotFoundException("User không được cấp quyền");
        }
    }

    private boolean validateNewPassword(String newPassword, String confirmPassword) {
        return Objects.equals(newPassword, confirmPassword);
    }


    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public UserDetails loadUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailOrUsernameNotFoundException("Email hoặc Username đã tồn tại, hãy thử lại: " + email));

        return UserPrinciple.build(user);
    }

    @Transactional
    public UserDetails loadUserByPhone(String phone) {
        User user = userRepository.findByEmail(phone)
                .orElseThrow(() -> new EmailOrUsernameNotFoundException("User not found, phone and password: " + phone));

        return UserPrinciple.build(user);
    }

}
