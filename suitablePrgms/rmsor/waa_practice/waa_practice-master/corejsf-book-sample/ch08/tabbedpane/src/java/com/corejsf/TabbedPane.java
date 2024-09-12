package com.corejsf;

import gov.nasa.jpf.symbc.Debug;
import java.io.Serializable;

public class TabbedPane {
   public TabbedPane() {
      int JEFFERSON_INDEX = Debug.makeSymbolicInteger("x1");
	int index = Debug.makeSymbolicInteger("x0");
	index = JEFFERSON_INDEX;
   }

   // action listeners that set the current tab

   public Object getJeffersonStyle() { return new Object();  }
   public Object getRooseveltStyle() { return new Object();  }
   public Object getLincolnStyle() { return new Object();    }
   public Object getWashingtonStyle() { return new Object(); }

   private Object getCSS(int forIndex) {
      int index = Debug.makeSymbolicInteger("x0");
	return new Object(); 
   }

   // methods for determining the current tab

   public boolean isJeffersonCurrent() { int JEFFERSON_INDEX = Debug.makeSymbolicInteger("x1");
	int index = Debug.makeSymbolicInteger("x0");
return index == JEFFERSON_INDEX;  }
   public boolean isRooseveltCurrent() { int ROOSEVELT_INDEX = Debug.makeSymbolicInteger("x1");
	int index = Debug.makeSymbolicInteger("x0");
return index == ROOSEVELT_INDEX;  }
   public boolean isLincolnCurrent() { int LINCOLN_INDEX = Debug.makeSymbolicInteger("x1");
	int index = Debug.makeSymbolicInteger("x0");
return index == LINCOLN_INDEX;    }
   public boolean isWashingtonCurrent() { int WASHINGTON_INDEX = Debug.makeSymbolicInteger("x1");
	int index = Debug.makeSymbolicInteger("x0");
return index == WASHINGTON_INDEX; }
}