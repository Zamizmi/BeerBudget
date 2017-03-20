/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.gui;

import java.util.Date;
import java.util.Scanner;
import sami.logic.BudgetLogic;

/**
 *
 * @author saklindq
 */
public class Interface {
    
    private BudgetLogic logic;
    private Scanner reader;
    
    public Interface() {
        this.logic = new BudgetLogic();
        this.reader = new Scanner(System.in);
        
    }
    
    public void run() {
        System.out.println("Welcome to the Beer Budget!");
        System.out.println("Please start by telling your current balance");
        Double balance = Double.parseDouble(reader.nextLine());
        logic.setBalance(balance);
        System.out.println("Please tell me your target sum you wish to save");
        Double target = Double.parseDouble(reader.nextLine());
        logic.setTarget(target);
        System.out.println("Say 'y' for new Income, 'n' for new expense");
        String decision = reader.nextLine();
        
        if (decision.equals("y")) {            
            newIncome("income", 0, true, new Date(1,1,1));
        } else if(decision.equals("n")) {
            newExpense("expense", 0, true, new Date(1,1,1));
        } else {
            System.out.println("Say that again!");
        }
        //System.out.println("");
    }
    
    public boolean yesOrNo(String decision) {
        if (decision.equals("y")) {
            return true;
        }
        return false;
    }
    
    public void newExpense(String name, double amount, boolean monthly, Date exp) {
        logic.newExpense(name, amount, monthly, exp);
        
    }
    
    public void newIncome(String name, double amount, boolean monthly, Date exp) {
        logic.newIncome(name, amount, monthly, exp);
    }
    
}
