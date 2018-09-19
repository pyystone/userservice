package com.ypacm.user.error;

import com.ypacm.user.model.responsebody.BaseResponse;

public class UserException extends Exception {
    private int code = BaseResponse.ERROR;
    private String message;

    public UserException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public UserException(String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
