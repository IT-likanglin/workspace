package com.chlian.trade.service;

import com.chlian.trade.domain.AccountBookLog;

import java.util.List;
import java.util.Optional;

public interface IAccountBookLogService {
    void addAccountBookLog(AccountBookLog accountBookLog);

    void deleteById(String id);

    void updateAccountBookLog(String id, AccountBookLog accountBookLog);

    List<AccountBookLog> findAll();

    Optional findById(String id);

    List<AccountBookLog> findAllByPage(int parseInt, int parseInt1);
}
