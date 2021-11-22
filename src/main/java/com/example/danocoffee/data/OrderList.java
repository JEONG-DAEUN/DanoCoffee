package com.example.danocoffee.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "orderlist")
public class OrderList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //int.autoincrement
    private int orlId;

    @ManyToOne
    @JoinColumn(name = "mId")
    private Menu mId; //메누아이디

    @ManyToOne
    @JoinColumn(name = "pId")
    private Pay pId; //결제아이디

    private int orlShot = 0;

    @Column
    private int orlPayment; //가격
    private int orlCount = 1; //수량


    public int getOrlId() {
        return orlId;
    }

    public void setOrlId(int orlId) {
        this.orlId = orlId;
    }

    public Menu getmId() {
        return mId;
    }

    public void setmId(Menu mId) {
        this.mId = mId;
    }

    public Pay getpId() {
        return pId;
    }

    public void setpId(Pay pId) {
        this.pId = pId;
    }

    public int getOrlPayment() {
        return orlPayment;
    }

    public void setOrlPayment(int orlPayment) {
        this.orlPayment = orlPayment;
    }

    public int getOrlCount() {
        return orlCount;
    }

    public void setOrlCount(int orlCount) {
        this.orlCount = orlCount;
    }

    public int getOrlShot() {
        return orlShot;
    }

    public void setOrlShot(int orlShot) {
        this.orlShot = orlShot;
    }

    public OrderList() {
    }
}
