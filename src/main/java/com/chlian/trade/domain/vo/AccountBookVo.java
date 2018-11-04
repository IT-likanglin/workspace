package com.chlian.trade.domain.vo;

import com.chlian.trade.domain.AccountBook;
import com.chlian.trade.domain.AccountBookLog;

import java.util.List;

/**
 * 账本包装类，用于封装账本记录和账本记录变更
 * */
public class AccountBookVo {
    private List<AccountBook> accountBooks;//封装账本，一个交易记录对应多条账本记录
    private AccountBookLog accountBookLog;//封装账本记录变更

    public AccountBookVo() {
    }

    public AccountBookVo(List<AccountBook> accountBooks, AccountBookLog accountBookLog) {
        this.accountBooks = accountBooks;
        this.accountBookLog = accountBookLog;
    }

    public List<AccountBook> getAccountBooks() {
        return accountBooks;
    }

    public void setAccountBooks(List<AccountBook> accountBooks) {
        this.accountBooks = accountBooks;
    }

    public AccountBookLog getAccountBookLog() {
        return accountBookLog;
    }

    public void setAccountBookLog(AccountBookLog accountBookLog) {
        this.accountBookLog = accountBookLog;
    }
}
