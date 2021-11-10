package com.example.danocoffee.data;


import javax.persistence.*;

@Entity
public class HotIced {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //int.autoincrement
    private int hiCode; //핫아이스코드

    @Column(nullable = false, length=10)
    private String hiTemp; ;//온도


    public int getHiCode() {
        return hiCode;
    }

    public void setHiCode(int hiCode) {
        this.hiCode = hiCode;
    }

    public String getHiTemp() {
        return hiTemp;
    }

    public void setHiTemp(String hiTemp) {
        this.hiTemp = hiTemp;
    }

    public HotIced() {
    }

    public HotIced(int hiCode, String hiTemp) {
        this.hiCode = hiCode;
        this.hiTemp = hiTemp;
    }
}
