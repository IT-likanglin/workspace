package com.chlian.trade.dao;

import com.chlian.trade.domain.TradeMasterAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITradeMasterAccountDAO extends JpaRepository<TradeMasterAccount, Integer> {
}
