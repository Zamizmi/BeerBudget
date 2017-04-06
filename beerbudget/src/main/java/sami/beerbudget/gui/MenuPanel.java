/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author saklindq
 */
public class MenuPanel extends JPanel implements ActionListener {

    public MenuPanel() {
        super(new GridLayout(1, 3));
        createComponents();
    }

    //TODO
    /**
     * WIP. When ready, creates buttons in JPanel.
     */
    private void createComponents() {
        //Asks for new moneyflow
        JButton moneyFlowButton = new JButton("Moneyflow");
        moneyFlowButton.addActionListener(this);
        add(moneyFlowButton);
        //Lists all the incomes
        JButton incomesButton = new JButton("Incomes");
        incomesButton.addActionListener(this);
        add(incomesButton);
        //Lists all the expenses
        JButton expensesButton = new JButton("Expenses");
        expensesButton.addActionListener(this);
        add(expensesButton);
        //Shows budget on some level? Might get deleted
        JButton budgetButton = new JButton("Budget");
        budgetButton.addActionListener(this);
        add(budgetButton);
        //Shows balance atm and at the end of month
        JButton balanceButton = new JButton("Balance");
        balanceButton.addActionListener(this);
        add(balanceButton);
        //Shows when the target is completed if completed
        JButton targetButton = new JButton("Target");
        targetButton.addActionListener(this);
        add(targetButton);
        //Shows how many beers one can buy at the next First of May
        JButton firstOfMayButton = new JButton("First Of May");
        firstOfMayButton.addActionListener(this);
        add(firstOfMayButton);
    }
    
    //TODO
    /**
     * When active, creates magic.
     *
     * @param e cool stuff. The best stuff.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
