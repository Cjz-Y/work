package com.ruangong.work.Controller;

import com.ruangong.work.Bean.Account;
import com.ruangong.work.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AccountService accountService;

   @GetMapping("test")
   public String test(){
       return "test";
   }

    @RequestMapping("/getPage")
    public String getPage(){
        return "";
    }


    @RequestMapping("/login")
    public String login(String username, String password){
        Account account = accountService.findAccountByUsername(username);
        if (account == null){

            return "username is null";

        }   else    {

            if (password.equals(account.getPassword())){
                if (account.getRole() == 2){
                    return "student";
                }   else if (account.getRole() == 0) {
                    return "admin";
                }
            }   else    {
                return "password is wrong";
            }

        }
        return null;
    }


}
