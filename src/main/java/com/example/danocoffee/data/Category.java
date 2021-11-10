package com.example.danocoffee.data;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //int.autoincrement
    private int cId; //카테고리아이디

    @Column(nullable = false, length=20)
    private String cName;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Category() {
    }

    public Category(int cId, String cName) {
        this.cId = cId;
        this.cName = cName;
    }
}
