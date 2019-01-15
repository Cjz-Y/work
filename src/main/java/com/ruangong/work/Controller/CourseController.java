package com.ruangong.work.Controller;

import com.google.gson.Gson;
import com.ruangong.work.Bean.Account;
import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Bean.BanToCourse;
import com.ruangong.work.Bean.Course;
import com.ruangong.work.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private MarkService markService;

    @Autowired
    private BanService banService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private BanToCourseService banToCourseService;

    /**
     * 展示课程的评价结果，各个班级
     * @param courseId
     * @return
     */
    @RequestMapping(value = "/showCourseMark", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> showCourseMark(Integer courseId){
        List<Map<String, Object>> result = new ArrayList<>();
        result = markService.findMarkByCourseId(courseId);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        return map;
    }

    /**
     * 展示指定班级对课程的评价结果
     * @param courseId
     * @param banId
     * @return
     */
    @RequestMapping(value = "/showCourseMarkByBan", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> showCourseMarkByBan(Integer courseId, Integer banId){
        List<Map<String, Object>> result = new ArrayList<>();
        result = markService.findMarkByCourseIdAndBanId(courseId, banId);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        return map;
    }

    /**
     * 展示选择该课程的班级
     * @param courseId
     * @return
     */
    @RequestMapping(value = "/showSelectedBanByCourse", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> showSelectedBanByCourse(Integer courseId){
        List<Ban> result = banToCourseService.findSelectedBanByCourse(courseId);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        return map;
    }

    /**
     * 为班级选择该课程
     * @param banToCourse
     * @param redirectAttributes
     */
    @RequestMapping("/addBan")
    public void addCourse(BanToCourse banToCourse, RedirectAttributes redirectAttributes){
        if (banToCourse.getBan_id() != null && banToCourse.getCourse_id() != null){
            BanToCourse banToCourse1 = banToCourseService.save(banToCourse);
//            return "success";
        }
//        return "error";
    }

    /**
     * 课程的评价页面
     * @param courseId
     * @param map
     * @return
     */
    @RequestMapping(value = "/courseEva", method = RequestMethod.GET)
    public String getCoursePage(Integer courseId, ModelMap map){
        Course course = courseService.findById(new Long(courseId));
        List<Ban> banList = banService.findAll();
        Map<Long, String> banDicts = banList.stream().collect(Collectors.toMap(Ban::getId, Ban::getName));
        map.put("course", course);
        map.put("banDict", new Gson().toJson(banDicts));
        return "views/course/course_eva";
    }

    /**
     * 课程与班级的绑定页面
     * @param courseId
     * @param map
     * @return
     */
    @RequestMapping(value = "/courseToBan", method = RequestMethod.GET)
    public String getCourseToBanPage(Integer courseId, ModelMap map){
        Course course = courseService.findById(new Long(courseId));
        List<Ban> noSelectedBan = banToCourseService.findNoSelectedBanByCourse(courseId);
        map.put("noSelectedBan", noSelectedBan);
        map.put("course", course);
        return "views/course/course_to_ban";
    }

    /**
     * 课程的评价详情页面
     * @param courseId
     * @param banId
     * @param map
     * @return
     */
    @RequestMapping(value = "/courseDetail", method = RequestMethod.GET)
    public String getCourseDetailPage(Integer courseId, Integer banId, ModelMap map){
        List<Account> students = accountService.findStudentsByBanId(banId);
        Map<Long, String> studentDict = students.stream().collect(Collectors.toMap(Account::getId, Account::getUsername));
        map.put("studentDict", new Gson().toJson(studentDict));
        map.put("courseId", courseId);
        map.put("banId", banId);
        return "views/course/course_detail";
    }

}
