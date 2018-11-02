package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IPaymentDAO;
import com.chlian.trade.domain.Payment;
import com.chlian.trade.service.IPaymentService;
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
public class PaymentService implements IPaymentService {

    @Autowired
    IPaymentDAO iPaymentDAO;

    @Override
    @Transactional
    @CacheEvict(cacheNames="secondlevels",allEntries = true)
    public void addPayment(Payment payment) {
        String code = payment.getCode() == null || payment.getCode() == "" ? UUIDUtils.getUUID() : payment.getCode();
        payment.setCode(code);
        iPaymentDAO.save(payment);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames="secondlevels",allEntries = true)
    public void deleteByCode(String code) {
        Payment payment = iPaymentDAO.findByCode(code);
        iPaymentDAO.deleteById(payment.getId());
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames="secondlevels",allEntries = true)
    public void updatePayment(String  code, Payment payment) {
        Payment updatePayment = iPaymentDAO.findByCode(code);

        if(payment.getCode() != null) {
            updatePayment.setCode(payment.getCode());
        }
        if(payment.getCreated_at() != null) {
            updatePayment.setCreated_at(payment.getCreated_at());
        }
        if(payment.getException() != null) {
            updatePayment.setException(payment.getException());
        }
        if(payment.getException_id() != null) {
            updatePayment.setException_id(payment.getException_id());
        }
        if(payment.getPaid() != null) {
            updatePayment.setPaid(payment.getPaid());
        }
        if(payment.getPaid_at() != null) {
            updatePayment.setPaid_at(payment.getPaid_at());
        }
        if(payment.getPlatform() != null) {
            updatePayment.setPlatform(payment.getPlatform());
        }
        if(payment.getPlatform_no() != null) {
            updatePayment.setPlatform_no(payment.getPlatform_no());
        }
        if(payment.getStatus() != null) {
            updatePayment.setStatus(payment.getStatus());
        }
        if(payment.getTrigger() != null) {
            updatePayment.setTrigger(payment.getTrigger());
        }
        if(payment.getUpdated_at() != null) {
            updatePayment.setUpdated_at(payment.getUpdated_at());
        }
        if(payment.getUuid() != null) {
            updatePayment.setUuid(payment.getUuid());
        }

    }

    @Override
    @Cacheable(value = "secondlevels", key = "#payment0")
    public List<Payment> findAll() {
        return iPaymentDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#payment1")
    public Payment findById(String code) {
        return iPaymentDAO.findByCode(code);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#payment2")
    public Page<Payment> findAllByPage(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size);
        return iPaymentDAO.findAll(pageable);
    }
}
