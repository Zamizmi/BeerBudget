/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import sami.beerbudget.budget.MoneyFlow;
import sami.beerbudget.logic.BudgetLogic;
import sami.beerbudget.logic.Date;
import sami.beerbudget.logic.DateLogic;

/**
 *
 * @author saklindq
 */
public class MoneyFlowListener implements ActionListener {

    private BudgetLogic bl;
    private JFrame frame;
    private JTextField name;
    private JTextField amount;
    private JTextField date;
    private boolean monthly;
    private Boolean expense;

    public MoneyFlowListener(BudgetLogic bl, JFrame jf, JTextField nameField, JTextField amountField, JTextField dateField, boolean monthly, boolean expense) {
        this.bl = bl;
        this.frame = jf;
        this.name = nameField;
        this.amount = amountField;
        this.date = dateField;
        this.monthly = monthly;
        this.expense = expense;
    }
    
    //TODO
    /**
     * When activated, creates new moneyflow.
     * @param ae activation.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        try {
            double amount = Double.parseDouble(this.amount.getText());
            String name = this.name.getText();
            Date dateType = DateLogic.stringToDate(this.date.getText());
            //System.out.println(amount);
            if (command.equals("Add")) {
                if (expense) {
                    bl.newExpense(name, amount, dateType, monthly);
                    this.frame.dispose();
                } else {
                    bl.newIncome(name, amount, dateType, monthly);
                    this.frame.dispose();
                }
            }
        } catch (Exception e) {
            this.frame.dispose();
        }

    }

}
