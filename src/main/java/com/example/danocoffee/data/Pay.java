package com.example.danocoffee.data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "pay")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId; //결제아이디

    @Column
    private int pPayment; //결제금액

//    private String pMethod; //결제방법

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="pTime") //결제시간
    private java.util.Date timestampField;

    public Pay(int pPayment, Date date) {
        this.pPayment = pPayment;
        this.timestampField = date;

    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getpPayment() {
        return pPayment;
    }

    public void setpPayment(int pPayment) {
        this.pPayment = pPayment;
    }

//    public String getpMethod() {
//        return pMethod;
//    }
//
//    public void setpMethod(String pMethod) {
//        this.pMethod = pMethod;
//    }

    public Date getTimestampField() {
        return timestampField;
    }

    public void setTimestampField(Date timestampField) {
        this.timestampField = timestampField;
    }

    public Pay() {
    }
}