package com.ruangong.work.Bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "question")
public class Question extends AbstractBean<Long>{

    private static final long serialVersionUID = -913403025565916199L;

    @Column
    private Integer course_id;

    @Column
    private String questionContent;

}
