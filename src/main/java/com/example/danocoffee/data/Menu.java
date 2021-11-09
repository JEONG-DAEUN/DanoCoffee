package com.example.danocoffee.data;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mId;

    private String mName;

    private int mPrice;

    @ColumnDefault("true")
    private boolean mInven;

    @Column(length = 300)
    private String mImg;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name="cId")
    private Category cId;

    public Menu(int mId, String mName,int mPrice, boolean mInven, String mImg, Category cId) {
        this.mId = mId;
        this.mName = mName;
        this.mPrice = mPrice;
        this.mInven = mInven;
        this.mImg = mImg;
        this.cId = cId;
    }

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
}
