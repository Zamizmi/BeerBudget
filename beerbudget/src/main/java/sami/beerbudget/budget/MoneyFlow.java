/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.budget;

import sami.beerbudget.logic.Date;

/**
 * Moneyflow contains info for the moneyflows.
 *
 * @author saklindq
 */
public class MoneyFlow {

    private String name;
    private double amount;
    private Date expirationDate;
    private boolean monthly;
    private boolean expense;

    /**
     * Creates new moneyflow with the given params.
     *
     * @param name name.
     * @param amount amount, double.
     * @param expiration due date.
     * @param monthly if the expense/income is monthly.
     * @param expense if expense/income.
     */
    public MoneyFlow(String name, double amount, Date expiration, boolean monthly, boolean expense) {
        this.name = name;
        this.amount = amount;
        this.expirationDate = expiration;
        this.monthly = monthly;
        this.expense = expense;
    }

    /**
     * Gives the amount.
     * @return the amount of the moneyflow.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gives boolean.
     * @param expense decides whether the moneyflow is expense or income.
     */
    public void setExpense(boolean expense) {
        this.expense = expense;
    }

    /**
     * Gives the expiration date.
     * @return the due date of the moneyflow.
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * Return name.
     * @return the name of the moneyflow.
     */
    public String getName() {
        return name;
    }

    /**
     * Return true if monthly.
     * @return returns true if moneyflow is expense or true if income.
     */
    public boolean isMonthly() {
        return monthly;
    }

    /**
     * Sets new amount.
     * @param amount is the new amount of the moneyflow. Always positive.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Sets new dueDate.
     * @param newExpirationDate is set as the new due date for the moneyflow.
     */
    public void setExpirationDate(Date newExpirationDate) {
        this.expirationDate = newExpirationDate;
    }

    /**
     * Sets the monthly-boolean.
     * @param monthly is set as the new value for the @param monthly.
     */
    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }

    /**
     * Sets new name.
     * @param name is the new name of the moneyflow.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the toString.
     * @return the name and value.
     */
    @Override
    public String toString() {
        return name + " Amount: " + amount + ", Due Date: " + getExpirationDate();
    }

    /**
     * Tells if moneyflow is expense.
     * @return true if moneyflow is expense.
     */
    public boolean isExpense() {
        return expense;
    }

}
