/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.gui;

import java.util.Scanner;
import sami.beerbudget.budget.MoneyFlow;
import sami.beerbudget.logic.BudgetLogic;
import sami.beerbudget.logic.Date;
import sami.beerbudget.logic.DateLogic;

/**
 *
 * @author saklindq
 */
public class InterfaceLogic {

    private BudgetLogic logic;
    private Scanner reader;

    public InterfaceLogic() {
        this.logic = new BudgetLogic();
        this.reader = new Scanner(System.in);

    }

    /**
     * Is the first method to run from the main-class. Is a text-based User
     * Interface.
     */
    public void run() {
        System.out.println("Welcome to the Beer Budget!");
        System.out.println("Please start by telling your current balance");
        Double balance = Double.parseDouble(reader.nextLine());
        logic.setBalance(balance);
        System.out.println("Please tell me your target sum you wish to save");
        Double target = Double.parseDouble(reader.nextLine());
        logic.setTarget(target);
        logic.setCurrentDate(askForDate());
        listCommands();
        commands();
    }

    /**
     *
     * Prints all the commands available for the text-based UI.
     *
     */
    public void listCommands() {
        System.out.println("list - Prints all the commands");
        System.out.println("moneyflow - Add new expense or income");
        System.out.println("balance - Print current balance");
        System.out.println("budget - View the current budget");
        System.out.println("incomes - Prints all added incomes");
        System.out.println("expenses - Prints all added expenses");
        System.out.println("target - Prints current target and how long you will have save for it at current budget");
        System.out.println("First of May -  Prints the number of beers you will get at the next First of May!");
    }

    /**
     *
     * Is running while app is running in text-based. Asks for input and calls
     * the right methods after receiving commands.
     *
     */
    public void commands() {
        while (true) {
            System.out.println("Please give one of the commands to proceed.");
            String command = reader.nextLine();
            if (command.equals("list")) {
                listCommands();
            } else if (command.equals("moneyflow")) {
                askForMoneyFlow();
            } else if (command.equals("balance")) {
                currentBalance();
            } else if (command.equals("budget")) {
                currentBudget();
            } else if (command.equals("incomes")) {
                listIncomes();
            } else if (command.equals("expenses")) {
                listExpenses();
            } else if (command.equals("target")) {
                printTarget();
            } else if (command.equals("First of May")) {
                firstOfMay();
            } else if (command.equals("exit")) {
                System.out.println("SEE YA MONEY MASTER!");
                break;
            } else {
                System.out.println("Command was invalid!");
            }
        }
    }

    /**
     * Prints the current balance and the amount User will have at the end of
     * the month according the budget.
     */
    public void currentBalance() {
        System.out.println("You have " + logic.currentBalance() + " left for current month." + "\n"
                + "Your balance will be " + logic.balanceAtTheEndOfMonth() + "at the end of the month");
    }

    /**
     * Prints info of the budget.
     */
    public void currentBudget() {
        System.out.println("todo");
    }

    /**
     * Prints all incomes and the total sum they'll produce for the month.
     */
    public void listIncomes() {
        System.out.println("Incomes: " + this.logic.getIncomes().size());

        for (MoneyFlow income : this.logic.getIncomes()) {
            System.out.println(income.toString());
        }
        System.out.println(" This will total in " + logic.sumIncomes() + " for this month");
    }

    /**
     * Prints all expenses and the total cost they'll produce for the current
     * month.
     */
    public void listExpenses() {
        System.out.println("Expenses: " + this.logic.getExpenses().size());
        for (MoneyFlow expense : this.logic.getExpenses()) {
            System.out.println(expense);
        }
        System.out.println(" This will total in " + this.logic.sumExpenses() + " for this month");
    }

    /**
     * Prints the amount of days needed to fulfil the target. If the budget
     * can't accomplish the target in 50 years, it will tell it.
     */
    public void printTarget() {
        System.out.println(logic.daysToTarget());
    }

    /**
     * Prints TODO. Also prints the amount of beers User can buy at the next
     * First Of May.
     */
    public void firstOfMay() {
        System.out.println(logic.toFirstOfMay());
        System.out.println("You will get " + logic.countBeers(1.0) + " beers at First of May!");

    }

    /**
     * Asks for input and user creates new moneyflow. The new Moneyflow is added
     * to the budget automatically.
     */
    public void askForMoneyFlow() {
        while (true) {
            System.out.println("Write 'i' for new Income, 'e' for new expense, exit to stop");
            String decision = reader.nextLine();
            if (decision.equals("i")) {
                newIncome();
            } else if (decision.equals("e")) {
                newExpense();
            } else if (decision.equals("exit")) {
                break;
            } else {
                System.out.println("Say that again!");
            }
        }
    }

    /**
     * Asks for input from the User to create expense.
     */
    public void newExpense() {
        System.out.println("Give a name for the expense");
        String name = reader.nextLine();
        System.out.println("How much money will it cost?");
        double amount = Double.parseDouble(reader.nextLine());
        boolean monthly = false;
        while (true) {
            System.out.println("Will it be monthly(m) or once(o)?");
            String decision = reader.nextLine();
            if (decision.equals("m")) {
                monthly = true;
                break;
            } else if (decision.equals("o")) {
                monthly = false;
                break;
            } else {
                System.out.println("You chose expense to be paid once");
                break;
            }
        }
        Date expiration = askForDate();
        this.logic.newExpense(name, amount, new Date(), monthly);
    }

    /**
     * Asks for input from the User to create new income. Asks correct input
     * until method receives one.
     */
    public void newIncome() {
        System.out.println("Give a name for the income");
        String name = reader.nextLine();
        System.out.println("How much money you will get?");
        double amount = Double.parseDouble(reader.nextLine());
        boolean monthly = false;
        while (true) {
            System.out.println("Will it be (m)onthly or (o)nce?");
            String decision = reader.nextLine();
            if (decision.equals("m")) {
                monthly = true;
                break;
            } else if (decision.equals("o")) {
                monthly = false;
                break;
            } else {
                System.out.println("Input is invalid, try again!");
            }
        }
        Date expiration = askForDate();
        this.logic.newIncome(name, amount, expiration, monthly);
    }

    /**
     *
     * @return Date from User input.
     */
    public Date askForDate() {
        System.out.println("Give the date (dd-mm-yyyy)");
        String date = reader.nextLine();
        return DateLogic.stringToDate(date);
    }
}
