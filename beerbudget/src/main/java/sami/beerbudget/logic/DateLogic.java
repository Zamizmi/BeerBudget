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

    public int daysToNextMonth(Date date) {
        int startMonth = date.getMonth();
        int toReturn = 0;
        while (date.getMonth() == startMonth) {
            date.turnDay();
            toReturn++;
        }
        return toReturn;
    }

    public int daysToNextFirstOfMay(Date date) {
        if (date.getDay() == 1 && date.getMonth() == 5) {
            return 0;
        }
        Date iteratorDate = date;
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

}
