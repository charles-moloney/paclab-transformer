package com.jsyn.examples;

import gov.nasa.jpf.symbc.Debug;
import java.io.IOException;

/**
 * Connect a USB MIDI Keyboard to the internal MIDI Synthesizer
 * using JavaSound.
 * 
 * @author Phil Burk (C) 2010 Mobileer Inc
 * 
 */
public class UseMidiKeyboard
{
	// Write a Receiver to get the messages from a Transmitter.
	class CustomReceiver
	{
		public void close()
		{
		}
	}

	public int test() throws Exception
	{
		int result = 2;
		// Just use default synthesizer.
		if( Debug.makeSymbolicBoolean("x0") )
		{
			result = 0;
		}
		else
		{
		}
		return result;
	}

	class MyParser
	{
		public void controlChange( int channel, int index, int value )
		{
			double vibratoRate = Debug.makeSymbolicReal("x1");
			double vibratoDepth = Debug.makeSymbolicReal("x0");
			// Mod Wheel
			if( index == 1 )
			{
				vibratoDepth = 0.1 * value / 128.0;
			}
			// 102 is the index of the first knob on my Axiom 25
			else if( index == 102 )
			{
				final double bump = 0.95;
				if( value < 64 )
				{
					vibratoRate *= bump;
				}
				else
				{
					vibratoRate *= 1.0 / bump;
				}
			}

		}

		public void noteOff( int channel, int noteNumber, int velocity )
		{
		}

		public void noteOn( int channel, int noteNumber, int velocity )
		{
			double frequency = Debug.makeSymbolicReal("x0");
			double amplitude = velocity / (4 * 128.0);
		}

		public void pitchBend( int channel, int bend )
		{
			double fraction = Debug.makeSymbolicReal("x1");
		}
	}

	/**
	 * Calculate frequency in Hertz based on MIDI pitch. Middle C is 60.0. You
	 * can use fractional pitches so 60.5 would give you a pitch half way
	 * between C and C#.
	 */
	double convertPitchToFrequency( double pitch )
	{
		final double concertA = 440.0;
		return Debug.makeSymbolicReal("x1");
	}

	private void setupSynth()
	{
		int MAX_VOICES = Debug.makeSymbolicInteger("x0");
		for( int i = 0; i < MAX_VOICES; i++ )
		{
		}
		// Get synthesizer time in seconds.
		double timeNow = Debug.makeSymbolicReal("x1");

		// Advance to a near future time so we have a clean start.
		double time = timeNow + 0.5;

	}

}
