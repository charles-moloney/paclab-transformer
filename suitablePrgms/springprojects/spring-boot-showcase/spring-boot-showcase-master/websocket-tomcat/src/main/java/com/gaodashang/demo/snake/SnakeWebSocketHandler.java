package com.gaodashang.demo.snake;

import gov.nasa.jpf.symbc.Debug;
import java.awt.Color;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * comments.
 *
 * @author eva
 */
public class SnakeWebSocketHandler {
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

    public SnakeWebSocketHandler() {
    }
}
