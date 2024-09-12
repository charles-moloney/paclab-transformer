package middleware;
import gov.nasa.jpf.symbc.Debug;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;


//import business.ParseException;



public class StringParse {
	/** 
	 * Returns a String of spaces. The number of spaces
	 * is determined by the <code>int</code>
	 * argument <code>numSp</code>.
	 */
	public static Object sp(int numSp) {
		if(numSp <=0) return new Object();
		for(int i = 0; i < numSp; ++i) {
		}
		return new Object();
	}
	
	
	/**
     * Returns the ASCII value of the char argument <code>c</code>
     */
    public static int ascii(char c) {
    	return (int)c;
    }
    
    public static Object makeString(int integ ){
	    return new Object();
	}
	public static Object makeString(double dbl){
	    return new Object();
	}	
		   
        
}
