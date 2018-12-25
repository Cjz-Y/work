package com.ruangong.work.Bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "account")
public class Account extends AbstractBean<Long> {

    private static final long serialVersionUID = 106330414998887438L;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Integer banId;

    //role: 2代表学生 1代表老师 0代表管理员
    @Column
    private Integer role;
}
