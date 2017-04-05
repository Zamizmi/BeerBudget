/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.gui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author saklindq
 */
public class GUI implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Title");
        frame.setPreferredSize(new Dimension(600, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(4, 3);
        container.setLayout(layout);

        JButton moneyflow = new JButton("Add!");
        JButton incomes = new JButton("Add!");
        JButton expenses = new JButton("Add!");
        JButton balance = new JButton("Add!");
        JButton target = new JButton("Add!");
        JButton addButton = new JButton("Add!");
        JButton firstOfMay = new JButton("Add!");
        JTextField printer = new JTextField();
        // event listener

        container.add(moneyflow);
        container.add(incomes);
        container.add(expenses);
        container.add(balance);
        container.add(target);
        container.add(firstOfMay);
        container.add(printer);
    }

    public JFrame getFrame() {
        return frame;
    }

}
