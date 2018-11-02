package com.chlian.trade.domain;

import javax.persistence.*;

/**
 * 资金账户
 */
@Entity
@Table(name = "fund_accounts")
public class FundAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // int(10) unsigned NOT NULL AUTO_INCREMENT,
    private String uuid; // varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户 UUID',
    private Long balance; // bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户余额',
    private Long ccm; // bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户 CCM',
    private Long cb;//` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户 CB',
    private Long freeze; //` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '冻结余额',
    private Long freeze_ccm; // bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '冻结 CCM',
    private String created_at; // timestamp NULL DEFAULT NULL,
    private String updated_at; // timestamp NULL DEFAULT NULL,

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getCcm() {
        return ccm;
    }

    public void setCcm(Long ccm) {
        this.ccm = ccm;
    }

    public Long getCb() {
        return cb;
    }

    public void setCb(Long cb) {
        this.cb = cb;
    }

    public Long getFreeze() {
        return freeze;
    }

    public void setFreeze(Long freeze) {
        this.freeze = freeze;
    }

    public Long getFreeze_ccm() {
        return freeze_ccm;
    }

    public void setFreeze_ccm(Long freeze_ccm) {
        this.freeze_ccm = freeze_ccm;
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
        return "FundAccount{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", balance=" + balance +
                ", ccm=" + ccm +
                ", cb=" + cb +
                ", freeze=" + freeze +
                ", freeze_ccm=" + freeze_ccm +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
