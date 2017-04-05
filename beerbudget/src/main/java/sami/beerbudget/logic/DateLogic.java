/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.logic;

/**
 *
 * @author saklindq
 */
public class DateLogic {

    //TODO
    /**
     * Returns length of the given year at the date.
     *
     * @param date which years length is wanted.
     * @return integer the length of the year.
     */
    public static int DaysInYear(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DateLogic() {

    }

    /**
     * Returns amount of days to next month. Creates an iterator date to ensure
     * integrity of the original date. Calls turnDay until month has changed.
     * Validates possible lengths of leap years etc.
     *
     * @param date days calculated from.
     * @return integer, days to next month.
     */
    public static int daysToNextMonth(Date date) {
        Date iterator = iteratorDate(date);
        int startMonth = iterator.getMonth();
        int toReturn = 0;
        while (iterator.getMonth() == startMonth) {
            iterator.turnDay();
            toReturn++;
        }
        return toReturn;
    }

    /**
     * Returns amount of days to next year. Creates an iterator date to ensure
     * integrity of the original date. Calls turnDay until year has changed.
     * Validates possible lengths of leap years etc.
     *
     * @param date days calculated from.
     * @return integer, days to next year.
     */
    public static int daysToNextYear(Date date) {
        Date iterator = iteratorDate(date);
        int startYear = iterator.getYear();
        int toReturn = 0;
        while (iterator.getYear() == startYear) {
            iterator.turnDay();
            toReturn++;
        }
        return toReturn;
    }

    /**
     * Returns amount of days to next First of May. Creates an iteratorDate to
     * ensure integrity of original Date. Validates possible lengths of leap
     * years etc.
     *
     * @param date to count from.
     * @return Integer, days to next First of May.
     */
    public static int daysToNextFirstOfMay(Date date) {
        if (date.getDay() == 1 && date.getMonth() == 5) {
            return 0;
        }
        Date iteratorDate = iteratorDate(date);
        int toReturn = 0;
        int startYear = iteratorDate.getYear();
        if (iteratorDate.getMonth() >= 5) {
            int targetYear = startYear++;
            while (iteratorDate.getYear() == targetYear) {
                iteratorDate.turnDay();
                toReturn++;
            }
        }
        while (iteratorDate.getMonth() != 5 || iteratorDate.getDay() != 1) {
            iteratorDate.turnDay();
            toReturn++;
        }
        return toReturn;
    }

    /**
     * Returns an iterator copy of the given date.
     *
     * @param date to make the copy from.
     * @return Date, copy of the input Date.
     */
    public static Date iteratorDate(Date date) {
        Date iteratorDate = new Date();
        iteratorDate.setDay(date.getDay());
        iteratorDate.setMonth(date.getMonth());
        iteratorDate.setYear(date.getYear());
        return iteratorDate;
    }

    //TODO: more validations, ex. dd.mm.yyyy
    /**
     * Turns correct String input to Date.
     *
     * @param dateString String in format dd-mm-yyyy.
     * @return Date from the input.
     */
    public static Date stringToDate(String dateString) {
        //takes the input in dd-mm-yyyy format
        String[] split = dateString.split("-");
        int day = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int year = Integer.parseInt(split[2]);
        Date toReturn = new Date();
        toReturn.setDay(day);
        toReturn.setMonth(month);
        toReturn.setYear(year);
        return toReturn;
    }
}
