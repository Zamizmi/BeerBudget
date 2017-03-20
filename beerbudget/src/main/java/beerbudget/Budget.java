/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beerbudget;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author saklindq
 */
public class Budget {

    private double target;
    private double balance;
    private Date end;
    private ArrayList<MoneyFlow> moneyflow;
    private ArrayList<MoneyFlow> incomes;
    private ArrayList<MoneyFlow> expenses;

    public Budget(double target, Date end) {
        this.target = target;
        this.balance = 0;
        this.end = end;
        this.moneyflow = new ArrayList<>();
        this.incomes = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
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
    
    public double getAllIncomes() {
        double toReturn = 0;
        for (MoneyFlow flow : this.incomes) {
            if (flow.isExpense())
            toReturn +=flow.getAmount() ;
        }
        return toReturn;
    }
    
    public double getAllExpenses() {
        double toReturn = 0;
        for (MoneyFlow flow : this.expenses) {
            if (!flow.isExpense()) {
            toReturn +=flow.getAmount() ;
            }
        }
        return toReturn;
    }

    @Override
    public String toString() {
        return "Your balance is: " + this.balance + " and you are " + (this.target - this.balance) + " short";
    }

}
