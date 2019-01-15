package com.ruangong.work.Controller;

import com.ruangong.work.Bean.Account;
import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Service.AccountService;
import com.ruangong.work.Service.BanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
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
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, RedirectAttributes redirectAttributes){
        Account account = accountService.findAccountByUsername(username);
        if (account == null){
            return "redirect:/manager/coursePage";
        }   else    {

            if (password.equals(account.getPassword())){
                if (account.getRole() == 2){
                    redirectAttributes.addAttribute("studentId", account.getId());
                    return "redirect:/student/courseNoEva";
                }   else if (account.getRole() == 0) {
                    return "redirect:/manager/coursePage";
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
