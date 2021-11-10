package com.example.danocoffee.data;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@Entity

public class Size {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //int.autoincrement
    private int sId; //사이즈아이디

    @Column(nullable = false, length=2)
    private int sSize; //사이즈

    @Column(nullable = false, length=5)
    private int sExtraMon; //추가금

    public Size(int sId, int sSize, int sExtraMon) {
        this.sId = sId;
        this.sSize = sSize;
        this.sExtraMon = sExtraMon;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getsSize() {
        return sSize;
    }

    public void setsSize(int sSize) {
        this.sSize = sSize;
    }

    public int getsExtraMon() {
        return sExtraMon;
    }

    public void setsExtraMon(int sExtraMon) {
        this.sExtraMon = sExtraMon;
    }

    public Size() {
    }
}
