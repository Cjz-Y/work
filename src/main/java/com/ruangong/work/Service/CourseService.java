package com.ruangong.work.Service;

import com.ruangong.work.Bean.Course;
import sun.java2d.loops.FillRect;

import java.util.List;


public interface CourseService extends GeneralService<Course, Long> {

    List<Course> findAll();
}
