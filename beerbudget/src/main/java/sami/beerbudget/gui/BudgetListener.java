/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import sami.beerbudget.logic.BudgetLogic;
import sami.beerbudget.logic.Date;
import sami.beerbudget.logic.DateLogic;

/**
 *
 * @author saklindq
 */
public class BudgetListener implements ActionListener {

    private BudgetLogic bl;
    private JFrame frame;
    private JTextField target;
    private JTextField balance;
    private JTextField end;

    public BudgetListener(BudgetLogic bl, JFrame jf, JTextField targetField, JTextField balanceField, JTextField endField) {
        this.bl = bl;
        this.frame = jf;
        this.target = targetField;
        this.balance = balanceField;
        this.end = endField;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        try {
            double amount = Double.parseDouble(this.target.getText());
            double balance = Double.parseDouble(this.balance.getText());
            Date dateType = DateLogic.stringToDate(this.end.getText());
        } catch (Exception e) {
            this.frame.dispose();
        }

    }

}
