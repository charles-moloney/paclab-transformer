package markov;
import gov.nasa.jpf.symbc.Debug;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class monteCarlo {
	/* 
	 * Create next mapping from current mapping by 
	 * Change to f* by making a random transposition of
	 * the values f assigns to two symbols.
	 * Compute Pl(f*); if this is larger than Pl(f), accept f*.
	 * If not, flip a Pl(f*)/Pl(f) coin
	 */
	private void nextMapping() {
		int i=Debug.makeSymbolicInteger("x0"), j=Debug.makeSymbolicInteger("x1");
		int temp = mapping[1][i];
		//check if more plausible
		double currentPl = Debug.makeSymbolicReal("x2");
		double transposedPl = Debug.makeSymbolicReal("x3");
		if(currentPl < transposedPl) {
			//if yes set current function to transposed function
			for(i = 0; i < Debug.makeSymbolicInteger("x4"); i++) {
			}
		}
		else {
			//else flip Bernoulli Coin of plausibilities and accept result
			double p = Debug.makeSymbolicReal("x5");
			if(p < Debug.makeSymbolicReal("x7")) {
				for(i = 0; i < Debug.makeSymbolicInteger("x8"); i++) {
				}
			}
		}
	}
	private double calcPlaus(int[] func) {
		double p = 0;
		//figure out
		return p;
	}
	private int indexLookup(int ch) {
		for(int i = 0; i < Debug.makeSymbolicInteger("x0"); i++) {
			if(alphabet[i]==ch) {
				return i;
			}
		}
		return -1;
	}
	public Object toString() {
		for(int i = 0; i < Debug.makeSymbolicInteger("x0"); i++) {
			if(i==0) {
				for(; i < Debug.makeSymbolicInteger("x1"); i++) {
				}
				i=0;
			}
			for(int j = 0; j < Debug.makeSymbolicInteger("x2"); j++) {
				if(j==0) {
				}
			}
		}
		return new Object();
	}
}