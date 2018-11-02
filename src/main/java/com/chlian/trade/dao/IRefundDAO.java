package com.chlian.trade.dao;

import com.chlian.trade.domain.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRefundDAO extends JpaRepository<Refund, Integer> {

    @Query(value = "select * from refunds where code = ?", nativeQuery = true)
    Refund findByCode(String code);
}