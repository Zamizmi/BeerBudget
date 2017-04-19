/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author saklindq
 */
public class GUI extends Application {

    @Override
    public void start(Stage window) {
        Label welcome = new Label("Welcome to Beer Budget. With Beer Budget you are able to track your money usage easily.");
        Label continueText = new Label("Before you start, take some and think all the incomes and expenses you have monthly." + "\n" + " Start with the easiest that come to your mind. Rent. Salary.");
        Label whenReady = new Label("When you are ready, press the button below to start creating your very own Beer Budget.");
        Button continueB = new Button("New Budget");
        Button importOld = new Button("Import old budget");
        Button exit = new Button("Exit");
        exit.setOnAction((event) -> {
            Platform.exit();
        });

        BorderPane layout = new BorderPane();
        HBox buttons = new HBox();
        buttons.setSpacing(150);

        VBox texts = new VBox();
        texts.setSpacing(20);
        texts.getChildren().add(welcome);
        texts.getChildren().add(continueText);
        texts.getChildren().add(whenReady);

        buttons.getChildren().add(continueB);
        buttons.getChildren().add(importOld);
        buttons.getChildren().add(exit);

        layout.setTop(texts);
        layout.setBottom(buttons);

        Scene scene = new Scene(layout);
        window.setTitle("Beer Budget");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(GUI.class);
    }
}

/**
 * Creates components.
 *
 * @param container The Place where these components are wanted.
 */
//    private void createComponents(Container container) {
//        //GridLayout layout = new GridLayout(4, 3);
//        //container.setLayout(layout);
//
//        JButton moneyflow = new JButton("Add!");
//        JButton incomes = new JButton("Add!");
//        JButton expenses = new JButton("Add!");
//        JButton balance = new JButton("Add!");
//        JButton target = new JButton("Add!");
//        JButton addButton = new JButton("Add!");
//        JButton firstOfMay = new JButton("Add!");
//        JTextField printer = new JTextField();
//        // event listener
//
//        container.add(new MenuPanel());
////        container.add(incomes);
////        container.add(expenses);
////        container.add(balance);
////        container.add(target);
////        container.add(firstOfMay);
////        container.add(printer);
//    }
//    public JFrame getFrame() {
//        return frame;
//    }

