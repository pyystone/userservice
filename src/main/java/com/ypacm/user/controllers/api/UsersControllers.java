package com.ypacm.user.controllers.api;

import com.ypacm.user.data.entity.User;
import com.ypacm.user.data.requestbody.UserLogin;
import com.ypacm.user.data.requestbody.UserRegister;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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

    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long,User>());


    // 获得用户信息
    @ApiOperation(value = "获得用户信息",notes = "根据用户id获取用户信息")
    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Long id) {
        if (users.containsKey(id)) {
            return users.get(id);
        }
        return null;
    }




    @ApiOperation(value = "注册用户",notes = "根据邮箱 account 密码注册用户")
    @PostMapping(value = "/register")
    public String Register(@RequestBody @Valid UserRegister ur) {

        return "succeed";
    }


    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    public String Login(@RequestBody @Valid UserLogin login) {
        return "succeed";
    }


}
