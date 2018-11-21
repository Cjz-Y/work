package com.ruangong.work.Bean;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
abstract class AbstractBean<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1821796981112693433L;

    @Id
    @GeneratedValue
    private ID id;
}
