package com.chlian.trade.domain;

import javax.persistence.*;

/**
 * 账本
 */
@Entity
@Table(name = "account_book")
public class AccountBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //int(10) UNSIGNED
    private String serial_code; //varchar(50) COMMENT ''业务序号''
    private String account; //varchar(255) COMMENT ''账号名称''
    private Integer account_type; //int(10) COMMENT ''影响人账号类型''
    private Long funds; //bigint(20) COMMENT ''交易易资⾦''
    private Integer fund_type; //smallint(10) COMMENT ''资⾦类型''
    private String out_biz_code; //varchar(255) COMMENT ''外部编号''
    private String created_at; //timestamp
    private String updated_at; //timestamp

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial_code() {
        return serial_code;
    }

    public void setSerial_code(String serial_code) {
        this.serial_code = serial_code;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getAccount_type() {
        return account_type;
    }

    public void setAccount_type(Integer account_type) {
        this.account_type = account_type;
    }

    public Long getFunds() {
        return funds;
    }

    public void setFunds(Long funds) {
        this.funds = funds;
    }

    public Integer getFund_type() {
        return fund_type;
    }

    public void setFund_type(Integer fund_type) {
        this.fund_type = fund_type;
    }

    public String getOut_biz_code() {
        return out_biz_code;
    }

    public void setOut_biz_code(String out_biz_code) {
        this.out_biz_code = out_biz_code;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }


    @Override
    public String toString() {
        return "AccountBook{" +
                "id=" + id +
                ", serial_code='" + serial_code + '\'' +
                ", account='" + account + '\'' +
                ", account_type=" + account_type +
                ", funds=" + funds +
                ", fund_type=" + fund_type +
                ", out_biz_code='" + out_biz_code + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
