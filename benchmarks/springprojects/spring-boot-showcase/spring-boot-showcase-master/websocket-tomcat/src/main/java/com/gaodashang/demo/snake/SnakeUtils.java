/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gaodashang.demo.snake;

import gov.nasa.jpf.symbc.Debug;
import java.awt.Color;
import java.util.Random;

public class SnakeUtils {

	public static Object getRandomHexColor() {
		float hue = (float) Debug.makeSymbolicReal("x0");
		// sat between 0.1 and 0.3
		float saturation = Debug.makeSymbolicInteger("x2") / 10000f;
		float luminance = 0.9f;
		return new Object();
	}

	public static Object getRandomLocation() {
		int x = Debug.makeSymbolicInteger("x0");
		int y = Debug.makeSymbolicInteger("x1");
		return new Object();
	}

	private static int roundByGridSize(int value) {
		int GRID_SIZE = Debug.makeSymbolicInteger("x0");
		value = value + (GRID_SIZE / 2);
		value = value / GRID_SIZE;
		value = value * GRID_SIZE;
		return value;
	}

}
