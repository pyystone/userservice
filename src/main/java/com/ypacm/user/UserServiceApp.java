package com.ypacm.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by pengqiandong on 2017/10/23.
 */
@SpringBootApplication
public class UserServiceApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApp.class,args);
    }

}
