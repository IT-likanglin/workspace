package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IInviteCodePurchaseRecordDAO;
import com.chlian.trade.domain.InviteCodePurchaseRecord;
import com.chlian.trade.service.IInviteCodePurchaseRecordService;
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
public class InviteCodePurchaseRecordService implements IInviteCodePurchaseRecordService {

    @Autowired
    private IInviteCodePurchaseRecordDAO iInviteCodePurchaseRecordDAO;


    @Override
    @Cacheable(value = "secondlevels", key = "#inviteCodePurchaseRecord1")
    public List<InviteCodePurchaseRecord> findAll() {
        return iInviteCodePurchaseRecordDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#inviteCodePurchaseRecord2")
    public InviteCodePurchaseRecord findByCode(String code) {
        return iInviteCodePurchaseRecordDAO.findByCode(code);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#inviteCodePurchaseRecord3")
    public List<InviteCodePurchaseRecord> findAllByPage(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<InviteCodePurchaseRecord> InviteCodePurchaseRecordPage = iInviteCodePurchaseRecordDAO.findAll(pageable);
        return InviteCodePurchaseRecordPage.getContent();
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void deleteByCode(String code) {
        InviteCodePurchaseRecord codePurchaseRecord = iInviteCodePurchaseRecordDAO.findByCode(code);
        iInviteCodePurchaseRecordDAO.deleteById(codePurchaseRecord.getId());
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void addRefund(InviteCodePurchaseRecord inviteCodePurchaseRecord) {
        inviteCodePurchaseRecord.setCode(inviteCodePurchaseRecord.getCode() == null ? UUIDUtils.getUUID() : inviteCodePurchaseRecord.getCode());
        iInviteCodePurchaseRecordDAO.save(inviteCodePurchaseRecord);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void updateRefund(String code, InviteCodePurchaseRecord inviteCodePurchaseRecord) {
        InviteCodePurchaseRecord updateInviteCodePurchaseRecord = iInviteCodePurchaseRecordDAO.findByCode(code);

        if(inviteCodePurchaseRecord.getAmount() != null) {
            updateInviteCodePurchaseRecord.setAmount(inviteCodePurchaseRecord.getAmount());
        }
        if(inviteCodePurchaseRecord.getCreated_at() != null) {
            updateInviteCodePurchaseRecord.setCreated_at(inviteCodePurchaseRecord.getCreated_at());
        }
        if(inviteCodePurchaseRecord.getPaid_at() != null) {
            updateInviteCodePurchaseRecord.setPaid_at(inviteCodePurchaseRecord.getPaid_at());
        }
        if(inviteCodePurchaseRecord.getPayment_code() != null) {
            updateInviteCodePurchaseRecord.setPayment_code(inviteCodePurchaseRecord.getPayment_code());
        }
        if(inviteCodePurchaseRecord.getPrice() != null) {
            updateInviteCodePurchaseRecord.setPrice(inviteCodePurchaseRecord.getPrice());
        }
        if(inviteCodePurchaseRecord.getStatus() != null) {
            updateInviteCodePurchaseRecord.setStatus(inviteCodePurchaseRecord.getStatus());
        }
        if(inviteCodePurchaseRecord.getUnit_amount() != null) {
            updateInviteCodePurchaseRecord.setUnit_amount(inviteCodePurchaseRecord.getUnit_amount());
        }
        if(inviteCodePurchaseRecord.getUpdated_at() != null) {
            updateInviteCodePurchaseRecord.setUpdated_at(inviteCodePurchaseRecord.getUpdated_at());
        }
        if(inviteCodePurchaseRecord.getUuid() != null) {
            updateInviteCodePurchaseRecord.setUuid(inviteCodePurchaseRecord.getUuid());
        }

    }
}
