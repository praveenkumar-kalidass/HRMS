package com.ideas2it.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * <p>
 * Model class which stores the details associated with the Salary of the
 * company.
 * </p>
 * 
 * @author Praveen Raj
 * 
 * @created 2016-09-15
 *
 */
@Entity
@Table(name = "salary")
public class Salary {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", updatable = true, nullable = true)
    private User user;

    @Column(name = "houserent_allowance")
    private float houseRentAllowance;

    @Column(name = "dearness_allowance")
    private float dearnessAllowance;

    @Column(name = "provident_fund")
    private float providentFund;

    @Column(name = "medical_allowance")
    private float medicalAllowance;

    @Column(name = "total_amount")
    private float totalAmount;

    @Column(name = "basic_pay")
    private float basicPay;

    @Column(name = "no_days")
    private int noDays;

    @Column(name = "loss_of_pay")
    private float lossOfPay;

    public Salary() {
    }

    public Salary(User user, float houseRentAllowance, float dearnessAllowance, float providentFund,
            float medicalAllowance, float totalAmount, float basicPay, int noDays, float lossOfPay) {
        this.user = user;
        this.houseRentAllowance = houseRentAllowance;
        this.dearnessAllowance = dearnessAllowance;
        this.providentFund = providentFund;
        this.medicalAllowance = medicalAllowance;
        this.totalAmount = totalAmount;
        this.basicPay = basicPay;
        this.noDays = noDays;
        this.lossOfPay = lossOfPay;
    }

    public float getNoDays() {
        return noDays;
    }

    public void setNoDays(int noDays) {
        this.noDays = noDays;
    }

    public float getLossOfPay() {
        return lossOfPay;
    }

    public void setLossOfPay(float lossOfPay) {
        this.lossOfPay = lossOfPay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getHouseRentAllowance() {
        return houseRentAllowance;
    }

    public void setHouseRentAllowance(float houseRentAllowance) {
        this.houseRentAllowance = houseRentAllowance;
    }

    public float getDearnessAllowance() {
        return dearnessAllowance;
    }

    public void setDearnessAllowance(float dearnessAllowance) {
        this.dearnessAllowance = dearnessAllowance;
    }

    public float getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(float providentFund) {
        this.providentFund = providentFund;
    }

    public float getMedicalAllowance() {
        return medicalAllowance;
    }

    public void setMedicalAllowance(float medicalAllowance) {
        this.medicalAllowance = medicalAllowance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(float basicPay) {
        this.basicPay = basicPay;
    }

}
