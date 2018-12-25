package com.ruangong.work.Controller;

import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Service.BanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ban")
public class BanController {

    @Autowired
    private BanService banService;

    @RequestMapping("showPage")
    public String showPage(Long id, ModelMap modelMap){
        Ban ban = banService.findById(id);
        modelMap.put("ban", ban);
        return "";

    }
}
