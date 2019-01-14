package com.ruangong.work.Service;

import com.ruangong.work.Bean.Mark;
import com.ruangong.work.Service.common.GeneralService;

import java.util.List;
import java.util.Map;


public interface MarkService extends GeneralService<Mark, Long> {

    List<Map<String, Object>> findMarkByCourseId(Integer courseId);

    List<Map<String, Object>> findMarkByCourseIdAndBanId(Integer courseId, Integer banId);

}
