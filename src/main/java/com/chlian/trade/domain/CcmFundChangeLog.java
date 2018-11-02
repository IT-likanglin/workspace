package com.chlian.trade.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "ccm_fund_change_logs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CcmFundChangeLog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    private String uuid; //` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'UUID',
    private Long ccm; //` bigint(20) unsigned NOT NULL COMMENT '用户 CCM',
    private Integer event; //` smallint(5) unsigned NOT NULL COMMENT '变更事件',
    private String trace; //` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '追踪来源记录信息',
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

    public Long getCcm() {
        return ccm;
    }

    public void setCcm(Long ccm) {
        this.ccm = ccm;
    }

    public Integer getEvent() {
        return event;
    }

    public void setEvent(Integer event) {
        this.event = event;
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

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "CcmFundChangeLog{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", ccm=" + ccm +
                ", event=" + event +
                ", trace='" + trace + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
