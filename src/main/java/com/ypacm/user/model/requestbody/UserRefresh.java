package com.ypacm.user.model.requestbody;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(description = "Token刷新")
public class UserRefresh  {

    @ApiModelProperty(required = true, value = "用户id")
    @NotNull(message = "输入信息错误")
    private Long userId;

    @ApiModelProperty(required = true, value = "用户token")
    @NotNull(message = "输入信息错误")
    private String token;

    @ApiModelProperty(required = true, value = "用户refreshtoken")
    @NotNull(message = "输入信息错误")
    private String refreshToken;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
