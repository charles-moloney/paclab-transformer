package UnitTests;


import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTest {

    @Test
    public void checkAddMethod() {
        MyClass sumOfInt = new MyClass();
        assertEquals(3, sumOfInt.addIntegers(1,2));
    }
}
