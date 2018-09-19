package com.ypacm.user.model.responsebody;
/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
public class BaseResponse {
    public static final int OK = 0;
    public static final int ERROR = -1;

    private int code;
    private String message;

    public BaseResponse(int code) {
        this.code = code;
        this.message = "";
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
