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
import sami.beerbudget.logic.Date;
import static org.junit.Assert.*;

/**
 *
 * @author saklindq
 */
public class DateTest {

    Date newYear = new Date();
    Date firstOfApril = new Date();
    Date leapYear = new Date();

    public DateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        firstOfApril.setDay(1);
        firstOfApril.setMonth(4);
        firstOfApril.setYear(2017);
        leapYear.setDay(27);
        leapYear.setMonth(2);
        leapYear.setYear(2000);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void dateIsSetUpCorrectlyTop() {
        newYear.setDay(31);
        newYear.setMonth(12);
        newYear.setYear(2019);

        assertEquals("31-12-2019", newYear.toString());
    }

    @Test
    public void dateIsSetUpCorrectlyLow() {
        firstOfApril.setDay(1);
        firstOfApril.setMonth(1);
        firstOfApril.setYear(2017);

        assertEquals("1-1-2017", firstOfApril.toString());
    }

    @Test
    public void dayGrowsCorrectly() {
        newYear.turnDay();
        assertEquals(2, newYear.getDay());
    }

    @Test
    public void dayChangesToOneAfter30() {
        Date lastOfApril = new Date();
        lastOfApril.setDay(30);
        lastOfApril.setMonth(4);
        lastOfApril.setYear(2017);
        lastOfApril.turnDay();

        assertEquals(1, lastOfApril.getDay());
    }

    @Test
    public void monthGrowsByOneCorrectly() {
        Date lastOfApril = new Date();
        lastOfApril.setDay(30);
        lastOfApril.setMonth(4);
        lastOfApril.setYear(2017);
        lastOfApril.turnDay();

        assertEquals(5, lastOfApril.getMonth());
    }

    @Test
    public void yearGrowsByOneAfterMonth12() {
        Date newYearsEwe = new Date();
        newYearsEwe.setDay(31);
        newYearsEwe.setMonth(12);
        newYearsEwe.setYear(2017);
        newYearsEwe.turnDay();

        assertEquals(1, newYearsEwe.getMonth());
        assertEquals(2018, newYearsEwe.getYear());
    }

    @Test
    public void daySetterValidatesTooBIgDates() {
        //default 1.1.2017
        newYear.setDay(38);
        assertEquals(1, newYear.getDay());
    }

    @Test
    public void daySetterValidatesTooSmallDates() {
        //default 1.1.2017
        newYear.setDay(0);
        assertEquals(1, newYear.getDay());
    }

    @Test
    public void monthSetterValidatesTooBigMonths() {
        //default 1.1.2017
        newYear.setMonth(13);
        assertEquals(1, newYear.getMonth());
    }

    @Test
    public void daySetterValidatesBoundary() {
        //default 1.1.2017
        newYear.setMonth(4);
        newYear.setDay(31);
        assertEquals(1, newYear.getDay());
    }

    @Test
    public void daySetterWorks() {
        newYear.setDay(5);
        assertEquals(5, newYear.getDay());
    }

    @Test
    public void daySetterValidatesBoundaryLow() {
        //default 1.1.2017
        newYear.setDay(0);
        assertEquals(1, newYear.getDay());
    }

    @Test
    public void monthSetterValidatesTooSmallMonths() {
        //default 1.1.2017
        newYear.setMonth(0);
        assertEquals(1, newYear.getMonth());
    }

    @Test
    public void monthLengthAt30() {
        newYear.setMonth(4);
        assertEquals(30, newYear.monthLength());
    }

    @Test
    public void leapYearIsCorrect() {
        assertEquals(29, leapYear.monthLength());
    }

    @Test
    public void notLeapYearIsCorrectIf100() {
        leapYear.setYear(1900);
        assertEquals(28, leapYear.monthLength());
    }

    @Test
    public void notLeapYearIsCorrect() {
        leapYear.setYear(2001);
        assertEquals(28, leapYear.monthLength());
    }
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
