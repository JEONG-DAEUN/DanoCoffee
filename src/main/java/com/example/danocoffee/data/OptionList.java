package com.example.danocoffee.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "optionList")
public class OptionList {

    @Id
    private String oplId;

    private int oplPayment;

    public OptionList(String oplId, int oplPayment){
        this.oplId =oplId;
        this.oplPayment =oplPayment;
    }
}
