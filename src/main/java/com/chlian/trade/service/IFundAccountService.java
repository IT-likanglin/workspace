package com.chlian.trade.service;

import com.chlian.trade.domain.FundAccount;

import java.util.List;
import java.util.Optional;

public interface IFundAccountService {
    List<FundAccount> findAll();

    Optional<FundAccount> findById(Integer id);

    List<FundAccount> findAllByPage(int parseInt, int parseInt1);

    void deleteById(Integer id);

    void addFundAccount(FundAccount fundAccount);

    void updateFundAccount(Integer id, FundAccount fndAccount);
}
