/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget;

import java.util.ArrayList;
import sami.logic.Date;

/**
 *
 * @author saklindq
 */
public class Budget {

    private double target;
    private double balance;
    private Date end;
    private ArrayList<MoneyFlow> incomes;
    private ArrayList<MoneyFlow> expenses;

    public Budget() {
        this.target = 0;
        this.balance = 0;
        this.incomes = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void addToBalance(double amount) {
        this.balance += amount;
    }

    public void subractFromBalance(double amount) {
        this.balance -= amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public double getTarget() {
        return target;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getEnd() {
        return this.end;
    }

    public void addExpense(String name, double amount, Date expiration, boolean monthly) {
        MoneyFlow expense = new MoneyFlow(name, amount, expiration, monthly, true);
        this.expenses.add(expense);
    }

    public void addIncome(String name, double amount, Date expiration, boolean monthly) {
        MoneyFlow income = new MoneyFlow(name, amount, expiration, monthly, false);
        this.incomes.add(income);
    }

    public ArrayList<MoneyFlow> getExpenses() {
        return this.expenses;
    }

    public ArrayList<MoneyFlow> getIncomes() {
        return this.incomes;
    }

    @Override
    public String toString() {
        return "Your balance is: " + this.balance;
    }

}
