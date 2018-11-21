package com.ruangong.work;

import com.ruangong.work.Bean.Account;
import com.ruangong.work.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WorkApplication {

    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(WorkApplication.class, args);
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public void save(Account account){
        System.out.println(account);
        accountService.save(account);
    }
}
