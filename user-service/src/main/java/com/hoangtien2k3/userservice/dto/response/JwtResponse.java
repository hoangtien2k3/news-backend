package com.hoangtien2k3.userservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String name;
    private String username;
    private String email;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String token, Long id, String name, String username, String email, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.roles = authorities;
    }
}
