package com.ruangong.work.Repository;

import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Bean.Course;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseRepository")
public interface CourseRepository extends GeneralRepository<Course, Long> {


    @Query("select data from Course data")
    List<Course> findAll();

    @Query("select data from Course data where data.name = (?1)")
    Course findByName(String name);
}
