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

    /**
     * 展示管理员的课程管理页面
     * @return
     */
    @RequestMapping(value = "/coursePage", method = RequestMethod.GET)
    public String getCoursePage(){
        return "views/manager/course_page";
    }

    /**
     * 展示管理员的班级管理页面
     * @return
     */
    @RequestMapping(value = "/banPage", method = RequestMethod.GET)
    public String getBanPage(){
        return "views/manager/ban_page";
    }

    /**
     * 展示添加课程页面
     * @return
     */
    @RequestMapping(value = "/addCoursePage", method = RequestMethod.GET)
    public String getAddCoursePage(){
        return "views/manager/add_cour_page";
    }

    /**
     * 展示添加班级页面
     * @return
     */
    @RequestMapping(value = "/addBanPage", method = RequestMethod.GET)
    public String getAddBanPage(){
        return "views/manager/add_ban_page";
    }

    /**
     * 课程列表数据
     * @return
     */
    @RequestMapping(value = "/getAllCourse", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getAllCourse(){
        List<Course> courseList = courseService.findAll();
        Map<String, Object> result = new HashMap<>();
        result.put("data", courseList);
        return result;
    }

    /**
     * 班级列表数据
     * @return
     */
    @RequestMapping(value = "/getAllBan", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getAllBan(){
        List<Ban> banList = banService.findAll();
        Map<String, Object> result = new HashMap<>();
        result.put("data", banList);
        return result;
    }

    /**
     * 保存课程
     * @param course
     * @return
     */
    @RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
    public String saveCourse(Course course){
        Course course1 = courseService.save(course);
        if (course1 != null){
            return "redirect:/manager/coursePage";
        }
        return null;
    }

    /**
     * 保存班级
     * @param ban
     * @return
     */
    @RequestMapping(value = "/saveBan", method = RequestMethod.POST)
    public String saveBan(Ban ban){
        Ban ban1 = banService.save(ban);
        if (ban1 != null){
            return "redirect:/manager/banPage";
        }
        return null;
    }


}
