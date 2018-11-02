package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IOrderDAO;
import com.chlian.trade.domain.Order;
import com.chlian.trade.service.IOrderService;
import com.chlian.trade.utils.UUIDUtils;
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
public class OrderService implements IOrderService {

    @Autowired
    IOrderDAO iOrderDAO;


    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void updateOrder(String code, Order order) {
        Order updateOrder = iOrderDAO.findByCode(code).get(0);

        if (order.getAddress() != null) {
            updateOrder.setAddress(order.getAddress());
        }
        if (order.getCb() != null) {
            updateOrder.setCb(order.getCb());
        }
        if (order.getCcm_rewards() != null) {
            updateOrder.setCcm_rewards(order.getCcm_rewards());
        }
        if (order.getChecked_at() != null) {
            updateOrder.setChecked_at(order.getChecked_at());
        }
        if (order.getCity() != null) {
            updateOrder.setCity(order.getCity());
        }
        if (order.getContact_name() != null) {
            updateOrder.setContact_name(order.getContact_name());
        }
        if (order.getContact_phone() != null) {
            updateOrder.setContact_phone(order.getContact_phone());
        }
        if (order.getCounty() != null) {
            updateOrder.setCounty(order.getCounty());
        }
        if (order.getCreated_at() != null) {
            updateOrder.setCreated_at(order.getCreated_at());
        }
        if (order.getDeleted_at() != null) {
            updateOrder.setDeleted_at(order.getDeleted_at());
        }
        if (order.getDetail() != null) {
            updateOrder.setDetail(order.getDetail());
        }
        if (order.getFinished_at() != null) {
            updateOrder.setFinished_at(order.getFinished_at());
        }
        if (order.getLogistics_code() != null) {
            updateOrder.setLogistics_code(order.getLogistics_code());
        }
        if (order.getLogistics_price() != null) {
            updateOrder.setLogistics_price(order.getLogistics_price());
        }
        if (order.getLogistics_provider() != null) {
            updateOrder.setLogistics_provider(order.getLogistics_provider());
        }
        if (order.getMark() != null) {
            updateOrder.setMark(order.getMark());
        }
        if (order.getMerchant() != null) {
            updateOrder.setMerchant(order.getMerchant());
        }
        if (order.getPaid_at() != null) {
            updateOrder.setPaid_at(order.getPaid_at());
        }
        if (order.getPayment_amount() != null) {
            updateOrder.setPayment_amount(order.getPayment_amount());
        }
        if (order.getPayment_code() != null) {
            updateOrder.setPayment_code(order.getPayment_code());
        }
        if (order.getPost_code() != null) {
            updateOrder.setPost_code(order.getPost_code());
        }
        if (order.getProvince() != null) {
            updateOrder.setProvince(order.getProvince());
        }
        if (order.getReceived_at() != null) {
            updateOrder.setReceived_at(order.getReceived_at());
        }
        if (order.getRefund_code() != null) {
            updateOrder.setRefund_code(order.getRefund_code());
        }
        if (order.getRemark() != null) {
            updateOrder.setRemark(order.getRemark());
        }
        if (order.getSent_at() != null) {
            updateOrder.setSent_at(order.getSent_at());
        }
        if (order.getStatus() != null) {
            updateOrder.setStatus(order.getStatus());
        }
        if (order.getTotal_amount() != null) {
            updateOrder.setTotal_amount(order.getTotal_amount());
        }
        if (order.getUpdated_at() != null) {
            updateOrder.setUpdated_at(order.getUpdated_at());
        }
        if (order.getUuid() != null) {
            updateOrder.setUuid(order.getUuid());
        }
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void deleteByCode(String code) {
        Order order = iOrderDAO.findByCode(code).get(0);
        iOrderDAO.deleteById(order.getId());
    }


    @Override
    @Transactional
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void addOrder(Order order) {
        order.setCode(order.getCode() == null || order.getCode() == "" ? UUIDUtils.getUUID() : order.getCode());
        iOrderDAO.save(order);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#order0")
    public List<Order> findAll() {
        return iOrderDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#order1")
    public Order findById(String id) {
        return iOrderDAO.findByCode(id).get(0);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#order0")
    public Page<Order> findAllByPage(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size);
        return iOrderDAO.findAll(pageable);
    }
}
