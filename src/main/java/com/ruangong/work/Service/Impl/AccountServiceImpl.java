package com.ruangong.work.Service.Impl;

import com.ruangong.work.Bean.Account;
import com.ruangong.work.Repository.AccountRepository;
import com.ruangong.work.Repository.GeneralRepository;
import com.ruangong.work.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("accountService")
public class AccountServiceImpl extends GeneralServiceImpl<Account, Long> implements AccountService {


    private AccountRepository accountRepository;

    @Autowired
    @Qualifier("accountRepository")
    @Override
    public void setGeneralRepository(GeneralRepository<Account, Long> generalRepository) {
        this.generalRepository = generalRepository;
        this.accountRepository = (AccountRepository) generalRepository;
    }

}
