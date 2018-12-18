package com.ruangong.work.Bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "course")
public class Course extends AbstractBean<Long> {

    private static final long serialVersionUID = 7788895723742213457L;

    @Column
    private String name;

    /**
     * 授课老师
     */
    @Column
    private String teacher;


}
