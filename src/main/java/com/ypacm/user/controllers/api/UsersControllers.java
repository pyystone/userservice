package com.ypacm.user.controllers.api;

import com.ypacm.user.net.response.RSData;
import com.ypacm.user.net.request.RQLogin;
import com.ypacm.user.net.request.RQRefresh;
import com.ypacm.user.net.request.RQRegister;
import com.ypacm.user.net.error.UserException;
import com.ypacm.user.net.response.RSToken;
import com.ypacm.user.service.impl.TokenServiceImpl;
import com.ypacm.user.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "获得用户信息",notes = "根据用户id获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "int", required = true, value = "用户id"),
            @ApiImplicitParam(name = "tk", dataType = "String", required = true, value = "用户token")
    })
    @GetMapping(value = "/detail")
    public RSData<com.ypacm.user.net.response.RSUser> getDetail(@PathParam(value = "id") Long id, @PathParam(value = "tk") String token) {
        return new UserServiceImpl().detail(id,token);
    }


    @ApiOperation(value = "注册用户",notes = "根据邮箱 account 密码注册用户")
    @PostMapping(value = "/register")
    public RSData Register(@RequestBody @Valid RQRegister ur) throws UserException {
        return new UserServiceImpl().register(ur);
    }


    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    public RSData<RSToken> login(@RequestBody @Valid RQLogin login) throws UserException {
        return new UserServiceImpl().login(login);
    }


    @ApiOperation(value = "刷新Token")
    @PostMapping(value = "refresh")
    public RSData<RSToken> refresh(@RequestBody @Valid RQRefresh ur) {
        return new TokenServiceImpl().refresh(ur);
    }

}
