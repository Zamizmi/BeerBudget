/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.logic;

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
        if (day <= 31 && day >= 1) {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.day;
        hash = 47 * hash + this.month;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Date other = (Date) obj;
        return this.day == other.day;
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

    public void nextDay() {
        this.day++;
    }

    public void turnDay() {
        if (this.day > 30) {
            this.day = 1;
            turnMonth();
        }
    }

    public void turnMonth() {
        if (this.month > 11) {
            this.month = 1;
            turnYear();
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
