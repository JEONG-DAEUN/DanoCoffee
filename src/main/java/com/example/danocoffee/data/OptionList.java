package com.example.danocoffee.data;

import javax.persistence.*;

@Entity
@Table(name="optionlist")
public class OptionList {
    @Id
    private String oplId; //세부옵션아이디

    @Column
    private int oplPayment; //옵션추가금

    public String getOplId() {
        return oplId;
    }

    public void setOplId(String oplId) {
        this.oplId = oplId;
    }

    public int getOplPayment() {
        return oplPayment;
    }

    public void setOplPayment(int oplPayment) {
        this.oplPayment = oplPayment;
    }

    public OptionList() {
    }
}
