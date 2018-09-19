package com.ypacm.user.data.requestbody;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
@ApiModel(description = "用户登录")
public class UserLogin {

    @ApiModelProperty(required = true, value = "登录邮箱")
    @NotNull(message = "输入信息错误")
    @Email(message = "输入信息错误")
    private String email;

    @ApiModelProperty(required = true, value = "登录密码 加密策略 MD5(MD5(用户密码)+ts+r)")
    @NotNull(message = "输入信息错误")
    private String password;

    @ApiModelProperty(required = true, value = "当前时间戳")
    @NotNull(message = "输入信息错误")
    private String ts;

    @ApiModelProperty(required = true, value = "随机10位数字")
    @NotNull(message = "输入信息错误")
    private String r;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }
}
