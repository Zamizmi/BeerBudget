/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.budget;

import sami.beerbudget.logic.Date;

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

    /**
     * @return the amount of the moneyflow.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param expense decides whether the moneyflow is expense or income.
     */
    public void setExpense(boolean expense) {
        this.expense = expense;
    }

    /**
     * @return the due date of the moneyflow.
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * @return the name of the moneyflow.
     */
    public String getName() {
        return name;
    }

    /**
     * @return returns true if moneyflow is expense or true if income.
     */
    public boolean isMonthly() {
        return monthly;
    }

    /**
     * @param amount is the new amount of the moneyflow. Always positive.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @param newExpirationDate is set as the new due date for the moneyflow.
     */
    public void setExpirationDate(Date newExpirationDate) {
        this.expirationDate = newExpirationDate;
    }

    /**
     * @param monthly is set as the new value for the @param monthly.
     */
    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }

    /**
     * @param name is the new name of the moneyflow.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name and value.
     */
    @Override
    public String toString() {
        return name + " Amount: " + amount + ", Due Date: " + getExpirationDate();
    }

    /**
     * @return true if moneyflow is expense.
     */
    public boolean isExpense() {
        return expense;
    }

}
