package com.chlian.trade.service;

import com.chlian.trade.domain.OrderItem;

import java.util.List;
import java.util.Optional;

public interface IOrderItemService {

    void updateById(Integer id, OrderItem orderItem);

    void save(OrderItem orderItem);

    void deleteById(Integer id);

    List<OrderItem> findAll();

    Optional findById(Integer id);

    List<OrderItem> findByPage(Integer page, Integer size);
}
