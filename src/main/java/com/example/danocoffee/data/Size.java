package com.example.danocoffee.data;

import javax.persistence.*;
import java.security.PrivateKey;

@Entity
@Table(name = "size")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sId;

    private int sSize;

    private int sExtraMon;

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
}
