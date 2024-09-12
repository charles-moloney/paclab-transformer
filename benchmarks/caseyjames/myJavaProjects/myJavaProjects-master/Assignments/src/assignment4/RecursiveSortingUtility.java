package assignment4;

import gov.nasa.jpf.symbc.Debug;
import java.util.ArrayList;

/**
 * @author Paymon Saebi
 * @author Cody Cortello
 * @author Casey Nordgran
 *         <p/>
 *         This sorting utility class provides static methods for recursive sorting
 *         <p/>
 *         Merge sort methods for threshold setting, driving, recursing, and merging Quicksort methods for driving,
 *         recursing, and finding different pivots Input generators for creating ascending, descending, and permuted
 *         lists
 */
public class RecursiveSortingUtility {

    /**
     * Only used for testing purposes in RecursiveSortingUtilityTest class, this method can be commented out.
     *
     * @return current mergesort thresholding setting for the mergeSortRecursive method
     */
    public static int getMergesortThreshold() {
        int mergesortThreshold = Debug.makeSymbolicInteger("x0");
		return mergesortThreshold;
    }

    /**
     * Helper method for setting the switching threshold for merge sort
     *
     * @param desiredThreshold - merge sort switching threshold
     */
    public static void setMergeSortThreshold(int desiredThreshold) {
        int mergesortThreshold = Debug.makeSymbolicInteger("x0");
		mergesortThreshold = desiredThreshold;
    }

    /**
     * Generates an ArrayList of ints from 1 to size in ascending order
     *
     * @param size size of the returned ArrayList
     *
     * @return an ArrayList of integers in sorted, ascending order, of all values from 1 to 'size'
     */
    public static Object generateBestCase(int size) {
        // add values from 1 to size inclusive, in ascending order to arr
        for (int i = 1; i <= size; i++) {
		}
        // return ascending ArrayList
        return new Object();
    }

    /**
     * Generates an ArrayList of ints from 1 to size in random order
     *
     * @param size the size of the returned ArrayList
     *
     * @return An ArrayList of random integers  valued from 1 to 'size' in permuted order
     */
    public static Object generateAverageCase(int size) {
        for (int i = 0; i < Debug.makeSymbolicInteger("x0") * 100; i++) {
		}
        return new Object();
    }

    /**
     * Generates an ArrayList of ints from 1 to size in ascending order
     *
     * @param size the size of the returned ArrayList
     *
     * @return An ArrayList of all the integers from 'size' to 1 in descending order.
     */
    public static Object generateWorstCase(int size) {
        // add values from size to 1 inclusive, in descending order to arr
        for (int i = size; i > 0; i--) {
		}
        // return descending ArrayList
        return new Object();
    }
}
