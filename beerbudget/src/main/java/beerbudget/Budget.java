/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beerbudget;

/**
 *
 * @author saklindq
 */
public class Budget {

    private double target;
    private double balance;

    public Budget(double target) {
        this.target = target;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public double getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "Your balance is: " + this.balance + " and you are " + (this.target-this.balance) + " short";
    }
    
    
    
    

}
