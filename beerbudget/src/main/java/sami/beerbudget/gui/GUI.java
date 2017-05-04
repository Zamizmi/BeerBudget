/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.gui;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sami.beerbudget.budget.MoneyFlow;
import sami.beerbudget.logic.BudgetLogic;
import sami.beerbudget.logic.Date;
import sami.beerbudget.logic.DateLogic;

/**
 * GUI is all the interface methods.
 *
 * @author saklindq
 */
public class GUI extends Application {
   
    private BudgetLogic bl;
    private Stage window;
    private GridPane layout;

    /**
     * Launch of the program.
     *
     * @param args start of main.
     */
    public static void main(String[] args) {
        launch(GUI.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        this.bl = new BudgetLogic();
        this.window = new Stage();
        this.window.setScene(startScene());
        this.window.setHeight(600);
        this.window.setWidth(450);
        this.window.show();
    }

    private Scene startScene() {
        Label currentBalance = new Label("Current Balance: ");
        TextField balanceInput = new TextField("0");
        balanceInput.textProperty().addListener(new DoubleListener(balanceInput));

        Label targetText = new Label("Target: ");
        TextField targetInput = new TextField("0");
        targetInput.textProperty().addListener(new DoubleListener(targetInput));

        Label dateDesc = new Label("Current Date: ");

        TextField dateInput = new TextField("01-01-2000");
        BooleanBinding dateInputValid = Bindings.createBooleanBinding(() -> {
            try {
                Date tet = DateLogic.stringToDate(dateInput.getText());
            } catch (Exception e) {
                return false;
            }
            return true;

        }, dateInput.textProperty());

        Button continueButton = new Button("Push to Continue");
        continueButton.disableProperty().bind(dateInputValid.not());
        continueButton.setOnAction((event) -> {
            try {
                this.bl.setBalance(Double.parseDouble(balanceInput.getText()));
                this.bl.setTarget(Double.parseDouble(targetInput.getText()));
                this.bl.setCurrentDate(DateLogic.stringToDate(dateInput.getText()));
                this.window.setScene(basicMenu());
                this.window.setScene(basicMenu());
            } catch (Exception e) {
                dateInput.setText("dd-mm-yyyy");
            }
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
    }

    private Scene basicMenu() {
        Button moneyflow = new Button("Add Moneyflow");
        moneyflow.setOnAction((event) -> {
            this.window.setScene(moneyFlowScene());
        });
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
        Label currentDate = new Label("Current Date: " + bl.getCurrentDate() + "");
        currentDate.setWrapText(true);
        Label shortOfTarget = new Label();
        shortOfTarget.setWrapText(true);
        if (bl.shortOfTarget() > 0) {
            shortOfTarget.setText("You Are " + bl.shortOfTarget() + "€ short of the Target.");
        } else {
            shortOfTarget.setText("You Have Reached Your Target!");
        }

        Label balance = new Label("Current Balance: " + bl.currentBalance());
        balance.setWrapText(true);

        Button turnDay = new Button("Turn Day");
        turnDay.setOnAction((event) -> {
            bl.turnOneDay();
            this.window.setScene(basicMenu());
        });

        Button turnMonth = new Button("Turn Month");
        turnMonth.setOnAction((event) -> {
            bl.turnToNextMonth();
            this.window.setScene(basicMenu());
        });

        Button turnYear = new Button("Turn Year");
        turnYear.setOnAction((event) -> {
            bl.turnToNextYear();
            this.window.setScene(basicMenu());
        });

        GridPane buttons = new GridPane();
        buttons.setVgap(10);
        buttons.setHgap(10);
        buttons.setPadding(new Insets(10, 10, 10, 10));

        buttons.add(moneyflow, 0, 0);
        buttons.add(budget, 3, 0);
        buttons.add(expenses, 3, 3);
        buttons.add(incomes, 0, 3);
        buttons.add(firstOfMay, 3, 6);
        buttons.add(target, 0, 6);
        //buttons.add(firstOfMay, 0, 9);
        buttons.add(turnDay, 0, 15);
        buttons.add(currentDate, 3, 15);
        buttons.add(turnMonth, 0, 18);
        buttons.add(shortOfTarget, 3, 18);
        buttons.add(turnYear, 0, 21);
        buttons.add(balance, 3, 21);

        Scene basicMenu = new Scene(buttons);
        return basicMenu;
    }

    private Scene budgetScene() {
        GridPane budgetGrid = new GridPane();
        budgetGrid.setVgap(10);
        budgetGrid.setHgap(10);
        budgetGrid.setPadding(new Insets(10, 10, 10, 10));
        Label balanceATM = new Label("Your Current Balance is: " + bl.currentBalance() + " €");
        budgetGrid.add(balanceATM, 2, 0);
        Label endOfMonth = new Label("With Current Budget You'll Have " + bl.balanceAtTheEndOfMonth() + " € at the End of the Month.");
        budgetGrid.add(endOfMonth, 2, 4);
        endOfMonth.setWrapText(true);
        Label toTarget = new Label(bl.daysToTarget());
        toTarget.setWrapText(true);
        budgetGrid.add(toTarget, 2, 6);

        Button toMenu = new Button("Menu");
        toMenu.setOnAction((event) -> {
            this.window.setScene(basicMenu());
        });
        budgetGrid.add(toMenu, 2, 16);

        Scene balanceScene = new Scene(budgetGrid);
        return balanceScene;

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
            if (DateLogic.firstDateIsBeforeSecondDateOrEqual(bl.getCurrentDate(), income.getExpirationDate())) {
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
        int i = 1;
        GridPane expenseGrid = new GridPane();
        expenseGrid.setVgap(5);
        expenseGrid.setHgap(5);

        Label desc = new Label("Here Are Listed Your Incoming Expenses");
        for (MoneyFlow expense : bl.getExpenses()) {
            if (DateLogic.firstDateIsBeforeSecondDateOrEqual(bl.getCurrentDate(), expense.getExpirationDate())) {
                Label name = new Label(expense.toString());
                Button delete = new Button("Delete");
                delete.setOnAction((event) -> {
                    bl.deleteIncome(expense);
                    delete.setVisible(false);
                });
                expenseGrid.add(delete, 1, i);
                expenseGrid.add(name, 0, i);
                i += 1;
            }
        }
        expenseGrid.add(desc, 0, 0);

        Button toMenu = new Button("Menu");
        toMenu.setOnAction((event) -> {
            this.window.setScene(basicMenu());
        });
        expenseGrid.add(toMenu, 1, i);

        Scene expenseScene = new Scene(expenseGrid);
        return expenseScene;
    }

    private Scene targetScene() {
        GridPane targetGrid = new GridPane();
        targetGrid.setVgap(10);
        targetGrid.setHgap(10);
        targetGrid.setPadding(new Insets(10, 10, 10, 10));

        Label desc = new Label(bl.daysToTarget());
        desc.setWrapText(true);
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
        income.setSelected(true);
        RadioButton expense = new RadioButton("Expense");
        expense.setToggleGroup(buttons);

        Label nameDesc = new Label("Name: ");
        TextField nameInput = new TextField();
        nameInput.setPrefWidth(80);
        BooleanBinding nameInputValid = Bindings.createBooleanBinding(() -> {
            return nameInput.getText().isEmpty();
        }, nameInput.textProperty());

        Label monthlyDesc = new Label("If The Cash Flow Is Due Monthly, Check The Box");
        monthlyDesc.setWrapText(true);
        RadioButton monthlyButton = new RadioButton("Is Monthly");

        Label amountDesc = new Label("Fill In The Amount Of Cash Flow, 'xxx.xx'");
        TextField amountInput = new TextField("0");
        amountInput.textProperty().addListener(new DoubleListener(amountInput));
        amountInput.prefWidth(80);

        Label dateDesc = new Label("Choose The Expiration Date For The Flow");
        ObservableList<Integer> dayList = FXCollections.observableArrayList();
        ObservableList<Integer> yearList = FXCollections.observableArrayList();
        ObservableList<Integer> monthList = FXCollections.observableArrayList();
        ComboBox dayBox = new ComboBox(dayList);
        ComboBox monthBox = new ComboBox(monthList);
        ComboBox yearBox = new ComboBox(yearList);
        GridPane grid = new GridPane();
        Date expirationDate = new Date();
        expirationDate.setYear(bl.getCurrentDate().getYear());
        for (int i = 1; i < DateLogic.lengthOfMonth(expirationDate); i++) {
            dayList.add(i);
        }
        dayBox.setValue(1);
        yearList.addAll(
                bl.getCurrentDate().getYear(),
                bl.getCurrentDate().getYear() + 1,
                bl.getCurrentDate().getYear() + 2
        );
        yearBox.setValue(bl.getCurrentDate().getYear());
        yearBox.setPrefSize(100, 20);
        yearBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try {
                    expirationDate.setYear((int) yearBox.getValue());
                    dayList.clear();
                    for (int i = 1; i < DateLogic.lengthOfMonth(expirationDate); i++) {
                        dayList.add(i);
                    }
                    dayBox.setValue(1);
                } catch (Exception e) {
                }
            }
        });
        monthList.addAll(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
        );
        monthBox.setValue(1);
        monthBox.setPrefSize(100, 20);
        monthBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try {
                    expirationDate.setMonth((int) monthBox.getValue());
                    dayList.clear();
                    for (int i = 1; i < DateLogic.lengthOfMonth(expirationDate); i++) {
                        dayList.add(i);
                    }
                    dayBox.setValue(1);
                } catch (Exception e) {
                }
            }
        });
        dayBox.setPrefSize(100, 20);
        dayBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try {
                    expirationDate.setDay((int) dayBox.getValue());
                } catch (Exception e) {
                }
            }
        });

        Button submit = new Button("Submit");
        submit.disableProperty().bind((nameInputValid));

        submit.setOnAction((event) -> {
            String name = nameInput.getText();
            Double amount = Double.parseDouble(amountInput.getText());
            if (amount <= 0 || name.isEmpty() || DateLogic.firstDateIsBeforeSecondDate(expirationDate, bl.getCurrentDate())) {
                this.window.setScene(basicMenu());
            } else {
                Boolean isMonthly = monthlyButton.isSelected();
                try {
                    if (buttons.getSelectedToggle().equals(income)) {
                        bl.newIncome(name, amount, expirationDate, isMonthly);
                    } else {
                        bl.newExpense(name, amount, expirationDate, isMonthly);
                    }
                } catch (Exception e) {
                    this.window.setScene(basicMenu());
                }
                this.window.setScene(basicMenu());
            }
        });

        Label yearDesc = new Label("Year");
        Label monthDesc = new Label("Month");
        Label dayDesc = new Label("Day");

        moneyFlowGrid.add(income, 2, 2);
        moneyFlowGrid.add(expense, 2, 4);
        moneyFlowGrid.add(monthlyDesc, 2, 6);
        moneyFlowGrid.add(monthlyButton, 2, 8);
        moneyFlowGrid.add(nameDesc, 2, 10);
        moneyFlowGrid.add(nameInput, 2, 12);
        moneyFlowGrid.add(amountDesc, 2, 14);
        moneyFlowGrid.add(amountInput, 2, 16);
        moneyFlowGrid.add(dateDesc, 2, 18);
        moneyFlowGrid.add(yearBox, 2, 19);
        moneyFlowGrid.add(yearDesc, 3, 19);
        moneyFlowGrid.add(monthBox, 2, 20);
        moneyFlowGrid.add(monthDesc, 3, 20);
        moneyFlowGrid.add(dayBox, 2, 21);
        moneyFlowGrid.add(dayDesc, 3, 21);
        //moneyFlowGrid.add(dateInput, 2, 20);
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
