import gov.nasa.jpf.symbc.Debug;
import java.util.ArrayList;
import java.util.Scanner;



        
        
// the Invoker class
 class Invoker {
    public void addVertex() {
    }
    public void deleteVertex(int deleteNumber) {
    }
    public void printTree() {
    }
    public void printVertex() { 
    }
    public void aR() {
    }
        
}
// Receiver 

 class Receiver {
    public Receiver() { }
    
    public void addVertex () {
        int FatherVertex = Debug.makeSymbolicInteger("x0");
        if (FatherVertex < Debug.makeSymbolicInteger("x1")) {
        } else if (FatherVertex == 0) {
        } else{
        }
    }
    
    public void printTree() {
        for (int i = 0; i < Debug.makeSymbolicInteger("x0"); i++) {
        }
        
    }
    public void printVertex() {
        int printNumber = Debug.makeSymbolicInteger("x0");
        if (printNumber <= Debug.makeSymbolicInteger("x1")) {
        } else {
        }
   }
    public void aR() {
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
    
    public void deleteVertex (int deleteNumber) {
       
      if (Debug.makeSymbolicInteger("x0") == 3) {
      } else if (Debug.makeSymbolicInteger("x1") > 3) {
                for (int i = 3; i < Debug.makeSymbolicInteger("x2");) {
                }
      } else {
      }
    }
     
     private static void methodDelete (int delete)   {
        for (int a = 0; a < Debug.makeSymbolicInteger("x0") ; a++) {
            for (int b = 1; b < Debug.makeSymbolicInteger("x1"); b++) {
                if (Debug.makeSymbolicInteger("x2") > delete) {
                    int z = Debug.makeSymbolicInteger("x3");
                    z--;
                } else if (Debug.makeSymbolicInteger("x4") == delete) {
                    b--;
                } else {
                        
                }
            }
        }
     }
}

//Command for aR
class ARCommand {
    public void execute () {
   }
}
//Command for printVertex
class PrintVertexCommand {
    public void execute() {
    }
}
//Command for PrintTree
class PrintTreeCommand {
    public void execute() {
    }
}
//Command for add vertex
class AddVertexCommand {
    public void execute() {
    }
}
// Command for delete Vertex
class DeleteVertexCommand {
    public void execute(int deleteNumber) { 
    }
}
    
//test
public class TestCommand {
}     

     

    /*
    
    private static ArrayList <ArrayList <Integer>> tree = new ArrayList <ArrayList<Integer>> ();
    //private static ArrayList <Integer> DeadList = new ArrayList <Integer> ();
    private static Scanner sc = new Scanner (System.in);
    private static int numberVertex = -1; // для создание новых Vertex
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Hi");
        
        
        while (true) {
            System.out.println("command: addVertex, printVertex, printTree, deleteVertex, rR or exit");
            String input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            } else if (input.equals("addVertex")) {
                addVertex();
            } else if (input.equals("printVertex")) {
                printVertex();
            } else if (input.equals("printTree")) {
                printTree();
            } else if (input.equals("deleteVertex")) {
                System.out.println("numberVertex");
                int deleteNumber = sc.nextInt();
                deleteVertex(deleteNumber);
                printTree();
            } else if (input.equals("test")) {
                test ();
            } else if (input.equals("rR")) {
                rR();
            } else {
                System.out.println("error");
            }
         
         
         
         }
     }
             
    private static void addVertex() {
        System.out.println("FatherVertex");
        int FatherVertex = sc.nextInt();
        if (FatherVertex < tree.size()) {
            numberVertex++;
            ArrayList <Integer> Vertex = new ArrayList <Integer> ();
            Vertex.add(0, 123456789);
            Vertex.add(1, numberVertex);
            Vertex.add(2, FatherVertex);
            tree.add(Vertex);
            tree.get(FatherVertex).add(numberVertex);
        } else if (FatherVertex == 0) {
          numberVertex++;
            ArrayList <Integer> Vertex = new ArrayList <Integer> ();
            Vertex.add(0, 123456789);
            Vertex.add(1, numberVertex);
            Vertex.add(2, FatherVertex);
            tree.add(Vertex);
        } else{
            System.out.println("Error Fater Vertex");
        }
        printTree();
     }
     
     private static void deleteVertex(int deleteNumber) {
        if (tree.get(deleteNumber).size() == 3) {
                metodDelete(deleteNumber);
        } else if (tree.get(deleteNumber).size() > 3) {
                for (int i = 3; i < tree.get(deleteNumber).size();) {
                    deleteVertex(tree.get(deleteNumber).get(i));
                }
                metodDelete(deleteNumber);
        } else {
                System.out.println("0_o");
        }
     }
     
     private static void metodDelete (int delete)   {
        tree.remove(delete);
        numberVertex--;
        for (int a = 0; a < tree.size() ; a++) {
            for (int b = 1; b < tree.get(a).size(); b++) {
                if (tree.get(a).get(b) > delete) {
                    int z = tree.get(a).get(b);
                    z--;
                    tree.get(a).set(b, z);
                } else if (tree.get(a).get(b) == delete) {
                    tree.get(a).remove(b);
                    b--;
                } else {
                        
                }
            }
        }
     }
     
   private static void printTree() {
        for (int i = 0; i < tree.size(); i++) {
            System.out.println(tree.get(i));
        }
    }
    
    private static void printVertex() {
        System.out.println("Number Vertex");
        int printNumber = sc.nextInt();
        if (printNumber <= tree.size()) {
            System.out.println(tree.get(printNumber));
        } else {
            System.out.println("does not have a vertex number " +printNumber );
        }
    }
    
    private static void rR () {
        printTree();
        System.out.println("NewRoot");
        int newRoot = sc.nextInt();
        for (int a = 0; a < tree.size(); a++) {
            for (int c = 3; c < tree.get(a).size(); c++) {
                if (tree.get(a).get(c) == newRoot) {
                    tree.get(a).remove(c);
                } else {                  
                }
            }
            for (int b = 1; b < tree.get(a).size(); b++) {
                if (newRoot > tree.get(a).get(b)) {
                    int z = tree.get(a).get(b);
                    z++;
                    tree.get(a).set(b, z);
                }else {
                }
            }
        }
        for (int a = 0, b = 2; a < tree.size(); a++) {
             if (tree.get(a).get(b) == newRoot) {
                tree.get(a).set(b, 0);
             } else {
             }
        }
        
        tree.get(newRoot).set(1, 0);
        tree.get(newRoot).set(2, 0);
        tree.get(newRoot).add(3, 1);
        tree.get(0).set(2,0);
        printTree();
        tree.add(0, tree.get(newRoot));
        System.out.println(newRoot);
        tree.remove(newRoot+1);
        System.out.println(newRoot+1);
        printTree();
    }
    
    private static void test () {
      int i = sc.nextInt();
      int a = tree.get(i).get(0);
      System.out.println(a);  
    }
} 
   
*/