package com.ypacm.user.net.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;
/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
@ApiModel(description = "用户注册")
public class RQRegister {

    @ApiModelProperty(required = true,value = "注册邮箱")
    @NotNull(message = "邮箱不能为空")
    @Email(message = "请输入正确的邮箱")
    private String email;


    @ApiModelProperty(required = true,value = "注册密码")
    @NotNull(message = "密码不能为空")
    @SafeHtml(message = "输入信息错误")
    private String pwd;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
