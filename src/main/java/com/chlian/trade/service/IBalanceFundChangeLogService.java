package com.chlian.trade.service;

import com.chlian.trade.domain.BalanceFundChangeLog;

import java.util.List;

public interface IBalanceFundChangeLogService {

    void addBalanceFundChangeLog(BalanceFundChangeLog balanceFundChangeLog);

    void deleteById(Long id);

    void updateBalanceFundChangeLog(Long id, BalanceFundChangeLog balanceFundChangeLog);

    List<BalanceFundChangeLog> findAll();

    BalanceFundChangeLog findById(Long id);

    List<BalanceFundChangeLog> findAllByPage(Integer page, Integer size);
}
