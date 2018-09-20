package com.ypacm.user.model.entity;

import com.ypacm.user.utils.UtilEncrypt;
import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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



    private static String ACCESS_SIGN_KEY   = "yp_acm_sign_key";
    private static String REFRESH_SIGN_KEY  = "yp_acm_refresh_sign_key";

    public static String generatorAccessToken(long userId,String pwd) {
        return UtilEncrypt.MD5(String.valueOf(userId)+pwd+System.currentTimeMillis()+ACCESS_SIGN_KEY);
    }
    public static String generatorRefreshToken(long userId,String pwd) {
        return UtilEncrypt.MD5(String.valueOf(userId)+pwd+System.currentTimeMillis()+REFRESH_SIGN_KEY);
    }

    /**
     * 判断token 是否过期
     * token的时效是 7天
     * @param ts token生成的时间戳
     * @return 是否过期
     */
    public static boolean isValidToken(long ts) {
        long validTime = 7*24*60*60*1000;
        long time = System.currentTimeMillis();
        return time - ts < validTime;
    }
}
