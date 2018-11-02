package com.chlian.trade.dao;


import com.chlian.trade.domain.CcmFundChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICcmFundChangeLogDAO extends JpaRepository<CcmFundChangeLog, Long> {
}
