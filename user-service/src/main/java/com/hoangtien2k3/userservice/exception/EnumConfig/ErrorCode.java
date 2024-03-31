package com.hoangtien2k3.userservice.exception.EnumConfig;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_EXISTED(409, "User existed, please again", HttpStatus.CONFLICT),
    NOT_FOUND(404, "Not Found", HttpStatus.NOT_FOUND),
    INVALID_KEY(1001, "Invalid message key", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
    USERNAME_INVALID(400, "Username must be at least 3 character", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(400, "Password must be at least 8 character", HttpStatus.BAD_REQUEST),
    USER_NOT_EXITSTED(404, "User not exitsted", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(401, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(403, "Access Deny: You do not permission", HttpStatus.FORBIDDEN),
    DATABASE_ERROR(1001, "Database error occurred", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}
