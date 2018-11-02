package com.chlian.trade.dao;

import com.chlian.trade.domain.FundAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFundAccountDAO extends JpaRepository<FundAccount, Integer> {
}
