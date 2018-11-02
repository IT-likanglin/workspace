package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IRefundDAO;
import com.chlian.trade.domain.Refund;
import com.chlian.trade.service.IRefundService;
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

/**
 *  退款Controller
 * @author liujiao
 */
@Service
public class RefundService implements IRefundService {

    @Autowired
    private IRefundDAO iRefundDAO;

    @Override
    @Cacheable(value = "secondlevels", key = "#refund1")
    public List<Refund> findAll() {
        return iRefundDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#refund2")
    public Refund findByCode(String code) {
        return iRefundDAO.findByCode(code);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#refund3")
    public List<Refund> findAllByPage(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size);
        Page<Refund> refundPage = iRefundDAO.findAll(pageable);
        return refundPage.getContent();
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void deleteByCode(String code) {
        Refund refund = iRefundDAO.findByCode(code);
        iRefundDAO.deleteById(refund.getId());
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void addRefund(Refund refund) {
        refund.setCode(refund.getCode() == null || refund.getCode() == "" ? UUIDUtils.getUUID() : refund.getCode());
        iRefundDAO.save(refund);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void updateRefund(String code, Refund refund) {
        Refund updateRefund = iRefundDAO.findByCode(code);

        if(refund.getId() != null) {
            updateRefund.setId(refund.getId());
        }
        if(refund.getCreated_at() != null) {
            updateRefund.setCreated_at(refund.getCreated_at());
        }
        if(refund.getPayment_code() != null) {
            updateRefund.setPayment_code(refund.getPayment_code());
        }
        if(refund.getPlatform() != null) {
            updateRefund.setPlatform(refund.getPlatform());
        }
        if(refund.getPlatform_no() != null) {
            updateRefund.setPlatform_no(refund.getPlatform_no());
        }
        if(refund.getRefund() != null) {
            updateRefund.setRefund(refund.getRefund());
        }
        if(refund.getStatus() != null) {
            updateRefund.setStatus(refund.getStatus());
        }
        if(refund.getUuid() != null) {
            updateRefund.setUuid(refund.getUuid());
        }

    }


}
