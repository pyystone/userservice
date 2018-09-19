package com.ypacm.user.model.responsebody;

/**
 * 登录接口返回的model
 */
public class LoginResponse extends BaseResponse {
    public LoginResponse(String token, String refreshToken) {
        super(BaseResponse.OK, "");
        this.token = token;
        this.refreshToken = refreshToken;
    }
    private String token;
    private String refreshToken;
}
