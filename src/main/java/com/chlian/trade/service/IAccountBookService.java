package com.chlian.trade.service;

import com.chlian.trade.domain.AccountBook;
import com.chlian.trade.domain.vo.AccountBookVo;

import java.util.List;
import java.util.Map;

public interface IAccountBookService {

    List<AccountBook> findAll();

    AccountBookVo findById(Integer id);

    List<AccountBook> findAllByPage(int page, int size);

    void deleteById(Integer id);

    /**
     * 插入账本记录和日志
     * */
    void addAccountBook(AccountBookVo accountBook) throws IllegalAccessException;

    void updateAccountBook(Integer id, AccountBook accountBook);

    void addAccountBook(AccountBook accountBook);

    /**
     *通过多条件动态查询
     * */
    List<AccountBookVo> findBySpec(Map<String, String> map);

    /**
     * 根据订单号查询
     * */
    List<AccountBookVo> findByOut_biz_code(String out_biz_code);

    /**
     * 根据订单业务序号查询
     * */
    List<AccountBookVo> findBySerial_code(String serial_code);
}
