package sami.beerbudget.budgetTest;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sami.beerbudget.budget.Budget;
import static org.junit.Assert.*;
import sami.beerbudget.logic.Date;

/**
 *
 * @author saklindq
 */
public class BudgetTest {

    Budget balanceIsPositive = new Budget();
    Budget balanceIsNegative = new Budget();

    public BudgetTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        balanceIsPositive.addExpense("food", 500.0, new Date(), false);
        balanceIsPositive.addIncome("rent", 500.0, new Date(), false);
        balanceIsNegative.addExpense("rent200", 200.0, new Date(), true);
        balanceIsNegative.addExpense("rent300", 300.0, new Date(), true);
        balanceIsNegative.addExpense("rent400", 400.0, new Date(), true);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addsIncomeToBudget() {
        //Budget balanceIsPositive = new Budget();
        balanceIsPositive.addIncome("salary", 500.0, new Date(), false);
        assertEquals(2, balanceIsPositive.getIncomes().size());
    }

    @Test
    public void addsExpenseToBudget() {
        balanceIsPositive.addExpense("food2", 500.0, new Date(), false);
        assertEquals(2, balanceIsPositive.getExpenses().size());
    }

    @Test
    public void addToBalance() {
        balanceIsPositive.addToBalance(500.0);
        assertEquals(500, balanceIsPositive.getBalance(), .0);
    }

    @Test
    public void subractToBalance() {
        balanceIsPositive.subractFromBalance(500.0);
        assertEquals(-500.0, balanceIsPositive.getBalance(), 1);
    }

    @Test
    public void toStringWorks() {
        balanceIsPositive.setBalance(500.0);
        balanceIsPositive.setTarget(400.0);
        assertEquals("Your target is: 400.0" + "\n" + "Your Current Balance is: 500.0", balanceIsPositive.toString());
    }
}
