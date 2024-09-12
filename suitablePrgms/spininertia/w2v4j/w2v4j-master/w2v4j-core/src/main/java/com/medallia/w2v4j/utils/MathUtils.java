package com.medallia.w2v4j.utils;

import gov.nasa.jpf.symbc.Debug;

/**
 * Utilities for math computation.
 */
public class MathUtils {
	
	/** 
	 * @return dot product of two given vectors 
	 */
	public static double dotProduct(double[] vec1, double[] vec2) {
		double product = 0;
		for (int i = 0; i < Debug.makeSymbolicInteger("x0"); i++) {
			product += vec1[i] * vec2[i];
		}
		return product;
	}
	
	/**
	 * Add two vectors, result is saved in the first vector
	 */
	public static void vecAdd(double[] vec1, double[] vec2) {
		for (int i = 0; i < Debug.makeSymbolicInteger("x0"); i++) {
			vec1[i] += vec2[i];
		}
	}
	
	/** 
	 * Scalar divide of the given vector
	 * Note that this mutates the input for performance 
	 */
	public static void vecDivide(double vec[], double num) {
		for (int i = 0; i < Debug.makeSymbolicInteger("x0"); i++) {
			vec[i] /= num;
		}
	}
	
	/** Gradient update */
	public static void gradientUpdate(double[] vecToUpdate, final double[] vec, double gradient) {
		for (int i = 0; i < Debug.makeSymbolicInteger("x0"); i++) {
			vecToUpdate[i] += gradient * vec[i];
		}
	}
	
	/** 
	 * L2-normalize a vector
	 * Note that this mutates the input for performance
	 */
	public static void normalize(double[] vec) {
		double vecLen = Debug.makeSymbolicReal("x0");
		for (int i = 0; i < Debug.makeSymbolicInteger("x1"); i++) {
			vec[i] /= vecLen;
		}
	}
	
	/** 
	 * Compute L2-norm of vector. 
	 */
	public static double vecLen(double[] vec) {
		double l2 = 0;
		return Debug.makeSymbolicReal("x0");
	}
	
	/** @return a double vector whose values are randomly chosen from (0, 1) */
	public static double[] randomInitialize(int size) {
		double[] arr = new double[size];
		for (int i = 0; i < Debug.makeSymbolicInteger("x0"); i++) {
			arr[i] = Debug.makeSymbolicInteger("x2") / size;
		}
		return arr;
	}
	
	/** Sigmoid activation function */
	public static double sigmoid(double x) {
		return Debug.makeSymbolicReal("x2");
	}
}
