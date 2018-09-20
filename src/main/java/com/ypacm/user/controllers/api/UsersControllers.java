package com.ypacm.user.controllers.api;

import com.ypacm.user.error.ExceptionFormat;
import com.ypacm.user.model.entity.Token;
import com.ypacm.user.model.repository.TokenRepository;
import com.ypacm.user.model.responsebody.RSData;
import com.ypacm.user.model.entity.User;
import com.ypacm.user.model.repository.UserRepository;
import com.ypacm.user.model.requestbody.RQLogin;
import com.ypacm.user.model.requestbody.RQRefresh;
import com.ypacm.user.model.requestbody.RQRegister;
import com.ypacm.user.error.UserException;
import com.ypacm.user.model.responsebody.RSLogin;
import com.ypacm.user.model.responsebody.RSUser;
import com.ypacm.user.utils.UtilEncrypt;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
@RestController
@RequestMapping(value="/user")
public class UsersControllers {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    @Autowired
    public UsersControllers(UserRepository userRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }


    @ApiOperation(value = "获得用户信息",notes = "根据用户id获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", required = true, value = "用户id"),
            @ApiImplicitParam(name = "tk", dataType = "String", required = true, value = "用户token")
    })
    @GetMapping(value = "/detail")
    public RSData<RSUser> getUser(@PathParam(value = "id") Long id, @PathParam(value = "tk") String token) {
        Token tk = tokenRepository.findOne(id);
        if (tk == null || !tk.getToken().equals(token)) {
            return ExceptionFormat.builderErrorResult(ExceptionFormat.User.LOGIN_ERROR,RSUser.class);
        }

        if (!Token.isValidToken(tk.getTimestamp())) {
            return ExceptionFormat.builderErrorResult(ExceptionFormat.User.RELOGIN,RSUser.class);
        }

        User user = userRepository.findOne(id);
        if (user == null) {
            return ExceptionFormat.builderErrorResult(ExceptionFormat.System.DATA_ERROR,RSUser.class);
        }
        return new RSData<>(user.getRSUser());
    }


    @ApiOperation(value = "注册用户",notes = "根据邮箱 account 密码注册用户")
    @PostMapping(value = "/register")
    public RSData Register(@RequestBody @Valid RQRegister ur) throws UserException {

        if( !User.isValidEmail(ur.getEmail()) ||
            !User.isvalidPassword(ur.getPwd())) {
            throw new UserException("参数错误");
        }


        User user = userRepository.findByEmail(ur.getEmail());

        if (user != null) throw new UserException("该邮箱已经被注册了");

        user = new User();
        user.setEmail(ur.getEmail());
        user.setPassword(User.generatePassword(ur.getPwd()));

        userRepository.save(user);
        return new RSData();
    }

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    public RSLogin Login(@RequestBody @Valid RQLogin login) throws UserException {

        if( !User.isValidEmail(login.getEmail()) ||
            !User.isvalidPassword(login.getPwd()) ||
            !User.isvalidR(login.getR()) ||
            !User.isvalidTS(login.getTs())) {
            throw new UserException("参数错误");
        }


        User user = userRepository.findByEmail(login.getEmail());

        if (user == null ||
                !UtilEncrypt.MD5(
                user.getPassword() + String.valueOf(login.getR()) + login.getTs()
                                ).equals(login.getPwd())
                ) throw new UserException("账号或密码错误");

        // 生成Token
        Token tk = new Token(user.getUserId(),
                    Token.generatorAccessToken(user.getUserId(),user.getPassword()),
                    Token.generatorRefreshToken(user.getUserId(),user.getPassword()),
                    System.currentTimeMillis());
        tokenRepository.save(tk);
        return new RSLogin(tk.getToken(),tk.getRefreshToken());
    }

    @ApiOperation(value = "刷新Token")
    @PostMapping(value = "refresh")
    public RSLogin refresh(@RequestBody @Valid RQRefresh ur) {
        // Token 刷新逻辑
//        Token tk = tokenRepository.findOne(ur.getUid());
//        if ()
//        Token.isValidRefreshToken(ur.getRtk())
        return new RSLogin("","token");
    }

}
