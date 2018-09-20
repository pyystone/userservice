package com.ypacm.user.net.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
@ApiModel(value = "返回的用户信息")
public class RSUser {

    @ApiModelProperty(name = "用户id", value = "用户id", dataType = "long", example = "123456")
    private long uid;

    @ApiModelProperty(name = "用户昵称", value = "用户昵称", dataType = "long", example = "ypacm")
    private String nickName;

    @ApiModelProperty(name = "用户密码", value = "用户密码", dataType = "long", example = "202CB962AC59075B964B07152D234B70")
    private String password;

    @ApiModelProperty(name = "用户邮箱", value = "用户邮箱", dataType = "long", example = "test@ypacm.com")
    private String email;

    @ApiModelProperty(name = "QQ", value = "QQ", dataType = "String", example = "290454391")
    private String QQ;

    @ApiModelProperty(name = "头像地址", value = "头像地址", dataType = "String", example = "http://ypacm.com/icon.png")
    private String headUrl;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
}
