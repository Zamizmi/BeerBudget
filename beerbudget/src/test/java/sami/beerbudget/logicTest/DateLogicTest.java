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
        String okDate = "05-02-2015";
        assertEquals("5-2-2015", DateLogic.stringToDate(okDate).toString());
    }

    @Test
    public void firstOfJanIsCreatedFromBadInput() {
        String badDate = "05-a0asd2-2aks015";
        assertEquals("1-1-2017", DateLogic.stringToDate(badDate).toString());
    }

    @Test
    public void lengthOfMonthIsOK() {
        Date halfWayMay = new Date();
        halfWayMay.setDay(15);
        halfWayMay.setMonth(5);
        assertEquals(31, DateLogic.lengthOfMonth(halfWayMay));
    }

    @Test
    public void getSameDayNextMonth() {
        Date lastOfFeb = new Date();
        lastOfFeb.setMonth(2);
        lastOfFeb.setDay(DateLogic.lengthOfMonth(lastOfFeb));
        assertEquals("31-3-2017", DateLogic.getSameDayNextMonth(lastOfFeb).toString());
    }

    @Test
    public void getSameDayNextMonthLeapYear() {
        Date lastOfFeb = new Date();
        lastOfFeb.setYear(2016);
        lastOfFeb.setMonth(2);
        lastOfFeb.setDay(DateLogic.lengthOfMonth(lastOfFeb));
        assertEquals("31-3-2016", DateLogic.getSameDayNextMonth(lastOfFeb).toString());
    }

    @Test
    public void getSameDayNextMonthFromJanLast() {
        Date lastOfJan = new Date();
        lastOfJan.setDay(DateLogic.lengthOfMonth(lastOfJan));
        assertEquals("28-2-2017", DateLogic.getSameDayNextMonth(lastOfJan).toString());
    }

    @Test
    public void isNotTheLastDayOfMonth() {
        assertFalse(DateLogic.isTheLastDayOfMonth(new Date()));
    }

    @Test
    public void isTheLastDayOfMonth() {
        Date lastJan = new Date();
        lastJan.setDay(31);
        assertTrue(DateLogic.isTheLastDayOfMonth(lastJan));
    }

    @Test
    public void firstDateIsBeforeSecondDate() {
        Date first = new Date();
        first.setYear(25); //1-1-25
        Date second = new Date();
        second.setMonth(2); //1-2-2017
        assertTrue(DateLogic.firstDateIsBeforeSecondDate(first, second));
    }

    @Test
    public void firstDateIsNotBeforeSecondDate() {
        Date first = new Date();
        first.setYear(2500); //1-1-2500
        Date second = new Date();
        second.setMonth(2); //1-2-2017
        assertFalse(DateLogic.firstDateIsBeforeSecondDate(first, second));
    }

    @Test
    public void firstDateIsEqualToSecondDate() {
        Date first = new Date();
        Date second = new Date();
        assertTrue(DateLogic.firstDateIsBeforeSecondDateOrEqual(first, second));
    }

    @Test
    public void secondYearGreater() {
        Date first = new Date();
        Date second = new Date();
        second.setYear(2018);
        assertTrue(DateLogic.firstDateIsBeforeSecondDate(first, second));
    }
}
