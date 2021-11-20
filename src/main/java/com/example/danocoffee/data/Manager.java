package com.example.danocoffee.data;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //int.autoincrement
    private int mnNumber; //관리자번호

    @Column
    private String mnId; //관리자아이디
    private String mnName; //이름
    private String mnPassword; //비밀번호



    @Transient
    private String newMnId; //수정할 관리자 아이디

    private String mnRole="admin"; //권한


    public String getNewMnId() {
        return newMnId;
    }

    public void setNewMnId(String newMnId) {
        this.newMnId = newMnId;
    }

    public int getMnNumber() {
        return mnNumber;
    }

    public void setMnNumber(int mnNumber) {
        this.mnNumber = mnNumber;
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

    public Manager() {
    }

    public Manager(int mnNumber, String mnId, String mnName, String mnPassword, String mnRole) {
        this.mnNumber = mnNumber;
        this.mnId = mnId;
        this.mnName = mnName;
        this.mnPassword = mnPassword;
        this.mnRole = mnRole;
    }
}
