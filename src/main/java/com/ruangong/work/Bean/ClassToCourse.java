package com.ruangong.work.Bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "class_to_course")
public class ClassToCourse {

    @Id
    @Column
    private Long id;

    @Column
    private Integer class_id;

    @Column
    private Integer course_id;


}
