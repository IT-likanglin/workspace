package com.chlian.trade.service;

import com.chlian.trade.domain.CcmFundChangeLog;

import java.util.List;

public interface ICcmFundChangeLogService {

    List<CcmFundChangeLog> findAll();

    CcmFundChangeLog findById(Long id);

    List<CcmFundChangeLog> findAllByPage(Integer page, Integer size);

    void deleteById(Long id);

    void addCcmFundChangeLog(CcmFundChangeLog ccmFundChangeLog);

    void updateCcmFundChangeLog(Long id, CcmFundChangeLog ccmFundChangeLog);

}
