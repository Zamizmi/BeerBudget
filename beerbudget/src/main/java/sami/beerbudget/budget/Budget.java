/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.budget;

//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import sami.beerbudget.logic.Date;

//import sami.beerbudget.logic.Date;
/**
 * Budget is the holder of all information.
 *
 * @author saklindq Budget holds all incomes and expenses of the user.
 */
public class Budget {

    private double target;
    private double balance;
    private ArrayList<MoneyFlow> incomes;
    private ArrayList<MoneyFlow> expenses;

    /**
     * Creates new Budget and sets everything to 0.
     */
    public Budget() {
        this.target = 0;
        this.balance = 0;
        this.incomes = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    /**
     * Get Balance.
     *
     * @return current balance as Double.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Adds param to balance.
     *
     * @param amount is added to the balance.
     */
    public void addToBalance(double amount) {
        this.balance += amount;
    }

    /**
     * Subtracts from balance.
     *
     * @param amount is subtracted from the balance.
     */
    public void subractFromBalance(double amount) {
        this.balance -= amount;
    }

    /**
     * Setter.
     * @param balance is set as the new balance of the budget.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Sets target to new value.
     *
     * @param target is set as the new target of the budget.
     */
    public void setTarget(double target) {
        this.target = target;
    }

    /**
     * Returns target.
     *
     * @return the target amount to be saved from the budget.
     */
    public double getTarget() {
        return target;
    }

    /**
     * Creates and adds an expense to the Budget.
     *
     * @param name is the name of the new expense.
     * @param amount is the amount of the new expense. Always positive.
     * @param expiration is the due date of the expense.
     * @param monthly decides whether the expense is going to be payed once or
     * monthly.
     */
    public void addExpense(String name, double amount, Date expiration, boolean monthly) {
        MoneyFlow expense = new MoneyFlow(name, amount, expiration, monthly, true);
        this.expenses.add(expense);
    }

    /**
     * Creates and adds an income to the Budget.
     *
     * @param name is the name of the new income.
     * @param amount is the amount of the new income. Always positive.
     * @param expiration is the due date of the income.
     * @param monthly decides whether the income is going to be payed once or
     * monthly.
     */
    //TODO Refactor
    public void addIncome(String name, double amount, Date expiration, boolean monthly) {
        MoneyFlow income = new MoneyFlow(name, amount, expiration, monthly, false);
        this.incomes.add(income);
    }

    /**
     * Get Expenses.
     *
     * @return All expenses.
     */
    public ArrayList<MoneyFlow> getExpenses() {
        return this.expenses;
    }

    /**
     * Get Incomes.
     *
     * @return ALL the Incomes.
     */
    public ArrayList<MoneyFlow> getIncomes() {
        return this.incomes;
    }

    /**
     * String with target and balance.
     *
     * @return Target and Balance of the Budget.
     */
    @Override
    public String toString() {
        return "Your target is: " + this.target + "\n"
                + "Your Current Balance is: " + this.balance;
    }

}
