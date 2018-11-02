package com.chlian.trade.service;

import com.chlian.trade.domain.TradeMasterAccount;

import java.util.List;
import java.util.Optional;

public interface ITradeMasterAccountService {

    List<TradeMasterAccount> findAll();

    Optional<TradeMasterAccount> findById(Integer id);

    List<TradeMasterAccount> findAllByPage(int page, int size);

    void deleteById(Integer id);

    void addTradeMasterAccount(TradeMasterAccount tradeMasterAccount);

    void updateTradeMasterAccount(Integer id, TradeMasterAccount tradeMasterAccount);
}
