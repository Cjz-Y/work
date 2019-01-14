package com.ruangong.work.Bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course extends AbstractBean<Long> {

    private static final long serialVersionUID = 7788895723742213457L;

    @Column
    private String name;

    /**
     * 任课老师
     */
    @Column
    private String teacher;

    /**
     * 课程简介
     */
    @Column(columnDefinition = "text")
    private String describeText;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDescribeText() {
        return describeText;
    }

    public void setDescribeText(String describeText) {
        this.describeText = describeText;
    }
}
