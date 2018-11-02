package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IOrderItemDAO;
import com.chlian.trade.domain.OrderItem;
import com.chlian.trade.service.IOrderItemService;
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
public class OrderItemService implements IOrderItemService {

    @Autowired
    private IOrderItemDAO iOrderItemDAO;

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames="secondlevels",allEntries = true)
    public void updateById(Integer id, OrderItem orderItem) {
        OrderItem updateOrderItem = iOrderItemDAO.getOne(id);

        if(orderItem.getActual_unit_price() != null) {
            updateOrderItem.setActual_unit_price(orderItem.getActual_unit_price());
        }
        if(orderItem.getAmount() != null) {
            updateOrderItem.setAmount(orderItem.getAmount());
        }
        if(orderItem.getCb() != null) {
            updateOrderItem.setCb(orderItem.getCb());
        }
        if(orderItem.getCommodity_code() != null) {
            updateOrderItem.setCommodity_code(orderItem.getCommodity_code());
        }
        if(orderItem.getCommodity_sku_code() != null) {
            updateOrderItem.setCommodity_sku_code(orderItem.getCommodity_sku_code());
        }
        if(orderItem.getCover() != null) {
            updateOrderItem.setCover(orderItem.getCover());
        }
        if(orderItem.getCreated_at() != null) {
            updateOrderItem.setCreated_at(orderItem.getCreated_at());
        }
        if(orderItem.getName() != null) {
            updateOrderItem.setName(orderItem.getName());
        }
        if(orderItem.getOrder_code() != null) {
            updateOrderItem.setOrder_code(orderItem.getOrder_code());
        }
        if(orderItem.getSpecification() != null) {
            updateOrderItem.setSpecification(orderItem.getSpecification());
        }
        if(orderItem.getSummary() != null) {
            updateOrderItem.setSummary(orderItem.getSummary());
        }
        if(orderItem.getUnit_price() != null) {
            updateOrderItem.setUnit_price(orderItem.getUnit_price());
        }
        if(orderItem.getUpdated_at() != null) {
            updateOrderItem.setUpdated_at(orderItem.getUpdated_at());
        }
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames="secondlevels",allEntries = true)
    public void save(OrderItem orderItem) {
        iOrderItemDAO.save(orderItem);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames="secondlevels",allEntries = true)
    public void deleteById(Integer id) {
        iOrderItemDAO.deleteById(id);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#orderItem1")
    public List<OrderItem> findAll() {
        return iOrderItemDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#orderItem2")
    public Optional findById(Integer id) {
        return iOrderItemDAO.findById(id);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#orderItem3")
    public List<OrderItem> findByPage(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size);
        Page<OrderItem> orderItems = iOrderItemDAO.findAll(pageable);
        return orderItems.getContent();
    }


}
