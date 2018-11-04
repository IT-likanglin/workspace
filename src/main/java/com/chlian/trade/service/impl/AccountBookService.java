package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IAccountBookDAO;
import com.chlian.trade.dao.IAccountBookLogDAO;
import com.chlian.trade.domain.AccountBook;
import com.chlian.trade.domain.vo.AccountBookVo;
import com.chlian.trade.service.IAccountBookService;
import com.chlian.trade.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountBookService implements IAccountBookService {

    @Autowired
    private IAccountBookDAO accountBookDAO;

    @Autowired
    private IAccountBookLogDAO accountBookLogDAO;


    @Override
    @Transactional
    public void addAccountBook(AccountBookVo accountBookVo) throws IllegalAccessException {

        if(accountBookVo == null && accountBookVo.getAccountBooks().size() == 0){
            throw new RuntimeException("交易记录不能为空");
        }
        String UUId = UUIDUtils.getUUID();
        int flag = 0;
        for(AccountBook accountBook : accountBookVo.getAccountBooks()){
            accountBook.setSerial_code(UUId);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            accountBook.setCreated_at(simpleDateFormat.format(new Date()));
            accountBook.setUpdated_at(simpleDateFormat.format(new Date()));
            flag += accountBook.getFunds();
            isNullOrEmpty(accountBook);
        }
        if(flag != 0){
            throw new RuntimeException("交易资金有误");
        }

        for(AccountBook accountBook : accountBookVo.getAccountBooks()){
            accountBook.setId(null);
            accountBookDAO.save(accountBook);
        }
        accountBookVo.getAccountBookLog().setSerial_code(UUId);
        isNullOrEmpty(accountBookVo.getAccountBookLog());
        accountBookLogDAO.save(accountBookVo.getAccountBookLog());
    }

    private void isNullOrEmpty(Object obj) throws IllegalAccessException {
        for(Field field : obj.getClass().getDeclaredFields()){
            field.setAccessible(true);
            if("id".equals(field.getName())){
                continue;
            }
            if(field.get(obj) == null || "".equals(field.get(obj))){
                throw new RuntimeException(field.getName()+"不能为空");
            }
        }
    }

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
