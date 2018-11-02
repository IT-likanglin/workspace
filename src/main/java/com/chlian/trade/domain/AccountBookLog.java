package com.chlian.trade.domain;

import javax.persistence.*;

/**
 * 账本记录变更
 */
@Entity
@Table(name = "account_book_logs")
public class AccountBookLog {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String serial_code; //varchar(50) COMMENT ''业务序号,对应 account_book中的serial_code字段''
    private String subject; //varchar(255) COMMENT ''资⾦金金变更更主题''
    private String body; //varchar(1000) COMMENT ''资⾦金金变更更详情记录''
    private String event; //varchar(255) COMMENT ''事件记录，多个记录⽤用;隔开''
    private String trace; //varchar(255) COMMENT ''源头追踪''
    private Integer status; //int(10) COMMENT ''审核状态''
    private String checked_at; //timestamp COMMENT ''审核时间''
    private String checker; //varchar(255) COMMENT ''审核⼈人''
    private Integer check_type; //int(10) COMMENT ''审核类型''


    public String getSerial_code() {
        return serial_code;
    }

    public void setSerial_code(String serial_code) {
        this.serial_code = serial_code;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getChecked_at() {
        return checked_at;
    }

    public void setChecked_at(String checked_at) {
        this.checked_at = checked_at;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public Integer getCheck_type() {
        return check_type;
    }

    public void setCheck_type(Integer check_type) {
        this.check_type = check_type;
    }

    @Override
    public String toString() {
        return "AccountBookLog{" +
                "serial_code='" + serial_code + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", event='" + event + '\'' +
                ", trace='" + trace + '\'' +
                ", status=" + status +
                ", checked_at='" + checked_at + '\'' +
                ", checker='" + checker + '\'' +
                ", check_type=" + check_type +
                '}';
    }

}
