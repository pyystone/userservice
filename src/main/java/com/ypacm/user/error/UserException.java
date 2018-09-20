package com.ypacm.user.error;

import com.ypacm.user.model.responsebody.RSData;

public class UserException extends Exception {
    private long code = RSData.ERROR;
    private String message;

    public UserException(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public UserException(String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
