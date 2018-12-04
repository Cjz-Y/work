package com.ruangong.work.Repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("classRepository")
public interface ClassRepository extends GeneralRepository<Class, Long> {

}
