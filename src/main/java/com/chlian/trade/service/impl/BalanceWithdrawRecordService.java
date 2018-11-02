package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IBalanceWithdrawRecordDAO;
import com.chlian.trade.domain.BalanceWithdrawRecord;
import com.chlian.trade.service.IBalanceWithdrawRecordService;
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
public class BalanceWithdrawRecordService implements IBalanceWithdrawRecordService {

    @Autowired
    private IBalanceWithdrawRecordDAO iBalanceWithdrawRecordDAO;

    @Override
    @Cacheable(value = "secondlevels", key = "#balanceDraw1")
    public List<BalanceWithdrawRecord> findAll() {
        return iBalanceWithdrawRecordDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#balanceDraw2")
    public BalanceWithdrawRecord findByCode(String code) {
        return iBalanceWithdrawRecordDAO.findByCode(code);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#balanceDraw3")
    public List<BalanceWithdrawRecord> findAllByPage(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size);
        Page<BalanceWithdrawRecord> balanceWithdrawRecords = iBalanceWithdrawRecordDAO.findAll(pageable);
        return balanceWithdrawRecords.getContent();
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void deleteByCode(String code) {
        BalanceWithdrawRecord balanceWithdrawRecord = iBalanceWithdrawRecordDAO.findByCode(code);
        iBalanceWithdrawRecordDAO.deleteById(balanceWithdrawRecord.getId());
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void addBalanceWithdrawRecord(BalanceWithdrawRecord balanceWithdrawRecord) {
        iBalanceWithdrawRecordDAO.save(balanceWithdrawRecord);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void updateBalanceWithdrawRecord(String code, BalanceWithdrawRecord balanceWithdrawRecord) {
        BalanceWithdrawRecord updateBalanceWithdrawRecord = iBalanceWithdrawRecordDAO.findByCode(code);

        if(balanceWithdrawRecord.getCreated_at() != null) {
            updateBalanceWithdrawRecord.setCreated_at(balanceWithdrawRecord.getCreated_at());
        }
        if(balanceWithdrawRecord.getPlatform_no() != null) {
            updateBalanceWithdrawRecord.setPlatform_no(balanceWithdrawRecord.getPlatform_no());
        }
        if(balanceWithdrawRecord.getStatus() != null) {
            updateBalanceWithdrawRecord.setStatus(balanceWithdrawRecord.getStatus());
        }
        if(balanceWithdrawRecord.getUpdated_at() != null) {
            updateBalanceWithdrawRecord.setUpdated_at(balanceWithdrawRecord.getUpdated_at());
        }
        if(balanceWithdrawRecord.getUuid() != null) {
            updateBalanceWithdrawRecord.setUuid(balanceWithdrawRecord.getUuid());
        }

    }
}
