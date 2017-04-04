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

    public static Date iteratorDate(Date date) {
        Date iteratorDate = new Date();
        iteratorDate.setDay(date.getDay());
        iteratorDate.setMonth(date.getMonth());
        iteratorDate.setYear(date.getYear());
        return iteratorDate;
    }

    public static Date stringToDate(String dateString) {
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
