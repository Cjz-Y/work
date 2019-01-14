package com.ruangong.work.Service.Impl;

import com.ruangong.work.Bean.Mark;
import com.ruangong.work.Repository.common.GeneralRepository;
import com.ruangong.work.Repository.MarkRepository;
import com.ruangong.work.Service.MarkService;
import com.ruangong.work.Service.common.GeneralServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("markService")
@Transactional
public class MarkServiceImpl extends GeneralServiceImpl<Mark, Long> implements MarkService {

    private MarkRepository markRepository;

    @Autowired
    @Qualifier("markRepository")
    @Override
    public void setGeneralRepository(GeneralRepository<Mark, Long> generalRepository) {
        this.generalRepository = generalRepository;
        this.markRepository = (MarkRepository) generalRepository;
    }

    @Override
    public List<Map<String, Object>> findMarkByCourseId(Integer courseId){

        List<Map<String, Object>> result = markRepository.getMarkByCourseId(courseId);
        for (Map<String, Object> map : result) {
            HashMap<String, Object> newMap = new HashMap<>();
            newMap.putAll(map);
            newMap.put("question_one_mark", (Double) newMap.getOrDefault("question_one_mark", 0) / (Long) newMap.getOrDefault("question_one_number", 0));
            newMap.put("question_two_mark", (Double) newMap.getOrDefault("question_two_mark", 0) / (Long) newMap.getOrDefault("question_two_number", 0));
            newMap.put("question_three_mark", (Double) newMap.getOrDefault("question_three_mark", 0) / (Long) newMap.getOrDefault("question_three_number", 0));
            newMap.put("question_four_mark", (Double) newMap.getOrDefault("question_four_mark", 0) / (Long) newMap.getOrDefault("question_four_number", 0));
            newMap.put("question_five_mark", (Double) newMap.getOrDefault("question_five_mark", 0) / (Long) newMap.getOrDefault("question_five_number", 0));
            result.remove(map);
            result.add(newMap);
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> findMarkByCourseIdAndBanId(Integer courseId, Integer banId){
        List<Map<String, Object>> result = new ArrayList<>();
        result = markRepository.getMarkByCourseIdAndBanId(courseId, banId);
        return result;
    }
}
