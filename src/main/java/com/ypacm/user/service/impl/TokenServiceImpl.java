package com.ypacm.user.service.impl;

import com.ypacm.user.entity.Token;
import com.ypacm.user.net.request.RQRefresh;
import com.ypacm.user.net.response.RSData;
import com.ypacm.user.net.response.RSToken;
import com.ypacm.user.repository.TokenRepository;
import com.ypacm.user.service.service.TokenService;
import com.ypacm.user.utils.UtilEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;

/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
@Service
public class TokenServiceImpl extends BaseServiceImpl<Token> implements TokenService {



    @Autowired
    private TokenRepository tokenRepository;


    @Override
    public RSData<RSToken> refresh(RQRefresh ur) {
        Token tk = tokenRepository.findOne(ur.getUid());
        if (tk == null || !isValidRefreshToken(tk.getTimestamp())) {
            return RSData.buildRSData(RSData.UserError.RELOGIN,RSToken.class);
        }
        tk = generatorAndSaveTokenById(ur.getUid());

        return RSData.buildRSData(new RSToken(ur.getUid(),tk.getToken(),tk.getRefreshToken())) ;
    }

    @Override
    public Token generatorAndSaveTokenById(long uid) {
        Token tk = new Token(uid,
                generatorAccessToken(uid),
                generatorRefreshToken(uid),
                System.currentTimeMillis());
        tokenRepository.save(tk);
        return tk;
    }

    /**
     *
     * 判断token 是否过期
     * token的时效是 7天
     * @param uid 用户id
     * @param tk 用户token
     * @return 是否过期
     */
    boolean isValidToken(long uid, String tk) {
        Token token = tokenRepository.findOne(uid);
        if (token == null || !token.getToken().equals(tk)) {
            return false;
        }
        long time = System.currentTimeMillis();
        return time - token.getTimestamp() < VALID_TOKEN_TIME;
    }

    /**
     * 判断refreshtoken 是否过期
     * token的时效是 7天
     * @param ts token生成的时间戳
     * @return 是否过期
     */
    public static boolean isValidRefreshToken(long ts) {
        long time = System.currentTimeMillis();
        return time - ts < VALID_REFRESH_TOKEN_TIME;
    }


    public static String generatorAccessToken(long userId) {
        return UtilEncrypt.MD5(String.valueOf(userId)+System.currentTimeMillis()+ACCESS_SIGN_KEY);
    }
    public static String generatorRefreshToken(long userId) {
        return UtilEncrypt.MD5(String.valueOf(userId)+System.currentTimeMillis()+REFRESH_SIGN_KEY);
    }
}
