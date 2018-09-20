package com.ypacm.user.net.error;

import com.ypacm.user.net.response.RSData;

public class UserException extends Exception {
    private int code = RSData.SystemError.DATA_ERROR;
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
