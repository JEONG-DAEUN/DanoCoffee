package com.example.danocoffee.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderList")
public class Orderlist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orlId;

    @ManyToOne(targetEntity = Menu.class)
    @JoinColumn(name = "mId")
    private Menu mId;

    @ManyToOne(targetEntity = Pay.class)
    @JoinColumn(name = "pId")
    private Pay pId;

    private int orlPayment;

    @Column(nullable = false)
    private int orlTotalPrice;


    public Orderlist(int orlId, Menu mId, Pay pId, int orlPayment, int orlTotalPrice) {
        this.orlId = orlId;
        this.mId = mId;
        this.pId = pId;
        this.orlPayment = orlPayment;
        this.orlTotalPrice = orlTotalPrice;
    }

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

    public int getOrlTotalPrice() {
        return orlTotalPrice;
    }

    public void setOrlTotalPrice(int orlTotalPrice) {
        this.orlTotalPrice = orlTotalPrice;
    }
}
