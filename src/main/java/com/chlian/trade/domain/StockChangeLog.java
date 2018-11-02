package com.chlian.trade.domain;

import javax.persistence.*;

@Entity
@Table(name = "stock_change_logs")
public class StockChangeLog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //         bigint unsigned auto_increment primary key,
    private String item_type; //  varchar(255)         not null comment '库存单元类型',
    private String item_code; //  varchar(255)         not null comment '库存单元编号',
    private Integer stock; //      int                  not null comment '库存变更',
    private Integer event; //      smallint(5) unsigned not null comment '变更事件',
    private String trace; //      varchar(255)         not null comment '追踪来源记录信息',
    private String created_at; // timestamp            null,
    private String updated_at; // timestamp            null


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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
        return "StockChangeLog{" +
                "id=" + id +
                ", item_type='" + item_type + '\'' +
                ", item_code='" + item_code + '\'' +
                ", stock=" + stock +
                ", event=" + event +
                ", trace='" + trace + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
