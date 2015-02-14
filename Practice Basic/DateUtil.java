/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author StaroMoon
 */
/* Utilities for Date Manipulation */
public class DateUtil {
    
    // Month's name - for printing
    public static String strMonths[] 
        = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
           "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public static String[] calendarDays 
        = { "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday" };
    
    // Number of days in each month (for non-leap years)
    public static int daysInMonths[]
       = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Returns true if the given year is a leap year
    public static boolean isLeapYear(int year){
        if((year % 4 == 0 ^ year % 100 == 0) || year % 400 == 0){
            return true;
        }else{
            return false;
        }
    }

    // Return true if the given year, month, day is a valid date
    // year : 1-9999
    // month: 1(Jan)-12(Dec)
    // day: 1-28|29|30|31. The last day depends on year and month
    public static boolean isValidDate(int year, int month, int day){
        if(year >= 1 && year <= 9999){
            switch(month){
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    if(day >= 1 && day <= 31) return true;
                case 4: case 6: case 9: case 11:
                    if(day >= 1 && day <= 30) return true;
                case 2:
                    if(isLeapYear(year)){
                        if(day >= 1 && day <= 29) return true;
                    }else{
                        if(day >= 1 && day <= 28) return true;
                    }
            }
        }
        return false;
    }

    // Return the day of the week, 0:Sun, 1:Mon, ..., 6:Sat
    public static int getDayOfWeek(int year, int month, int day){
        int sumday = 0; //sum to calculate day
        int numyear = 0; // number for year
        int nummonth = 0; // number for month
        int l2digit = year % 100;
        if(isValidDate(year,month,day)){
            switch((year / 100) % 4){
                case 0: numyear = 6; break;
                case 1: numyear = 4; break;
                case 2: numyear = 2; break;
                case 3: numyear = 0; break;
            }
            if(isLeapYear(year)){
                switch(month){
                    case 1: case 4: case 7: nummonth = 6; break;
                    case 2: case 8:         nummonth = 2; break;
                    case 3: case 11:        nummonth = 3; break;
                    case 5:                 nummonth = 1; break;
                    case 6:                 nummonth = 4; break;
                    case 9: case 12:        nummonth = 5; break;
                    case 10:                nummonth = 0; break;
                }
            }else{
                switch(month){
                    case 1: case 10:        nummonth = 0; break;
                    case 4: case 7:         nummonth = 6; break;
                    case 8:                 nummonth = 2; break;
                    case 2: case 3: case 11:nummonth = 3; break;
                    case 5:                 nummonth = 1; break;
                    case 6:                 nummonth = 4; break;
                    case 9: case 12:        nummonth = 5; break;
                }
            }
            sumday = (numyear + l2digit + (l2digit/4) + nummonth + day) % 7;
            return sumday;
        }else{
            return 61654;
        }
    }

    // Return String "xxxday d mmm yyyy" (e.g., Wednesday 29 Feb 2012)
    public static String printDate(int year, int month, int day){
        String date = calendarDays[getDayOfWeek(year, month, day)] + " " + 
            String.valueOf(day) + " " + strMonths[month-1] + " " + String.valueOf(year);
        return date;
    }
   
    public static void main(String[] args){
        System.out.println(isLeapYear(1900));  // false
        System.out.println(isLeapYear(2000));  // true
        System.out.println(isLeapYear(2011));  // false
        System.out.println(isLeapYear(2012));  // true

        System.out.println(isValidDate(2012, 2, 29));  // true
        System.out.println(isValidDate(2011, 2, 29));  // false
        System.out.println(isValidDate(2099, 12, 31)); // true
        System.out.println(isValidDate(2099, 12, 32)); // false

        System.out.println(getDayOfWeek(1982, 4, 24));  // 6:Sat
        System.out.println(getDayOfWeek(2000, 1, 1));   // 6:Sat
        System.out.println(getDayOfWeek(2054, 6, 19));  // 5:Fri
        System.out.println(getDayOfWeek(2012, 2, 14));  // 5:Fri

        System.out.println(printDate(2054, 6, 19)); // Tuesday 14 Feb 2012
    }
}
