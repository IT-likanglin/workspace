package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IFundAccountDAO;
import com.chlian.trade.domain.FundAccount;
import com.chlian.trade.service.IFundAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FundAccountService implements IFundAccountService {

    @Autowired
    private IFundAccountDAO iFundAccountDAO;

    @Override
    @Cacheable(value = "secondlevels", key = "#fundAccount1")
    public List<FundAccount> findAll() {
        return iFundAccountDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#fundAccount2")
    public Optional<FundAccount> findById(Integer id) {
        return iFundAccountDAO.findById(id);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#fundAccount3")
    public List<FundAccount> findAllByPage(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<FundAccount> fundAccounts = iFundAccountDAO.findAll(pageable);
        return fundAccounts.getContent();
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void deleteById(Integer id) {
        iFundAccountDAO.deleteById(id);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void addFundAccount(FundAccount fundAccount) {
        iFundAccountDAO.save(fundAccount);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void updateFundAccount(Integer id, FundAccount fndAccount) {
        FundAccount updateFundAccount = iFundAccountDAO.getOne(id);
        if(fndAccount.getBalance() != null) {
            updateFundAccount.setBalance(fndAccount.getBalance());
        }
        if(fndAccount.getCb() != null) {
            updateFundAccount.setCb(fndAccount.getCb());
        }
        if(fndAccount.getCcm() != null) {
            updateFundAccount.setCcm(fndAccount.getCcm());
        }
        if(fndAccount.getCreated_at() != null) {
            updateFundAccount.setCreated_at(fndAccount.getCreated_at());
        }
        if(fndAccount.getFreeze() != null) {
            updateFundAccount.setFreeze(fndAccount.getFreeze());
        }
        if(fndAccount.getFreeze_ccm() != null) {
            updateFundAccount.setFreeze_ccm(fndAccount.getFreeze_ccm());
        }
        if(fndAccount.getUpdated_at() != null) {
            updateFundAccount.setUpdated_at(fndAccount.getUpdated_at());
        }
        if(fndAccount.getUuid() != null) {
            updateFundAccount.setUuid(fndAccount.getUuid());
        }

    }
}
