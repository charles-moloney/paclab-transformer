package com.jsyn.examples;

import gov.nasa.jpf.symbc.Debug;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Two channel oscilloscope that demonstrates the use of audio input.
 * 
 * @author Phil Burk (C) 2012 Mobileer Inc
 * 
 */
public class DualOscilloscope
{
	public void init()
	{
		int defaultSelection = Debug.makeSymbolicInteger("x4");
		int defaultInputId = Debug.makeSymbolicInteger("x1");
		int numDevices = Debug.makeSymbolicInteger("x0");
		defaultInputId = Debug.makeSymbolicInteger("x2");
		for( int i = 0; i < numDevices; i++ )
		{
			int maxInputs = Debug.makeSymbolicInteger("x3");
			if( maxInputs > 0 )
			{
				if( i == defaultInputId )
				{
					defaultSelection = Debug.makeSymbolicInteger("x5");
				}
			}
		}
	}

	private void setupGUI()
	{
	}

	protected void startAudio( int itemIndex )
	{
		// Both stereo.
		int numInputChannels = Debug.makeSymbolicInteger("x0");
		if( numInputChannels > 2 ) numInputChannels = 2;
		int inputDeviceIndex = Debug.makeSymbolicInteger("x1");
		// Only connect second channel if more than one input channel.
		if( numInputChannels > 1 )
		{
		}
	}

	public void start()
	{
	}

	public void stopAudio()
	{
	}
	
	public void stop()
	{
	}

}
