/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget;

import java.util.ArrayList;
import java.util.Date;
import sami.logic.BudgetLogic;

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

    public Budget() {
        this.target = 0;
        this.balance = 0;
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

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getEnd() {
        return end;
    }
    
    

    public void addExpense(MoneyFlow expense) {
        if (!this.expenses.contains(expense)) {
            this.expenses.add(expense);
        }
    }

    public void addIncome(MoneyFlow income) {
        if (!this.incomes.contains(income)) {
            this.incomes.add(income);
        }
    }

    public ArrayList<MoneyFlow> getExpenses() {
        return expenses;
    }

    public ArrayList<MoneyFlow> getIncomes() {
        return incomes;
    }

    public ArrayList<MoneyFlow> getMoneyflow() {
        return moneyflow;
    }

    @Override
    public String toString() {
        return "Your balance is: " + this.balance + " and you are " + (this.target - this.balance) + " short" + "\n";
    }

}
