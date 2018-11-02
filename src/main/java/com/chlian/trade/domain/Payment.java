package com.chlian.trade.domain;


import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment extends BaseEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //primary key
    private String uuid;
    private String code;  //unique key
    private String platform_no;
    private Integer platform;
    private Integer paid;
    private Integer status;
    private String paid_at;
    private Integer exception_id;
    private String exception;
    private String created_at;
    private String updated_at;
    private String trigger;

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public String getCode() {
        return code;
    }

    public String getPlatform_no() {
        return platform_no;
    }

    public Integer getPlatform() {
        return platform;
    }

    public Integer getPaid() {
        return paid;
    }

    public Integer getStatus() {
        return status;
    }

    public String getPaid_at() {
        return paid_at;
    }

    public Integer getException_id() {
        return exception_id;
    }

    public String getException() {
        return exception;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPlatform_no(String platform_no) {
        this.platform_no = platform_no;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setPaid_at(String paid_at) {
        this.paid_at = paid_at;
    }

    public void setException_id(Integer exception_id) {
        this.exception_id = exception_id;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", code='" + code + '\'' +
                ", platform_no='" + platform_no + '\'' +
                ", platform=" + platform +
                ", paid=" + paid +
                ", status=" + status +
                ", paid_at='" + paid_at + '\'' +
                ", exception_id=" + exception_id +
                ", exception='" + exception + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", trigger='" + trigger + '\'' +
                '}';
    }
}
