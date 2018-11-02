package com.chlian.trade.domain;

import javax.persistence.*;

@Entity
@Table(name = "trade_master_account")
public class TradeMasterAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //int(10) UNSIGNED
    private String account; //varchar(255) COMMENT ''账号''
    private Long funds; //bigint(20) COMMENT ''资⾦金金''
    private String trace; //varchar(500)  根源追踪
    private String created_at; //timestamp
    private String pupdated_at; //timestamp


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Long getFunds() {
        return funds;
    }

    public void setFunds(Long funds) {
        this.funds = funds;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPupdated_at() {
        return pupdated_at;
    }

    public void setPupdated_at(String pupdated_at) {
        this.pupdated_at = pupdated_at;
    }

    @Override
    public String toString() {
        return "TradeMasterAccount{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", funds=" + funds +
                ", trace='" + trace + '\'' +
                ", created_at='" + created_at + '\'' +
                ", pupdated_at='" + pupdated_at + '\'' +
                '}';
    }
}
