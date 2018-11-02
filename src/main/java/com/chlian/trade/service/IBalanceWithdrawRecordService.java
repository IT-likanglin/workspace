package com.chlian.trade.service;

import com.chlian.trade.domain.BalanceWithdrawRecord;

import java.util.List;

public interface IBalanceWithdrawRecordService {

    void addBalanceWithdrawRecord(BalanceWithdrawRecord balanceWithdrawRecord);

    void deleteByCode(String code);

    void updateBalanceWithdrawRecord(String code, BalanceWithdrawRecord balanceWithdrawRecord);

    List<BalanceWithdrawRecord> findAll();

    BalanceWithdrawRecord findByCode(String code);

    List<BalanceWithdrawRecord> findAllByPage(Integer page, Integer size);
}
