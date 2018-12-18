package com.ruangong.work.Service;

import com.ruangong.work.Bean.Ban;

import java.util.List;

public interface BanService extends GeneralService<Ban, Long> {

    List<Ban> findAll();
}
