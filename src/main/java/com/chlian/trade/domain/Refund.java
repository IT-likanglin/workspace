package com.chlian.trade.domain;

import javax.persistence.*;

/**
 * 退款
 */
@Entity
@Table(name = "refunds")
public class Refund extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uuid;
    private String code;
    private String payment_code;
    private String platform_no;
    private Integer platform;
    private Integer refund;
    private Integer  status;
    private String created_at;
    private String updated_at;

    public Integer getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public String getCode() {
        return code;
    }

    public String getPayment_code() {
        return payment_code;
    }

    public String getPlatform_no() {
        return platform_no;
    }

    public Integer getPlatform() {
        return platform;
    }

    public Integer getRefund() {
        return refund;
    }

    public Integer getStatus() {
        return status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPayment_code(String payment_code) {
        this.payment_code = payment_code;
    }

    public void setPlatform_no(String platform_no) {
        this.platform_no = platform_no;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public void setRefund(Integer refund) {
        this.refund = refund;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", code='" + code + '\'' +
                ", payment_code='" + payment_code + '\'' +
                ", platform_no='" + platform_no + '\'' +
                ", platform=" + platform +
                ", refund=" + refund +
                ", status=" + status +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
