package com.ypacm.user.error;

public class ErrorInfo {
    public static final Integer OK = 0;
    public static final Integer ERROR = -1;

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
