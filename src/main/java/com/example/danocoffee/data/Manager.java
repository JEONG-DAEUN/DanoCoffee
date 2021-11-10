package com.example.danocoffee.data;

import javax.persistence.*;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //int.autoincrement
    private int mnId;

    @Column(nullable = false, length=10)
    private String mnName;

    @Column(nullable = false, length=200)
    private String mnPassword;

    public int getMnId() {
        return mnId;
    }

    public void setMnId(int mnId) {
        this.mnId = mnId;
    }

    public String getMnName() {
        return mnName;
    }

    public void setMnName(String mnName) {
        this.mnName = mnName;
    }

    public String getMnPassword() {
        return mnPassword;
    }

    public void setMnPassword(String mnPassword) {
        this.mnPassword = mnPassword;
    }

    public Manager() {
    }

    public Manager(int mnId, String mnName, String mnPassword) {
        this.mnId = mnId;
        this.mnName = mnName;
        this.mnPassword = mnPassword;
    }
}
