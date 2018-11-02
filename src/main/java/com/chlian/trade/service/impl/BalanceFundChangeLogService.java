package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IBalanceFundChangeLogDAO;
import com.chlian.trade.domain.BalanceFundChangeLog;
import com.chlian.trade.service.IBalanceFundChangeLogService;
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

@Service
public class BalanceFundChangeLogService implements IBalanceFundChangeLogService {

    @Autowired
    private IBalanceFundChangeLogDAO iBalanceFundChangeLogDAO;


    @Override
    @Transactional
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void addBalanceFundChangeLog(BalanceFundChangeLog balanceFundChangeLog) {
        iBalanceFundChangeLogDAO.save(balanceFundChangeLog);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void deleteById(Long id) {
        iBalanceFundChangeLogDAO.deleteById(id);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void updateBalanceFundChangeLog(Long id, BalanceFundChangeLog balanceFundChangeLog) {
        BalanceFundChangeLog updateBalanceFundChangeLog = iBalanceFundChangeLogDAO.getOne(id);

        if(balanceFundChangeLog.getBalance() != null) {
            updateBalanceFundChangeLog.setBalance(balanceFundChangeLog.getBalance());
        }
        if(balanceFundChangeLog.getCreated_at() != null) {
            updateBalanceFundChangeLog.setCreated_at(balanceFundChangeLog.getCreated_at());
        }
        if(balanceFundChangeLog.getEvent() != null) {
            updateBalanceFundChangeLog.setEvent(balanceFundChangeLog.getEvent());
        }
        if(balanceFundChangeLog.getTrace() != null) {
            updateBalanceFundChangeLog.setTrace(balanceFundChangeLog.getTrace());
        }
        if(balanceFundChangeLog.getUpdated_at() != null) {
            updateBalanceFundChangeLog.setUpdated_at(balanceFundChangeLog.getUpdated_at());
        }
        if(balanceFundChangeLog.getUuid() != null) {
            updateBalanceFundChangeLog.setUuid(balanceFundChangeLog.getUuid());
        }
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#balanceFundChangeLog1")
    public List<BalanceFundChangeLog> findAll() {
        return iBalanceFundChangeLogDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#balanceFundChangeLog2")
    public BalanceFundChangeLog findById(Long id) {
        return iBalanceFundChangeLogDAO.getOne(id);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#balanceFundChangeLog3")
    public List<BalanceFundChangeLog> findAllByPage(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size);
        Page<BalanceFundChangeLog> balanceFundChangeLogs = iBalanceFundChangeLogDAO.findAll(pageable);
        return balanceFundChangeLogs.getContent();
    }
}
