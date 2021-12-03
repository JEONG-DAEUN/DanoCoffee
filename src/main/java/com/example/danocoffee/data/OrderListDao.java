package com.example.danocoffee.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


public class OrderListDao {
    private int orlId;
    private Menu mId; //메뉴아이디
    private Pay pId; //결제아이디
    private int orlPayment; //가격
    private int orlCount; //수량
    private int pPayment; // 총 결제금액

    public int getpPayment() {
        return pPayment;
    }

    public void setpPayment(int pPayment) {
        this.pPayment = pPayment;
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

    public int getorlCount() {
        return orlCount;
    }

    public void setorlCount(int orlCount) {
        this.orlCount = orlCount;
    }


    public OrderListDao() {
    }
}