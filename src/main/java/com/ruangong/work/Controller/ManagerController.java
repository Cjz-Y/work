package com.ruangong.work.Controller;

import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Bean.Course;
import com.ruangong.work.Service.BanService;
import com.ruangong.work.Service.CourseService;
import com.ruangong.work.Service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private BanService banService;

    @Autowired
    private MarkService markService;

    @RequestMapping(value = "/coursePage", method = RequestMethod.GET)
    public String getCoursePage(){
        return "views/manager/course_page";
    }

    @RequestMapping(value = "/banPage", method = RequestMethod.GET)
    public String getBanPage(){
        return "views/manager/ban_page";
    }

    @RequestMapping(value = "/addCoursePage", method = RequestMethod.GET)
    public String getAddCoursePage(){
        return "views/manager/add_cour_page";
    }

    @RequestMapping(value = "/addBanPage", method = RequestMethod.GET)
    public String getAddBanPage(){
        return "views/manager/add_ban_page";
    }

    @RequestMapping(value = "/getAllCourse", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getAllCourse(){
        List<Course> courseList = courseService.findAll();
        Map<String, Object> result = new HashMap<>();
        result.put("data", courseList);
        return result;
    }

    @RequestMapping(value = "/getAllBan", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getAllBan(){
        List<Ban> banList = banService.findAll();
        Map<String, Object> result = new HashMap<>();
        result.put("data", banList);
        return result;
    }

    @RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
    public String saveCourse(Course course){
        Course course1 = courseService.save(course);
        if (course1 != null){
            return "redirect:/manager/coursePage";
        }
        return null;
    }

    @RequestMapping(value = "/saveBan", method = RequestMethod.POST)
    public String saveBan(Ban ban){
        Ban ban1 = banService.save(ban);
        if (ban1 != null){
            return "redirect:/manager/banPage";
        }
        return null;
    }


}
