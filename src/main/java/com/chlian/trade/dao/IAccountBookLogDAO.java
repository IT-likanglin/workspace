package com.chlian.trade.dao;

import com.chlian.trade.domain.AccountBook;
import com.chlian.trade.domain.AccountBookLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IAccountBookLogDAO extends JpaRepository<AccountBookLog, String>, JpaSpecificationExecutor<AccountBook> {

}
