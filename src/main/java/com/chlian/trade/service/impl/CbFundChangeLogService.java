package com.chlian.trade.service.impl;

import com.chlian.trade.dao.ICbFundChangeLogDAO;
import com.chlian.trade.domain.CbFundChangeLog;
import com.chlian.trade.service.ICbFundChangeLogService;
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
public class CbFundChangeLogService implements ICbFundChangeLogService {

    @Autowired
    private ICbFundChangeLogDAO iCbFundChangeLogDAO;
    @Override
    @Cacheable(value = "secondlevels", key = "#ccmFundChangeLog1")
    public List<CbFundChangeLog> findAll() {
        return iCbFundChangeLogDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#ccmFundChangeLog2")
    public CbFundChangeLog findById(Long id) {
        CbFundChangeLog cbFundChangeLog = iCbFundChangeLogDAO.getOne(id);
        return cbFundChangeLog;
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#ccmFundChangeLog3")
    public List<CbFundChangeLog> findAllByPage(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size);
        Page<CbFundChangeLog> cbFundChangeLogPage = iCbFundChangeLogDAO.findAll(pageable);
        return cbFundChangeLogPage.getContent();
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void deleteById(Long id) {
        iCbFundChangeLogDAO.deleteById(id);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void addCbFundChangeLog(CbFundChangeLog cbFundChangeLog) {
        iCbFundChangeLogDAO.save(cbFundChangeLog);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void updateCbFundChangeLog(Long id, CbFundChangeLog cbFundChangeLog) {
        CbFundChangeLog updateCbFundChangeLog = iCbFundChangeLogDAO.getOne(id);

       if(cbFundChangeLog.getCb() != null) {
           updateCbFundChangeLog.setCb(cbFundChangeLog.getCb());
       }
       if(cbFundChangeLog.getCreated_at() != null) {
           updateCbFundChangeLog.setCreated_at(cbFundChangeLog.getCreated_at());
       }
       if(cbFundChangeLog.getEvent() != null) {
           updateCbFundChangeLog.setEvent(cbFundChangeLog.getEvent());
       }
       if(cbFundChangeLog.getTrace() != null) {
           updateCbFundChangeLog.setTrace(cbFundChangeLog.getTrace());
       }
       if(cbFundChangeLog.getUpdated_at() != null) {
           updateCbFundChangeLog.setUpdated_at(cbFundChangeLog.getUpdated_at());
       }
       if(cbFundChangeLog.getUuid() != null) {
           updateCbFundChangeLog.setUuid(cbFundChangeLog.getUuid());
       }

    }

}
