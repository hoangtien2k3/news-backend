package com.hoangtien2k3.userservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    String name;
    @Size(min = 3, message = "USERNAME_INVALID")
    String username;
    @Email
    String email;
    @Size(min = 8, message = "PASSWORD_INVALID")
    String password;
    Set<String> roles;
}
