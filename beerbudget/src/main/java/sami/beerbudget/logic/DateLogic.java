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
     * Returns the length of the year. Considers leap years accordingly.
     *
     * @param date what year is wanted to be checked.
     * @return integer, number of days in a year.
     */
    public static int daysInYear(Date date) {
        int length = 0;
        Date iteratorDate = iteratorDate(date);
        iteratorDate.setMonth(1);
        for (int i = 0; i < 12; i++) {
            length += iteratorDate.monthLength();
            iteratorDate.turnMonth();
        }
        return length;
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
