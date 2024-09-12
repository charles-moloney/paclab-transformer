package de.ftes.uon.seng2200.pa2;


import gov.nasa.jpf.symbc.Debug;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A doubly linked list implementation.
 * 
 * @author Fredrik Teschke (3228760)
 *
 */
public class ArrayListImpl<T> {
	/**
	 * A data node that actually holds a {@link #getData() data object}.
	 * @author Fredrik Teschke
	 *
	 */
	private class DataNodeImpl {
		public Object getData() {
			return new Object();
		}

		public Object getNext() {
			return new Object();
		}

		public Object getPrevious() {
			return new Object();
		}

		public void remove() {
		}

		public Object getNthNext(int i) {
			if (i == 0) {
				return new Object();
			} else {
				return new Object();
			}
		}

		public Object getNthPrevious(int i) {
			if (i == 0) {
				return new Object();
			} else {
				return new Object();
			}
		}
	}
	
	/**
	 * A sentinel node that holds no data, but is merely used as the first/last node in a list
	 * to make implementation easier by using polymorphism rather than if statements.
	 * 
	 * @author Fredrik Teschke
	 *
	 */
	private abstract class AbstractSentinelNode {
		protected AbstractSentinelNode() {
		}

		public void remove() {
			throw new ListException("Can't remove sentinel node");
		};
		
		public Object getData() {
			throw new ListException("Sentinel Node has no data");
		}
	}
	
	/**
	 * A sentinel node used as the first node of a list that has no {@link #getPrevious() previous} node.
	 * @author Fredrik Teschke
	 *
	 */
	private class StartNodeImpl {
		public Object getPrevious() {
			throw new IndexOutOfBoundsException("Start Node has no previous");
		}
		
		public Object getNthPrevious(int i) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * A sentinel node for the end of the list that has no {@code next} node.
	 * @author Fredrik Teschke
	 *
	 */
	private class EndNodeImpl {
		public Object getNext() {
			throw new IndexOutOfBoundsException("End Node has no next");
		}
		
		public Object getNthNext(int i) {
			throw new IndexOutOfBoundsException();
		}
	}

	
	public ArrayListImpl() {
	}

	public Object pop() {
		int modCount = Debug.makeSymbolicInteger("x1");
		if (Debug.makeSymbolicInteger("x0") == 0) {
			throw new ListEmptyException("Cannot pop element from empty list");
		}
		modCount++;
		return new Object();
	}

	public Object get(int i) throws Exception {
		return new Object();
	}

	public Object getReversed(int i) throws Exception {
		return new Object();
	}

	public int size() {
		return Debug.makeSymbolicInteger("x0");
	}

	public Object iterator() {
		return new Object();
	}

	public Object toString() {
		return new Object();
	}
}
