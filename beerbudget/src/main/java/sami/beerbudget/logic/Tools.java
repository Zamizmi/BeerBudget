/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.logic;

import java.util.regex.Pattern;

/**
 * Manipulates input and helps in all kinds of places.
 *
 * @author saklindq
 */
public class Tools {

    /**
     * Checks if input can be parse into Double.
     *
     * @param input String to test
     * @return true if can be turned to double.
     */
    public static boolean isStringToDouble(String input) {
        Pattern digits = Pattern.compile("[0-9]+.[0-9]+");
        return digits.matcher(input).matches();
    }

    /**
     * Checks if input is non-negative and parseable to double.
     *
     * @param input String to test.
     * @return true if it is.
     */
    public static boolean inputIsNonNegativeDouble(String input) {
        if (isStringToDouble(input)) {
            if (Double.parseDouble(input) >= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the input is parseable to positive double.
     *
     * @param input string to get tested.
     * @return boolean, true if succeeded.
     */
    public static boolean inputIsPositiveDouble(String input) {
        if (inputIsNonNegativeDouble(input)) {
            if (Double.parseDouble(input) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Turns input string to double or 0.
     *
     * @param input string to be parsed to double.
     * @return double or 0.
     */
    public static Double stringToDouble(String input) {
        if (isStringToDouble(input)) {
            return Double.parseDouble(input);
        }
        return 0.0;
    }

    /**
     * Turns string to non-negative double or 0.
     *
     * @param input string to be turned.
     * @return double or 0.
     */
    public static Double inputToDoubleNonNegative(String input) {
        if (isStringToDouble(input)) {
            Double toReturn = Double.parseDouble(input);
            if (toReturn >= 0) {
                return toReturn;
            }
        }
        return 0.0;
    }
}
