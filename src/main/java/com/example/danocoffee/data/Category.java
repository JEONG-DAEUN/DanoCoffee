package com.example.danocoffee.data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId;

    private String cName;

    @OneToMany
    @JoinColumn(name="menu")
    private List<Menu> cMenu;

    public Category(int cId, String cName, List<Menu> cMenu) {
        this.cId = cId;
        this.cName = cName;
        this.cMenu = cMenu;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setMenu(List<Menu> cMenu) {
        this.cMenu = cMenu;
    }
}
