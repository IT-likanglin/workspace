package com.chlian.trade.service;

import com.chlian.trade.domain.AccountBook;
import com.chlian.trade.domain.vo.AccountBookVo;

import java.util.List;
import java.util.Optional;

public interface IAccountBookService {

    List<AccountBook> findAll();

    Optional<AccountBook> findById(Integer id);

    List<AccountBook> findAllByPage(int page, int size);

    void deleteById(Integer id);

    void addAccountBook(AccountBookVo accountBook) throws IllegalAccessException;

    void updateAccountBook(Integer id, AccountBook accountBook);

    void addAccountBook(AccountBook accountBook);
}
