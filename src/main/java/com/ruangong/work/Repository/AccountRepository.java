package com.ruangong.work.Repository;

import com.ruangong.work.Bean.Account;
import org.springframework.stereotype.Repository;

@Repository("accountRepository")
public interface AccountRepository extends GeneralRepository<Account, Long>{
}
