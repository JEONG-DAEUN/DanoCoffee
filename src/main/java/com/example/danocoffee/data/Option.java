package com.example.danocoffee.data;

import javax.persistence.*;

@Entity
@Table(name = "option")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int opId;

    @ManyToOne(targetEntity = OptionList.class)
    @JoinColumn(name = "oplId")
    private OptionList oplId;

    @ManyToOne(targetEntity = Orderlist.class)
    @JoinColumn(name = "orlId")
    private Orderlist orlId;

    private int opCount;

    public Option(int opId, OptionList oplId, Orderlist orlId, int opCount){
        this.opId =opId;
        this.oplId=oplId;
        this.orlId=orlId;
        this.opCount=opCount;
    }

    public int getOpId() {
        return opId;
    }

    public void setOpId(int opId) {
        this.opId = opId;
    }

    public OptionList getOplId() {
        return oplId;
    }

    public void setOplId(OptionList oplId) {
        this.oplId = oplId;
    }

    public Orderlist getOrlId() {
        return orlId;
    }

    public void setOrlId(Orderlist orlId) {
        this.orlId = orlId;
    }

    public int getOpCount() {
        return opCount;
    }

    public void setOpCount(int opCount) {
        this.opCount = opCount;
    }
}
