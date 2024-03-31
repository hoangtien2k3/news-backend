package com.hoangtien2k3.userservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(Include.NON_NULL)
public class ApiResponse<T> {
    int code = 200;
    String message;
    T data;

    public static <T> ApiResponse<T> defaultResponse() {
        return ApiResponse.<T>builder()
                .code(200) // Set default code to 200
                .build();
    }
}
