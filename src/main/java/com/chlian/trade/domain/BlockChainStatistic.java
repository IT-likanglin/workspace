package com.chlian.trade.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "block_chain_statistics")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BlockChainStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //` int(10) unsigned NOT NULL AUTO_INCREMENT,
    private Long ccm_dispatched; //` bigint(20) unsigned NOT NULL COMMENT 'CCM 已发放总量',
    private Long turnover; //` bigint(20) unsigned NOT NULL COMMENT '今日营业额',
    private String created_at; //` timestamp NULL DEFAULT NULL,
    private String updated_at; //` timestamp NULL DEFAULT NULL,


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCcm_dispatched() {
        return ccm_dispatched;
    }

    public void setCcm_dispatched(Long ccm_dispatched) {
        this.ccm_dispatched = ccm_dispatched;
    }

    public Long getTurnover() {
        return turnover;
    }

    public void setTurnover(Long turnover) {
        this.turnover = turnover;
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
        return "BlockChainStatistic{" +
                "id=" + id +
                ", ccm_dispatched=" + ccm_dispatched +
                ", turnover=" + turnover +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
