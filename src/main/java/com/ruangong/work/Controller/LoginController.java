package com.ruangong.work.Controller;

import com.ruangong.work.Bean.Account;
import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Service.AccountService;
import com.ruangong.work.Service.BanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/getPage")
    public String getPage(){
        return "hh";
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

    @Autowired
    private  BanService banService;

    @RequestMapping("/banFindAll")
    public List<Ban> findAll(){
        return banService.findAll();
    }

    @RequestMapping("/banFindByName")
    public Ban findByName(String name){
        return banService.findByName(name);
    }

    @RequestMapping("/saveBan")
    @ResponseBody
    public Ban saveBan(Ban ban){
        Ban ban1 = banService.save(ban);
        return ban1;
    }

    @RequestMapping("/deleteBan")
    @ResponseBody
    public int deleteBan(Long id){
        int numberOfDeleteSuccess = banService.deleteById(id);

        return numberOfDeleteSuccess;

    }




}
