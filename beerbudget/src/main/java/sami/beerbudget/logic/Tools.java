/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.logic;

import java.util.regex.Pattern;

/**
 *
 * @author saklindq
 */
public class Tools {

    public static boolean isStringToDouble(String input) {
        Pattern digits = Pattern.compile("[0-9]+.[0-9]+");
        return digits.matcher(input).matches();
    }

    public static boolean isStringToOnlyNotNegativeDouble(String input) {
        if (isStringToDouble(input)) {
            if (Double.parseDouble(input) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static Double stringToDouble(String input) {
        if (isStringToDouble(input)) {
            return Double.parseDouble(input);
        }
        return 0.0;
    }

    public static Double stringToNotNegativeDouble(String input) {
        if (isStringToDouble(input)) {
            Double toReturn = Double.parseDouble(input);
            if (toReturn >= 0) {
                return toReturn;
            }
        }
        return 0.0;
    }

}
