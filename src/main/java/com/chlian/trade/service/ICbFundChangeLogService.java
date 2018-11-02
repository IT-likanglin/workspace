package com.chlian.trade.service;

import com.chlian.trade.domain.CbFundChangeLog;

import java.util.List;

public interface ICbFundChangeLogService {

    List<CbFundChangeLog> findAll();

    CbFundChangeLog findById(Long id);

    List<CbFundChangeLog> findAllByPage(Integer page, Integer size);

    void deleteById(Long id);

    void addCbFundChangeLog(CbFundChangeLog cbFundChangeLog);

    void updateCbFundChangeLog(Long id, CbFundChangeLog cbFundChangeLog);

}
