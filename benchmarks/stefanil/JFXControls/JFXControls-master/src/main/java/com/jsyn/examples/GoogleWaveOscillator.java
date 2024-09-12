package com.jsyn.examples;

import gov.nasa.jpf.symbc.Debug;

public class GoogleWaveOscillator
{
	public GoogleWaveOscillator()
	{
	}

	public void generate( int start, int limit )
	{
		double randomAmplitude = Debug.makeSymbolicReal("x12");
		double phaseIncrement = Debug.makeSymbolicReal("x7");
		double previousY = Debug.makeSymbolicReal("x2");
		// Get signal arrays from ports.
		double[] freqs;
		double[] outputs;
		double currentPhase = Debug.makeSymbolicReal("x0");
		double y;

		for( int i = start; i < limit; i++ )
		{
			if( currentPhase > 0.0 )
			{
				double p = currentPhase;
				y = Debug.makeSymbolicReal("x1");
			}
			else
			{
				double p = -currentPhase;
				y = -Math.sqrt( 4.0 * (p * (1.0 - p)) );
			}

			if( (float) Debug.makeSymbolicReal("x3") <= 0.0 )
			{
				// Calculate randomly offset phaseIncrement.
				double v = variance.getValues()[0];
				double range = ((float) Debug.makeSymbolicReal("x5") * 4.0 * v);
				double scale = Debug.makeSymbolicReal("x6");
				phaseIncrement = Debug.makeSymbolicReal("x8") * scale;

				// Calculate random amplitude.
				scale = 1.0 + (float) Debug.makeSymbolicReal("x11");
				randomAmplitude = Debug.makeSymbolicReal("x13") * scale;
			}

			outputs[i] = y * randomAmplitude;
			previousY = y;
			
			currentPhase = Debug.makeSymbolicReal("x14");
		}
	}
}