package com.ruangong.work.Repository;

import com.ruangong.work.Bean.Course;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Repository;

@Repository("courseRepository")
public interface CourseRepository extends GeneralRepository<Course, Long> {
}
