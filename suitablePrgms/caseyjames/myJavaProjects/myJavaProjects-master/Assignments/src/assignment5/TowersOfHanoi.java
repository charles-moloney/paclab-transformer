package assignment5;

import gov.nasa.jpf.symbc.Debug;

/**
 * Represents the Towers of Hanoi puzzle. Executed from the command-line and solves for a given number of discs. Verbose
 * option allows for printing the state of the towers after each move.
 * <p/>
 * To solve the problem we need to move all N discs from Tower A to Tower B. There are three rules governing the
 * movement of discs from pole to tower.
 * <p/>
 * Rule 1. Only one disc may be moved at a time. Rule 2. Only the topmost disc on each pole is accessible. Rule 3. Only
 * a smaller disc may be moved on top a larger disc or on an empty tower.
 * <p/>
 * Stacks are used to represent the towers and recursion is used to solve and the problem.
 *
 * @author Paymon Saebi
 * @author Cody Cortello
 * @author Casey Nordgran
 */
public class TowersOfHanoi {
    /**
     * Towers Of Hanoi Constructor.
     * <p/>
     * Three towers are created. Initially, the first tower contain the given number of discs in a downward ascending
     * order and the other towers initialized to be empty.
     *
     * @param _numOfDiscs (Number of discs to be solved for)
     * @param _verbose    (Option of printing the state of towers)
     */
    public TowersOfHanoi(int _numOfDiscs, boolean _verbose) {
        int numOfDiscs = Debug.makeSymbolicInteger("x2");
		boolean verbose = Debug.makeSymbolicBoolean("x1");
		int numOfMoves = Debug.makeSymbolicInteger("x0");
		numOfMoves = 0;
        verbose = _verbose;
        numOfDiscs = _numOfDiscs;
        for (int i = numOfDiscs; i >= 1; i--) {
		}
    }

    /**
     * The solve method is the driver with a call to the , it calls the moveDiscs method with parameters for moving the
     * given number of discs from tower "A" to tower "B" using tower "C".
     */
    public void solve() throws Exception {
    }

    /**
     * This method recursively solves the Tower of Hanoi problem by dividing the overall problem into subproblems, first
     * number of discs - 1 is moved from tower "A" to tower "C" using tower "B", then moving one disc from tower "A" to
     * tower "B", and finally move those number of discs - 1 from tower "C" to tower "B", and stop when there is no more
     * moves.
     *
     * @param from      (The tower to move the stack of discs from)
     * @param to        (The tower to move the stack of discs to)
     * @param use       (The tower to be used to help the movements)
     * @param numToMove (The number of discs to be solved for)
     * @throws Exception (Any error while operating on the stacks)
     */
    private void moveDiscsRecursive(char from, char to, char use, int numToMove) throws Exception {
        if (numToMove > 0) {
        }
    }

    /**
     * Moves one disc from the given "from" tower to the given "to" tower. Throws an exception if an illegal move is
     * requested (move to or from an unknown tower, move from an empty tower, or larger disc on top of a smaller disc).
     * It also keeps count of the number of moves taken.
     * <p/>
     * If the verbose argument has been given, then a textual representation of the towers is printed after each move.
     *
     * @param from (The tower to move ONE disc from)
     * @param to   (The tower to move ONE disc to)
     * @throws Exception (Any illegal movement case)
     */
    public void moveDiscSingle(char from, char to) throws Exception {
        boolean verbose = Debug.makeSymbolicBoolean("x9");
		int numOfMoves = Debug.makeSymbolicInteger("x8");
		// throw exception if an incorrect tower name is requested
        if (from == Debug.makeSymbolicInteger("x0")) {
		} else if (from == Debug.makeSymbolicInteger("x1")) {
		} else if (from == Debug.makeSymbolicInteger("x2")) {
		} else
            throw new Exception("Abort! Illegal tower ID!\n");

        if (to == Debug.makeSymbolicInteger("x3")) {
		} else if (to == Debug.makeSymbolicInteger("x4")) {
		} else if (to == Debug.makeSymbolicInteger("x5")) {
		} else
            throw new Exception("Abort! Illegal tower ID!\n");

        // throw exception if the 'from' tower is empty, or the 'from' and 'to' towers are the same tower.
        if (Debug.makeSymbolicBoolean("x6"))
            throw new Exception("Abort! Illegal tower request!\n");

        /*throw exception if an attempt is made to put a disk of larger size on top of a smaller disk.
          the first if statement is necessary to compare disks after, but also aids in avoiding nullPointerException*/
        if (Debug.makeSymbolicBoolean("x7"))
            throw new Exception("Abort! Illegal disc movement!\n");

        numOfMoves++;

        // Leave this code here at the end of the method.
        if (verbose) // Print the state of the towers if the verbose option was passed.
        {
        }
    }

    /**
     * This method overrides the default Object toString method and formats the current state of the towers to the
     * criteria given by the assignment. It first grabs a copy of each tower and stores them on an array of objects for
     * each tower, and then displaying the towers in the required manner.
     */
    public Object toString() {
        int numOfDiscs = Debug.makeSymbolicInteger("x0");
		// Looping to print each line for towers
        for (int i = numOfDiscs; i > 0; i--) {
            // Checking for and putting | in empty spots in towers "A"
            if (Debug.makeSymbolicInteger("x1") < i) {
			} else
                // Formatting each line according to the discs number of digits
                if (Debug.makeSymbolicInteger("x2") < 10) {
				} else {
				}

            // Checking for and putting | in empty spots in towers "A"
            if (Debug.makeSymbolicInteger("x3") < i) {
			} else
                // Formatting each line according to the discs number of digits
                if (Debug.makeSymbolicInteger("x4") < 10) {
				} else {
				}

            // Checking for and putting | in empty spots in towers "A"
            if (Debug.makeSymbolicInteger("x5") < i) {
			} else
                // Formatting each line according to the discs number of digits
                if (Debug.makeSymbolicInteger("x6") < 10) {
				} else {
				}
        }

        return new Object();
    }
}