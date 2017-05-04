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
import sami.beerbudget.logic.DateLogic;

/**
 *
 * @author saklindq
 */
public class BudgetLogicTest {

    Budget budget;
    BudgetLogic bl;
    DateLogic dl;

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
    public void blCheckIncomes() {
        bl.newIncome("name", 100, new Date(), true);
        assertEquals(1, bl.getIncomes().size());
    }

    @Test
    public void blCheckExpenses() {
        bl.newExpense("name", 100, new Date(), true);
        assertEquals(1, bl.getExpenses().size());
    }

    @Test
    public void blTurnsDay() {
        bl.turnOneDay();
        Date secondDay = new Date();
        secondDay.turnDay();
        assertEquals(secondDay.toString(), bl.getCurrentDate().toString());
    }

    @Test
    public void blTurnsMonth() {
        bl.setCurrentDate(new Date());
        bl.turnToNextMonth();
        Date febFirst = new Date();
        febFirst.setDay(1);
        febFirst.setMonth(2);
        assertEquals(febFirst.toString(), bl.getCurrentDate().toString());
        //TODO
    }

    @Test
    public void blTurnsYear() {
        bl.turnOneYear();
        Date first2018 = new Date();
        first2018.turnYear();
        assertEquals(first2018.toString(), bl.getCurrentDate().toString());
    }

    @Test
    public void blSumsIncomes() {
        bl.newIncome("rent 100", 100, new Date(), true);
        bl.newIncome("rent 200", 200, new Date(), true);
        bl.newIncome("rent 300", 300, new Date(), true);
        assertEquals(600.0, bl.sumIncomes(), 0);
    }

    @Test
    public void blSumsExpenses() {
        bl.newExpense("rent 100", 100, new Date(), true);
        bl.newExpense("rent 200", 200, new Date(), true);
        bl.newExpense("rent 300", 300, new Date(), true);
        assertEquals(600.0, bl.sumExpenses(), 0);
    }

    @Test
    public void blCountsBeersCorrectlyWithNoExpensesOrIncomes() {
        bl.setBalance(1000);
        assertEquals(500, bl.countBeers(2.0), 0);
    }

    @Test
    public void blCountsBeersCorrectlyWithNoExpensesAndSingleIncome() {
        bl.setBalance(1000);
        Date febFirst = new Date();
        febFirst.setMonth(2);
        bl.newIncome("200", 200, febFirst, false);
        assertEquals(600, bl.countBeers(2.0), 0);
    }

    @Test
    public void blCountsBeersCorrectlyWithNoExpensesAndMonthlyIncome() {
        bl.setBalance(1000);
        Date janSecond = new Date();
        janSecond.setDay(2);
        janSecond.setMonth(1);
        bl.newIncome("200", 200, janSecond, true);
        assertEquals(900, bl.countBeers(2.0), 0);
    }

    @Test
    public void blCountsBeersCorrectlyWithNoIncomesAndSingleMonthlyExpense() {
        bl.setBalance(1000);
        Date febFirst = new Date();
        febFirst.setMonth(2);
        bl.newExpense("200", 200, febFirst, true);
        assertEquals(100, bl.countBeers(2.0), 0);
    }

    @Test
    public void blCountsBeersCorrectlyWithNoIncomesAndSingleExpense() {
        bl.setBalance(1000);
        Date febFirst = new Date();
        febFirst.setMonth(2);
        bl.newExpense("200", 200, febFirst, false);
        assertEquals(400, bl.countBeers(2.0), 0);
    }

    @Test
    public void toStringWorks() {
        bl.newIncome("100", 100, new Date(), true);
        bl.setBalance(200);
        System.out.println(bl.toString());
        assertEquals("Your balance is 600.0. You will get 250.0 beers with this budget at next First of May!", bl.toString());
    }

    @Test
    public void getAndSetBalance() {
        bl.setBalance(5000);
        assertEquals(5000.0, bl.currentBalance(), 0);
    }

    @Test
    public void getAndSetTarget() {
        bl.setTarget(1000);
        assertEquals(1000.0, bl.getTarget(), 0);
    }

    @Test
    public void getAndSetCurrentDate() {
        Date wanted = new Date();
        wanted.setDay(15);
        wanted.setMonth(10);
        wanted.setYear(2009);
        bl.setCurrentDate(wanted);
        assertEquals(wanted, bl.getCurrentDate());
    }

    @Test
    public void turn60Days() {
        Date after60 = new Date();
        after60.setDay(2);
        after60.setMonth(3);
        bl.turnManyDays(60);
        assertEquals(after60.toString(), bl.getCurrentDate().toString());
    }

    @Test
    public void createsNewBudgetLogic() {
        assertEquals(new BudgetLogic().toString(), new BudgetLogic().toString());
    }

    @Test
    public void reachTarget() {
        Date feb = new Date();
        feb.setMonth(2);
        bl.setTarget(2000);
        bl.newIncome("income", 500.0, feb, true);
        System.out.println(bl.daysToTarget());
        assertEquals("With the current budget it will take 120 days to reach the target.", bl.daysToTarget());
    }

    @Test
    public void neverReachTarget() {
        bl.setTarget(2000);
        bl.newExpense("20", 20.0, new Date(), true);
        assertEquals("With the current budget, it seems you'll never reach your target, at least not in 50 years.", bl.daysToTarget());
    }
    
    @Test
   public void shortOfBudget() {
       bl.setTarget(1000);
       bl.setBalance(500);
       assertEquals(500, bl.shortOfTarget(),1.0);
   }
   
   @Test
   public void daysToGivenDate() {
       assertEquals(31, DateLogic.daysToNextMonth(new Date()));
   }
}
