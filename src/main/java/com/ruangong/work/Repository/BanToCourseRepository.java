package com.ruangong.work.Repository;

import com.ruangong.work.Bean.BanToCourse;
import com.ruangong.work.Bean.Course;
import com.ruangong.work.Repository.common.GeneralRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("banToCourseRepository")
public interface BanToCourseRepository extends GeneralRepository<BanToCourse, Long> {

    @Query( nativeQuery = true,
            value = "select course " +
                    "from Course course " +
                    "where course.id not in (select bantoCourse.courseId from BanToCourse bantoCourse where bantoCourse.banId = (?1)) ")
    List<Course> findNoSelectedCourse(Integer banId);
}
