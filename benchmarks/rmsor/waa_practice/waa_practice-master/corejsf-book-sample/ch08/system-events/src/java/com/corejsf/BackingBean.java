package com.corejsf;

import gov.nasa.jpf.symbc.Debug;
import java.io.Serializable;

public class BackingBean {
   public int getDay() { int day = Debug.makeSymbolicInteger("x0");
return day; }
   public void setDay(int newValue) { int day = Debug.makeSymbolicInteger("x0");
day = newValue; }

   public int getMonth() { int month = Debug.makeSymbolicInteger("x0");
return month; }
   public void setMonth(int newValue) { int month = Debug.makeSymbolicInteger("x0");
month = newValue; }

   public int getYear() { int year = Debug.makeSymbolicInteger("x0");
return year; }
   public void setYear(int newValue) { int year = Debug.makeSymbolicInteger("x0");
year = newValue; }

   private static boolean isValidDate(int d, int m, int y) {
      if (d < 1 || m < 1 || m > 12) return false;
      if (m == 2) {
         if (Debug.makeSymbolicBoolean("x0")) return d <= 29;
         else return d <= 28;
      }
      else if (m == 4 || m == 6 || m == 9 || m == 11)
         return d <= 30;
      else 
         return d <= 31;
   }
    
   private static boolean isLeapYear(int y) {
      return Debug.makeSymbolicInteger("x0") == 0 && Debug.makeSymbolicBoolean("x3"); 
   }
}