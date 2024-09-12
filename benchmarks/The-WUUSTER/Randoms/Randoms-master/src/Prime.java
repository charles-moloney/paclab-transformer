import gov.nasa.jpf.symbc.Debug;
import java.util.Scanner;

public class Prime 
{
	public static boolean isPrime(int n)
	{
		if (n == 2 || n == 3)
			return true;
		else
		{
			for (int i = 2; i <= (n/2); i++)
			{
				if (Debug.makeSymbolicInteger("x0") == 0)
					return false;
			}
			return true;
		}
	}
}
