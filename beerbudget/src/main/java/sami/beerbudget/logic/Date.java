/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.logic;

/**
 *Date object. Made completely on my own. Took a lot of time.
 * @author saklindq
 */
public class Date {

    private int day;
    private int month;
    private int year;

    /**
     * Constructor.
     */
    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2017;
    }
    
    /**
     * Setter.
     * @param day as int. 
     */
    public void setDay(int day) {
        if (day <= monthLength() && day >= 1) {
            this.day = day;
        }
    }

    /**
     * Setter.
     * @param month as int.
     */
    public void setMonth(int month) {
        if (month <= 12 && month >= 1) {
            this.month = month;
        }
    }

    /**
     * Setter.
     * @param year as int.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns the length of the current month. Calculates every months length
     * individually. Therefore looks a bit horrific.
     * @return integer of the length of the month.
     */
    public int monthLength() {
        if (this.month == 1 | this.month == 3 | this.month == 5 | this.month == 7 | this.month == 8 | this.month == 10 | this.month == 12) {
            return 31;
        } else if (this.month == 2) {
            if (this.year % 4 == 0) {
                if (this.year % 100 == 0) {
                    if (this.year % 400 == 0) {
                        return 29;
                    }
                    return 28;
                }
                return 29;
            }
            return 28;
        }
        return 30;
    }
    
    /**
     * Getter.
     * @return year. 
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter.
     * @return month. 
     */
    public int getMonth() {
        return month;
    }

    /**
     * Getter.
     * @return day. 
     */
    public int getDay() {
        return day;
    }

    /**
     * Turns day by one and checks if month/year needs turning.
     */
    public void turnDay() {
        if (this.day >= monthLength()) {
            this.day = 1;
            turnMonth();
        } else {
            this.day++;
        }
    }

    /**
     * Turns month by one and checks if year needs turning.
     */
    public void turnMonth() {
        if (this.month >= 12) {
            this.month = 1;
            turnYear();
        } else {
            this.month++;
        }
    }

    /**
     * Grows the year by one.
     */
    public void turnYear() {
        this.year++;
    }

    /**
     * Gives dd.-m-yyyy presentation of the date.
     * @return String dd-mm-yyyy
     */
    @Override
    public String toString() {
        return this.day + "-" + this.month + "-" + this.year;
    }

}
