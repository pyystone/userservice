package com.ypacm.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
@SpringBootApplication
public class UserServiceApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApp.class,args);
    }

}
