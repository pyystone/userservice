package com.ypacm.user.model.entity;

import com.ypacm.user.model.responsebody.RSUser;
import com.ypacm.user.utils.UtilEncrypt;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
@Entity
@ApiModel(value = "用户类")
public class User {

    @Id
    @GeneratedValue
    @ApiModelProperty(value = "用户id", dataType = "long")
    private long userId;

    @ApiModelProperty(value = "用户昵称", dataType = "long")
    private String nickName;

    @Column(nullable = false)
    @ApiModelProperty(value = "用户密码", dataType = "long")
    private String password;

    @Column(nullable = false)
    @ApiModelProperty(value = "用户邮箱", dataType = "long")
    private String email;

    @ApiModelProperty(value = "QQ", dataType = "String")
    private String QQ;

    @ApiModelProperty(value = "头像地址", dataType = "String")
    @URL(message = "信息错误")
    private String headUrl;


    @Transient
    private RSUser rsUser;

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public RSUser getRSUser() {
        if (rsUser == null) {
            rsUser = new RSUser();
            rsUser.setEmail(getEmail());
            rsUser.setHeadUrl(getHeadUrl());
            rsUser.setNickName(getNickName());
            rsUser.setPassword(getPassword());
            rsUser.setQQ(getQQ());
            rsUser.setUid(getUserId());
        }
        return rsUser;
    }



    // 加密签名，用于加密密码的，从配置文件 application.properties 中读取
    @Value("${com.ypacm.user.sign}")
    private static String sign;

    /**
     * 判断是否是合法的字符串（防御XSS攻击）
     * @param data 字符串
     * @return 是否合法
     */
    private static Boolean isValidString(String data) {
        return true;
    }

    /**
     * 判断是否是合法的email
     * @param email 邮箱
     * @return 是否合法
     */
    public static Boolean isValidEmail(String email) {
        if (!isValidString(email)) return false;
        return true;
    }

    /**
     * 是否是合法的密码
     * @param password 密码
     * @return 是否合法
     */
    public static Boolean isvalidPassword(String password) {
        if (!isValidString(password)) return false;
        return true;
    }

    /**
     * 是否是合法的时间戳
     * @param ts 时间戳
     * @return 是否合法
     */
    public static Boolean isvalidTS(String ts) {
        if (!isValidString(ts)) return false;
        return true;
    }

    /**
     * 是否是合法的随机数
     * @param r 10位随机数
     * @return 是否合法
     */
    public static Boolean isvalidR(long r) {
        return true;
    }

    /**
     * 生成服务器存储密码
     * @param password 用户上传密码
     * @return 处理以后的密码
     */
    public static String generatePassword(String password) {
        return UtilEncrypt.MD5(password + sign);
    }
}
