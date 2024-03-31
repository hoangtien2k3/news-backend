package com.hoangtien2k3.userservice.exception.payload;

import com.hoangtien2k3.userservice.exception.EnumConfig.ErrorCode;
import lombok.Getter;

@Getter
public class AppException extends RuntimeException{

    private final ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
