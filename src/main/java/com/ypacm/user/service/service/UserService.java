package com.ypacm.user.service.service;

import com.ypacm.user.net.request.RQLogin;
import com.ypacm.user.net.request.RQRegister;
import com.ypacm.user.net.response.RSData;
import com.ypacm.user.net.response.RSToken;
import com.ypacm.user.net.response.RSUser;

/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
public interface UserService {

    RSData register(RQRegister rqRegister);

    RSData<RSUser> detail(long uid, String tk);

    RSData<RSToken> login(RQLogin login);

}
