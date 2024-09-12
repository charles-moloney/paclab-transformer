import gov.nasa.jpf.symbc.Debug;
import java.util.ArrayList;
import java.util.Scanner;
public class Proba3 {
    private static void addVertex() {
        int numberVertex = Debug.makeSymbolicInteger("x2");
		int FatherVertex = Debug.makeSymbolicInteger("x0");
        if (FatherVertex < Debug.makeSymbolicInteger("x1")) {
            numberVertex++;
        } else if (FatherVertex == 0) {
          numberVertex++;
        } else{
        }
     }
     
     private static void deleteVertex(int deleteNumber) {
        if (Debug.makeSymbolicInteger("x0") == 3) {
        } else if (Debug.makeSymbolicInteger("x1") > 3) {
                for (int i = 3; i < Debug.makeSymbolicInteger("x2");) {
                }
        } else {
        }
     }
     
     private static void metodDelete (int delete)   {
        int numberVertex = Debug.makeSymbolicInteger("x0");
		numberVertex--;
        for (int a = 0; a < Debug.makeSymbolicInteger("x1") ; a++) {
            for (int b = 1; b < Debug.makeSymbolicInteger("x2"); b++) {
                if (Debug.makeSymbolicInteger("x3") > delete) {
                    int z = Debug.makeSymbolicInteger("x4");
                    z--;
                } else if (Debug.makeSymbolicInteger("x5") == delete) {
                    b--;
                } else {
                        
                }
            }
        }
     }
     
   private static void printTree() {
        for (int i = 0; i < Debug.makeSymbolicInteger("x0"); i++) {
        }
    }
    
    private static void printVertex() {
        int printNumber = Debug.makeSymbolicInteger("x0");
        if (printNumber <= Debug.makeSymbolicInteger("x1")) {
        } else {
        }
    }
    
    private static void rR () {
        int newRoot = Debug.makeSymbolicInteger("x0");
        for (int a = 0; a < Debug.makeSymbolicInteger("x1"); a++) {
            for (int c = 3; c < Debug.makeSymbolicInteger("x2"); c++) {
                if (Debug.makeSymbolicInteger("x3") == newRoot) {
                } else {                  
                }
            }
            for (int b = 1; b < Debug.makeSymbolicInteger("x4"); b++) {
                if (newRoot > Debug.makeSymbolicInteger("x5")) {
                    int z = Debug.makeSymbolicInteger("x6");
                    z++;
                }else {
                }
            }
        }
        for (int a = 0, b = 2; a < Debug.makeSymbolicInteger("x7"); a++) {
             if (Debug.makeSymbolicInteger("x8") == newRoot) {
             } else {
             }
        }
    }
    private static void test () {
      int i = Debug.makeSymbolicInteger("x0");
      int a = Debug.makeSymbolicInteger("x1");  
    }
}    
