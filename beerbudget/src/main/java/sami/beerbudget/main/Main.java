package sami.beerbudget.main;

import javax.swing.*;
import sami.beerbudget.gui.GUI;
import sami.beerbudget.gui.InterfaceLogic;

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
        GUI ui = new GUI();
        SwingUtilities.invokeLater(ui);
        InterfaceLogic alku = new InterfaceLogic();
        alku.run();
    }

}
