package com.chlian.trade.dao;

import com.chlian.trade.domain.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStockItemDAO extends JpaRepository<StockItem, Integer> {

    @Query("select u from StockItem u where u.stock = :stock")
    List<StockItem> findByStock(@Param("stock") Long stock);

}
