package com.ruangong.work.Repository;

import com.ruangong.work.Bean.Account;
import com.ruangong.work.Repository.common.GeneralRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountRepository")
public interface AccountRepository extends GeneralRepository<Account, Long> {
    Account findAccountByUsername(String username);

    @Query("select student from Account student where student.banId = (?1) and student.role = 2")
    List<Account> findStudentByBanId(Integer banId);


//    @Query("select data from Account where data.username = (?1)")
//    Account findByUsername(String username);
}
