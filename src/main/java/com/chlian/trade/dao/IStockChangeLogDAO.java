package com.chlian.trade.dao;

import com.chlian.trade.domain.StockChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStockChangeLogDAO extends JpaRepository<StockChangeLog, Long> {


}
