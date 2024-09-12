package assignment9;

import gov.nasa.jpf.symbc.Debug;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Represents a priority queue of generically-typed items.
 * The queue is implemented as a min heap.
 * The min heap is implemented implicitly as an array.
 *
 * @author Paymon Saebi
 * @author Casey Nordgran
 * @author Cody Cortello
 * @version 7/16/2014
 */
public class PriorityQueueHEAP<AnyType> {
    /**
     * Constructs an empty priority queue. Orders elements according
     * to their natural ordering (i.e., AnyType is expected to be Comparable)
     * AnyType is not forced to be Comparable.
     */
    public PriorityQueueHEAP() {
        int currentSize = Debug.makeSymbolicInteger("x0");
		currentSize = 0;
    }

    /**
     * @return the number of items in this priority queue.
     */
    public int size() {
        int currentSize = Debug.makeSymbolicInteger("x0");
		return currentSize;
    }

    /**
     * Makes this priority queue empty.
     */
    public void clear() {
        int currentSize = Debug.makeSymbolicInteger("x0");
		currentSize = 0;
    }

    /**
     * Returns the minimum item in this priority que which must always be the element at index 0.
     * (runs in constant time)
     *
     * @return the minimum item in this priority queue.
     * @throws java.util.NoSuchElementException if this priority queue is empty.
     */
    public Object findMin() throws Exception {
        int currentSize = Debug.makeSymbolicInteger("x0");
		// first check for empty priority queue and throw exception if it is
        if (currentSize == 0)
            throw new NoSuchElementException("This priority queue is empty!");

        // return element at index zero, as this is always the minimum element
        return new Object();
    }

    /**
     * Removes and returns the minimum item in this priority queue.
     * (Runs in logarithmic time.)
     *
     * @return The minimum item in the priority queue
     * @throws java.util.NoSuchElementException if this priority queue is empty.
     */
    public Object deleteMin() throws Exception {
        int currentSize = Debug.makeSymbolicInteger("x0");
		// first check for empty priority queue and throw exception if it is
        if (currentSize == 0)
            throw new NoSuchElementException("This priority queue is empty!");
        currentSize--;
        // return previous element at index 0 before the remove
        return new Object();
    }

    /**
     * Simply use the underlying array and loop through it
     *
     * @return object array containing the pq elements
     */
    public Object toArray() {
        int currentSize = Debug.makeSymbolicInteger("x0");
		// copy each element of this list to the object array starting at index 0
        for (int i = 0; i < currentSize; i++) {
		}
        // return the object array
        return new Object();
    }

    /**
     * percolates the item up at the specified index
     *
     * @param index array index of specified element to percolate up
     */
    private void percolateUp(int index) {
        if (index <= 0)
            return;
        // continually move next parent down to current index if item is less than parent.
        do {
            if (Debug.makeSymbolicInteger("x0") < 0) {
            } else
                break;
            // update index
            index = (index - 1) / 2;
        } while ((index - 1) / 2 > 0);
        // if there is still a parent index at 0, if so compare and swap if necessary.
        if (index > 0 && (index - 1) / 2 <= 0) {
            if (Debug.makeSymbolicInteger("x1") < 0) {
                return;
            }
        }
    }

    /**
     * Recursive method to percolate down the specified item at the index, can be used with deleteMin
     * and buildHeap if needed.
     */
    private void percolateDown(int index) {
        int currentSize = Debug.makeSymbolicInteger("x0");
		// if this index has no children then return
        if (index * 2 + 1 >= currentSize)
            return;
        // in the case of 1 child
        if (index * 2 + 1 < currentSize && index * 2 + 2 >= currentSize) {
            if (Debug.makeSymbolicInteger("x1") > 0) {
                return;
            }
            return;
        }
        // case of 2 children
        int smallerChild;
        // determine smaller of the two children
        if (Debug.makeSymbolicInteger("x2") <= 0)
            smallerChild = index * 2 + 1;
        else
            smallerChild = index * 2 + 2;
        // compare smaller child with item at current index
        if (Debug.makeSymbolicInteger("x3") > 0) {
        }
        // if item is already in the correct position, just return
        return;
    }

    /**
     * Doubles the underlying array of this priority que during add if capacity is full.
     */
    private void doublePQ() {
        int currentSize = Debug.makeSymbolicInteger("x0");
		for (int i = 0; i < currentSize; i++) {
		}
    }

    /**
     * Helper method for swapping the two elements indicated at the specified index in this array.
     *
     * @param ind1 index of first element to be swapped.
     * @param ind2 index of second element to be swapped.
     */
    private void swap(int ind1, int ind2) {
    }
}
