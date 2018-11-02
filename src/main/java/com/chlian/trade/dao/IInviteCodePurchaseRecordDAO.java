package com.chlian.trade.dao;

import com.chlian.trade.domain.InviteCodePurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IInviteCodePurchaseRecordDAO extends JpaRepository<InviteCodePurchaseRecord, Integer> {

    @Query(value = "select * from invite_code_purchase_records where code = ?", nativeQuery = true)
    InviteCodePurchaseRecord findByCode(String code);
}
