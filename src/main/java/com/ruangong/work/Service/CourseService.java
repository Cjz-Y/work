package com.ruangong.work.Service;

import com.ruangong.work.Bean.Course;
import com.ruangong.work.Service.common.GeneralService;

import java.util.List;


public interface CourseService extends GeneralService<Course, Long> {

    List<Course> findAll();

    Course findbyName(String name);

    List<Course> findNoEvaCourseByStudent(Integer banId, Integer studentId);
}
