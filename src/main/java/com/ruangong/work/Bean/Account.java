package com.ruangong.work.Bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getBanId() {
        return banId;
    }

    public void setBanId(Integer banId) {
        this.banId = banId;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
