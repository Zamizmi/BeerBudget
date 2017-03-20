/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.logic;

import sami.beerbudget.Budget;
import sami.beerbudget.MoneyFlow;
import java.util.Date;

/**
 *
 * @author saklindq
 */
public class BudgetLogic {
    
    private Budget budget;
    
    public BudgetLogic() {
        this.budget = new Budget();
    }
    
    public void setBalance(double balance) {
        System.out.println("bulon testi");
        this.budget.setBalance(balance);
    }
    
    public void setTarget(double target) {
        this.budget.setTarget(target);
    }
    
    public void setDate(Date date) {
        this.budget.setEnd(date);
    }
    
    public double sumIncomes() {
        double sum =0;
        for (MoneyFlow flow : this.budget.getIncomes()) {
            sum += flow.getAmount();
        }
        
        return sum;
    }
    
    public MoneyFlow newExpense(String name, double amount, boolean monthly, Date exp) {
        MoneyFlow expense = new MoneyFlow(name, amount, exp, monthly, true);
        return expense;
    }
    
    public MoneyFlow newIncome(String name, double amount, boolean monthly, Date exp) {
        MoneyFlow income = new MoneyFlow(name, amount, exp, monthly, false);
        return income;
    }
    
    public double countBeers(double price) {
        return budget.getBalance()/price;
    }
    
    @Override
    public String toString() {
        return "You have " + countBeers(4.5);
    }
    
    
}
