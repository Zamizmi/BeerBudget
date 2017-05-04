package sami.beerbudget.main;

import sami.beerbudget.gui.GUI;
import static javafx.application.Application.launch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *Main.
 * @author saklindq
 */
public class Main {

    /**
     * Main. Launches the GUI.
     * If comments are removed starts the txt-version in console.
     * @param args main.
     */
    public static void main(String[] args) {
        GUI ui = new GUI();
        //InterfaceLogic alku = new InterfaceLogic();
        launch(GUI.class);
    }

}
