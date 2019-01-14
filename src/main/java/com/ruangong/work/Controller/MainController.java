package com.ruangong.work.Controller;

import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Bean.Course;
import com.ruangong.work.Service.BanService;
import com.ruangong.work.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("main")
public class MainController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private BanService banService;

    @RequestMapping("/showPage")
    public String showPage(ModelMap model){
        List<Course> courseList = courseService.findAll();
        List<Ban> banList = banService.findAll();
        model.put("courseList", courseList);
        model.put("banList", banList);
        return "";
    }

    @RequestMapping("/ban/showAddPage")
    public String showBanAdd(){
        return "";
    }

    @RequestMapping("/course/showAddPage")
    public String showCourseAdd(){
        return "";
    }

    @RequestMapping("/ban/save")
    public String saveBan(Ban ban){
        Ban result = banService.save(ban);
        if (result != null){
            return "回到主页";
        }   else    {
            return "error";
        }
    }

    @RequestMapping("/course/save")
    public String saveCourse(Course course){
        Course result = courseService.save(course);

        if (result != null){
            return "回到主页";
        }   else    {
            return "error";
        }
    }

}
