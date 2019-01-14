package com.ruangong.work.Controller;

import com.ruangong.work.Bean.Course;
import com.ruangong.work.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/testCourse")
public class TestCourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/findAll")
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @PostMapping("/save")
    @ResponseBody
    public Course save(Course course){
        Course savedCourse = courseService.save(course);
        return savedCourse;
    }

    @PostMapping("/delete")
    public Integer delete(Long id){
        Integer count = courseService.deleteById(id);
        return count;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage(){
        return "login";
    }
}
