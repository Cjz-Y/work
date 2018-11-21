package com.ruangong.work.Bean;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "mark")
public class Mark extends AbstractBean<Long> {

    private static final long serialVersionUID = -6115100517586766376L;


    @Column
    private Integer studentId;

    @Column
    private Integer classId;

    @Column
    private Integer questionId;

    @Column
    private Double mark;

}
