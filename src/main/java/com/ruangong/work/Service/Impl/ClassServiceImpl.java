package com.ruangong.work.Service.Impl;

import com.ruangong.work.Repository.ClassRepository;
import com.ruangong.work.Repository.GeneralRepository;
import com.ruangong.work.Service.ClassService;
import com.ruangong.work.Service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("classService")
public class ClassServiceImpl extends GeneralServiceImpl<Class, Long> implements ClassService {

    private ClassRepository classRepository;


    @Override
    @Autowired
    @Qualifier("classRepository")
    public void setGeneralRepository(GeneralRepository<Class, Long> generalRepository) {
        this.generalRepository = generalRepository;
        this.classRepository = (ClassRepository) generalRepository;
    }

    public List<Class> findAll(){
        return classRepository.findAll();
    }
}
