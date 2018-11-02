package com.chlian.trade.service;

import com.chlian.trade.domain.AccountBook;

import java.util.List;
import java.util.Optional;

public interface IAccountBookService {

    List<AccountBook> findAll();

    Optional<AccountBook> findById(Integer id);

    List<AccountBook> findAllByPage(int page, int size);

    void deleteById(Integer id);

    void addAccountBook(AccountBook accountBook);

    void updateAccountBook(Integer id, AccountBook accountBook);

}
