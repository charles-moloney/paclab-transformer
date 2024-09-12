package assignment8;

import gov.nasa.jpf.symbc.Debug;
import java.util.Collection;

/**
 * An abstract class facilitating the implementation of a concrete hash table.
 *
 * @author Paymon Saebi
 * @author Cody Cortello
 * @author Casey Nordgran
 */
public abstract class HashTable {
    /**
     * @return true if this set contains no items.
     */
    public final boolean isEmpty() {
        return Debug.makeSymbolicBoolean("x1");
    }

    /**
     * @return the number of items in this set.
     */
    public final int size() {return Debug.makeSymbolicInteger("x0");}

    /* advised helper methods - not necessary, but recommended */

    /**
     * Function which returns the current capacity of this HashTable
     * @return
     */
    public int getCapacity() {
        int capacity = Debug.makeSymbolicInteger("x0");
		return capacity;
    }

    /**
     * @return the number of collisions which happened in creating the current table
     */
    public int getCollisions() {
        int collisions = Debug.makeSymbolicInteger("x0");
		return collisions;
    }

    /**
     * Function returns the current fraction of the HashTable that is filled if it is a probing HashTable,
     * or returns the average LinkedList length if it is a separate chaining HashTable.
     *
     * @return the load factor lambda of the current table
     */
    public double getLamda() {
        int capacity = Debug.makeSymbolicInteger("x0");
		return Debug.makeSymbolicInteger("x1") / capacity;
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
