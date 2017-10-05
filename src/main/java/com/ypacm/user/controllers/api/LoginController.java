package com.ypacm.user.controllers.api;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("")
public class LoginController {
    @Get("login")
    public String errorPath() {
        return "@your method is wrong";
    }
}
