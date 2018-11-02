package com.chlian.trade.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "balance_withdraw_records")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BalanceWithdrawRecord extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    private String uuid; //` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户 UUID',
    private String code; //` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '提现单号',
    private String platform_no; //` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '平台单号',
    private Integer status; //` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '状态',
    private String created_at; //` timestamp NULL DEFAULT NULL,
    private String updated_at; //` timestamp NULL DEFAULT NULL,


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlatform_no() {
        return platform_no;
    }

    public void setPlatform_no(String platform_no) {
        this.platform_no = platform_no;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "BalanceWithdrawRecord{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", code='" + code + '\'' +
                ", platform_no='" + platform_no + '\'' +
                ", status=" + status +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
