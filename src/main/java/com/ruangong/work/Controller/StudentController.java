package com.ruangong.work.Controller;

import com.google.gson.Gson;
import com.ruangong.work.Bean.Account;
import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Bean.Course;
import com.ruangong.work.Bean.Mark;
import com.ruangong.work.Bean.temp.TempMark;
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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private BanService banService;

    @Autowired
    private MarkService markService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private BanToCourseService banToCourseService;

    /**
     * 展示该学生没有评价的课程列表
     * @param banId
     * @param studentId
     * @return
     */
    @RequestMapping(value = "/showNoEvaCourse", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> showNoEvaCourse(Integer banId, Integer studentId){
        List<Course> result = new ArrayList<>();
        result = courseService.findNoEvaCourseByStudent(banId, studentId);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        return map;
    }

    /**
     * 展示已经评价的课程详情
     * @param studentId
     * @return
     */
    @RequestMapping(value = "/showEvaCourse", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> showEvaCourse(Integer studentId){
        List<Map<String, Object>> result = new ArrayList<>();
        result = markService.getMarkByStudentId(studentId);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        return map;
    }

    /**
     * 添加评价
     * @param tempMark
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/addMark", method = RequestMethod.POST)
    public String addMark(TempMark tempMark, RedirectAttributes redirectAttributes){
        System.out.println("test");

        if (tempMark.getQuestion1() != null){
            Mark mark = new Mark();
            mark.setBanId(tempMark.getBanId());
            mark.setCourseId(tempMark.getCourseId());
            mark.setStudentId(tempMark.getStudentId());
            mark.setQuestionId(1);
            mark.setMark(tempMark.getQuestion1().doubleValue());
            markService.save(mark);
        }

        if (tempMark.getQuestion2() != null){
            Mark mark = new Mark();
            mark.setBanId(tempMark.getBanId());
            mark.setCourseId(tempMark.getCourseId());
            mark.setStudentId(tempMark.getStudentId());
            mark.setQuestionId(2);
            mark.setMark(tempMark.getQuestion2().doubleValue());
            markService.save(mark);
        }

        if (tempMark.getQuestion3() != null){
            Mark mark = new Mark();
            mark.setBanId(tempMark.getBanId());
            mark.setCourseId(tempMark.getCourseId());
            mark.setStudentId(tempMark.getStudentId());
            mark.setQuestionId(3);
            mark.setMark(tempMark.getQuestion3().doubleValue());
            markService.save(mark);
        }

        if (tempMark.getQuestion4() != null){
            Mark mark = new Mark();
            mark.setBanId(tempMark.getBanId());
            mark.setCourseId(tempMark.getCourseId());
            mark.setStudentId(tempMark.getStudentId());
            mark.setQuestionId(4);
            mark.setMark(tempMark.getQuestion4().doubleValue());
            markService.save(mark);
        }

        if (tempMark.getQuestion5() != null){
            Mark mark = new Mark();
            mark.setBanId(tempMark.getBanId());
            mark.setCourseId(tempMark.getCourseId());
            mark.setStudentId(tempMark.getStudentId());
            mark.setQuestionId(5);
            mark.setMark(tempMark.getQuestion5().doubleValue());
            markService.save(mark);
        }

        redirectAttributes.addAttribute("studentId", tempMark.getStudentId());
        return "redirect:/student/courseNoEva";
    }

    /**
     * 展示没有评价的课程页面
     * @param studentId
     * @param map
     * @return
     */
    @RequestMapping(value = "/courseNoEva", method = RequestMethod.GET)
    public String getCourseNoEvaPage(Integer studentId, ModelMap map){
        Account student = accountService.findById(studentId.longValue());
        map.put("student", student);
        return "views/student/student_no_eva";
    }

    @RequestMapping(value = "/courseEva", method = RequestMethod.GET)
    public String getCourseEvaPage(Integer studentId, ModelMap map){
        Account student = accountService.findById(studentId.longValue());
        List<Course> courses = courseService.findAll();
        Map<Long, String> courseDicts = courses.stream().collect(Collectors.toMap(Course::getId, Course::getName));
        map.put("student", student);
        map.put("courseDict", new Gson().toJson(courseDicts));
        return "views/student/student_eva";
    }

    @RequestMapping(value = "/evaCourse", method = RequestMethod.GET)
    public String getEvaCoursePage(Integer studentId, Integer courseId, ModelMap map){
        Account student = accountService.findById(studentId.longValue());
        map.put("student", student);
        map.put("courseId", courseId);
        return "views/student/eva_course";
    }


}
