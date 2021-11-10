package com.example.danocoffee.data;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mId;

    @Column(nullable=false,length=100)
    private String mnName;
    @Column
    private String mPassword;

    Manager(){}
    Manager(int mId, String mnName, String mPassword){
        this.mId = mId;
        this.mnName = mnName;
        this.mPassword = mPassword;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getMnName() {
        return mnName;
    }

    public void setMnName(String mnName) {
        this.mnName = mnName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
