package com.ruangong.work.Bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ban_to_course")
public class BanToCourse extends AbstractBean<Long> {

    private static final long serialVersionUID = -5740147999321554057L;
    @Column
    private Integer ban_id;

    @Column
    private Integer course_id;

    public Integer getBan_id() {
        return ban_id;
    }

    public void setBan_id(Integer ban_id) {
        this.ban_id = ban_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }
}
