package com.ypacm.user.data.entity;

import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Token {
    @Id
    private long userId;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private String refreshToken;


    Token(){}
    public Token(long userId,  String token, String refreshToken) {
        this.userId = userId;
        this.token = token;
        this.refreshToken = refreshToken;
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
}
