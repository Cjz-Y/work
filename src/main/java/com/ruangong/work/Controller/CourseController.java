package com.ruangong.work.Controller;

import com.google.gson.Gson;
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
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/showCourseMark", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> showCourseMark(Integer courseId){
//        List<Ban> banList = banService.findAll();
//        Map<Long, String> banDicts = banList.stream().collect(Collectors.toMap(Ban::getId, Ban::getName));

        List<Map<String, Object>> result = new ArrayList<>();
        result = markService.findMarkByCourseId(courseId);
//        for (Map<String, Object> map : result) {
//            map.put("ban_name", banDicts.get(map.get("ban_name")));
//        }

        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        return map;
    }

    @RequestMapping(value = "/showCourseMarkByBan", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> showCourseMarkByBan(Integer courseId, Integer banId){
        List<Map<String, Object>> result = new ArrayList<>();
        result = markService.findMarkByCourseIdAndBanId(courseId, banId);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        return map;
    }

    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public String getCoursePage(Integer courseId, ModelMap map){
        Course course = courseService.findById(new Long(courseId));
        List<Ban> banList = banService.findAll();
        Map<Long, String> banDicts = banList.stream().collect(Collectors.toMap(Ban::getId, Ban::getName));
        map.put("course", course);
        map.put("banDict", new Gson().toJson(banDicts));
        return "views/course/course";
    }

}
