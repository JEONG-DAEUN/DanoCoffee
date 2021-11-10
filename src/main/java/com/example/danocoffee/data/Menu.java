package com.example.danocoffee.data;

import javax.persistence.*;


@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //int.autoincrement
    private int mId; //메뉴아이디

    @Column(nullable = false, length=20)
    private String mName; //메뉴명
    @Column(nullable = false, length=5)
    private int mPrice; //가격
    private boolean mInven; //재고수량
    @Column(nullable = false, length=300)
    private String mImg; //메뉴이미지

    @ManyToOne
    @JoinColumn(name="cId")
    private Category cId;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public boolean ismInven() {
        return mInven;
    }

    public void setmInven(boolean mInven) {
        this.mInven = mInven;
    }

    public String getmImg() {
        return mImg;
    }

    public void setmImg(String mImg) {
        this.mImg = mImg;
    }

    public Category getcId() {
        return cId;
    }

    public void setcId(Category cId) {
        this.cId = cId;
    }

    public Menu() {
    }

    public Menu(int mId, String mName, int mPrice, boolean mInven, String mImg, Category cId) {
        this.mId = mId;
        this.mName = mName;
        this.mPrice = mPrice;
        this.mInven = mInven;
        this.mImg = mImg;
        this.cId = cId;
    }
}
