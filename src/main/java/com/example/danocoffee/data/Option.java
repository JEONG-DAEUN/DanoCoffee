package com.example.danocoffee.data;

import javax.persistence.*;

@Entity
@Table(name="option")
public class Option {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //int.autoincrement
    private int opId; //옵션아이디

    @ManyToOne
    @JoinColumn(name="oplId")
    private OptionList oplId; //세부옵션 아이디

    @ManyToOne
    @JoinColumn(name="orlId")
    private OrderList orlId; //주문목록 아이디

    private int opCount; //추가

    public Option() {
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

    public OrderList getOrlId() {
        return orlId;
    }

    public void setOrlId(OrderList orlId) {
        this.orlId = orlId;
    }

    public int getOpCount() {
        return opCount;
    }

    public void setOpCount(int opCount) {
        this.opCount = opCount;
    }
}
