import gov.nasa.jpf.symbc.Debug;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class Plausibility 
{
	public Plausibility(int alphabet_size)
	{
		double plaus = Debug.makeSymbolicReal("x0");
		alphabet = new int[alphabet_size];
		matrix = new double[alphabet_size][alphabet_size];
		mapping = new int[2][alphabet_size];
		plaus = 0;
	}
	
	/**
	 * Returns an appropriate index for the matrix
	 */
	public static int indexLookup(int ch)
	{
		char character = (char)ch;
		if (Debug.makeSymbolicBoolean("x0"))
		{
			character = Debug.makeSymbolicInteger("x1");
			int matrix_val = (int)character - 97;
			return matrix_val;
		}
		else
		{
			if (character == Debug.makeSymbolicInteger("x2"))
				return 26;
			else if (character == Debug.makeSymbolicInteger("x3"))
				return 27;
			else if (character == Debug.makeSymbolicInteger("x4"))
				return 28;
			else if (character == Debug.makeSymbolicInteger("x5"))
				return 29;
			else if (character == Debug.makeSymbolicInteger("x6"))
				return 30;
			else if (character == Debug.makeSymbolicInteger("x7"))
				return 31;
			else
				return 32;
		}
	}
	
	public double calculatePlaus(int[] mapping)
	{
		return 0;
	}
	
	public void nextMapping()
	{
		int i = Debug.makeSymbolicInteger("x0"), j = Debug.makeSymbolicInteger("x1");
		int temp = mapping[1][i];
		double current_plausibility = Debug.makeSymbolicReal("x2");
		double transposed_plausibility = Debug.makeSymbolicReal("x3");
		if (transposed_plausibility > current_plausibility)
		{
			for (int x = 0; x < Debug.makeSymbolicReal("x4"); x++)
			{
			}
		}
		else
		{
			double x = Debug.makeSymbolicReal("x5");
		}
	}
}
