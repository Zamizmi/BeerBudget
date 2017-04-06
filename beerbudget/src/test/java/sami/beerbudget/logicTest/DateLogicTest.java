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
        assertEquals(3, DateLogic.daysToNextFirstOfMay(threeDaysBeforeFOM));
    }

    @Test
    public void daysFrom2ndOfMay() {
        fom.setDay(2);
        fom.setMonth(5);
        fom.setYear(2017);
        assertEquals(364, DateLogic.daysToNextFirstOfMay(fom));
    }

    @Test
    public void daysFrom1stOfMay() {
        assertEquals(0, DateLogic.daysToNextFirstOfMay(fom));
    }

    @Test
    public void daysFromNewYear() {
        Date newYear = new Date();
        assertEquals(120, DateLogic.daysToNextFirstOfMay(newYear));
    }

    @Test
    public void daysFromIndependenceDay() {
        Date independenceDay = new Date();
        independenceDay.setDay(6);
        independenceDay.setMonth(12);

        assertEquals(146, DateLogic.daysToNextFirstOfMay(independenceDay));
    }

    @Test
    public void daysToFebFromNewYear() {
        Date newYear = new Date();
        assertEquals(31, DateLogic.daysToNextMonth(newYear));
    }

    @Test
    public void daysFromIndependenceDayToNewYear() {
        Date independenceDay = new Date();
        independenceDay.setDay(6);
        independenceDay.setMonth(12);

        assertEquals(26, DateLogic.daysToNextMonth(independenceDay));
    }

    @Test
    public void daysInYearIsCorrectWhenLeapYear() {
        Date leapYear = new Date();
        leapYear.setYear(2000);
        assertEquals(366, DateLogic.daysInYear(leapYear));
    }

    @Test
    public void daysInYearIsCorrectWhenNotLeapYear() {
        Date notLeapYear = new Date();
        notLeapYear.setYear(2100);
        assertEquals(365, DateLogic.daysInYear(notLeapYear));
    }

    @Test
    public void iteratorDateMakesNoChangesToOriginal() {
        Date iteratorDate = DateLogic.iteratorDate(fom);
        String fomString = fom.toString();
        iteratorDate.turnDay();
        iteratorDate.turnDay();
        assertEquals(3, iteratorDate.getDay());
        iteratorDate.setMonth(6);
        assertEquals(6, iteratorDate.getMonth());
        iteratorDate.setYear(2020);
        assertEquals(2020, iteratorDate.getYear());
        assertEquals(fomString, fom.toString());
    }

    @Test
    public void daysToNextYearFromFirstOfMay() {
        assertEquals(245, DateLogic.daysToNextYear(fom));
    }

    @Test
    public void daysToNextYearFromNewYearsEve() {
        Date newYearsEve = new Date();
        newYearsEve.setMonth(12);
        newYearsEve.setDay(31);
        assertEquals(1, DateLogic.daysToNextYear(newYearsEve));
    }

    @Test
    public void daysToNextYearFromNewYear() {
        Date newYear = new Date();
        assertEquals(365, DateLogic.daysToNextYear(newYear));
    }

    @Test
    public void stringIsCreatedFromProperInput() {

    }

    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
