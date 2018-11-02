package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IStockChangeLogDAO;
import com.chlian.trade.domain.StockChangeLog;
import com.chlian.trade.service.IStockChangeLogService;
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
public class StockChangeLogService implements IStockChangeLogService {

    @Autowired
    private IStockChangeLogDAO iStockChangeLogDAO;


    @Override
    @Cacheable(value = "secondlevels", key = "#stockChangeLog1")
    public List<StockChangeLog> findAll() {
        return iStockChangeLogDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#stockChangeLog2")
    public Optional<StockChangeLog> findById(Long id) {
        return iStockChangeLogDAO.findById(id);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#stockChangeLog3")
    public List<StockChangeLog> findAllByPage(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<StockChangeLog> stockChangeLogs = iStockChangeLogDAO.findAll(pageable);
        return stockChangeLogs.getContent();

    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void deleteById(Long id) {
        iStockChangeLogDAO.deleteById(id);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void addStockChangeLog(StockChangeLog stockChangeLog) {
        iStockChangeLogDAO.save(stockChangeLog);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void updateStockChangeLog(Long id, StockChangeLog stockChangeLog) {
        StockChangeLog updateStockChangeLog = iStockChangeLogDAO.getOne(id);

        if (stockChangeLog.getCreated_at() != null) {
            updateStockChangeLog.setCreated_at(stockChangeLog.getCreated_at());
        }
        if (stockChangeLog.getEvent() != null) {
            updateStockChangeLog.setEvent(stockChangeLog.getEvent());
        }
        if (stockChangeLog.getItem_code() != null) {
            updateStockChangeLog.setItem_code(stockChangeLog.getItem_code());
        }
        if (stockChangeLog.getItem_type() != null) {
            updateStockChangeLog.setItem_type(stockChangeLog.getItem_type());
        }
        if (stockChangeLog.getStock() != null) {
            updateStockChangeLog.setStock(stockChangeLog.getStock());
        }
        if (stockChangeLog.getTrace() != null) {
            updateStockChangeLog.setTrace(stockChangeLog.getTrace());
        }
        if (stockChangeLog.getUpdated_at() != null) {
            updateStockChangeLog.setUpdated_at(stockChangeLog.getUpdated_at());
        }
    }
}
