package com.chlian.trade.dao;

import com.chlian.trade.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemDAO extends JpaRepository<OrderItem, Integer> {
}
