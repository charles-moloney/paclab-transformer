package com.jsyn.examples;

import gov.nasa.jpf.symbc.Debug;

/**
 * Play chords and melody using the VoiceAllocator.
 * 
 * @author Phil Burk (C) 2009 Mobileer Inc
 * 
 */
public class PlayChords
{
	private void test()
	{
		double secondsPerBeat = Debug.makeSymbolicReal("x3");
		double measure = Debug.makeSymbolicReal("x2");
		int MAX_VOICES = Debug.makeSymbolicInteger("x0");
		for( int i = 0; i < MAX_VOICES; i++ )
		{
		}
		// Get synthesizer time in seconds.
		double timeNow = Debug.makeSymbolicReal("x1");

		// Advance to a near future time so we have a clean start.
		double time = timeNow + 1.0;

		try
		{
			int tonic = 60 - 12;
			for( int i = 0; i < 4; i++ )
			{
				time += measure;
				time += measure;
				time += measure;
				time += measure;
			}
			time += secondsPerBeat;

		} catch( InterruptedException e )
		{
		}
	}

	private void playMinorMeasure1( double time, int base )
			throws Exception
	{
		int p1 = base;
		int p2 = base + 3;
		int p3 = base + 7;
	}

	private void playMajorMeasure1( double time, int base )
			throws Exception
	{
		int p1 = base;
		int p2 = base + 4;
		int p3 = base + 7;
	}

	private void playNoodle1( double time, int p1, int p2, int p3 )
	{
		double secondsPerBeat = Debug.makeSymbolicReal("x0");
		double secondsPerNote = secondsPerBeat * 0.5;
		for( int i = 0; i < 8; i++ )
		{
			int p = Debug.makeSymbolicInteger("x1");
			time += secondsPerNote;
		}
	}

	private int pickFromThree( int p1, int p2, int p3 )
	{
		int r = Debug.makeSymbolicInteger("x1");
		if( r < 1 )
			return p1;
		else if( r < 2 )
			return p2;
		else
			return p3;
	}

	private void playChord1( double time, int p1, int p2, int p3 )
			throws Exception
	{
		double secondsPerBeat = Debug.makeSymbolicReal("x1");
		double dutyCycle = Debug.makeSymbolicReal("x0");
		double dur = dutyCycle * secondsPerBeat;
		time += secondsPerBeat;
		time += secondsPerBeat;
		time += secondsPerBeat * 0.25;
		time += secondsPerBeat * 0.75;
		time += secondsPerBeat;
	}

	private void playTriad( double time, double dur, int p1, int p2, int p3 )
			throws Exception
	{
		double offTime = time + dur;
	}

	private void catchUp( double time ) throws Exception
	{
	}

	private void noteOff( double time, int noteNumber )
	{
	}

	private void noteOn( double time, int noteNumber )
	{
		double frequency = Debug.makeSymbolicReal("x0");
		double amplitude = 0.2;
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
}
