package com.ruangong.work.Controller;

import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Bean.Course;
import com.ruangong.work.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/courseFindAll")
    public List<Course> findAll(){

        return courseService.findAll();
    }

    @RequestMapping("/courseFindByName")
    public Course findByName(String name){
        return courseService.findByName(name);
    }

    @RequestMapping("/saveCourse")
    @ResponseBody
    public Course saveCourse(Course course){
        Course course1 = courseService.save(course);
        return course1;
    }

    @RequestMapping("/deleteCourse")
    @ResponseBody
    public int deleteBan(Long id) {
        int numberOfDeleteSuccess = courseService.deleteById(id);

        return numberOfDeleteSuccess;
    }
}
