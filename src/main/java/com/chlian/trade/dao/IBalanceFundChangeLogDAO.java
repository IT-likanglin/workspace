package com.chlian.trade.dao;

import com.chlian.trade.domain.BalanceFundChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBalanceFundChangeLogDAO extends JpaRepository<BalanceFundChangeLog, Long> {

    @Query(value = "select * from balance_fund_change_logs where code = ?", nativeQuery = true)
    BalanceFundChangeLog findByCode(String code);
}