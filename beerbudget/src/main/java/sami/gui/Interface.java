/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.gui;

import java.util.Scanner;
import sami.beerbudget.MoneyFlow;
import sami.logic.BudgetLogic;
import sami.logic.Date;

/**
 *
 * @author saklindq
 */
public class Interface {

    private BudgetLogic logic;
    private Scanner reader;

    public Interface() {
        this.logic = new BudgetLogic();
        this.reader = new Scanner(System.in);

    }

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

    public void listCommands() {
        System.out.println("list - Prints all the commands");
        System.out.println("moneyflow - Add new expense or income");
        System.out.println("balance - Print current balance");
        System.out.println("budget - View the current budget");
        System.out.println("incomes - Prints all added incomes");
        System.out.println("expenses - Prints all added expenses");
        System.out.println("target - Prints current target and how long you will have save for it at current budget");
        System.out.println("First of May -  Prints the number of beers you will get at the next First of May!");
        //System.out.println("TODO");
    }

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
                //commands();
            }
        }

    }

    public void currentBalance() {
        //TODO
        // logic.countTillTheEndOfMonth();
        System.out.println("You have " + logic.currentBalance() + " left for current month.");
    }

    public void currentBudget() {
        System.out.println("todo");
    }

    public void listIncomes() {
        System.out.println("Incomes: " + this.logic.getIncomes().size());

        for (MoneyFlow income : this.logic.getIncomes()) {
            System.out.println(income.toString());
        }
        System.out.println(" This will total in " + logic.sumIncomes() + " for this month");
    }

    public void listExpenses() {
        System.out.println("Expenses: " + this.logic.getExpenses().size());
        for (MoneyFlow expense : this.logic.getExpenses()) {
            System.out.println(expense);
        }
        System.out.println(" This will total in " + this.logic.sumExpenses() + " for this month");
    }

    public void printTarget() {
        //TODO
        System.out.println("According to the budget you wish to save a lot of money");

    }

    public void firstOfMay() {
        System.out.println(logic.daysToFirstOfMay());
        System.out.println("You will get " + logic.countBeers(1.0) + " beers at First of May!");

    }

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

    public void newIncome() {
        System.out.println("Give a name for the income");
        String name = reader.nextLine();
        System.out.println("How much money you will get?");
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
                System.out.println("You chose income to be paid once");
                break;
            }
        }
        Date expiration = askForDate();

        this.logic.newIncome(name, amount, expiration, monthly);

    }

    public Date askForDate() {
        System.out.println("Give the date (dd-mm-yyyy)");
        String date = reader.nextLine();
        String[] split = date.split("-");
        int day = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int year = Integer.parseInt(split[2]);
        Date toReturn = new Date();
        toReturn.setDay(day);
        toReturn.setMonth(month);
        toReturn.setYear(year);
        return toReturn;
    }

}
