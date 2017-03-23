package sami.beerbudget.budgetTest;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import sami.beerbudget.budget.Budget;
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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addsIncomeToBudget() {
        Budget testi = new Budget();
        testi.addIncome("vuokra", 500.0, new Date(), false);
        assertEquals(1, testi.getIncomes().size());
    }
    
    @Test
    public void addsExpenseToBudget() {
        Budget testi = new Budget();
        testi.addExpense("vuokra", 500.0, new Date(), false);
        assertEquals(1, testi.getExpenses().size());
    }
    
    @Test
    public void addToBalance() {
        Budget testi = new Budget();
        testi.addExpense("vuokra", 500.0, new Date(), false);
        assertEquals(1, testi.getExpenses().size());
    }
    
    @Test
    public void subractToBalance() {
        Budget testi = new Budget();
        testi.addExpense("vuokra", 500.0, new Date(), false);
        assertEquals(1, testi.getExpenses().size());
    }
}
