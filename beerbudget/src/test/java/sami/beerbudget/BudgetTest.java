package sami.beerbudget;


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
import static org.junit.Assert.*;
import sami.logic.Date;

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
    
    public void addsExpenseToBudget() {
        Budget testi = new Budget();
        testi.addExpense("vuokra", 500.0, new Date(), false);
        assertEquals(1, testi.getExpenses().size());
    }
}
