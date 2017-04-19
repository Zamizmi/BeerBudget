package sami.beerbudget.main;

import sami.beerbudget.gui.GUI;
import sami.beerbudget.gui.InterfaceLogic;
import sami.beerbudget.logic.Date;
import sami.beerbudget.logic.DateLogic;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author saklindq
 */
public class Main {

    public static void main(String[] args) {
        Date test = new Date();
        test.setYear(1900);
        System.out.println(DateLogic.daysInYear(test));
        GUI ui = new GUI();
        //launch(GUI.class);
        //SwingUtilities.invokeLater(ui);
        InterfaceLogic alku = new InterfaceLogic();
        launch(GUI.class);
    }

}
