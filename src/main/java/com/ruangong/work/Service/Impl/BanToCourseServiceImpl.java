package com.ruangong.work.Service.Impl;

import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Bean.BanToCourse;
import com.ruangong.work.Bean.Course;
import com.ruangong.work.Repository.BanToCourseRepository;
import com.ruangong.work.Repository.common.GeneralRepository;
import com.ruangong.work.Service.BanToCourseService;
import com.ruangong.work.Service.common.GeneralServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("banToCourseService")
@Transactional
public class BanToCourseServiceImpl extends GeneralServiceImpl<BanToCourse, Long> implements BanToCourseService {

    private BanToCourseRepository banToCourseRepository;

    @Autowired
    @Qualifier("banToCourseRepository")
    @Override
    public void setGeneralRepository(GeneralRepository<BanToCourse, Long> generalRepository) {
        this.generalRepository = generalRepository;
        this.banToCourseRepository = (BanToCourseRepository) generalRepository;
    }

    @Override
    public List<Course> findNoSelectedCourse(Integer banId){
        List<Course> result = banToCourseRepository.findNoSelectedCourse(banId);
        return result;
    }

    @Override
    public List<Ban> findSelectedBanByCourse(Integer courseId){
        List<Ban> result = banToCourseRepository.findSelectedBanByCourse(courseId);
        return result;
    }

    @Override
    public List<Ban> findNoSelectedBanByCourse(Integer courseId){
        List<Ban> result = banToCourseRepository.findNoSelectedBanByCourse(courseId);
        return result;
    }
}
