/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.logic;

/**
 * Static class. Manipulates date-objects.
 *
 * @author saklindq
 */
public class DateLogic {

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
     * Returns the length of the month of input date.
     *
     * @param date input.
     * @return integer as the length of the month.
     */
    public static int lengthOfMonth(Date date) {
        Date iteratorDate = iteratorDate(date);
        iteratorDate.setDay(1);
        return (daysToNextMonth(iteratorDate));
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

    /**
     * Turns correct String input to Date.
     *
     * @param dateString String in format dd-mm-yyyy
     * @return Date from the input.
     */
    public static Date stringToDate(String dateString) {
        try {
            String[] split = dateString.split("-");
            int day = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);
            int year = Integer.parseInt(split[2]);
            Date toReturn = new Date();
            toReturn.setDay(day);
            toReturn.setMonth(month);
            toReturn.setYear(year);
            return toReturn;

        } catch (NumberFormatException e) {
        }
        return new Date();
    }

    /**
     * Returns date but after one month. Notices different lengths of months.
     *
     * @param startDate date to start from.
     * @return new Date.
     */
    public static Date getSameDayNextMonth(Date startDate) {
        Date iteratorDate = iteratorDate(startDate);
        iteratorDate.turnMonth();
        if (startDate.getDay() >= iteratorDate.monthLength() || isTheLastDayOfMonth(startDate)) {
            iteratorDate.setDay(iteratorDate.monthLength());
        }
        return iteratorDate;
    }

    /**
     * Returns true if the date is the last day of the month.
     *
     * @param date to get checked.
     * @return true if is the last day.
     */
    public static boolean isTheLastDayOfMonth(Date date) {
        return date.getDay() == date.monthLength();
    }

    /**
     * Compares to dates and returns true if the first param is before second.
     *
     * @param first Date
     * @param second Date
     * @return true if first is earlier than second.
     */
    public static boolean firstDateIsBeforeSecondDateOrEqual(Date first, Date second) {
        if (second.getYear() < first.getYear()) {
            return false;
        }
        if (second.getMonth() < first.getMonth()) {
            return false;
        }
        if (second.getDay() < first.getDay()) {
            return false;
        }
        return true;
    }

    /**
     * Compares two dates, and returns true if first is earlier.
     *
     * @param first date.
     * @param second date.
     * @return boolean.
     */
    public static boolean firstDateIsBeforeSecondDate(Date first, Date second) {
        if (first.getYear() < second.getYear()) {
            return true;
        }
        if (second.getYear() >= first.getYear()) {
            if (second.getMonth() <= first.getMonth()) {
                if (second.getYear() <= first.getYear()) {
                    return false;
                }
                return false;
            }
            return true;
        }
        return false;
    }

}
