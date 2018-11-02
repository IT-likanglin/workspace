package com.chlian.trade.service.impl;

import com.chlian.trade.dao.ICcmFundChangeLogDAO;
import com.chlian.trade.domain.CcmFundChangeLog;
import com.chlian.trade.service.ICcmFundChangeLogService;
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
public class CcmFundChangeLogService implements ICcmFundChangeLogService {

    @Autowired
    private ICcmFundChangeLogDAO iCcmFundChangeLogDAO;


    @Override
    @Cacheable(value = "secondlevels", key = "#ccmFundChangeLog1")
    public List<CcmFundChangeLog> findAll() {
        return iCcmFundChangeLogDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#ccmFundChangeLog2")
    public CcmFundChangeLog findById(Long id) {
        CcmFundChangeLog ccm = iCcmFundChangeLogDAO.getOne(id);
        return ccm;
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#ccmFundChangeLog3")
    public List<CcmFundChangeLog> findAllByPage(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size);
        Page<CcmFundChangeLog> ccmFundChangeLogPage = iCcmFundChangeLogDAO.findAll(pageable);
        return ccmFundChangeLogPage.getContent();
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void deleteById(Long id) {
        iCcmFundChangeLogDAO.deleteById(id);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void addCcmFundChangeLog(CcmFundChangeLog ccmFundChangeLog) {
        iCcmFundChangeLogDAO.save(ccmFundChangeLog);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void updateCcmFundChangeLog(Long id, CcmFundChangeLog ccmFundChangeLog) {
        CcmFundChangeLog updateCcmFundChangeLog = iCcmFundChangeLogDAO.getOne(id);

        if(ccmFundChangeLog.getCcm() != null) {
            updateCcmFundChangeLog.setCcm(ccmFundChangeLog.getCcm());
        }
        if(ccmFundChangeLog.getCreated_at() != null) {
            updateCcmFundChangeLog.setCreated_at(ccmFundChangeLog.getCreated_at());
        }
        if(ccmFundChangeLog.getEvent() != null) {
            updateCcmFundChangeLog.setEvent(ccmFundChangeLog.getEvent());
        }
        if(ccmFundChangeLog.getTrace() != null) {
            updateCcmFundChangeLog.setTrace(ccmFundChangeLog.getTrace());
        }
        if(ccmFundChangeLog.getUpdated_at() != null) {
            updateCcmFundChangeLog.setUpdated_at(ccmFundChangeLog.getUpdated_at());
        }
        if(ccmFundChangeLog.getUuid() != null) {
            updateCcmFundChangeLog.setUuid(ccmFundChangeLog.getUuid());
        }

    }
}
