package com.ruangong.work.Service;

import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Service.common.GeneralService;

import java.util.List;

public interface BanService extends GeneralService<Ban, Long> {

    List<Ban> findAll();

    Ban findByName(String name);
}
