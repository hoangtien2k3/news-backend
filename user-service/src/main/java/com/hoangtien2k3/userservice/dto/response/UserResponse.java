package com.hoangtien2k3.userservice.dto.response;

import com.hoangtien2k3.userservice.entity.Timestamps;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    String name;
    String username;
    String email;
    Set<String> roles;
    Timestamps timestamps;
}
