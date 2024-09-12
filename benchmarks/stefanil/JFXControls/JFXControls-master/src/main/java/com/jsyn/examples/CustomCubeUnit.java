package com.jsyn.examples;

import gov.nasa.jpf.symbc.Debug;

/**
 * Custom unit generator that can be used with other JSyn units.
 * Cube the input value and write it to output port.
 * 
 * @author Phil Burk (C) 2010 Mobileer Inc
 * 
 */
public class CustomCubeUnit
{

	public void generate( int start, int limit )
	{
		// Get signal arrays from ports.
		double[] inputs;
		double[] outputs;

		for( int i = start; i < limit; i++ )
		{
			double x = inputs[i];
			// Do the math.
			outputs[i] = x * x * x;
		}
	}
}
