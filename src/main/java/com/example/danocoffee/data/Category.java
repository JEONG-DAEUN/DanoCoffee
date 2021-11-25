package com.example.danocoffee.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId; //카테고리 아이디

    private String cName; //카테고리명

//    @OneToMany
//    @JoinColumn(name="menu")
//    private List<Menu> mId;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

//    public List<Menu> getmId() {
//        return mId;
//    }
//
//    public void setmId(List<Menu> mId) {
//        this.mId = mId;
//    }


    public Category() {
    }
}
