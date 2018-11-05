package com.chlian.trade.service.impl;

import com.chlian.trade.dao.IAccountBookDAO;
import com.chlian.trade.dao.IAccountBookLogDAO;
import com.chlian.trade.domain.AccountBook;
import com.chlian.trade.domain.AccountBookLog;
import com.chlian.trade.domain.vo.AccountBookVo;
import com.chlian.trade.service.IAccountBookService;
import com.chlian.trade.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AccountBookService implements IAccountBookService {

    @Autowired
    private IAccountBookDAO accountBookDAO;

    @Autowired
    private IAccountBookLogDAO accountBookLogDAO;


    @Override
    @Transactional
    public void addAccountBook(AccountBookVo accountBookVo) throws IllegalAccessException {

        if(accountBookVo == null && accountBookVo.getAccountBooks().size() <3){
            throw new RuntimeException("交易记录不能为空");
        }
        String UUId = UUIDUtils.getUUID();
        int flag = 0;
        String out_biz_code = null;
        for(AccountBook accountBook : accountBookVo.getAccountBooks()){
            accountBook.setId(null);
            accountBook.setSerial_code(UUId);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            accountBook.setCreated_at(simpleDateFormat.format(new Date()));
            accountBook.setUpdated_at(simpleDateFormat.format(new Date()));
            accountBook.setAccount(accountBook.getAccount().trim());
            accountBook.setOut_biz_code(accountBook.getOut_biz_code().trim());
            flag += accountBook.getFunds();
            isNullOrEmpty(accountBook);
            if(out_biz_code == null){
                out_biz_code = accountBook.getOut_biz_code();
            }
            if(!out_biz_code.equals(accountBook.getOut_biz_code())){
                throw new RuntimeException("订单号不一致");
            }
        }
        if(flag != 0){
            throw new RuntimeException("交易资金有误");
        }
        accountBookDAO.saveAll(accountBookVo.getAccountBooks());
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
            if(StringUtils.isEmpty(field.get(obj))){
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
    public AccountBookVo findById(Integer id) {
        List<AccountBook> accountBooks = new ArrayList<>();
        AccountBook accountBook = accountBookDAO.findById(id).get();
        accountBooks.add(accountBook);
        AccountBookLog accountBookLog = accountBookLogDAO.findById(accountBook.getSerial_code()).get();
        AccountBookVo accountBookVo = new AccountBookVo();
        accountBookVo.setAccountBooks(accountBooks);
        accountBookVo.setAccountBookLog(accountBookLog);
        return accountBookVo;
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

    @Override
    @Cacheable(value = "secondlevels", key = "#searchMap")
    public List<AccountBookVo> findBySpec(Map<String, String> searchMap) {
        List<AccountBook> result_accoutBooks = null;
        if(searchMap == null || searchMap.size() == 0){
            result_accoutBooks = accountBookDAO.findAll();
        }else{
            Specification<AccountBook> book_spec = new Specification<AccountBook>() {
                @Override
                public Predicate toPredicate(Root<AccountBook> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                    List<Predicate> predicateList = new ArrayList<Predicate>();
                    if(searchMap.get("id") != null && !"".equals(searchMap.get("id"))){
                        predicateList.add(cb.equal(root.get("id"),searchMap.get("id")));
                    }
                    if(searchMap.get("serial_code") != null && !"".equals(searchMap.get("serial_code"))){
                        predicateList.add(cb.like(root.get("serial_code").as(String.class),"%"+(String)searchMap.get("serial_code")+"%"));
                    }
                    if(searchMap.get("account") != null && !"".equals(searchMap.get("account"))){
                        predicateList.add(cb.like(root.get("serial_code").as(String.class),"%"+(String)searchMap.get("account")+"%"));
                    }
                    if(searchMap.get("account_type") != null && !"".equals(searchMap.get("account_type"))){
                        predicateList.add(cb.equal(root.get("account_type"),searchMap.get("account_type")));
                    }
                    if(searchMap.get("funds") != null && !"".equals(searchMap.get("funds"))){
                        predicateList.add(cb.equal(root.get("funds"),searchMap.get("funds")));
                    }
                    if(searchMap.get("fund_type") != null && !"".equals(searchMap.get("fund_type"))){
                        predicateList.add(cb.equal(root.get("fund_type"),searchMap.get("fund_type")));
                    }
                    if(searchMap.get("out_biz_code") != null && !"".equals(searchMap.get("out_biz_code"))){
                        predicateList.add(cb.like(root.get("out_biz_code").as(String.class),"%"+(String)searchMap.get("out_biz_code")+"%"));
                    }
                    if(searchMap.get("trade_type") != null && !"".equals(searchMap.get("trade_type"))){
                        predicateList.add(cb.equal(root.get("trade_type").as(String.class),searchMap.get("trade_type")));
                    }
                    return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
                }
            };
            result_accoutBooks = accountBookDAO.findAll(book_spec);
        }
        return getAccountBookVoList(result_accoutBooks);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#out_biz_code")
    public List<AccountBookVo> findByOut_biz_code(String out_biz_code) {

        List<AccountBook> accountBookList = accountBookDAO.findAccountBooksByOut_biz_code(out_biz_code);
        return getAccountBookVoList(accountBookList);
    }

    @Override
    @Cacheable(value = "secondlevels", key = "#serial_code")
    public List<AccountBookVo> findBySerial_code(String serial_code) {
        List<AccountBook> accountBookList = accountBookDAO.findAccountBooksBySerial_code(serial_code);
        return getAccountBookVoList(accountBookList);
    }


    private List<AccountBookVo> getAccountBookVoList(List<AccountBook> accountBooks){
        Set<String> serial_codes = new HashSet<>();
        List<String> distinct_serial_codes = new ArrayList<>();
        for(AccountBook accountBook : accountBooks){
            if(serial_codes.add(accountBook.getSerial_code())){
                   distinct_serial_codes.add(accountBook.getSerial_code());
            }
        }
        List<AccountBookVo> accountBookVos = new ArrayList<>();
        for(String serial_code : distinct_serial_codes){
            AccountBookVo accountBookvo = new AccountBookVo();
            List<AccountBook> accountBookList = accountBookDAO.findAccountBooksBySerial_code(serial_code);
            AccountBookLog accountBookLog = accountBookLogDAO.findById(serial_code).get();
            accountBookvo.setAccountBooks(accountBooks);
            accountBookvo.setAccountBookLog(accountBookLog);
            accountBookVos.add(accountBookvo);
        }
        return accountBookVos;
    }
}


