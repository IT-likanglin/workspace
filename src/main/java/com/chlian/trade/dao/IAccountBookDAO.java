package com.chlian.trade.dao;

import com.chlian.trade.domain.AccountBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 账本DAO
 */
public interface IAccountBookDAO extends JpaRepository<AccountBook, Integer>, JpaSpecificationExecutor<AccountBook> {

}
