package sami.beerbudget.logicTest;

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
import sami.beerbudget.logic.BudgetLogic;
import sami.beerbudget.logic.Date;
import static org.junit.Assert.*;

/**
 *
 * @author saklindq
 */
public class BudgetLogicTest {

    Budget budget;
    BudgetLogic bl;

    public BudgetLogicTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
        budget = new Budget();
        budget.setBalance(200);
        budget.setTarget(500);
        bl = new BudgetLogic(budget, new Date());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void blSetsBalance() {
        bl.setBalance(500);
        assertEquals(500, budget.getBalance(), 1);
    }

    @Test
    public void blSetsTarget() {
        bl.setTarget(5000);
        assertEquals(5000, budget.getTarget(), 1);
    }

    @Test
    public void blSetsDate() {
        Date lastChristmas = new Date();
        lastChristmas.setDay(25);
        lastChristmas.setMonth(12);
        bl.setEndDate(lastChristmas);
        assertEquals("25.12.2017", bl.getEndDate().toString());
    }
    
    @Test
    public void blCheckIncomes() {
        //TODO
    }
    
    @Test
    public void blCheckExpenses() {
        //TODO
    }
    
    @Test
    public void blTurnsDay() {
        //TODO
    }
    
    @Test
    public void blTurnsMonth() {
        //TODO
    }
    
    @Test
    public void blTurnsYear() {
        //TODO
    }
    
    @Test
    public void blSumsIncomes() {
        //TODO
    }
    
    @Test
    public void blSubtractsExpenses() {
        //TODO
    }
    
    @Test
    public void blCountsBeersCorrectly() {
        //TODO
    }
    
    @Test
    public void blCountsDaysToFirstOfMayCorrect() {
        //TODO
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
