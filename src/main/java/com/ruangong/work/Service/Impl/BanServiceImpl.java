package com.ruangong.work.Service.Impl;

import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Repository.BanRepository;
import com.ruangong.work.Repository.GeneralRepository;
import com.ruangong.work.Service.BanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("banService")
public class BanServiceImpl extends GeneralServiceImpl<Ban, Long> implements BanService {

    private BanRepository banRepository;


    @Override
    @Autowired
    @Qualifier("banRepository")
    public void setGeneralRepository(GeneralRepository<Ban, Long> generalRepository) {
        this.generalRepository = generalRepository;
        this.banRepository = (BanRepository) generalRepository;
    }

    @Override
    public List<Ban> findAll(){

        return banRepository.findAll();
    }

    @Override
    public Ban findByName(String name) {

        return banRepository.findByName(name);
    }
}
