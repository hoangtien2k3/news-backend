package com.hoangtien2k3.userservice.controller;

import com.hoangtien2k3.userservice.dto.request.ChangePasswordRequest;
import com.hoangtien2k3.userservice.dto.request.SignInForm;
import com.hoangtien2k3.userservice.dto.request.SignUpFrom;
import com.hoangtien2k3.userservice.dto.response.JwtResponse;
import com.hoangtien2k3.userservice.dto.response.ResponseMessge;
import com.hoangtien2k3.userservice.entity.User;
import com.hoangtien2k3.userservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/signingoogle")
    public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        if (oAuth2AuthenticationToken != null) {
            return oAuth2AuthenticationToken.getPrincipal().getAttributes();
        } else {
            // Xử lý khi oAuth2AuthenticationToken là null
            return Collections.emptyMap();
        }
    }

    @GetMapping("/user")
    public String getUser(@AuthenticationPrincipal OAuth2User principal) {
        return "Welcome, " + principal.getAttribute("name") + "!";
    }

    @PostMapping({"/signup", "/register"})
    public ResponseEntity<ResponseMessge> register(@Valid @RequestBody SignUpFrom signUpFrom) {
        return new ResponseEntity<>(userService.register(signUpFrom), HttpStatus.OK);
    }

    @PostMapping({"/signin", "/login"})
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody SignInForm signInForm) {
        return ResponseEntity.ok(userService.login(signInForm));
    }

    @PutMapping("update/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody SignUpFrom update) {
        return userService.update(id, update);
    }

    @PutMapping("/changePassword")
    public String changePassword(@RequestBody ChangePasswordRequest request) {
        return userService.changePassword(request);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }

}
