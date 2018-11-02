package com.chlian.trade.domain;


import javax.persistence.*;

@Entity
@Table(name = "invite_code_purchase_records")
public class InviteCodePurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code; //购买编号',
    private String uuid; //购买人',
    private Integer price; //单价',
    private String payment_code; // 支付单号',
    private Integer status; //状态',
    private String paid_at;  //支付时间';
    private Integer amount; //购买数量
    private Integer unit_amount; //'单个邀请码包含的可用次数'
    private String created_at;//` timestamp NULL DEFAULT NULL,
    private String updated_at; //` timestamp NULL DEFAULT NULL,

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPayment_code() {
        return payment_code;
    }

    public void setPayment_code(String payment_code) {
        this.payment_code = payment_code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(String paid_at) {
        this.paid_at = paid_at;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getUnit_amount() {
        return unit_amount;
    }

    public void setUnit_amount(Integer unit_amount) {
        this.unit_amount = unit_amount;
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
        return "InviteCodePurchaseRecord{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", uuid='" + uuid + '\'' +
                ", price=" + price +
                ", payment_code='" + payment_code + '\'' +
                ", status=" + status +
                ", paid_at='" + paid_at + '\'' +
                ", amount=" + amount +
                ", unit_amount=" + unit_amount +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
