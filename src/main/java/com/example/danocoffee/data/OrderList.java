package com.example.danocoffee.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="orderlist")
public class OrderList implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name="mId")
    private Menu mId;

    @ManyToOne
    @JoinColumn(name="pId")
    private Pay pId;

    @ManyToOne
    @JoinColumn(name="sId")
    private Size sId;

    @Column(nullable = false, length=5)
    private int oTotalPrice;

    public OrderList() {
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

    public Size getsId() {
        return sId;
    }

    public void setsId(Size sId) {
        this.sId = sId;
    }

    public int getoTotalPrice() {
        return oTotalPrice;
    }

    public void setoTotalPrice(int oTotalPrice) {
        this.oTotalPrice = oTotalPrice;
    }
}
