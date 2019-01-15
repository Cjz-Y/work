package com.ruangong.work.common;

import com.ruangong.work.Bean.Account;
import com.ruangong.work.Bean.temp.TempAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataProcessUtils {

    /**
     * 将录入的数据处理成可以导入到数据库的数据格式
     *
     * @param tempList
     * @param banDicts
     * @return
     */
    public static List<Account> processStudentData(List<Object> tempList, Map<String, Long> banDicts){
        ArrayList<Account> result = new ArrayList<>();
        for (Object o : tempList) {
            TempAccount temp = (TempAccount) o;
            Account account = new Account();
            account.setRole(2);
            account.setUsername(temp.getUsername());
            account.setPassword(temp.getPassword());
            account.setBanId(banDicts.getOrDefault(temp.getBanName(), -1L).intValue());
            result.add(account);
        }

        return result;
    }
}
