package com.ruangong.work.Service.Impl;

import com.ruangong.work.Bean.Course;
import com.ruangong.work.Repository.CourseRepository;
import com.ruangong.work.Repository.GeneralRepository;
import com.ruangong.work.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("courseService")
public class CourseServiceImpl extends GeneralServiceImpl<Course, Long> implements CourseService {
    private CourseRepository courseRepository;

    @Autowired
    @Qualifier("courseRepository")
    @Override
    public void setGeneralRepository(GeneralRepository<Course, Long> generalRepository) {
        this.generalRepository = generalRepository;
        this.courseRepository = (CourseRepository) generalRepository;
    }

    @Override
    public List<Course> findAll(){
        return courseRepository.findAll();
    }

}
