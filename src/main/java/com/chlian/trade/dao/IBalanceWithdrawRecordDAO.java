package com.chlian.trade.dao;

import com.chlian.trade.domain.BalanceWithdrawRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBalanceWithdrawRecordDAO extends JpaRepository<BalanceWithdrawRecord, Long> {

    @Query(value = "select * from balance_withdraw_records where code = ?", nativeQuery = true)
    BalanceWithdrawRecord findByCode(String code);
}