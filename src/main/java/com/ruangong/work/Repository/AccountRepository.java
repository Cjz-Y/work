package com.ruangong.work.Repository;

import com.ruangong.work.Bean.Account;
import com.ruangong.work.Repository.common.GeneralRepository;
import org.springframework.stereotype.Repository;

@Repository("accountRepository")
public interface AccountRepository extends GeneralRepository<Account, Long> {
    Account findAccountByUsername(String username);


//    @Query("select data from Account where data.username = (?1)")
//    Account findByUsername(String username);
}
