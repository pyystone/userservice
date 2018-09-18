package com.ypacm.user.data.requestbody;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

@ApiModel(description = "用户注册")
public class UserRegister {

    @ApiModelProperty(required = true,value = "注册邮箱")
    @NotNull(message = "邮箱不能为空")
    @Email(message = "请输入正确的邮箱")
    private String email;


    @ApiModelProperty(required = true,value = "注册密码")
    @NotNull(message = "密码不能为空")
    private String password;


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
}
