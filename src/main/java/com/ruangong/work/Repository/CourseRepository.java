package com.ruangong.work.Repository;

import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Bean.Course;
import com.ruangong.work.Repository.common.GeneralRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseRepository")
public interface CourseRepository extends GeneralRepository<Course, Long> {


    @Query("select data from Course data")
    List<Course> findAll();

    @Query("select data from Course data where data.name = (?1)")
    Course findByName(String name);

    /**
     *  找到学生没有评价的课程
     * @param studentId
     * @return
     */
    @Query("select course " +
            "from Course course " +
            "where course.id in (select tocourse.course_id from BanToCourse tocourse where tocourse.ban_id = (?1) and tocourse.course_id is not null) " +
            "and course.id not in (select mark.courseId from Mark mark where mark.studentId = (?2) and mark.courseId is not null)")
    List<Course> findNoEvaCourseByStudent(Integer banId, Integer studentId);

}
