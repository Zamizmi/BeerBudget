package sami.beerbudget.budgetTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import sami.beerbudget.budget.MoneyFlow;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sami.beerbudget.budget.MoneyFlow;
import static org.junit.Assert.*;
import sami.beerbudget.logic.Date;

/**
 *
 * @author saklindq
 */
public class MoneyFlowTest {

    public MoneyFlowTest() {
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
    public void incomeToStringIsCorrect() {
        MoneyFlow income = new MoneyFlow("income", 100, new Date(), true, false);

        assertEquals("income will give : 100.0", income.toString());
    }

    @Test
    public void expenseToStringIsCorrect() {
        MoneyFlow expense = new MoneyFlow("expense", 100, new Date(), true, true);

        assertEquals("expense will cost : 100.0", expense.toString());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
