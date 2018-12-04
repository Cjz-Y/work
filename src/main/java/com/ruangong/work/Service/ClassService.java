package com.ruangong.work.Service;

import java.util.List;

public interface ClassService extends GeneralService<Class, Long> {

    List<Class> findAll();
}
