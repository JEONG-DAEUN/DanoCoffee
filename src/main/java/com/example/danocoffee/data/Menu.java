package com.example.danocoffee.data;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //int.autoincrement
    private int mId; //메뉴아이디

    @Column
    private String mName; //메뉴명
    private int mPrice; //가격
    private boolean mInven; //재고수량
    private String mImg; //메뉴이미지
    private String mImgName;
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

    public boolean setmInven(boolean mInven) {
        this.mInven = mInven;
        return mInven;
    }

    public String getmImg() {
        return mImg;
    }

    public void setmImg(String mImg) {
        this.mImg = mImg;
    }

    public String getmImgName() {
        return mImgName;
    }

    public void setmImgName(String mImgName) {
        this.mImgName = mImgName;
    }


    public Category getcId() {
        return cId;
    }

    public void setcId(Category cId) {
        this.cId = cId;
    }

    public Menu() {
    }

    public Menu(String mName, int mPrice, boolean mInven, String mImg, String mImgName, Category cId) {
        this.cId = cId;
        this.mName = mName;
        this.mPrice = mPrice;
        this.mInven = mInven;
        this.mImgName = mImgName;
        this.mImg = mImg;

    }

}
