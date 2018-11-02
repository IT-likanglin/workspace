package com.chlian.trade.service;

import com.chlian.trade.domain.StockChangeLog;

import java.util.List;
import java.util.Optional;

public interface IStockChangeLogService {

    List<StockChangeLog> findAll(); //

    Optional<StockChangeLog> findById(Long id);

    List<StockChangeLog> findAllByPage(int page, int size);

    void deleteById(Long id);

    void addStockChangeLog(StockChangeLog stockChangeLog);

    void updateStockChangeLog(Long id, StockChangeLog stockChangeLog);
}
