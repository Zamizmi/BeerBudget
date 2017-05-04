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
import sami.beerbudget.logic.Tools;

/**
 *
 * @author saklindq
 */
public class ToolsTest {

    public ToolsTest() {
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
    public void isStringToDouble() {
        String isOK = "123.5";
        assertEquals(123.5, Tools.stringToDouble(isOK), .1);
    }

    @Test
    public void isNotStringToDouble() {
        String isOK = "12asd3.5";
        assertEquals(0.0, Tools.stringToDouble(isOK), .1);
    }

    @Test
    public void isStringToOnlyNotNegativeDouble() {
        assertTrue(Tools.inputIsNonNegativeDouble("666"));
    }

    @Test
    public void isStringToOnlyNotNegativeDoubleAndZero() {
        assertTrue(Tools.inputIsNonNegativeDouble("0.0"));
    }

    @Test
    public void stringIsNegativeAndShouldNotBe() {
        assertFalse(Tools.inputIsNonNegativeDouble("-5.0"));
    }

    @Test
    public void stringIsZeroAndShouldNotBe() {
        assertFalse(Tools.inputIsPositiveDouble("0.0"));
    }

    @Test
    public void stringIsPositive() {
        assertTrue(Tools.inputIsPositiveDouble("5.0"));
    }
    
    @Test
    public void inputToDoubleNonNegative() {
        String ok = "123.4";
        assertEquals(123.4,Tools.inputToDoubleNonNegative(ok),0.0);
    }
    
    @Test
    public void inputToDoubleNonNegativeZero() {
        String ok = "0.0";
        assertEquals(0.0,Tools.inputToDoubleNonNegative(ok),0.0);
    }
    
    @Test
    public void inputToDoubleNonNegativeTakesNoNegatives() {
        String ok = "-50.0";
        assertEquals(0.0,Tools.inputToDoubleNonNegative(ok),0.0);
    }
}
