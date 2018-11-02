package com.chlian.trade.service;

import com.chlian.trade.domain.StockItem;

import java.util.List;
import java.util.Optional;

public interface IStockItemService {

    List<StockItem> findAll();

    Optional<StockItem> findById(Integer id);

    List<StockItem> findAllByPage(int page, int size);

    void deleteById(Integer id);

    void addStockItem(StockItem stockItem);

    void updateStockItem(Integer id, StockItem stockItem);

    List<StockItem> findByCreated_at(Long stock);
}
