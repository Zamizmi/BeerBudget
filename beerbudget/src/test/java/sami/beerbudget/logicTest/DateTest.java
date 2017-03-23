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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void dateIsSetUpCorrectly() {
        Date firstOfApril = new Date();
        firstOfApril.setDay(1);
        firstOfApril.setMonth(4);
        firstOfApril.setYear(2017);

        assertEquals("1.4.2017", firstOfApril.toString());
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
    public void monthGrowsByOneAfter30() {
        Date lastOfApril = new Date();
        lastOfApril.setDay(30);
        lastOfApril.setMonth(4);
        lastOfApril.setYear(2017);
        lastOfApril.turnDay();

        assertEquals(5, lastOfApril.getMonth());
    }

    @Test
    public void yearGrowsByOneAfterMonth12() {
        Date lastOfApril = new Date();
        lastOfApril.setDay(30);
        lastOfApril.setMonth(12);
        lastOfApril.setYear(2017);
        lastOfApril.turnDay();

        assertEquals(1, lastOfApril.getMonth());
        assertEquals(2018, lastOfApril.getYear());
    }

    @Test
    public void daySetterValidates() {
        //default 1.1.2017
        Date newYear = new Date();
        newYear.setDay(31);
        assertEquals(1, newYear.getDay());
    }

    @Test
    public void monthSetterValidates() {
        //default 1.1.2017
        Date newYear = new Date();
        newYear.setMonth(13);
        assertEquals(1, newYear.getMonth());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
