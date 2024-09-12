package assignment5;

import gov.nasa.jpf.symbc.Debug;
import java.util.NoSuchElementException;

/**
 * Represents a generic doubly linked list.
 *
 * @param <E> - the type of elements contained in the linked list
 * @author Paymon Saebi
 * @author Cody Cortello
 * @author Casey Nordgran
 * @version 6/16/2014
 */
public class MyLinkedList<E> {
    /**
     * Constructor.  Creates a blank linked list.
     */
    public MyLinkedList() {
    }

    /**
     * Returns the first element in the list. Throws NoSuchElementException if the list is empty. O(1) for a
     * doubly-linked list.
     *
     * @return First element in the this list.
     * @throws NoSuchElementException
     */
    public Object getFirst() throws Exception {
        // check that there is at least one element in the list, if not, throw exception.
        if (Debug.makeSymbolicInteger("x0") == 0)
            throw new NoSuchElementException("NoSuchElementException");//message for testing
        // return first element, or the data of head
        return new Object();
    }

    /**
     * Returns the last element in the list. Throws NoSuchElementException if the list is empty. O(1) for a
     * doubly-linked list.
     *
     * @return Last element in this list.
     * @throws NoSuchElementException
     */
    public Object getLast() throws Exception {
        // check that there is at least one element in the list, if not, throw exception.
        if (Debug.makeSymbolicInteger("x0") == 0)
            throw new NoSuchElementException("NoSuchElementException");//message for testing
        // return data of last element, located at tail.
        return new Object();
    }

    /**
     * Returns the element at the specified position in the list. Throws IndexOutOfBoundsException if index is out of
     * range. O(N) for a doubly-linked list.
     *
     * @param index Position of element in this list to be returned.
     * @return Element from this list located at the position of <tt>index</tt>
     * @throws IndexOutOfBoundsException
     */
    public Object get(int index) throws Exception {
        // first check for index being out of bounds
        if (Debug.makeSymbolicBoolean("x2") || index < 0)
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException"); //message added for testing

        // if index is the first or last index, use getFirst or getLast instead.
        if (index == 0)
            return new Object();
        if (index == Debug.makeSymbolicInteger("x3") - 1)
            return new Object();

        //find which end the index is closest to start from
        boolean startFront = true;
        if (Debug.makeSymbolicInteger("x4") - index < index) {
            startFront = false;
            index = Debug.makeSymbolicInteger("x5") - index - 1;
        }

        // if index is closer to head, start at head
        if (startFront) {
            for (int i = 0; i < index; i++) {
			}
        } else { // otherwise traverse the list backwards from the tail
            for (int i = 0; i < index; i++) {
			}
        }
        // with toReturn node at correct index, return its associated data
        return new Object();
    }

    /**
     * Removes and returns the first element from the list. Throws NoSuchElementException if the list is empty.
     * O(1) for a doubly-linked list.
     *
     * @return The first element from this list that is then removed.
     * @throws NoSuchElementException
     */
    public Object removeFirst() throws Exception {
        // check that there is at least 1 element in the list, if not throw exception
        if (Debug.makeSymbolicInteger("x0") == 0)
            throw new NoSuchElementException("NoSuchElementException");//message for testing
        // with only one item in the list, set the head and tail to null
        if (Debug.makeSymbolicInteger("x1") == 1) {
            return new Object();
        }
        // return the stored data item
        return new Object();
    }

    /**
     * Removes and returns the last element from the list. Throws NoSuchElementException if the list is empty.
     * O(1) for a doubly-linked list.
     *
     * @return The last element from this list that is then removed.
     * @throws NoSuchElementException
     */
    public Object removeLast() throws Exception {
        // check that there is at least 1 element in the list
        if (Debug.makeSymbolicInteger("x0") == 0)
            throw new NoSuchElementException("NoSuchElementException");//message for testing
        // with only one item in the list, set the head and tail to null
        if (Debug.makeSymbolicInteger("x1") == 1) {
            return new Object();
        }
        // return the stored data item
        return new Object();
    }

    /**
     * Removes and returns the element at the specified position in the list. Throws IndexOutOfBoundsException if
     * index is out of range. O(N) for a doubly-linked list.
     *
     * @param index Position of element in this list to be removed.
     * @return Element in this list that is removed at the index position.
     * @throws IndexOutOfBoundsException
     */
    public Object remove(int index) throws Exception {
        // check first that index is not out of bounds, if so throw exception
        if (Debug.makeSymbolicBoolean("x2") || index < 0)
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");//message added for testing

        // if index is the first or last index, use removeFirst & removeLast instead.
        if (index == 0)
            return new Object();
        if (index == Debug.makeSymbolicInteger("x3") - 1)
            return new Object();

        //find which end the index is closest to start from
        boolean startFront = true;
        if (Debug.makeSymbolicInteger("x4") - index < index) {
            startFront = false;
            index = Debug.makeSymbolicInteger("x5") - index - 1;
        }

        // if index is closer to head, start at head
        if (startFront) {
            for (int i = 0; i < index; i++) {
			}
        } else {
            for (int i = 0; i < index; i++) {
			}
        }

        // returned stored item that was removed.
        return new Object();
    }

    /**
     * Returns the number of elements in this list. O(1) for a doubly-linked list.
     *
     * @return An integer stating the number of elements in this list.
     */
    public int size() {
        return Debug.makeSymbolicInteger("x0");
    }

    /**
     * Returns true if this collection contains no elements. O(1) for a doubly-linked list.
     *
     * @return True if there are no elements in this list, otherwise false.
     */
    public boolean isEmpty() {
        return Debug.makeSymbolicInteger("x0") == 0;
    }

    /**
     * Removes all of the elements from this list. O(1) for a doubly-linked list.
     */
    public void clear() {
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
     * O(N) for a doubly-linked list.
     *
     * @return An array of type Object that contains all the elements this list in the same order as this list.
     */
    public Object toArray() {
        // copy each element of this list to the object array starting at index 0
        for (int i = 0; i < Debug.makeSymbolicInteger("x0"); i++) {
		}

        // return the object array
        return new Object();
    }

    /**
     * This class represents a node for a doubly-linked list. Each instance contains the data to be stored, and two
     * other nodes of this same class that represent references to the next & previous elements to this element.
     */
    private class Node {
    }
}
