package com.hoangtien2k3.userservice.configuration;

import com.hoangtien2k3.userservice.entity.Timestamps;
import com.hoangtien2k3.userservice.entity.User;
import com.hoangtien2k3.userservice.enums.Role;
import com.hoangtien2k3.userservice.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.HashSet;

@Slf4j
@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository repository) {
        return args -> {
            if (repository.findByUsername("admin").isEmpty()) {
                var role = new HashSet<String>();
                role.add(Role.ADMIN.name());

                User user = User.builder()
                        .name("ADMIN")
                        .username("admin")
                        .email("admin@gmail.com")
                        .password(passwordEncoder.encode("admin"))
                        .roles(role)
                        .timestamps(Timestamps.builder()
                                .created_at(LocalDateTime.now())
                                .updated_at(LocalDateTime.now())
                                .build())
                        .build();

                repository.save(user);

                log.warn("admin user has bean create with default password: admin, please change it");
            }
        };
    }

}
