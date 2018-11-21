package com.ruangong.work.Bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "class_to_course")
public class ClassToCourse extends AbstractBean<Long> {

    private static final long serialVersionUID = -5740147999321554057L;
    @Column
    private Integer class_id;

    @Column
    private Integer course_id;


}
