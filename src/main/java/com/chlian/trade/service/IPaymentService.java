package com.chlian.trade.service;

import com.chlian.trade.domain.Payment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPaymentService {

    void addPayment(Payment payment);

    void deleteByCode(String code);

    void updatePayment(String code, Payment payment);

    List<Payment> findAll();

    Payment findById(String id);

    Page<Payment> findAllByPage(Integer page, Integer size);
}
