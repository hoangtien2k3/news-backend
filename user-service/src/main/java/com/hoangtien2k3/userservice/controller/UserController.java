package com.hoangtien2k3.userservice.controller;

import com.hoangtien2k3.userservice.constant.Constants;
import com.hoangtien2k3.userservice.dto.request.UserCreationRequest;
import com.hoangtien2k3.userservice.dto.request.UserUpdateRequest;
import com.hoangtien2k3.userservice.dto.response.ApiResponse;
import com.hoangtien2k3.userservice.dto.response.IntrospectResponse;
import com.hoangtien2k3.userservice.dto.response.UserResponse;
import com.hoangtien2k3.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService userService;

    @PostMapping({"/signup", "/register"})
    private ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest userCreationRequest) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        log.info("USER-SERVICE: {}", userService);

        apiResponse.setMessage(Constants.SUCCESS);
        apiResponse.setData(userService.createRequest(userCreationRequest));

        return apiResponse;
    }

    @GetMapping
    private ApiResponse<List<UserResponse>> getAllUser() {

        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info("Role: {}", grantedAuthority.getAuthority()));

        return ApiResponse.<List<UserResponse>>builder()
                .code(HttpStatus.OK.value())
                .message(Constants.SUCCESS)
                .data(userService.getAllUser())
                .build();
    }

    @GetMapping("/{id}")
    private ApiResponse<UserResponse> getUserById(@PathVariable("id") Long id) {
        return ApiResponse.<UserResponse>builder()
                .code(HttpStatus.OK.value())
                .message(Constants.SUCCESS)
                .data(userService.getUserById(id))
                .build();
    }

    @GetMapping("/myInfo")
    private ApiResponse<UserResponse> getUserMyInfo() {
        return ApiResponse.<UserResponse>builder()
                .code(HttpStatus.OK.value())
                .message(Constants.SUCCESS)
                .data(userService.getUserMyInfo())
                .build();
    }

    @PutMapping("/{id}")
    private ApiResponse<UserResponse> updateUser(@RequestBody UserUpdateRequest userUpdateRequest,
                                    @PathVariable("id") Long id) {
        return ApiResponse.<UserResponse>builder()
                .code(HttpStatus.OK.value())
                .message(Constants.SUCCESS)
                .data(userService.updateUser(userUpdateRequest, id))
                .build();
    }

    @DeleteMapping("/{id}")
    private ApiResponse<IntrospectResponse> deleteUserById(@PathVariable("id") Long id) {
        var result = userService.deleteUserById(id);
        HttpStatus httpStatus = result.isValid() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        String message = result.isValid() ? Constants.SUCCESS : Constants.FAILED;

       return ApiResponse.<IntrospectResponse>builder()
                .code(httpStatus.value())
                .message(message)
                .data(result)
                .build();
    }

}
