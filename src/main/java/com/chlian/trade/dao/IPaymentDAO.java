package com.chlian.trade.dao;

import com.chlian.trade.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPaymentDAO extends JpaRepository<Payment, Long> {

    @Query(value = "select * from payments o where o.code=?", nativeQuery = true)
    Payment findByCode(String code);
}
