package com.example.danocoffee.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotIced {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hiCode;

    private String hiTemp;

    public HotIced(int hiCode, String hiTemp){
        this.hiCode = hiCode;
        this.hiTemp = hiTemp;
    }

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
}
