package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IAccountBookDAO;
import com.chlian.trade.domain.AccountBook;
import com.chlian.trade.service.IAccountBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountBookService implements IAccountBookService {

    @Autowired
    private IAccountBookDAO accountBookDAO;


    @Override
    @Cacheable(value = "secondlevels", key = "#accountBook1")
    public List<AccountBook> findAll() {
        return accountBookDAO.findAll();
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#accountBook2")
    public Optional<AccountBook> findById(Integer id) {
        return accountBookDAO.findById(id);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#accountBook3")
    public List<AccountBook> findAllByPage(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<AccountBook> pageList = accountBookDAO.findAll(pageable);
        return pageList.getContent();
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void deleteById(Integer id) {
        accountBookDAO.deleteById(id);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void addAccountBook(AccountBook accountBook) {
        accountBookDAO.save(accountBook);
    }

    @Override
    @Transactional
    @Modifying
    @CacheEvict(cacheNames = "secondlevels", allEntries = true)
    public void updateAccountBook(Integer id, AccountBook accountBook) {
        AccountBook updateAccountBook = accountBookDAO.getOne(id);

        if(accountBook.getAccount() != null) {
            updateAccountBook.setAccount(accountBook.getAccount());
        }
        if(accountBook.getAccount_type() != null) {
            updateAccountBook.setAccount_type(accountBook.getAccount_type());
        }
        if(accountBook.getCreated_at() != null) {
            updateAccountBook.setCreated_at(accountBook.getCreated_at());
        }
        if(accountBook.getFund_type() != null) {
            updateAccountBook.setFund_type(accountBook.getFund_type());
        }
        if(accountBook.getFunds() != null) {
            updateAccountBook.setFunds(accountBook.getFunds());
        }
        if(accountBook.getOut_biz_code() != null) {
            updateAccountBook.setOut_biz_code(accountBook.getOut_biz_code());
        }
        if(accountBook.getSerial_code() != null) {
            updateAccountBook.setSerial_code(accountBook.getSerial_code());
        }
        if(accountBook.getUpdated_at() != null) {
            updateAccountBook.setUpdated_at(accountBook.getUpdated_at());
        }
    }
}
