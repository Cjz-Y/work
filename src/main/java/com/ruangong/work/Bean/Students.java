package com.ruangong.work.Bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "students")
public class Students {

    @Id
    @Column
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Integer classId;
}
