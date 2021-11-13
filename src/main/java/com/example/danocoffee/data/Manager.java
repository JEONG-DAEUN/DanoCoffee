package com.example.danocoffee.data;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    private String mnId;

    @Column(nullable=false,length=100)
    private String mnName;
    @Column
    private String mnPassword;

    Manager(){}
    Manager(String mnId, String mnName, String mnPassword){
        this.mnId = mnId;
        this.mnName = mnName;
        this.mnPassword = mnPassword;
    }

    public String getMnId() {
        return mnId;
    }

    public void setMnId(String mnId) {
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
}
