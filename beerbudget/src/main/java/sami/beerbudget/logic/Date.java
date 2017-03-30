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
public class Date {

    private int day;
    private int month;
    private int year;

    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2017;
    }

    public void setDay(int day) {
        if (day <= monthLength() && day >= 1) {
            this.day = day;
        }
    }

    public void setMonth(int month) {
        if (month <= 12 && month >= 1) {
            this.month = month;
        }
    }

    public void setYear(int year) {
        this.year = year;
    }

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
            }
            return 28;
        }
        return 30;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void turnDay() {
        if (this.day >= monthLength()) {
            this.day = 1;
            turnMonth();
        } else {
            this.day++;
        }
    }

    public void turnMonth() {
        if (this.month >= 12) {
            this.month = 1;
            turnYear();
        } else {
            this.month++;
        }
    }

    public void turnYear() {
        this.year++;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

}
