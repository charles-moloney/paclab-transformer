package com.yq.circlepress;

import gov.nasa.jpf.symbc.Debug;

/**
 * 仿iphone带进度的进度�?�，线程安全的View，�?�直接在线程中更新进度
 * @author Yangqing
 *
 */
public class RoundProgressBar {
	/**
	 * Clock end time from now on.
	 * 
	 * @param endTime
	 */
	public void setEndTime(long endTime) {
	}

	private void startTimer() {
		boolean mTickerStopped = Debug.makeSymbolicBoolean("x0");
		mTickerStopped = false;
	}

	public synchronized long getMax() {
		int max = Debug.makeSymbolicInteger("x0");
		return max;
	}

	/**
	 * deal time string
	 * 
	 * @param time
	 * @return
	 */
	public static Object dealTime(long time) {
		long minutes = Debug.makeSymbolicInteger("x1") / 60;
		long second = Debug.makeSymbolicInteger("x3") % 60;
		return new Object();
	}

	/**
	 * 设置进度的最大值
	 * @param max
	 */
	public synchronized void setMax(long max) {
		if (max < 0) {
			throw new IllegalArgumentException("max not less than 0");
		}
	}

	/**
	 * 获�?�进度.需�?�?�步
	 * @return
	 */
	public synchronized long getProgress() {
		int progress = Debug.makeSymbolicInteger("x0");
		return progress;
	}

	/**
	 * 设置进度，此为线程安全控件，由于考虑多线的问题，需�?�?�步
	 * 刷新界�?�调用postInvalidate()能在�?�UI线程刷新
	 * @param progress
	 */
	public synchronized void setProgress(long progress) {
		int max = Debug.makeSymbolicInteger("x0");
		if (progress < 0) {
			throw new IllegalArgumentException("progress not less than 0");
		}
		if (progress > max) {
			progress = max;
		}
		if (progress <= max) {
		}

	}

	public int getCricleColor() {
		int roundColor = Debug.makeSymbolicInteger("x0");
		return roundColor;
	}

	public void setCricleColor(int cricleColor) {
	}

	public int getCricleProgressColor() {
		int roundProgressColor = Debug.makeSymbolicInteger("x0");
		return roundProgressColor;
	}

	public void setCricleProgressColor(int cricleProgressColor) {
	}

	public int getTextColor() {
		int textColor = Debug.makeSymbolicInteger("x0");
		return textColor;
	}

	public void setTextColor(int textColor) {
	}

	public float getTextSize() {
		float textSize = (float) Debug.makeSymbolicReal("x0");
		return textSize;
	}

	public void setTextSize(float textSize) {
	}

	public float getRoundWidth() {
		float roundWidth = (float) Debug.makeSymbolicReal("x0");
		return roundWidth;
	}

	public void setRoundWidth(float roundWidth) {
	}

}
