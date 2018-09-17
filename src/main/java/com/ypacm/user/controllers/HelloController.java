package com.ypacm.user.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/helloworld")
public class HelloController {

    @GetMapping
    public String hello() {
        return "hello3";
    }

}
