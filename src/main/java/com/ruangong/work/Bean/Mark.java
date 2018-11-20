package com.ruangong.work.Bean;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "mark")
public class Mark {

    @Id
    @Column
    private Long id;

    @Column
    private Integer studentId;

    @Column
    private Integer classId;

    @Column
    private Integer questionId;

    @Column
    private Double mark;

}
