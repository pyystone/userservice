package com.ypacm.user.controllers.api;

import com.ypacm.user.model.responsebody.BaseResponse;
import com.ypacm.user.model.entity.User;
import com.ypacm.user.model.repository.UserRepository;
import com.ypacm.user.model.requestbody.UserLogin;
import com.ypacm.user.model.requestbody.UserRefresh;
import com.ypacm.user.model.requestbody.UserRegister;
import com.ypacm.user.error.UserException;
import com.ypacm.user.model.responsebody.LoginResponse;
import com.ypacm.user.utils.UtilEncrypt;
import com.ypacm.user.utils.UtilUser;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @Autowired
    public UsersControllers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // 获得用户信息
    @ApiOperation(value = "获得用户信息",notes = "根据用户id获取用户信息")
    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Long id) throws UserException {
        User user = userRepository.findOne(id);
        if (user != null) {
            return user;
        }
        throw new UserException("未找到这个用户信息");
    }


    @ApiOperation(value = "注册用户",notes = "根据邮箱 account 密码注册用户")
    @PostMapping(value = "/register")
    public BaseResponse Register(@RequestBody @Valid UserRegister ur) throws UserException {

        if( !UtilUser.isVaildEmail(ur.getEmail()) ||
            !UtilUser.isVaildPassword(ur.getPassword())) {
            throw new UserException("参数错误");
        }


        User user = userRepository.findByEmail(ur.getEmail());

        if (user != null) throw new UserException("该邮箱已经被注册了");

        user = new User();
        user.setEmail(ur.getEmail());
        user.setPassword(UtilUser.generatePassword(ur.getPassword()));

        userRepository.save(user);
        return new BaseResponse(BaseResponse.OK);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    public LoginResponse Login(@RequestBody @Valid UserLogin login) throws UserException {

        if( !UtilUser.isVaildEmail(login.getEmail()) ||
            !UtilUser.isVaildPassword(login.getPassword()) ||
            !UtilUser.isVaildR(login.getR()) ||
            !UtilUser.isVaildTS(login.getTs())) {
            throw new UserException("参数错误");
        }


        User user = userRepository.findByEmail(login.getEmail());

        if (user == null ||
                !UtilEncrypt.MD5(
                user.getPassword() + String.valueOf(login.getR()) + login.getTs()
                                ).equals(login.getPassword())
                ) throw new UserException("账号或密码错误");

        // 生成Token

        return new LoginResponse("","token");
    }

    @ApiOperation(value = "刷新Token")
    @PostMapping(value = "refresh")
    public LoginResponse refresh(@RequestBody @Valid UserRefresh ur) {
        // Token 刷新逻辑
        return new LoginResponse("","token");
    }

}
