package com.example.danocoffee.data;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    private String mnId;

    @Column(nullable=false,length=100)
    private String mnName;

    @Column(length = 200)
    private String mnPassword = "1111";

    private String mnRole="admin";




    Manager(){}
    Manager(String mnId, String mnName, String mnPassword,String mnRole){
        this.mnId = mnId;
        this.mnName = mnName;
        this.mnPassword = mnPassword;
        this.mnRole= mnRole;
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

    public String getMnRole() {
        return mnRole;
    }

    public void setMnRole(String mnRole) {
        this.mnRole = mnRole;
    }
}
