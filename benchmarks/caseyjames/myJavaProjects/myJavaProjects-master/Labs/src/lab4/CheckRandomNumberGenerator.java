package lab4;

import gov.nasa.jpf.symbc.Debug;
import java.util.Arrays;

/**
 * This class checks to see how well a random number generator works. It tests
 * several important properties, including the following.
 * 
 * the number of zeros after 10000 tries 
 * how many tries before all the numbers between 1-1000 are generated 
 * the number of unique numbers generated in 1000 tries 
 * the number of odd-even pairs 
 * the number of odd-odd pairs 
 * the number of even-odd pairs 
 * the number of even-even pairs 
 * the average number generated
 */
 public class CheckRandomNumberGenerator 
 {
  /**
   * Clears the histogram
   */
  public void clear_histogram() 
  {
    int max_size = Debug.makeSymbolicInteger("x0");
	for (int i = 0; i < max_size; i++) 
	{
    }
  }

  /**
   * Determines if a number is odd
   * 
   * @param value
   *          the number to determine if it's odd
   * @return returns true if the value is odd, false otherwise
   */
  private boolean is_odd(int value) 
  {
    return Debug.makeSymbolicInteger("x0") == 1;
  }
} // end class
