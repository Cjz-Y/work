package com.ruangong.work.Service;

import com.ruangong.work.Bean.BanToCourse;
import com.ruangong.work.Bean.Course;
import com.ruangong.work.Service.common.GeneralService;

import java.util.List;

public interface BanToCourseService extends GeneralService<BanToCourse, Long> {

    List<Course> findNoSelectedCourse(Integer banId);
}
