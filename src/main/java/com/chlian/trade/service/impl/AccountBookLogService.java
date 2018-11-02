package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IAccountBookLogDAO;
import com.chlian.trade.domain.AccountBookLog;
import com.chlian.trade.service.IAccountBookLogService;
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
public class AccountBookLogService implements IAccountBookLogService {

    @Autowired
    private IAccountBookLogDAO accountBookLogDAO;

    @Override
    @Transactional
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void addAccountBookLog(AccountBookLog accountBookLog) {
        accountBookLogDAO.save(accountBookLog);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void deleteById(String id) {
        accountBookLogDAO.deleteById(id);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void updateAccountBookLog(String id, AccountBookLog accountBookLog) {
        AccountBookLog updateAccountBookLOg = accountBookLogDAO.getOne(id);

        if(accountBookLog.getBody() != null) {
            updateAccountBookLOg.setBody(accountBookLog.getBody());
        }
        if(accountBookLog.getCheck_type() != null) {
            updateAccountBookLOg.setCheck_type(accountBookLog.getCheck_type());
        }
        if(accountBookLog.getChecked_at() != null) {
            updateAccountBookLOg.setChecked_at(accountBookLog.getChecked_at());
        }
        if(accountBookLog.getChecker() != null) {
            updateAccountBookLOg.setChecker(accountBookLog.getChecker());
        }
        if(accountBookLog.getEvent() != null) {
            updateAccountBookLOg.setEvent(accountBookLog.getEvent());
        }
        if(accountBookLog.getStatus() != null) {
            updateAccountBookLOg.setStatus(accountBookLog.getStatus());
        }
        if(accountBookLog.getSubject() != null) {
            updateAccountBookLOg.setSubject(accountBookLog.getSubject());
        }
        if(accountBookLog.getTrace() != null) {
            updateAccountBookLOg.setTrace(accountBookLog.getTrace());
        }
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#accountBookLog1")
    public List<AccountBookLog> findAll() {
        return accountBookLogDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#accountBookLog2")
    public Optional findById(String id) {
        return accountBookLogDAO.findById(id);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#accountBookLog3")
    public List<AccountBookLog> findAllByPage(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<AccountBookLog> pageList = accountBookLogDAO.findAll(pageable);
        return pageList.getContent();
    }
}
