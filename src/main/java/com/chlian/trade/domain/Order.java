package com.chlian.trade.domain;


import javax.persistence.*;

/**
 * 订单表
 */
@Entity
@Table(name = "orders")

public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uuid;
    private String merchant;

    private String code;
    private Integer cb;
    private Integer total_amount;
    private Integer payment_amount;
    private Integer logistics_price;
    private Integer status;
    private String payment_code;
    private Integer mark;
    private String refund_code;
    private String paid_at;
    private String finished_at;
    private String sent_at;
    private String received_at;
    private String checked_at;
    private String detail;
    private String remark;
    private String logistics_code;
    private String logistics_provider;
    private Long ccm_rewards;
    private String deleted_at;
    private String created_at;
    private String updated_at;
    private String address;
    private String province;
    private String city;
    private String county;
    private String contact_name;
    private String contact_phone;
    private String post_code;


   public Integer getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public String getMerchant() {
        return merchant;
    }

    public String getCode() {
        return code;
    }

    public Integer getCb() {
        return cb;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    public Integer getPayment_amount() {
        return payment_amount;
    }

    public Integer getLogistics_price() {
        return logistics_price;
    }

    public Integer getStatus() {
        return status;
    }

    public String getPayment_code() {
        return payment_code;
    }

    public Integer getMark() {
        return mark;
    }

    public String getRefund_code() {
        return refund_code;
    }

    public String getPaid_at() {
        return paid_at;
    }

    public String getFinished_at() {
        return finished_at;
    }

    public String getSent_at() {
        return sent_at;
    }

    public String getReceived_at() {
        return received_at;
    }

    public String getChecked_at() {
        return checked_at;
    }

    public String getDetail() {
        return detail;
    }

    public String getRemark() {
        return remark;
    }

    public String getLogistics_code() {
        return logistics_code;
    }

    public String getLogistics_provider() {
        return logistics_provider;
    }

    public Long getCcm_rewards() {
        return ccm_rewards;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getAddress() {
        return address;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return county;
    }

    public String getContact_name() {
        return contact_name;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCb(Integer cb) {
        this.cb = cb;
    }

    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }

    public void setPayment_amount(Integer payment_amount) {
        this.payment_amount = payment_amount;
    }

    public void setLogistics_price(Integer logistics_price) {
        this.logistics_price = logistics_price;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setPayment_code(String payment_code) {
        this.payment_code = payment_code;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public void setRefund_code(String refund_code) {
        this.refund_code = refund_code;
    }

    public void setPaid_at(String paid_at) {
        this.paid_at = paid_at;
    }

    public void setFinished_at(String finished_at) {
        this.finished_at = finished_at;
    }

    public void setSent_at(String sent_at) {
        this.sent_at = sent_at;
    }

    public void setReceived_at(String received_at) {
        this.received_at = received_at;
    }

    public void setChecked_at(String checked_at) {
        this.checked_at = checked_at;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setLogistics_code(String logistics_code) {
        this.logistics_code = logistics_code;
    }

    public void setLogistics_provider(String logistics_provider) {
        this.logistics_provider = logistics_provider;
    }

    public void setCcm_rewards(Long ccm_rewards) {
        this.ccm_rewards = ccm_rewards;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", merchant='" + merchant + '\'' +
                ", code='" + code + '\'' +
                ", cb=" + cb +
                ", total_amount=" + total_amount +
                ", payment_amount=" + payment_amount +
                ", logistics_price=" + logistics_price +
                ", status=" + status +
                ", payment_code='" + payment_code + '\'' +
                ", mark=" + mark +
                ", refund_code='" + refund_code + '\'' +
                ", paid_at='" + paid_at + '\'' +
                ", finished_at='" + finished_at + '\'' +
                ", sent_at='" + sent_at + '\'' +
                ", received_at='" + received_at + '\'' +
                ", checked_at='" + checked_at + '\'' +
                ", detail='" + detail + '\'' +
                ", remark='" + remark + '\'' +
                ", logistics_code='" + logistics_code + '\'' +
                ", logistics_provider='" + logistics_provider + '\'' +
                ", ccm_rewards=" + ccm_rewards +
                ", deleted_at='" + deleted_at + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", address='" + address + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", contact_name='" + contact_name + '\'' +
                ", contact_phone='" + contact_phone + '\'' +
                ", post_code='" + post_code + '\'' +
                '}';
    }
}
