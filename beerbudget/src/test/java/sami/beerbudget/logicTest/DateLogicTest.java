/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.logicTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sami.beerbudget.logic.Date;
import sami.beerbudget.logic.DateLogic;

/**
 *
 * @author saklindq
 */
public class DateLogicTest {

    DateLogic dlt = new DateLogic();
    Date fom = new Date();
    Date threeDaysBeforeFOM = new Date();

    public DateLogicTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        threeDaysBeforeFOM.setDay(28);
        threeDaysBeforeFOM.setMonth(4);
        threeDaysBeforeFOM.setYear(2000);
        fom.setDay(1);
        fom.setMonth(5);
        fom.setYear(2001);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void daysToFirstOfMay() {
        assertEquals(3, dlt.daysToNextFirstOfMay(threeDaysBeforeFOM));
    }

    @Test
    public void daysFrom2ndOfMay() {
        fom.setDay(2);
        fom.setMonth(5);
        fom.setYear(2017);
        assertEquals(364, dlt.daysToNextFirstOfMay(fom));
    }

    @Test
    public void daysFrom1stOfMay() {
        assertEquals(0, dlt.daysToNextFirstOfMay(fom));
    }

    @Test
    public void daysFromNewYear() {
        Date newYear = new Date();
        assertEquals(120, dlt.daysToNextFirstOfMay(newYear));
    }

    @Test
    public void daysFromIndependenceDay() {
        Date independenceDay = new Date();
        independenceDay.setDay(6);
        independenceDay.setMonth(12);

        assertEquals(146, dlt.daysToNextFirstOfMay(independenceDay));
    }

    @Test
    public void daysToFebFromNewYear() {
        Date newYear = new Date();
        assertEquals(31, dlt.daysToNextMonth(newYear));
    }

    @Test
    public void daysFromIndependenceDayToNewYear() {
        Date independenceDay = new Date();
        independenceDay.setDay(6);
        independenceDay.setMonth(12);

        assertEquals(26, dlt.daysToNextMonth(independenceDay));
    }
    
    
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
