package com.chlian.trade.service.impl;

import com.chlian.trade.dao.ITradeMasterAccountDAO;
import com.chlian.trade.domain.TradeMasterAccount;
import com.chlian.trade.service.ITradeMasterAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeMasterAccountService implements ITradeMasterAccountService {

    @Autowired
    private ITradeMasterAccountDAO tradeMasterAccountDAO;

    @Override
    public List<TradeMasterAccount> findAll() {
        return null;
    }

    @Override
    public Optional<TradeMasterAccount> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<TradeMasterAccount> findAllByPage(int page, int size) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void addTradeMasterAccount(TradeMasterAccount tradeMasterAccount) {

    }

    @Override
    public void updateTradeMasterAccount(Integer id, TradeMasterAccount tradeMasterAccount) {

    }
}
