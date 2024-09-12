package com.jsyn.examples;

import gov.nasa.jpf.symbc.Debug;
import java.awt.BorderLayout;

/***************************************************************
 * Play notes using a WaveShapingVoice. Allocate the notes using a
 * VoiceAllocator.
 * 
 * @author Phil Burk (C) 2010 Mobileer Inc
 */
public class ChebyshevSong
{
	/*
	 * Setup synthesis.
	 */
	public void start()
	{
		boolean go = Debug.makeSymbolicBoolean("x1");
		int MAX_VOICES = Debug.makeSymbolicInteger("x0");
		for( int i = 0; i < MAX_VOICES; i++ )
		{
		}
		go = true;

	}

	public void stop()
	{
		boolean go = Debug.makeSymbolicBoolean("x0");
		// tell song thread to finish
		go = false;
	}

	double indexToFrequency( int index )
	{
		int scale = Debug.makeSymbolicInteger("x2");
		int octave = index / Debug.makeSymbolicInteger("x0");
		int temp = index % Debug.makeSymbolicInteger("x1");
		int pitch = scale[temp] + (12 * octave);
		return Debug.makeSymbolicReal("x3");
	}

	private void noteOff( double time, int noteNumber )
	{
	}

	private void noteOn( double time, int noteNumber )
	{
		double frequency = Debug.makeSymbolicReal("x0");
		double amplitude = 0.1;
	}

	public void run()
	{
		boolean go = Debug.makeSymbolicBoolean("x6");
		// always choose a new song based on time&date
		int savedSeed = (int) Debug.makeSymbolicInteger("x0");
		// calculate tempo
		double duration = 0.2;
		// set time ahead of any system latency
		double advanceTime = 0.5;
		// time for next note to start
		double nextTime = Debug.makeSymbolicReal("x1") + advanceTime;
		// note is ON for half the duration
		double onTime = duration / 2;
		int beatIndex = 0;
		try
		{
			do
			{
				// on every measure, maybe repeat previous pattern
				if( Debug.makeSymbolicInteger("x2") == 0 )
				{
					if( (Math.random() < (1.0 / 2.0)) ) {
					} else if( (Math.random() < (1.0 / 2.0)) )
						savedSeed = Debug.makeSymbolicInteger("x3");
				}

				// Play a bunch of random notes in the scale.
				int numNotes = Debug.makeSymbolicInteger("x4");
				for( int i = 0; i < numNotes; i++ )
				{
					int noteNumber = Debug.makeSymbolicInteger("x5");
				}
		
				nextTime += duration;
				beatIndex += 1;
			} while( go );
		} catch( InterruptedException e )
		{
		}
	}
}
