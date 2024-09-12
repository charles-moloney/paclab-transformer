/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/
package org.apache.cordova;

import gov.nasa.jpf.symbc.Debug;

/**
 * This class is used to detect when the soft keyboard is shown and hidden in the web view.
 */
public class LinearLayoutSoftKeyboardDetect {

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int oldWidth = Debug.makeSymbolicInteger("x5");
		int screenWidth = Debug.makeSymbolicInteger("x4");
		int screenHeight = Debug.makeSymbolicInteger("x3");
		int oldHeight = Debug.makeSymbolicInteger("x2");
		// Get the current height of the visible part of the screen.
        // This height will not included the status bar.\
        int width, height;

        height = Debug.makeSymbolicInteger("x0");
        width = Debug.makeSymbolicInteger("x1");
        // If the oldHeight = 0 then this is the first measure event as the app starts up.
        // If oldHeight == height then we got a measurement change that doesn't affect us.
        if (oldHeight == 0 || oldHeight == height) {
        }
        // Account for orientation change and ignore this event/Fire orientation change
        else if (screenHeight == width)
        {
            int tmp_var = screenHeight;
            screenHeight = screenWidth;
            screenWidth = tmp_var;
        }
        // If the height as gotten bigger then we will assume the soft keyboard has
        // gone away.
        else if (height > oldHeight) {
        }
        // If the height as gotten smaller then we will assume the soft keyboard has
        // been displayed.
        else if (height < oldHeight) {
        }

        // Update the old height for the next event
        oldHeight = height;
        oldWidth = width;
    }
}
