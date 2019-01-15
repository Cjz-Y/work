package com.ruangong.work.Service;

import com.ruangong.work.Bean.Account;
import com.ruangong.work.Service.common.GeneralService;

import java.util.List;

public interface AccountService extends GeneralService<Account, Long> {
    Account findAccountByUsername(String username);

    List<Account> findStudentsByBanId(Integer banId);
}
