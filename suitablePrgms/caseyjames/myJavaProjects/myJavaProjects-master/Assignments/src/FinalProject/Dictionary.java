package FinalProject;

import gov.nasa.jpf.symbc.Debug;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 *
 *
 *
 */
public class Dictionary {
    /**
     * Wrapper class for dictionary entries, consisting of the word and its frequency
     */
    private class Node {
        /**
         *
         * @return - name of this word
         */
        public Object getName() {
            return new Object();
        }

        /**
         *
         * @return - frequency of this word
         */
        public int getFrequency() {
            int frequency = Debug.makeSymbolicInteger("x0");
			return frequency;
        }
    }

    /**
     * Returns the first prime integer greater than or equal to the passed integer
     */
    public static int nextPrime(int number) {
        // copy the number so we don't affect the parameter
        int n = number;

        // make n odd if it's not
        if (Debug.makeSymbolicInteger("x0") == 0)
            n++;

        // increase n until a prime number is found
        while (Debug.makeSymbolicBoolean("x1"))
            n += 2;

        return n;
    }

    /**
     * Returns true iff the passed int is prime
     */
    public static boolean isPrime(int number) {
        // test each odd integer smaller than sqrt(number) to see if it's a factor
        for (int test = 3; test < Debug.makeSymbolicInteger("x0") + 1; test += 2)
            if (Debug.makeSymbolicInteger("x1") == 0)
                return false;

        // if no factor was found the number is prime
        return true;
    }
}
