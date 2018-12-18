package com.ruangong.work.Repository;

import com.ruangong.work.Bean.Ban;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("banRepository")
public interface BanRepository extends GeneralRepository<Ban, Long> {

}
