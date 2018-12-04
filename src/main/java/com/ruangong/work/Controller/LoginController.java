package com.ruangong.work.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/getPage")
    public String getPage(){
        return "";
    }


    @RequestMapping("/login")
    public String login(String username, String password){
        return null;
    }


}
