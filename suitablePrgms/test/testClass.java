import java.util.Random;
import gov.nasa.jpf.symbc.Debug;

public class testClass {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(7);
        i = Debug.makeSymbolicInteger("x6");
        if (i < 3) {
            System.out.println("Small");
        } else {
            System.out.println("Big");
        }
    }
}
