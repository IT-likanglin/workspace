package com.chlian.trade.dao;

import com.chlian.trade.domain.AccountBook;
import com.chlian.trade.domain.AccountBookLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IAccountBookLogDAO extends JpaRepository<AccountBookLog, String>, JpaSpecificationExecutor<AccountBook> {

}
