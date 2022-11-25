package com.simplilearn.fitnessclubautomation.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_subscriberpayments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Long paymentId;
    @Column(name = "payment_amount", nullable = false)
    private int paidAmount;
    @Column(name = "payment_date", nullable = false)
    private String paymentDate;
    @Column(name = "payment_mode", nullable = false)
    private String paymentMode;

    public Payment() {
    }

    public Payment(Long paymentId, int paidAmount, String paymentDate, String paymentMode) {
        this.paymentId = paymentId;
        this.paidAmount = paidAmount;
        this.paymentDate = paymentDate;
        this.paymentMode = paymentMode;
    }

    public Payment(int paidAmount, String paymentDate, String paymentMode) {
        this.paidAmount = paidAmount;
        this.paymentDate = paymentDate;
        this.paymentMode = paymentMode;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
}
