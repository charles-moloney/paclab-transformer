package com.corejsf;

import gov.nasa.jpf.symbc.Debug;
import java.io.IOException;
import java.util.Map;

public class UISpinner {
   public UISpinner() {
   }

   private int getIncrementedValue(int submittedValue, int increment) {
      int newValue = submittedValue + increment;

      if (Debug.makeSymbolicBoolean("x4"))
         return newValue;
      else
         return submittedValue;
   }
}
