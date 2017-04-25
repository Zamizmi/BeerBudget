/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sami.beerbudget.budget.MoneyFlow;
import sami.beerbudget.logic.BudgetLogic;
import sami.beerbudget.logic.Date;
import sami.beerbudget.logic.DateLogic;

/**
 *
 * @author saklindq
 */
public class GUI extends Application {

    private InterfaceLogic logic;
    private BudgetLogic bl;
    private Stage window;
    private GridPane layout;

    public static void main(String[] args) {
        launch(GUI.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        this.bl = new BudgetLogic();
        this.window = new Stage();
        this.window.setScene(startScene());
        this.window.setHeight(600);
        this.window.setWidth(400);
        this.window.show();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Scene startScene() {
        Label currentBalance = new Label("Current Balance: ");
        TextField balanceInput = new TextField("0");
        Label targetText = new Label("Target: ");
        TextField targetInput = new TextField("0");
        Label dateDesc = new Label("Current Date: ");
        TextField dateInput = new TextField("dd-mm-yyyy");

        Button continueButton = new Button("Push to Continue");
        continueButton.setOnAction((event) -> {
            this.bl.setBalance(Double.parseDouble(balanceInput.getText()));
            this.bl.setTarget(Double.parseDouble(targetInput.getText()));
            this.bl.setCurrentDate(DateLogic.stringToDate(dateInput.getText()));
            this.window.setScene(basicMenu());
        });

        GridPane startView = new GridPane();
        startView.add(currentBalance, 0, 0);
        startView.add(balanceInput, 1, 0);
        startView.add(targetText, 0, 1);
        startView.add(targetInput, 1, 1);
        startView.add(dateDesc, 0, 2);
        startView.add(dateInput, 1, 2);
        startView.add(continueButton, 1, 4);
        startView.setHgap(10);
        startView.setVgap(10);
        startView.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(startView);
        return scene;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Scene basicMenu() {
        Button moneyflow = new Button("Add Moneyflow");
        moneyflow.setOnAction((event) -> {
            this.window.setScene(moneyFlowScene());
        });
        Button balance = new Button("Balance");
        balance.setOnAction((event) -> {
            this.window.setScene(balanceScene());
        });
        balance.setMinSize(120, 20);
        Button budget = new Button("Budget");
        budget.setOnAction((event) -> {
            this.window.setScene(budgetScene());
        });
        budget.setMinSize(120, 20);
        Button incomes = new Button("Incomes");
        incomes.setOnAction((event) -> {
            this.window.setScene(incomesScene());
        });
        incomes.setMinSize(120, 20);
        Button expenses = new Button("Expenses");
        expenses.setOnAction((event) -> {
            this.window.setScene(expensesScene());
        });
        expenses.setMinSize(120, 20);
        Button target = new Button("Target");
        target.setOnAction((event) -> {
            this.window.setScene(targetScene());
        });
        target.setMinSize(120, 20);
        Button firstOfMay = new Button("First of May");
        firstOfMay.setOnAction((event) -> {
            this.window.setScene(firstOfMayScene());
        });
        firstOfMay.setMinSize(120, 20);

        GridPane buttons = new GridPane();
        buttons.setVgap(10);
        buttons.setHgap(10);
        buttons.setPadding(new Insets(10, 10, 10, 10));

        buttons.add(moneyflow, 0, 0);
        buttons.add(balance, 3, 0);
        buttons.add(expenses, 3, 3);
        buttons.add(incomes, 0, 3);
        buttons.add(budget, 3, 6);
        buttons.add(target, 0, 6);
        buttons.add(firstOfMay, 0, 9);

        Scene basicMenu = new Scene(buttons);
        return basicMenu;
    }

    private Scene balanceScene() {
        GridPane balanceGrid = new GridPane();
        balanceGrid.setVgap(10);
        balanceGrid.setHgap(10);
        balanceGrid.setPadding(new Insets(10, 10, 10, 10));
        TextArea balanceATM = new TextArea("Your Current Balance is: " + bl.currentBalance() + " €");
        balanceGrid.add(balanceATM, 2, 0);
        TextArea endOfMonth = new TextArea("With Current Budget You'll Have " + bl.balanceAtTheEndOfMonth() + " € at the End of the Month.");
        balanceGrid.add(endOfMonth, 2, 4);
        endOfMonth.setWrapText(true);
        Button toMenu = new Button("Menu");
        toMenu.setOnAction((event) -> {
            this.window.setScene(basicMenu());
        });
        balanceGrid.add(toMenu, 2, 16);

        Scene balanceScene = new Scene(balanceGrid);
        return balanceScene;
    }

    //TODO
    //Dont know what to do with this...
    private Scene budgetScene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Scene incomesScene() {
        int i = 1;
        GridPane incomeGrid = new GridPane();
        incomeGrid.setVgap(5);
        incomeGrid.setHgap(5);
        //incomeGrid.setPadding(new Insets(10, 10, 10, 10));

        Label desc = new Label("Here Are Listed Your Incomes");
        incomeGrid.add(desc, 0, 0);
        for (MoneyFlow income : bl.getIncomes()) {
            Label name = new Label(income.toString());
            Button delete = new Button("Delete");
            delete.setOnAction((event) -> {
                bl.deleteIncome(income);
                delete.setVisible(false);
            });
            incomeGrid.add(delete, 1, i);
            incomeGrid.add(name, 0, i);
            i += 1;
        }

        //incomeGrid.add(incomeArea, 0, 2);
        Button toMenu = new Button("Menu");
        toMenu.setOnAction((event) -> {
            this.window.setScene(basicMenu());
        });
        incomeGrid.add(toMenu, 1, i);

        Scene incomeScene = new Scene(incomeGrid);
        return incomeScene;
    }

    private Scene expensesScene() {
        GridPane expenseGrid = new GridPane();
        expenseGrid.setVgap(10);
        expenseGrid.setHgap(10);
        expenseGrid.setPadding(new Insets(10, 10, 10, 10));

        Label desc = new Label("Here Are Listed Your Expenses For The Month");
        for (int i = 0; i < bl.getExpenses().size(); i++) {
            String name = "Expense" + i;
            Label expense = new Label("" + bl.getExpenses().get(i) + " Will get Realized at " + bl.getExpenses().get(i).getExpirationDate());
        }
        Label expenses = new Label("" + bl.getExpenses());
        expenseGrid.add(desc, 0, 0);
        expenseGrid.add(expenses, 0, 2);

        Button toMenu = new Button("Menu");
        toMenu.setOnAction((event) -> {
            this.window.setScene(basicMenu());
        });
        expenseGrid.add(toMenu, 2, 16);

        Scene expenseScene = new Scene(expenseGrid);
        return expenseScene;
    }

    private Scene targetScene() {
        GridPane targetGrid = new GridPane();
        targetGrid.setVgap(10);
        targetGrid.setHgap(10);
        targetGrid.setPadding(new Insets(10, 10, 10, 10));

        Label desc = new Label(bl.daysToTarget());
        targetGrid.add(desc, 0, 0);

        Button toMenu = new Button("Menu");
        toMenu.setOnAction((event) -> {
            this.window.setScene(basicMenu());
        });
        targetGrid.add(toMenu, 1, 16);

        Scene targetScene = new Scene(targetGrid);
        return targetScene;
    }

    private Scene firstOfMayScene() {
        GridPane firstOfMayGrid = new GridPane();
        firstOfMayGrid.setVgap(10);
        firstOfMayGrid.setHgap(10);
        firstOfMayGrid.setPadding(new Insets(10, 10, 10, 10));

        Label daysToMayDay = new Label("It is " + DateLogic.daysToNextFirstOfMay(bl.getCurrentDate()) + " Days To First Of May!");
        firstOfMayGrid.add(daysToMayDay, 0, 2);
        Label mayDay = new Label("And You'll Get " + bl.countBeers(4.0) + " Beers At Then!");
        firstOfMayGrid.add(mayDay, 0, 4);

        Button toMenu = new Button("Menu");
        toMenu.setOnAction((event) -> {
            this.window.setScene(basicMenu());
        });
        firstOfMayGrid.add(toMenu, 2, 16);

        Scene firstOfMayScene = new Scene(firstOfMayGrid);
        return firstOfMayScene;
    }

    private Scene moneyFlowScene() {

        GridPane moneyFlowGrid = new GridPane();
        moneyFlowGrid.setVgap(10);
        moneyFlowGrid.setHgap(10);
        moneyFlowGrid.setPadding(new Insets(10, 10, 10, 10));

        Label desc = new Label("Choose Income or Expense");
        moneyFlowGrid.add(desc, 2, 0);
        ToggleGroup buttons = new ToggleGroup();
        RadioButton income = new RadioButton("Income");
        income.setToggleGroup(buttons);
        RadioButton expense = new RadioButton("Expense");
        expense.setToggleGroup(buttons);
        Label nameDesc = new Label("Name: ");
        TextField nameInput = new TextField();
        Label monthlyDesc = new Label("If The Cash Flow Is Due Monthly, Check The Box");
        RadioButton monthlyButton = new RadioButton("Is Monthly");
        Label amountDesc = new Label("Fill In The Amount Of Cash Flow, 'xxx.xx'");
        TextField amountInput = new TextField("0");
        Label dateDesc = new Label("Fill In The Due Date For The Flow, 'dd-mm-yyyy'");
        TextField dateInput = new TextField("dd-mm-yyyy");
        Button submit = new Button("Submit");
        submit.setOnAction((event) -> {
            String name = nameInput.getText();
            Double amount = Double.parseDouble(amountInput.getText());
            Date dueDate = DateLogic.stringToDate(dateInput.getText());
            Boolean isMonthly = monthlyButton.isSelected();
            if (buttons.getSelectedToggle().equals(income)) {
                bl.newIncome(name, amount, dueDate, isMonthly);
            } else {
                bl.newExpense(name, amount, dueDate, isMonthly);
            }
            this.window.setScene(basicMenu());
        });

        moneyFlowGrid.add(income, 2, 2);
        moneyFlowGrid.add(expense, 2, 4);
        moneyFlowGrid.add(monthlyDesc, 2, 6);
        moneyFlowGrid.add(monthlyButton, 2, 8);
        moneyFlowGrid.add(nameDesc, 2, 10);
        moneyFlowGrid.add(nameInput, 2, 12);
        moneyFlowGrid.add(amountDesc, 2, 14);
        moneyFlowGrid.add(amountInput, 2, 16);
        moneyFlowGrid.add(dateDesc, 2, 18);
        moneyFlowGrid.add(dateInput, 2, 20);
        moneyFlowGrid.add(submit, 2, 22);

        Button toMenu = new Button("Menu");
        toMenu.setOnAction((event) -> {
            this.window.setScene(basicMenu());
        });
        moneyFlowGrid.add(toMenu, 2, 24);

        Scene moneyFlowScene = new Scene(moneyFlowGrid);
        return moneyFlowScene;
    }
}
