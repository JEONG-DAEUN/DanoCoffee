package com.example.danocoffee.data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pay")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;

    private int pPayment;

    private String pMethod;

    private LocalDateTime pTime;

    public Pay(int pId, int pPayment, String pMethod, LocalDateTime pTime) {
        this.pId = pId;
        this.pPayment = pPayment;
        this.pMethod = pMethod;
        this.pTime = pTime;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getpPayment() {
        return pPayment;
    }

    public void setpPayment(int pPayment) {
        this.pPayment = pPayment;
    }

    public String getpMethod() {
        return pMethod;
    }

    public void setpMethod(String pMethod) {
        this.pMethod = pMethod;
    }

    public LocalDateTime getpTime() {
        return pTime;
    }

    public void setpTime(LocalDateTime pTime) {
        this.pTime = pTime;
    }
}
