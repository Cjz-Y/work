package com.ruangong.work.Service.common;

import java.io.Serializable;
import java.util.List;

public interface GeneralService<T, ID extends Serializable> {

    T save(T entity);

    List<T> save(List<T> entities);

    int deleteById(ID id);

    int deleteById(ID[] ids);

    void delete(T entity);

    void delete(List<T> entities);

    T update(T entity);

    List<T> update(List<T> entities);

    T findById(ID id);

    List<T> findAll();
}
