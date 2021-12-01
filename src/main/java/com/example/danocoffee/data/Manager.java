package com.example.danocoffee.data;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    private String mnId; //관리자아이디

    @Column
    private String mnName; //이름
    private String mnPassword; //비밀번호

    private String mnRole="admin"; //권한
    
    @Transient
    private String newMnName; //수정할 관리자 아이디

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

	public String getNewMnName() {
		return newMnName;
	}

	public void setNewMnName(String newMnName) {
		this.newMnName = newMnName;
	}

	public Manager() {
    }
}