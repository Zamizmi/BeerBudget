/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget;

import sami.logic.Date;

/**
 *
 * @author saklindq
 */
public class MoneyFlow {

    private String name;
    private double amount;
    private Date expirationDate;
    private boolean monthly;
    private boolean expense;

    public MoneyFlow(String name, double amount, Date expiration, boolean monthly, boolean expense) {
        this.name = name;
        this.amount = amount;
        this.expirationDate = expiration;
        this.monthly = monthly;
        this.expense = expense;
    }

    public double getAmount() {
        return amount;
    }

    public void setExpense(boolean expense) {
        this.expense = expense;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getName() {
        return name;
    }

    public boolean isMonthly() {
        return monthly;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " : " + amount;
    }

    public boolean isExpense() {
        return expense;
    }

}
