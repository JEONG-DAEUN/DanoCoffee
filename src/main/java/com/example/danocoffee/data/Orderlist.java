package com.example.danocoffee.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderList")
public class Orderlist implements Serializable {
    @Id
    @ManyToOne(targetEntity = Menu.class)
    @JoinColumn(name= "mId")
    private Menu mId;

    @Id
    @ManyToOne(targetEntity = Pay.class)
    @JoinColumn(name= "pId")
    private Pay pId;

    private int oTotalPrice;

    @Id
    @ManyToOne(targetEntity = Size.class)
    @JoinColumn(name = "sId")
    private Size sId;

    public Orderlist(Menu mId, Pay pId, int oTotalPrice,Size sId) {
        this.mId = mId;
        this.pId = pId;
        this.oTotalPrice =oTotalPrice;
        this.sId =sId;
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

    public int getoTotalPrice() {
        return oTotalPrice;
    }

    public void setoTotalPrice(int oTotalPrice) {
        this.oTotalPrice = oTotalPrice;
    }

    public Size getsId() {
        return sId;
    }

    public void setsId(Size sId) {
        this.sId = sId;
    }

}
