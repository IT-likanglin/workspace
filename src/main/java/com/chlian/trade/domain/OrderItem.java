package com.chlian.trade.domain;

import javax.persistence.*;

/**
 * 订单商品项目
 */
@Entity
@Table(name = "order_items")
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String order_code;
    private String commodity_code;
    private String commodity_sku_code;
    private String name;
    private String cover;
    private String summary;
    private String specification;
    private Integer amount;
    private Integer unit_price;
    private Integer actual_unit_price;
    private Integer cb;
    private String created_at;
    private String updated_at;

    public Integer getId() {
        return id;
    }

    public String getOrder_code() {
        return order_code;
    }

    public String getCommodity_code() {
        return commodity_code;
    }

    public String getCommodity_sku_code() {
        return commodity_sku_code;
    }

    public String getName() {
        return name;
    }

    public String getCover() {
        return cover;
    }

    public String getSummary() {
        return summary;
    }

    public String getSpecification() {
        return specification;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getUnit_price() {
        return unit_price;
    }

    public Integer getActual_unit_price() {
        return actual_unit_price;
    }

    public Integer getCb() {
        return cb;
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

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public void setCommodity_code(String commodity_code) {
        this.commodity_code = commodity_code;
    }

    public void setCommodity_sku_code(String commodity_sku_code) {
        this.commodity_sku_code = commodity_sku_code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setUnit_price(Integer unit_price) {
        this.unit_price = unit_price;
    }

    public void setActual_unit_price(Integer actual_unit_price) {
        this.actual_unit_price = actual_unit_price;
    }

    public void setCb(Integer cb) {
        this.cb = cb;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order_code='" + order_code + '\'' +
                ", commodity_code='" + commodity_code + '\'' +
                ", commodity_sku_code='" + commodity_sku_code + '\'' +
                ", name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", summary='" + summary + '\'' +
                ", specification='" + specification + '\'' +
                ", amount=" + amount +
                ", unit_price=" + unit_price +
                ", actual_unit_price=" + actual_unit_price +
                ", cb=" + cb +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
