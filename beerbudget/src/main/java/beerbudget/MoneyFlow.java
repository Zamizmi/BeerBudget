/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beerbudget;

import java.util.Date;

/**
 *
 * @author saklindq
 */
public class MoneyFlow {

    private double amount;
    private Date expirationDate;
    private boolean monthly;
    private boolean expense;

    public MoneyFlow(double amount, Date expiration, boolean monthly) {
        this.amount = amount;
        this.expirationDate = expiration;
        this.monthly = monthly;
    }

    public double getAmount() {
        return amount;
    }

    public void setExpense(boolean expense) {
        this.expense = expense;
    }

    public boolean isExpense() {
        return expense;
    }

    

}
