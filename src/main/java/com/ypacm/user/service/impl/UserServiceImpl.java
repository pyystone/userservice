package com.ypacm.user.service.impl;

import com.ypacm.user.entity.Token;
import com.ypacm.user.entity.User;
import com.ypacm.user.net.request.RQLogin;
import com.ypacm.user.net.request.RQRegister;
import com.ypacm.user.net.response.RSData;
import com.ypacm.user.net.response.RSToken;
import com.ypacm.user.net.response.RSUser;
import com.ypacm.user.repository.UserRepository;
import com.ypacm.user.service.service.UserService;
import com.ypacm.user.utils.UtilEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenServiceImpl tokenServiceImpl;

    @Override
    public RSData register(RQRegister rqRegister) {

        if( !User.isValidEmail(rqRegister.getEmail()) ||
                !User.isvalidPassword(rqRegister.getPwd())) {
            return RSData.buildRSData(RSData.SystemError.DATA_ERROR);
        }


        User user = userRepository.findByEmail(rqRegister.getEmail());

        if (user != null) {
            return RSData.buildRSData(RSData.UserError.HAD_REGISTER);
        }

        user = new User();
        user.setEmail(rqRegister.getEmail());
        user.setPassword(User.generatePassword(rqRegister.getPwd()));

        userRepository.save(user);

        return RSData.buildRSData();
    }

    @Override
    public RSData<RSUser> detail(long uid, String tk) {

        if (!tokenServiceImpl.isValidToken(uid,tk)) {
            return RSData.buildRSData(RSData.UserError.RELOGIN, com.ypacm.user.net.response.RSUser.class);
        }
        User user = userRepository.findOne(uid);
        if (user == null) {
            return RSData.buildRSData(RSData.SystemError.SYSTEM_ERROR, com.ypacm.user.net.response.RSUser.class);
        }
        return RSData.buildRSData(user.getRSUser());
    }

    @Override
    public RSData<RSToken> login(RQLogin login) {

        if( !User.isValidEmail(login.getEmail()) ||
                !User.isvalidPassword(login.getPwd()) ||
                !User.isvalidR(login.getR()) ||
                !User.isvalidTS(login.getTs())) {
            return RSData.buildRSData(RSData.SystemError.DATA_ERROR,RSToken.class);
        }


        User user = userRepository.findByEmail(login.getEmail());

        if (user == null ||
                !UtilEncrypt.MD5(
                        user.getPassword() + String.valueOf(login.getR()) + login.getTs()
                ).equals(login.getPwd())
                ) return RSData.buildRSData(RSData.UserError.LOGIN_ERROR,RSToken.class);

        // 生成Token
        Token tk = tokenServiceImpl.generatorAndSaveTokenById(user.getUserId());

        RSToken rsToken = new RSToken(tk.getUserId(), tk.getToken(), tk.getRefreshToken());

        return RSData.buildRSData(rsToken);
    }
}
