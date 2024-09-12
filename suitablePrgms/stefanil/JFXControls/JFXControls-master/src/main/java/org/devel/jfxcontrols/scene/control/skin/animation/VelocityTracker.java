/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.devel.jfxcontrols.scene.control.skin.animation;

import gov.nasa.jpf.symbc.Debug;

/**
 * Helper for tracking the velocity of touch events, for implementing
 * flinging and other such gestures.  Use obtain to retrieve a
 * new instance of the class when you are going to begin tracking, put
 * the motion events you receive into it with addMovement(MotionEvent),
 * and when you want to determine the velocity call
 * computeCurrentVelocity(int) and then getXVelocity()
 * and getXVelocity().
 */
public final class VelocityTracker {
    
    public VelocityTracker() {
    }
    
    /**
     * Reset the velocity tracker back to its initial state.
     */
    public void clear() {
        int mPastTime = Debug.makeSymbolicInteger("x0");
		mPastTime[0] = 0;
    }
    

    public void addPoint(float x, float y, long time) {
        float mPastY = (float) Debug.makeSymbolicReal("x4");
		float mPastX = (float) Debug.makeSymbolicReal("x3");
		int LONGEST_PAST_TIME = Debug.makeSymbolicInteger("x2");
		int NUM_PAST = Debug.makeSymbolicInteger("x1");
		int mPastTime = Debug.makeSymbolicInteger("x0");
		int drop = -1;
        int i;
        final long[] pastTime = mPastTime;
        for (i=0; i<NUM_PAST; i++) {
            if (pastTime[i] == 0) {
                break;
            } else if (pastTime[i] < time-LONGEST_PAST_TIME) {
                drop = i;
            }
        }
        if (i == NUM_PAST && drop < 0) {
            drop = 0;
        }
        if (drop == i) drop--;
        final float[] pastX = mPastX;
        final float[] pastY = mPastY;
        if (drop >= 0) {
            final int start = drop+1;
            final int count = NUM_PAST-drop-1;
            i -= (drop+1);
        }
        pastX[i] = x;
        pastY[i] = y;
        pastTime[i] = time;
        i++;
        if (i < NUM_PAST) {
            pastTime[i] = 0;
        }
    }
    
    /**
     * Compute the current velocity based on the points that have been
     * collected.  Only call this when you actually want to retrieve velocity
     * information, as it is relatively expensive.  You can then retrieve
     * the velocity with {@link #getXVelocity()} and
     * {@link #getYVelocity()}.
     * 
     * @param units The units you would like the velocity in.  A value of 1
     * provides pixels per millisecond, 1000 provides pixels per second, etc.
     */
    public void computeCurrentVelocity(int units) {
        float mYVelocity = (float) Debug.makeSymbolicReal("x8");
		float mXVelocity = (float) Debug.makeSymbolicReal("x7");
		int NUM_PAST = Debug.makeSymbolicInteger("x3");
		int mPastTime = Debug.makeSymbolicInteger("x2");
		float mPastY = (float) Debug.makeSymbolicReal("x1");
		float mPastX = (float) Debug.makeSymbolicReal("x0");
		final float[] pastX = mPastX;
        final float[] pastY = mPastY;
        final long[] pastTime = mPastTime;
        
        // Kind-of stupid.
        final float oldestX = pastX[0];
        final float oldestY = pastY[0];
        final long oldestTime = pastTime[0];
        float accumX = 0;
        float accumY = 0;
        int N=0;
        while (N < NUM_PAST) {
            if (pastTime[N] == 0) {
                break;
            }
            N++;
        }
        // Skip the last received event, since it is probably pretty noisy.
        if (N > 3) N--;
        
        for (int i=1; i < N; i++) {
            final int dur = Debug.makeSymbolicInteger("x4");
            if (dur == 0) continue;
            float dist = pastX[i] - oldestX;
            float vel = (dist/dur) * units;   // pixels/frame.
            if (accumX == 0) accumX = vel;
            else accumX = (float) Debug.makeSymbolicReal("x5") * .5f;
            
            dist = pastY[i] - oldestY;
            vel = (dist/dur) * units;   // pixels/frame.
            if (accumY == 0) accumY = vel;
            else accumY = (float) Debug.makeSymbolicReal("x6") * .5f;
        }
        mXVelocity = accumX;
        mYVelocity = accumY;
    }
    
    /**
     * Retrieve the last computed X velocity.  You must first call
     * {@link #computeCurrentVelocity(int)} before calling this function.
     * 
     * @return The previously computed X velocity.
     */
    public float getXVelocity() {
        float mXVelocity = (float) Debug.makeSymbolicReal("x0");
		return mXVelocity;
    }
    
    /**
     * Retrieve the last computed Y velocity.  You must first call
     * {@link #computeCurrentVelocity(int)} before calling this function.
     * 
     * @return The previously computed Y velocity.
     */
    public float getYVelocity() {
        float mYVelocity = (float) Debug.makeSymbolicReal("x0");
		return mYVelocity;
    }
}
