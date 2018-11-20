package com.ruangong.work.Bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "classes")
public class Class {

    @Id
    @Column
    private Long id;

    @Column
    private String name;


}
