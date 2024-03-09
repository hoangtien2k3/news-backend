package com.hoangtien2k3.userservice.service;

import com.hoangtien2k3.userservice.dto.request.ChangePasswordRequest;
import com.hoangtien2k3.userservice.dto.request.SignInForm;
import com.hoangtien2k3.userservice.dto.request.SignUpFrom;
import com.hoangtien2k3.userservice.dto.response.JwtResponse;
import com.hoangtien2k3.userservice.dto.response.ResponseMessge;
import com.hoangtien2k3.userservice.entity.User;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface IUserService {
    ResponseMessge register(SignUpFrom signUpFrom);
    JwtResponse login(SignInForm signInForm);
    Optional<User> findByUsername(String name);
    Optional<User> findByEmail(String email);
    String changePassword(ChangePasswordRequest request);
    User update(Long userId, SignUpFrom update);
    String delete(Long id);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User save(User user);
}
