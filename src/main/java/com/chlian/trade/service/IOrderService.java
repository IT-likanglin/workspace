package com.chlian.trade.service;

import com.chlian.trade.domain.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrderService {

    /**
     * 订单更新
     * @param code 订单code
     * @param order 需要更新的订单数据
     */
    void updateOrder(String code, Order order);


    /**
     * 订单删除
     * @param code 订单code
     */
    void deleteByCode(String code);

    /**
     * 订单新增
     * @param order
     */
    void addOrder(Order order);

    /**
     * 查询所有
     * @return
     */
    List<Order> findAll();

    /**
     * 根据code查询
     * @param id
     * @return
     */

    Order findById(String id);

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<Order> findAllByPage(Integer page, Integer size);
}
