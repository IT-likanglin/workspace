package com.chlian.trade.dao;

import com.chlian.trade.domain.AccountBookLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountBookLogDAO extends JpaRepository<AccountBookLog, String> {

}
