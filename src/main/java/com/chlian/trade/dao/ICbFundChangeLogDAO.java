package com.chlian.trade.dao;

import com.chlian.trade.domain.CbFundChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICbFundChangeLogDAO extends JpaRepository<CbFundChangeLog, Long> {
}
