package com.chlian.trade.domain;

import javax.persistence.*;

@Entity
@Table(name = "stock_items")
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //int unsigned auto_increment  primary key,
    private String item_type; //varchar(255)           not null comment '库存单元类型',
    private String item_code; //varchar(255)           not null comment '库存单元编号',
    private Long stock; //bigint default '0'     not null comment '库存数',
    private Integer virtual_item; //tinyint(1) default '0' not null comment '虚拟物品',
    private String created_at; //timestamp              null,
    private String updated_at; //timestamp              null,
    private String group_code; //varchar(255)           null comment '库存组编号',
    private String category_code; //varchar(255)           null comment '库存分类编号',
    private String name; //varchar(255)           null comment '名称',
    private String description; //varchar(500)           null comment '库存项描述',

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Integer getVirtual_item() {
        return virtual_item;
    }

    public void setVirtual_item(Integer virtual_item) {
        this.virtual_item = virtual_item;
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

    public String getGroup_code() {
        return group_code;
    }

    public void setGroup_code(String group_code) {
        this.group_code = group_code;
    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "id=" + id +
                ", item_type='" + item_type + '\'' +
                ", item_code='" + item_code + '\'' +
                ", stock=" + stock +
                ", virtual_item=" + virtual_item +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", group_code='" + group_code + '\'' +
                ", category_code='" + category_code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
