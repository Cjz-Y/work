package com.ruangong.work.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("")
public class LoginController {

    @RequestMapping("login")
    public String getLogin(){
        return "";
    }


}
