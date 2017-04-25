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

    /**
     * Sets the balance to the given amount.
     *
     * @param balance input to be the new balance.
     * @return true if succeeded.
     */
    public boolean setBalance(double balance) {
        this.budget.setBalance(balance);
        if (this.budget.getBalance() == balance) {
            return true;
        }
        return false;
    }

    /**
     * Sets the target to the given amount.
     *
     * @param target input to be the new target.
     * @return true if succeeded.
     */
    public boolean setTarget(double target) {
        this.budget.setTarget(target);
        if (this.budget.getTarget() == target) {
            return true;
        }
        return false;
    }

    /**
     * Returns double as the current target of the budget.
     *
     * @return the target from the budget.
     */
    public double getTarget() {
        return this.budget.getTarget();
    }

    /**
     * Returns string with days to accomplish the target. Counts days until
     * target is fulfilled or 50 years is reached.
     *
     * @return string with days to the target or tells if the target will never
     * be fulfilled.
     */
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

    /**
     * Returns integer with days to fulfil the target. Counts days until target
     * is fulfilled or 50 years is reached.
     *
     * @return the days to target or -1 if 50 years will pass.
     */
    public int daysToTargetInDays() {
        Date toTarget = this.today;
        Budget targetBudget = this.budget;
        BudgetLogic targetLogic = new BudgetLogic(targetBudget, toTarget);
        int daysToGo = 0;
        while (targetLogic.currentBalance() < this.getTarget()) {
            targetLogic.turnOneDay();
            daysToGo++;
            if (daysToGo > 18263) {
                return -1;
            }
        }
        return daysToGo;
    }

    /**
     * Sets the input date as the budgets end date.
     *
     * @param date input to be the new end date of the budget.
     */
    public void setEndDate(Date date) {
        this.budget.setEnd(date);
    }

    /**
     * Get end date of budget.
     *
     * @return ending date of budget.
     */
    public Date getEndDate() {
        return this.budget.getEnd();
    }

    /**
     * Sets the input date as the current date for the app.
     *
     * @param currentDate as the current date of the app.
     */
    public void setCurrentDate(Date currentDate) {
        this.today = currentDate;
    }

    /**
     * Returns Date of the current date.
     *
     * @return Date of the app.
     */
    public Date getCurrentDate() {
        return this.today;
    }

    /**
     * Returns the current balance as Double.
     *
     * @return Double as the current balance.
     */
    public double currentBalance() {
        return this.budget.getBalance();
    }

    /**
     * Updates the balance by checking all moneyflows. Compares currentDate with
     * the moneyflows endDate. if equals makes changes to the balance. Called
     * every time if day changes.
     */
    public void updateBalance() {
        checkIncomes();
        checkExpenses();
    }

    /**
     * Adds to balance by checking incomes. Goes through every income, compares
     * currentDay to incomes expirationDate and if equals, adds the amount to
     * balance.
     */
    public void checkIncomes() {
        ArrayList<MoneyFlow> remove = new ArrayList<>();
        for (MoneyFlow income : this.budget.getIncomes()) {
            if (income.getExpirationDate().getDay() == this.today.getDay() && income.isMonthly()) {
                income.setExpirationDate(DateLogic.turnToSameDayNextMonth(today));
                this.budget.addToBalance(income.getAmount());
            } else if (income.getExpirationDate().getDay() == this.today.getDay() && income.getExpirationDate().getMonth() == this.today.getMonth() && !income.isMonthly()) {
                this.budget.addToBalance(income.getAmount());
                remove.add(income);
            }
        }
        this.budget.getIncomes().removeAll(remove);
    }

    /**
     * Subracts from balance by checking expenses. Goes through every expense,
     * compares currentDay to expenses expirationDate and if equals, subracts
     * the amount from balance.
     */
    public void checkExpenses() {
        ArrayList<MoneyFlow> remove = new ArrayList<>();
        for (MoneyFlow expense : budget.getExpenses()) {
            if (expense.getExpirationDate().getDay() == this.today.getDay() && expense.isMonthly()) {
                expense.setExpirationDate(DateLogic.turnToSameDayNextMonth(today));
                this.budget.subractFromBalance(expense.getAmount());
            } else if (expense.getExpirationDate().getDay() == this.today.getDay() && expense.getExpirationDate().getMonth() == this.today.getMonth() && !expense.isMonthly()) {
                this.budget.subractFromBalance(expense.getAmount());
                remove.add(expense);
            }
        }
        this.budget.getExpenses().removeAll(remove);
    }

    /**
     * Turns currentDate to next day. Updates balance.
     */
    public void turnOneDay() {
        this.today.turnDay();
        updateBalance();
    }

    /**
     * Calls turnOneDay() many times.
     *
     * @param days to be turned, must be greater than 1.
     */
    public void turnManyDays(int days) {
        for (int i = 0; i < days; i++) {
            turnOneDay();
        }
    }

    /**
     * Calls turnOneDay until the month has changed. Automatically updates the
     * balance and validates the length of current month.
     */
    public void turnToNextMonth() {
        turnManyDays(DateLogic.daysToNextMonth(this.today));
    }

    /**
     * Calls turnOneDay until the year has changed. * Automatically updates the
     * balance and validates the length of current month.
     */
    public void turnToNextYear() {
        turnManyDays(DateLogic.daysToNextYear(this.today));
    }

    //TODO change to use DateLogic
    /**
     * Calls turnOneDay until one year has passed.
     */
    public void turnOneYear() {
        int daysToGo = DateLogic.daysInYear(this.today);
        for (int i = 0; i < daysToGo; i++) {
            turnOneDay();
        }
    }

    /**
     * Return all Incomes in a ArrayList.
     *
     * @return ArrayList containing all the incomes.
     */
    public ArrayList<MoneyFlow> getIncomes() {
        return this.budget.getIncomes();
    }

    /**
     * Return all Expenses in a ArrayList.
     *
     * @return ArrayList containing all the expenses.
     */
    public ArrayList<MoneyFlow> getExpenses() {
        return this.budget.getExpenses();
    }

    /**
     * Return the sum of all the incomes.
     *
     * @return double with value of all incomes.
     */
    public double sumIncomes() {
        double sum = 0;
        for (MoneyFlow flow : this.budget.getIncomes()) {
            sum += flow.getAmount();
        }
        return sum;
    }

    /**
     * Return the sum of all the expenses.
     *
     * @return double with value of all expenses.
     */
    public double sumExpenses() {
        double sum = 0;
        for (MoneyFlow flow : this.budget.getExpenses()) {
            sum += flow.getAmount();
        }
        return sum;
    }

    /**
     * Creates new expense and adds it to the budget. Asks input from the User
     * to create a new expense.
     *
     * @param name String to be the name.
     * @param amount Double to be the amount of the MoneyFlow. Must be positive.
     * @param expiration Date to be the dueDate for the MoneyFlow.
     * @param monthly Boolean to be declare how many times to be payed.
     */
    public void newExpense(String name, double amount, Date expiration, boolean monthly) {
        this.budget.addExpense(name, amount, expiration, monthly);
    }

    /**
     * Creates new income and adds it to the budget. Asks input from the User to
     * create a new income.
     *
     * @param name String to be the name.
     * @param amount Double to be the amount of the MoneyFlow. Must be positive.
     * @param expiration Date to be the dueDate for the MoneyFlow.
     * @param monthly Boolean to be declare how many times to be payed.
     */
    public void newIncome(String name, double amount, Date expiration, boolean monthly) {
        this.budget.addIncome(name, amount, expiration, monthly);
    }

    /**
     * Returns integer as the amount of beers User can buy at next First of May.
     *
     * @param price price for the wanted beer. Double.
     * @return Amount of beers User can buy. Integer.
     */
    public double countBeers(double price) {
        Budget firstOfMay = this.budget;
        Date firstOfMayDate = this.today;
        BudgetLogic firstOfMayLogic = new BudgetLogic(firstOfMay, firstOfMayDate);
        while (firstOfMayDate.getDay() != 1 || firstOfMayDate.getMonth() != 5) {
            firstOfMayLogic.turnOneDay();
        }
        return firstOfMayLogic.currentBalance() / price;
    }

    /**
     * Updates to next month. Updates balance accordingly using turnOneDay.
     */
    public void updateToNextMonth() {
        turnManyDays(DateLogic.daysToNextMonth(today));
    }

    /**
     * Returns number of days to given Date.
     *
     * @param dateTo Date as the target.
     * @return Integer, number of days to dateTo.
     */
    public int daysToGivenDate(Date dateTo) {
        return DateLogic.daysToNextMonth(dateTo);
    }

    /**
     * Counts and returns the amount of money User will have at the end of
     * month. Creates a iterator Date and a copy of BudgetLogic to ensure the
     * integrity of the real Budget.
     *
     * @return Double, amount of money User will have at the end of month.
     */
    public double balanceAtTheEndOfMonth() {
        Budget atTheEnd = this.budget;
        Date iteratorDate = DateLogic.iteratorDate(today);
        BudgetLogic atTheEndLogic = new BudgetLogic(atTheEnd, iteratorDate);
        atTheEndLogic.updateToNextMonth();

        return atTheEndLogic.currentBalance();
    }

    public boolean deleteIncome(MoneyFlow toBeDeleted) {
        if (this.budget.getIncomes().contains(toBeDeleted)) {
            this.budget.getIncomes().remove(toBeDeleted);
            return true;
        }
        return false;
    }

    public boolean deleteExpense(MoneyFlow toBeDeleted) {
        if (this.budget.getExpenses().contains(toBeDeleted)) {
            this.budget.getExpenses().remove(toBeDeleted);
            return true;
        }
        return false;
    }

    //TODO: change the amount of beers to something else?
    /**
     * @return String with balance and amount of beers one can buy at next First
     * Of May.
     */
    @Override
    public String toString() {
        return "Your balance is " + this.budget.getBalance() + ". You will get " + countBeers(4.0) + " beers with this budget at next First of May!";
    }
}
