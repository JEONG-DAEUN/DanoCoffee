package com.example.danocoffee.data;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pay {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //int.autoincrement
    private int pId; //결제아이디

    @Column(nullable = false, length=7)
    private int pPayment;

    @Column(nullable = false, length=10)
    private String pMethod;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="pTime")
    private java.util.Date timestampField;

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

    public String getpMethod() {
        return pMethod;
    }

    public void setpMethod(String pMethod) {
        this.pMethod = pMethod;
    }

    public Date getTimestampField() {
        return timestampField;
    }

    public void setTimestampField(Date timestampField) {
        this.timestampField = timestampField;
    }

    public Pay() {
    }

    public Pay(int pId, int pPayment, String pMethod, Date timestampField) {
        this.pId = pId;
        this.pPayment = pPayment;
        this.pMethod = pMethod;
        this.timestampField = timestampField;
    }
}
