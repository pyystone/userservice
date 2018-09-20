package com.ypacm.user.entity;

import com.ypacm.user.utils.UtilEncrypt;

import javax.persistence.*;

/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 *
 */
@Entity
public class Token {

    @Id
    private long userId;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private String refreshToken;

    @Column(nullable = false)
    private long timestamp;


    Token(){}

    public Token(long userId,  String token, String refreshToken, long timestamp) {
        this.userId = userId;
        this.token = token;
        this.refreshToken = refreshToken;
        this.timestamp = timestamp;
    }


    public long getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public long getTimestamp() {
        return timestamp;
    }

}
