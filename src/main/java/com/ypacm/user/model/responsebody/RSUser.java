package com.ypacm.user.model.responsebody;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
@ApiModel
public class RSUser {

    @ApiModelProperty(value = "用户id", dataType = "long")
    private long uid;

    @ApiModelProperty(value = "用户昵称", dataType = "long")
    private String nickName;

    @ApiModelProperty(value = "用户密码", dataType = "long")
    private String password;

    @ApiModelProperty(value = "用户邮箱", dataType = "long")
    private String email;

    @ApiModelProperty(value = "QQ", dataType = "String")
    private String QQ;

    @ApiModelProperty(value = "头像地址", dataType = "String")
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
