package com.chlian.trade.service;

import com.chlian.trade.domain.Refund;

import java.util.List;

public interface IRefundService {

    List<Refund> findAll();

    Refund findByCode(String code);

    List<Refund> findAllByPage(Integer page, Integer size);

    void deleteByCode(String code);

    void addRefund(Refund refund);

    void updateRefund(String code, Refund refund);
}
