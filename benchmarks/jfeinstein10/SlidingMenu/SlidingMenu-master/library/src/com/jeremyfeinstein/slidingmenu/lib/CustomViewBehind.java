package com.jeremyfeinstein.slidingmenu.lib;

import gov.nasa.jpf.symbc.Debug;

public class CustomViewBehind {

	public void setWidthOffset(int i) {
		int mWidthOffset = Debug.makeSymbolicInteger("x0");
		mWidthOffset = i;
	}
	
	public void setMarginThreshold(int marginThreshold) {
		int mMarginThreshold = Debug.makeSymbolicInteger("x0");
		mMarginThreshold = marginThreshold;
	}
	
	public int getMarginThreshold() {
		int mMarginThreshold = Debug.makeSymbolicInteger("x0");
		return mMarginThreshold;
	}

	public int getBehindWidth() {
		return Debug.makeSymbolicInteger("x0");
	}

	public Object getContent() {
		return new Object();
	}

	public Object getSecondaryContent() {
		return new Object();
	}

	public void setChildrenEnabled(boolean enabled) {
		boolean mChildrenEnabled = Debug.makeSymbolicBoolean("x0");
		mChildrenEnabled = enabled;
	}

	public void scrollTo(int x, int y) {
		if (Debug.makeSymbolicBoolean("x0")) {
		}
	}

	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		final int width = r - l;
		final int height = b - t;
		if (Debug.makeSymbolicBoolean("x0")) {
		}
	}

	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int width = Debug.makeSymbolicInteger("x0");
		int height = Debug.makeSymbolicInteger("x1");
		final int contentWidth = Debug.makeSymbolicInteger("x2");
		final int contentHeight = Debug.makeSymbolicInteger("x3");
		if (Debug.makeSymbolicBoolean("x4")) {
		}
	}

	public void setMode(int mode) {
		int mMode = Debug.makeSymbolicInteger("x4");
		if (mode == Debug.makeSymbolicInteger("x0") || mode == Debug.makeSymbolicInteger("x1")) {
			if (Debug.makeSymbolicBoolean("x2")) {
			}
			if (Debug.makeSymbolicBoolean("x3")) {
			}
		}
		mMode = mode;
	}

	public int getMode() {
		int mMode = Debug.makeSymbolicInteger("x0");
		return mMode;
	}

	public void setScrollScale(float scrollScale) {
		float mScrollScale = (float) Debug.makeSymbolicReal("x0");
		mScrollScale = scrollScale;
	}

	public float getScrollScale() {
		float mScrollScale = (float) Debug.makeSymbolicReal("x0");
		return mScrollScale;
	}

	public void setShadowWidth(int width) {
		int mShadowWidth = Debug.makeSymbolicInteger("x0");
		mShadowWidth = width;
	}

	public void setFadeEnabled(boolean b) {
		boolean mFadeEnabled = Debug.makeSymbolicBoolean("x0");
		mFadeEnabled = b;
	}

	public void setFadeDegree(float degree) {
		float mFadeDegree = (float) Debug.makeSymbolicReal("x0");
		if (degree > 1.0f || degree < 0.0f)
			throw new IllegalStateException("The BehindFadeDegree must be between 0.0f and 1.0f");
		mFadeDegree = degree;
	}

	public int getMenuPage(int page) {
		int mMode = Debug.makeSymbolicInteger("x0");
		page = (page > 1) ? 2 : ((page < 1) ? 0 : page);
		if (mMode == Debug.makeSymbolicInteger("x1") && page > 1) {
			return 0;
		} else if (mMode == Debug.makeSymbolicInteger("x2") && page < 1) {
			return 2;
		} else {
			return page;
		}
	}

	public void setTouchMode(int i) {
		int mTouchMode = Debug.makeSymbolicInteger("x0");
		mTouchMode = i;
	}

	public boolean menuClosedSlideAllowed(float dx) {
		int mMode = Debug.makeSymbolicInteger("x0");
		if (mMode == Debug.makeSymbolicInteger("x1")) {
			return dx > 0;
		} else if (mMode == Debug.makeSymbolicInteger("x2")) {
			return dx < 0;
		} else if (mMode == Debug.makeSymbolicInteger("x3")) {
			return true;
		}
		return false;
	}

	public boolean menuOpenSlideAllowed(float dx) {
		int mMode = Debug.makeSymbolicInteger("x0");
		if (mMode == Debug.makeSymbolicInteger("x1")) {
			return dx < 0;
		} else if (mMode == Debug.makeSymbolicInteger("x2")) {
			return dx > 0;
		} else if (mMode == Debug.makeSymbolicInteger("x3")) {
			return true;
		}
		return false;
	}

	public void setSelectorEnabled(boolean b) {
		boolean mSelectorEnabled = Debug.makeSymbolicBoolean("x0");
		mSelectorEnabled = b;
	}

	private int getSelectorTop() {
		int y = Debug.makeSymbolicInteger("x0");
		y += Debug.makeSymbolicInteger("x1") / 2;
		return y;
	}

}
