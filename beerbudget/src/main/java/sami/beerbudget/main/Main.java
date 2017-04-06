package sami.beerbudget.main;

import javax.swing.*;
import sami.beerbudget.gui.GUI;
import sami.beerbudget.gui.InterfaceLogic;
import sami.beerbudget.logic.Date;
import sami.beerbudget.logic.DateLogic;

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
        SwingUtilities.invokeLater(ui);
        InterfaceLogic alku = new InterfaceLogic();
        alku.run();
    }

}
