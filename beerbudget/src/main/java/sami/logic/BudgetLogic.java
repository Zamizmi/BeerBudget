/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.logic;

import java.util.ArrayList;
import sami.beerbudget.Budget;
import sami.beerbudget.MoneyFlow;

/**
 *
 * @author saklindq
 */
public class BudgetLogic {
    
    private Budget budget;
    private Date today;
    
    public BudgetLogic() {
        this.budget = new Budget();
        this.today = new Date();
    }
    
    public BudgetLogic(Budget budget, Date date) {
        this.budget = budget;
        this.today = date;
    }
    
    public void setBalance(double balance) {
        this.budget.setBalance(balance);
    }
    
    public void setTarget(double target) {
        this.budget.setTarget(target);
    }
    
    public void setEndDate(Date date) {
        this.budget.setEnd(date);
    }
    
    public void setCurrentDate(Date currentDate) {
        this.today = currentDate;
    }
    
    public String currentBalance() {
        return "" + this.budget.getBalance();
    }
    
    public void updateBalance() {
        checkIncomes();
        checkIncomes();
    }
    
    public void checkIncomes() {
        for (MoneyFlow income : this.budget.getIncomes()) {
            if (income.getExpirationDate().getDay() == this.today.getDay() && income.isMonthly()) {
                this.budget.addToBalance(income.getAmount());
            } else if (income.getExpirationDate().getDay() == this.today.getDay() && income.getExpirationDate().getMonth() == this.today.getMonth() && !income.isMonthly()) {
                this.budget.addToBalance(income.getAmount());
            }
        }
    }
    
    public void checkExpenses() {
        for (MoneyFlow expense : budget.getExpenses()) {
            if (expense.getExpirationDate().getDay() == this.today.getDay() && expense.isMonthly()) {
                this.budget.subractFromBalance(expense.getAmount());
            } else if (expense.getExpirationDate().getDay() == this.today.getDay() && expense.getExpirationDate().getMonth() == this.today.getMonth() && !expense.isMonthly()) {
                this.budget.subractFromBalance(expense.getAmount());
            }
        }
    }
    
    public void turnOneDay() {
        this.today.turnDay();
        updateBalance();
    }
    
    public void turnManyDays(int days) {
        for (int i = 0; i < days; i++) {
            turnOneDay();
        }
    }
    
    public void turnOneMonth() {
        this.today.turnMonth();
    }
    
    public void turnManyMonths(int months) {
        for (int i = 0; i < months; i++) {
            turnOneMonth();
        }
    }
    
    public void turnOneYear() {
        this.today.turnYear();
    }
    
    public void turnManyYears(int years) {
        for (int i = 0; i < years; i++) {
            turnOneYear();
        }
    }
    
    public ArrayList<MoneyFlow> getIncomes() {
        return this.budget.getIncomes();
    }
    
    public ArrayList<MoneyFlow> getExpenses() {
        return this.budget.getExpenses();
    }
    
    public double sumIncomes() {
        double sum = 0;
        for (MoneyFlow flow : this.budget.getIncomes()) {
            sum += flow.getAmount();
        }
        return sum;
    }
    
    public double sumExpenses() {
        double sum = 0;
        for (MoneyFlow flow : this.budget.getExpenses()) {
            sum += flow.getAmount();
        }
        return sum;
    }
    
    public void newExpense(String name, double amount, Date expiration, boolean monthly) {
        this.budget.addExpense(name, amount, expiration, monthly);
    }
    
    public void newIncome(String name, double amount, Date expiration, boolean monthly) {
        this.budget.addIncome(name, amount, expiration, monthly);
    }
    
    public double countBeers(double price) {
        Budget firstOfMay = this.budget;
        Date firstOfMayDate = this.today;
        BudgetLogic firstOfMayLogic = new BudgetLogic(firstOfMay, firstOfMayDate);
        if (firstOfMayDate.getDay() != 01 && firstOfMayDate.getMonth() != 05) {
            firstOfMayLogic.turnOneDay();
        }
        return this.budget.getBalance() / price;
    }
    
    public void countTillTheEndOfMonth() {
        //TODO
        //Counts
    }
    
    public int daysToFirstOfMay() {
        int days = 0;
        Date toFirstOfMay = this.today;
        System.out.println(toFirstOfMay);
        while (toFirstOfMay.getMonth() != 5 && toFirstOfMay.getDay() != 1) {
            toFirstOfMay.turnDay();
            days++;
        }
        return days;
    }
    
    @Override
    public String toString() {
        return "Your balance is " + this.budget.getBalance() + ". You will get " + countBeers(4.5) + " beers with this budget at the moment!";
    }
    
}
