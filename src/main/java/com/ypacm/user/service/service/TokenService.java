package com.ypacm.user.service.service;

import com.ypacm.user.entity.Token;
import com.ypacm.user.net.request.RQRefresh;
import com.ypacm.user.net.response.RSData;
import com.ypacm.user.net.response.RSToken;
import com.ypacm.user.utils.UtilEncrypt;

/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
public interface TokenService {

    long VALID_TOKEN_TIME = 7*24*60*60*1000;
    long VALID_REFRESH_TOKEN_TIME = 30*24*60*60*1000;

    String ACCESS_SIGN_KEY   = "yp_acm_sign_key";
    String REFRESH_SIGN_KEY  = "yp_acm_refresh_sign_key";



    RSData<RSToken> refresh(RQRefresh ur);

    Token generatorAndSaveTokenById(long uid);
}
