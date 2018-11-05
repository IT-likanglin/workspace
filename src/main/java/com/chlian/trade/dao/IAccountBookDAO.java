package com.chlian.trade.dao;

import com.chlian.trade.domain.AccountBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 账本DAO
 */
public interface IAccountBookDAO extends JpaRepository<AccountBook, Integer>, JpaSpecificationExecutor<AccountBook> {

    @Query(value = "select * from account_book where serial_code = ?",nativeQuery = true)
    public List<AccountBook> findAccountBooksBySerial_code(String serial_code);


    @Query(value = "select * from account_book where out_biz_code = ?",nativeQuery = true)
    public List<AccountBook> findAccountBooksByOut_biz_code(String out_biz_code);



}
