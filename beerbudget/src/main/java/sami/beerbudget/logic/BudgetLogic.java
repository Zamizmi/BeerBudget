/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.logic;

import java.util.ArrayList;
import sami.beerbudget.budget.Budget;
import sami.beerbudget.budget.MoneyFlow;

/**
 *
 * @author saklindq
 */
public class BudgetLogic {

    private Budget budget;
    private DateLogic dateLogic;
    private Date today;

    public BudgetLogic() {
        this.budget = new Budget();
        this.dateLogic = new DateLogic();
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

    public double getTarget() {
        return this.budget.getTarget();
    }

    public String daysToTarget() {
        Date toTarget = this.today;
        Budget targetBudget = this.budget;
        BudgetLogic targetLogic = new BudgetLogic(targetBudget, toTarget);
        int daysToGo = 0;
        while (targetLogic.currentBalance() <= this.getTarget()) {
            targetLogic.turnOneDay();
            daysToGo++;
            if (daysToGo > 18263) {
                return "With the current budget, it seems you'll never reach your target, at least not in 50 years.";
            }
        }
        return "With the current budget it will take " + daysToGo + " days to reach the target.";
    }

    public void setEndDate(Date date) {
        this.budget.setEnd(date);
    }

    public Date getEndDate() {
        return this.budget.getEnd();
    }

    public void setCurrentDate(Date currentDate) {
        this.today = currentDate;
    }

    public Date getCurrentDate() {
        return this.today;
    }

    public double currentBalance() {
        return this.budget.getBalance();
    }

    public void updateBalance() {
        checkIncomes();
        checkExpenses();
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

    public void turnToNextMonth() {
        int targetMonth = today.getMonth();
        if (targetMonth == 12) {
            targetMonth = 1;
        } else {
            targetMonth++;
        }
        while (today.getMonth() != targetMonth) {
            this.today.turnDay();
        }
    }

    public void turnOneYear() {
        for (int i = 0; i < 12; i++) {
            this.today.turnMonth();
        }
    }

    //doesnt work yet
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
        while (firstOfMayDate.getDay() != 1 || firstOfMayDate.getMonth() != 5) {
            firstOfMayLogic.turnOneDay();
        }
        return firstOfMayLogic.currentBalance() / price;
    }

    public void updateToNextMonth() {
        turnManyDays(dateLogic.daysToNextMonth(today));
    }

    public int daysToNextMonth(Date dateTo) {
        return this.dateLogic.daysToNextMonth(dateTo);
    }

    public double balanceAtTheEndOfMonth() {
        Budget atTheEnd = this.budget;
        Date iteratorDate = this.today;
        BudgetLogic atTheEndLogic = new BudgetLogic(atTheEnd, iteratorDate);
        atTheEndLogic.turnManyDays(daysToNextMonth(iteratorDate));

        return atTheEndLogic.currentBalance();
    }

    public String toFirstOfMay() {
        //TODO
        return "12";
    }

    @Override
    public String toString() {
        return "Your balance is " + this.budget.getBalance() + ". You will get " + countBeers(4.0) + " beers with this budget at next First of May!";
    }
}
