package com.ruangong.work.Repository;

import com.ruangong.work.Bean.Mark;
import com.ruangong.work.Repository.common.GeneralRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("markRepository")
public interface MarkRepository extends GeneralRepository<Mark, Long> {


    @Query("select data.banId as ban_name, " +
            "sum(case when data.questionId = 1 then data.mark else 0 end) as question_one_mark, " +
            "sum(case when data.questionId = 1 then 1 else 0 end) as question_one_number, " +
            "sum(case when data.questionId = 2 then data.mark else 0 end) as question_two_mark, " +
            "sum(case when data.questionId = 2 then 1 else 0 end) as question_two_number, " +
            "sum(case when data.questionId = 3 then data.mark else 0 end) as question_three_mark, " +
            "sum(case when data.questionId = 3 then 1 else 0 end) as question_three_number, " +
            "sum(case when data.questionId = 4 then data.mark else 0 end) as question_four_mark, " +
            "sum(case when data.questionId = 4 then 1 else 0 end) as question_four_number, " +
            "sum(case when data.questionId = 5 then data.mark else 0 end) as question_five_mark, " +
            "sum(case when data.questionId = 5 then 1 else 0 end) as question_five_number " +
            "from Mark data " +
            "where data.courseId = (?1)" +
            "group by data.banId")
    List<Map<String, Object>> getMarkByCourseId(Integer courseId);


    @Query("select sum(case when data.questionId = 1 then data.mark else 0 end) as question_one_mark, " +
            "sum(case when data.questionId = 2 then data.mark else 0 end) as question_two_mark, " +
            "sum(case when data.questionId = 3 then data.mark else 0 end) as question_three_mark, " +
            "sum(case when data.questionId = 4 then data.mark else 0 end) as question_four_mark, " +
            "sum(case when data.questionId = 5 then data.mark else 0 end) as question_five_mark, " +
            "data.studentName as student_name " +
            "from Mark data " +
            "where data.courseId = (?1) and data.banId = (?2) " +
            "group by data.studentId")
    List<Map<String, Object>> getMarkByCourseIdAndBanId(Integer courseId, Integer banId);

    @Query("select sum(case when data.questionId = 1 then data.mark else 0 end) as question_one_mark, " +
            "sum(case when data.questionId = 2 then data.mark else 0 end) as question_two_mark, " +
            "sum(case when data.questionId = 3 then data.mark else 0 end) as question_three_mark, " +
            "sum(case when data.questionId = 4 then data.mark else 0 end) as question_four_mark, " +
            "sum(case when data.questionId = 5 then data.mark else 0 end) as question_five_mark, " +
            "data.courseId as courseId " +
            "from Mark data " +
            "where data.studentId = (?1) " +
            "group by data.courseId")
    List<Map<String, Object>> getMarkByStudentId(Integer studentId);
}
