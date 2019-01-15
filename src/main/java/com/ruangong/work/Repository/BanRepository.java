package com.ruangong.work.Repository;

import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Repository.common.GeneralRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("banRepository")
public interface BanRepository extends GeneralRepository<Ban, Long> {

    @Query("select data from Ban data where data.name = (?1)")
    Ban findByName(String name);

    @Query("select data from Ban data")
    List<Ban> findAll();

}
