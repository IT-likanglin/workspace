package com.chlian.trade.service;

import com.chlian.trade.domain.InviteCodePurchaseRecord;

import java.util.List;

public interface IInviteCodePurchaseRecordService {
    List<InviteCodePurchaseRecord> findAll();

    InviteCodePurchaseRecord findByCode(String code);

    List<InviteCodePurchaseRecord> findAllByPage(int parseInt, int parseInt1);

    void deleteByCode(String code);

    void addRefund(InviteCodePurchaseRecord inviteCodePurchaseRecord);

    void updateRefund(String code, InviteCodePurchaseRecord inviteCodePurchaseRecord);
}
