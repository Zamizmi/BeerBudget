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
import sami.beerbudget.budget.MoneyFlow;
import static org.junit.Assert.*;
import sami.beerbudget.logic.Date;

/**
 *
 * @author saklindq
 */
public class MoneyFlowTest {

    Date newYear = new Date();
    MoneyFlow rentExpense = new MoneyFlow("rent", 500.0, newYear, false, true);
    MoneyFlow salaryIncome = new MoneyFlow("salary", 1500.0, newYear, false, false);

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

        assertEquals("income Amount: 100.0, Due Date: 1-1-2017", income.toString());
    }

    @Test
    public void expenseToStringIsCorrect() {
        MoneyFlow expense = new MoneyFlow("expense", 100, new Date(), true, true);

        assertEquals("expense Amount: 100.0, Due Date: 1-1-2017", expense.toString());
    }

    @Test
    public void setsAndGetsAmount() {
        salaryIncome.setAmount(8000);
        assertEquals(8000.0, salaryIncome.getAmount(), 0);
    }

    @Test
    public void setsIncomeToExpense() {
        salaryIncome.setExpense(true);
        assertEquals(true, salaryIncome.isExpense());
    }

    @Test
    public void setsAndGetsExpiration() {
        Date old = new Date();
        old.setYear(1888);
        salaryIncome.setExpirationDate(old);
        assertEquals(old, salaryIncome.getExpirationDate());
    }

    @Test
    public void setsAndGetsName() {
        salaryIncome.setName("The Best Name Ever");
        assertEquals("The Best Name Ever", salaryIncome.getName());
    }

    @Test
    public void setsAndGetsMonthly() {
        salaryIncome.setMonthly(true);
        assertEquals(true, salaryIncome.isMonthly());
    }

    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
