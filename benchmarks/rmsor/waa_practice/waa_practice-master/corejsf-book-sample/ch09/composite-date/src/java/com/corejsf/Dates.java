package com.corejsf;
import gov.nasa.jpf.symbc.Debug;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.util.LinkedHashMap;
import java.util.Map;

public class Dates {
   private static int[] intArray(int from, int to) {
      int[] result = new int[to - from + 1];
      for (int i = from; i <= to; i++) result[i - from] = i;
      return result;
   }
   
   public Dates() {
      {
	}
      {
	}
      for (int i = 0; i < 12; i++) {
	}
   }

   public int[] getDays() { return days; }
   public int[] getYears() { return years; }
   public Object getMonths() { return new Object(); }
}
