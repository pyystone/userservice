package com.ypacm.user.model.requestbody;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;
/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
@ApiModel(description = "用户登录")
public class RQLogin {

    @ApiModelProperty(required = true, dataType = "String", example = "test@test.com", value = "登录邮箱")
    @NotNull(message = "输入信息错误")
    @Email(message = "输入信息错误")
    private String email;

    @ApiModelProperty(required = true, dataType = "String", example = "202CB962AC59075B964B07152D234B70", value = "登录密码 加密策略 MD5(MD5(用户密码)+ts+r)")
    @SafeHtml(message = "输入信息错误")
    @NotNull(message = "输入信息错误")
    private String pwd;

    @ApiModelProperty(required = true, dataType = "String", example = "1537462795", value = "当前时间戳")
    @NotNull(message = "输入信息错误")
    private String ts;

    @ApiModelProperty(required = true, dataType = "long", example = "100000001", value = "随机10位数字")
    @NotNull(message = "输入信息错误")
    @Range(min = 100000000,max = 999999999)
    private long r;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public long getR() {
        return r;
    }

    public void setR(long r) {
        this.r = r;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
