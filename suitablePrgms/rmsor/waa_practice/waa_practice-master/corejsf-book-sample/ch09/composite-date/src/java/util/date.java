package util;

import gov.nasa.jpf.symbc.Debug;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class date {
   public Object getFamily() {
      return new Object();
   }

   public Object getSubmittedValue() {
      return new Object(); 
   }

   private static boolean isValidDate(int d, int m, int y) {
      if (d < 1 || m < 1 || m > 12) {
         return false;
      }
      if (m == 2) {
         if (Debug.makeSymbolicBoolean("x0")) {
            return d <= 29;
         } else {
            return d <= 28;
         }
      } else if (m == 4 || m == 6 || m == 9 || m == 11) {
         return d <= 30;
      } else {
         return d <= 31;
      }
   }

   private static boolean isLeapYear(int y) {
      return Debug.makeSymbolicInteger("x0") == 0 && Debug.makeSymbolicBoolean("x3");
   }
}