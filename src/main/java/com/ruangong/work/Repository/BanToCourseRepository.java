package com.ruangong.work.Repository;

import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Bean.BanToCourse;
import com.ruangong.work.Bean.Course;
import com.ruangong.work.Repository.common.GeneralRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("banToCourseRepository")
public interface BanToCourseRepository extends GeneralRepository<BanToCourse, Long> {

    /**
     * 查找指定班级没有选择的课程
     * @param banId
     * @return
     */
//    @Query( nativeQuery = true,
//            value = "select * " +
//                    "from course " +
//                    "where course.id not in (select bantoCourse.course_id from ban_to_course bantoCourse where bantoCourse.ban_id = (?1)) ")
    @Query("select course " +
            "from Course course " +
            "where course.id not in (select bantocourse.course_id from BanToCourse bantocourse where bantocourse.ban_id = (?1))")
    List<Course> findNoSelectedCourse(Integer banId);

    /**
     * 查找指定课程选择的班级
     * @param courseId
     * @return
     */
//    @Query( nativeQuery = true,
//            value = "select * " +
//                    "from ban " +
//                    "where ban.id in (select bantoCourse.ban_id from ban_to_course bantoCourse where bantoCourse.course_id = (?1)) ")
    @Query("select ban " +
            "from Ban ban " +
            "where ban.id in (select bantocourse.ban_id from BanToCourse bantocourse where bantocourse.course_id = (?1) and bantocourse.ban_id is not null)")
    List<Ban> findSelectedBanByCourse(Integer courseId);

    /**
     * 查找没有选择指定课程的班级
     * @param courseId
     * @return
     */
//    @Query( nativeQuery = true,
//            value = "select * " +
//                    "from ban " +
//                    "where ban.id in (select bantoCourse.ban_id from ban_to_course bantoCourse where bantoCourse.course_id = (?1)) ")
    @Query("select ban " +
            "from Ban ban " +
            "where ban.id not in (select bantocourse.ban_id from BanToCourse bantocourse where bantocourse.course_id = (?1) and bantocourse.ban_id is not null)")
    List<Ban> findNoSelectedBanByCourse(Integer courseId);


}
