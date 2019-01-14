package com.ruangong.work.Bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mark")
public class Mark extends AbstractBean<Long> {

    private static final long serialVersionUID = -6115100517586766376L;

    /**
     * 这个分数属于哪个学生
     */
    @Column
    private Integer studentId;

    @Column
    private String studentName;

    /**
     * 这个分数属于哪个班
     */
    @Column
    private Integer banId;

    /**
     * 这个分数属于哪个课程
     */
    @Column
    private Integer courseId;

    /**
     * 这个分数属于那种问题
     */
    @Column
    private Integer questionId;

    /**
     * 分数
     */
    @Column
    private Double mark;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getBanId() {
        return banId;
    }

    public void setBanId(Integer banId) {
        this.banId = banId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }
}
