package com.example.danocoffee.data.dto;


public class MenuDTO {
    private int mId;
    private String mName; //메뉴명
    private int mPrice; //가격
    private boolean mInven; //재고수량
    private String mImg; //메뉴이미지
    private String mImgName;
    private int newmPrice; //변경할 가격
    private String newmName; //변경할 이름
    private String newmImgName; //변경할 사진
    private String newmImg; //변경할 메뉴이미지
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

    public String getmImgName() {
        return mImgName;
    }

    public void setmImgName(String mImgName) {
        this.mImgName = mImgName;
    }

    public int getNewmPrice() {
        return newmPrice;
    }

    public void setNewmPrice(int newmPrice) {
        this.newmPrice = newmPrice;
    }

    public String getNewmName() {
        return newmName;
    }

    public void setNewmName(String newmName) {
        this.newmName = newmName;
    }

    public String getNewmImgName() {
        return newmImgName;
    }

    public void setNewmImgName(String newmImgName) {
        this.newmImgName = newmImgName;
    }

    public String getNewmImg() {
        return newmImg;
    }

    public void setNewmImg(String newmImg) {
        this.newmImg = newmImg;
    }
}
