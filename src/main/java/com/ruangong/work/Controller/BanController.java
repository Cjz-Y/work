package com.ruangong.work.Controller;

import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Bean.BanToCourse;
import com.ruangong.work.Bean.Course;
import com.ruangong.work.Service.BanService;
import com.ruangong.work.Service.BanToCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ban")
public class BanController {

    @Autowired
    private BanService banService;

    @Autowired
    private BanToCourseService banToCourseService;

    @RequestMapping("/ban")
    public String showPage(Integer banId, ModelMap modelMap){
        Ban ban = banService.findById(banId.longValue());
        List<Course> noCourseList = banToCourseService.findNoSelectedCourse(banId);
        modelMap.put("noSelectedCourse", noCourseList);
        modelMap.put("ban", ban);
        return "views/ban/ban";
    }

    @RequestMapping("/addCourse")
    public String addCourse(BanToCourse banToCourse, RedirectAttributes redirectAttributes){
        BanToCourse banToCourse1 = banToCourseService.save(banToCourse);
        redirectAttributes.addAttribute("banId", banToCourse.getBan_id());
        return "redirect:/ban/ban";
    }

}
