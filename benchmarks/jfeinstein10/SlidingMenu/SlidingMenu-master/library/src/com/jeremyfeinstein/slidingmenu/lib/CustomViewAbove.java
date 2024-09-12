package com.jeremyfeinstein.slidingmenu.lib;

import gov.nasa.jpf.symbc.Debug;
import java.util.ArrayList;
import java.util.List;

public class CustomViewAbove {

	/**
	 * Simple implementation of the {@link OnPageChangeListener} interface with stub
	 * implementations of each method. Extend this if you do not intend to override
	 * every method of {@link OnPageChangeListener}.
	 */
	public static class SimpleOnPageChangeListener {

		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			// This space for rent
		}

		public void onPageSelected(int position) {
			// This space for rent
		}

		public void onPageScrollStateChanged(int state) {
			// This space for rent
		}

	}

	void initCustomViewAbove() {
		int MIN_DISTANCE_FOR_FLING = Debug.makeSymbolicInteger("x8");
		int mFlingDistance = Debug.makeSymbolicInteger("x7");
		int mMaximumVelocity = Debug.makeSymbolicInteger("x4");
		int mMinimumVelocity = Debug.makeSymbolicInteger("x2");
		int mTouchSlop = Debug.makeSymbolicInteger("x0");
		mTouchSlop = Debug.makeSymbolicInteger("x1");
		mMinimumVelocity = Debug.makeSymbolicInteger("x3");
		mMaximumVelocity = Debug.makeSymbolicInteger("x5");
		final float density = (float) Debug.makeSymbolicReal("x6");
		mFlingDistance = (int) (MIN_DISTANCE_FOR_FLING * density);
	}

	/**
	 * Set the currently selected page. If the CustomViewPager has already been through its first
	 * layout there will be a smooth animated transition between the current item and the
	 * specified item.
	 *
	 * @param item Item index to select
	 */
	public void setCurrentItem(int item) {
	}

	/**
	 * Set the currently selected page.
	 *
	 * @param item Item index to select
	 * @param smoothScroll True to smoothly scroll to the new item, false to transition immediately
	 */
	public void setCurrentItem(int item, boolean smoothScroll) {
	}

	public int getCurrentItem() {
		int mCurItem = Debug.makeSymbolicInteger("x0");
		return mCurItem;
	}

	void setCurrentItemInternal(int item, boolean smoothScroll, boolean always) {
	}

	void setCurrentItemInternal(int item, boolean smoothScroll, boolean always, int velocity) {
		int mCurItem = Debug.makeSymbolicInteger("x0");
		if (!always && mCurItem == item) {
			return;
		}

		item = Debug.makeSymbolicInteger("x1");

		final boolean dispatchSelected = mCurItem != item;
		mCurItem = item;
		final int destX = Debug.makeSymbolicInteger("x2");
		if (dispatchSelected && Debug.makeSymbolicBoolean("x3")) {
		}
		if (dispatchSelected && Debug.makeSymbolicBoolean("x4")) {
		}
		if (smoothScroll) {
		} else {
		}
	}

	public void clearIgnoredViews() {
	}

	// We want the duration of the page snap animation to be influenced by the distance that
	// the screen has to travel, however, we don't want this duration to be effected in a
	// purely linear fashion. Instead, we use this method to moderate the effect that the distance
	// of travel has on the overall snap duration.
	float distanceInfluenceForSnapDuration(float f) {
		f -= 0.5f; // center the values about 0.
		f *= (float) Debug.makeSymbolicReal("x1") / 2.0f;
		return (float) (float) Debug.makeSymbolicReal("x2");
	}

	public int getDestScrollX(int page) {
		return 0;
	}

	private int getLeftBound() {
		return Debug.makeSymbolicInteger("x0");
	}

	private int getRightBound() {
		return Debug.makeSymbolicInteger("x0");
	}

	public int getContentLeft() {
		return Debug.makeSymbolicInteger("x0");
	}

	public boolean isMenuOpen() {
		int mCurItem = Debug.makeSymbolicInteger("x0");
		return mCurItem == 0 || mCurItem == 2;
	}

	public int getBehindWidth() {
		if (Debug.makeSymbolicBoolean("x0")) {
			return 0;
		} else {
			return Debug.makeSymbolicInteger("x1");
		}
	}

	public int getChildWidth(int i) {
	}

	public boolean isSlidingEnabled() {
		boolean mEnabled = Debug.makeSymbolicBoolean("x0");
		return mEnabled;
	}

	public void setSlidingEnabled(boolean b) {
		boolean mEnabled = Debug.makeSymbolicBoolean("x0");
		mEnabled = b;
	}

	/**
	 * Like {@link View#scrollBy}, but scroll smoothly instead of immediately.
	 *
	 * @param x the number of pixels to scroll by on the X axis
	 * @param y the number of pixels to scroll by on the Y axis
	 */
	void smoothScrollTo(int x, int y) {
	}

	/**
	 * Like {@link View#scrollBy}, but scroll smoothly instead of immediately.
	 *
	 * @param x the number of pixels to scroll by on the X axis
	 * @param y the number of pixels to scroll by on the Y axis
	 * @param velocity the velocity associated with a fling, if applicable. (0 otherwise)
	 */
	void smoothScrollTo(int x, int y, int velocity) {
		int MAX_SETTLE_DURATION = Debug.makeSymbolicInteger("x13");
		boolean mScrolling = Debug.makeSymbolicBoolean("x6");
		if (Debug.makeSymbolicInteger("x0") == 0) {
			return;
		}
		int sx = Debug.makeSymbolicInteger("x1");
		int sy = Debug.makeSymbolicInteger("x2");
		int dx = x - sx;
		int dy = y - sy;
		if (dx == 0 && dy == 0) {
			if (Debug.makeSymbolicBoolean("x3")) {
				if (Debug.makeSymbolicBoolean("x4")) {
				}
			} else {
				if (Debug.makeSymbolicBoolean("x5")) {
				}
			}
			return;
		}

		mScrolling = true;

		final int width = Debug.makeSymbolicInteger("x7");
		final int halfWidth = width / 2;
		final float distanceRatio = (float) Debug.makeSymbolicReal("x8");
		final float distance = halfWidth + halfWidth *
				Debug.makeSymbolicInteger("x9");

		int duration = 0;
		velocity = Debug.makeSymbolicInteger("x10");
		if (velocity > 0) {
			duration = 4 * Debug.makeSymbolicInteger("x11");
		} else {
			final float pageDelta = (float) (float) Debug.makeSymbolicReal("x12") / width;
			duration = (int) ((pageDelta + 1) * 100);
			duration = MAX_SETTLE_DURATION;
		}
		duration = Debug.makeSymbolicInteger("x14");
	}

	public Object getContent() {
		return new Object();
	}

	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int width = Debug.makeSymbolicInteger("x0");
		int height = Debug.makeSymbolicInteger("x1");
		final int contentWidth = Debug.makeSymbolicInteger("x2");
		final int contentHeight = Debug.makeSymbolicInteger("x3");
	}

	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// Make sure scroll position is set correctly.
		if (w != oldw) {
		}
	}

	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		final int width = r - l;
		final int height = b - t;
	}

	public void setAboveOffset(int i) {
	}


	public void computeScroll() {
		if (Debug.makeSymbolicBoolean("x0")) {
			if (Debug.makeSymbolicBoolean("x1")) {
				int oldX = Debug.makeSymbolicInteger("x2");
				int oldY = Debug.makeSymbolicInteger("x3");
				int x = Debug.makeSymbolicInteger("x4");
				int y = Debug.makeSymbolicInteger("x5");

				if (oldX != x || oldY != y) {
				}

				return;
			}
		}
	}

	private void pageScrolled(int xpos) {
		final int widthWithMargin = Debug.makeSymbolicInteger("x0");
		final int position = xpos / widthWithMargin;
		final int offsetPixels = xpos % widthWithMargin;
		final float offset = (float) offsetPixels / widthWithMargin;
	}

	/**
	 * This method will be invoked when the current page is scrolled, either as part
	 * of a programmatically initiated smooth scroll or a user initiated touch scroll.
	 * If you override this method you must call through to the superclass implementation
	 * (e.g. super.onPageScrolled(position, offset, offsetPixels)) before onPageScrolled
	 * returns.
	 *
	 * @param position Position index of the first page currently being displayed.
	 *                 Page position+1 will be visible if positionOffset is nonzero.
	 * @param offset Value from [0, 1) indicating the offset from the page at position.
	 * @param offsetPixels Value in pixels indicating the offset from position.
	 */
	protected void onPageScrolled(int position, float offset, int offsetPixels) {
		if (Debug.makeSymbolicBoolean("x0")) {
		}
		if (Debug.makeSymbolicBoolean("x1")) {
		}
	}

	private void completeScroll() {
		boolean mScrolling = Debug.makeSymbolicBoolean("x0");
		boolean needPopulate = mScrolling;
		if (needPopulate) {
			int oldX = Debug.makeSymbolicInteger("x1");
			int oldY = Debug.makeSymbolicInteger("x2");
			int x = Debug.makeSymbolicInteger("x3");
			int y = Debug.makeSymbolicInteger("x4");
			if (oldX != x || oldY != y) {
			}
			if (Debug.makeSymbolicBoolean("x5")) {
				if (Debug.makeSymbolicBoolean("x6")) {
				}
			} else {
				if (Debug.makeSymbolicBoolean("x7")) {
				}
			}
		}
		mScrolling = false;
	}

	public void setTouchMode(int i) {
		int mTouchMode = Debug.makeSymbolicInteger("x0");
		mTouchMode = i;
	}

	public int getTouchMode() {
		int mTouchMode = Debug.makeSymbolicInteger("x0");
		return mTouchMode;
	}

	private boolean thisSlideAllowed(float dx) {
		boolean DEBUG = Debug.makeSymbolicBoolean("x3");
		boolean allowed = false;
		if (Debug.makeSymbolicBoolean("x0")) {
			allowed = Debug.makeSymbolicBoolean("x1");
		} else {
			allowed = Debug.makeSymbolicBoolean("x2");
		}
		if (DEBUG) {
		}
		return allowed;
	}

	public void scrollTo(int x, int y) {
		float mScrollX = (float) Debug.makeSymbolicReal("x0");
		mScrollX = x;
	}

	private int determineTargetPage(float pageOffset, int velocity, int deltaX) {
		int mMinimumVelocity = Debug.makeSymbolicInteger("x3");
		int mFlingDistance = Debug.makeSymbolicInteger("x1");
		int mCurItem = Debug.makeSymbolicInteger("x0");
		int targetPage = mCurItem;
		if (Debug.makeSymbolicInteger("x2") > mFlingDistance && Debug.makeSymbolicInteger("x4") > mMinimumVelocity) {
			if (velocity > 0 && deltaX > 0) {
				targetPage -= 1;
			} else if (velocity < 0 && deltaX < 0){
				targetPage += 1;
			}
		} else {
			targetPage = (int) Debug.makeSymbolicInteger("x5");
		}
		return targetPage;
	}

	protected float getPercentOpen() {
		return (float) Debug.makeSymbolicReal("x0");
	}

	private void startDrag() {
		boolean mQuickReturn = Debug.makeSymbolicBoolean("x1");
		boolean mIsBeingDragged = Debug.makeSymbolicBoolean("x0");
		mIsBeingDragged = true;
		mQuickReturn = false;
	}

	private void endDrag() {
		int INVALID_POINTER = Debug.makeSymbolicInteger("x4");
		int mActivePointerId = Debug.makeSymbolicInteger("x3");
		boolean mIsUnableToDrag = Debug.makeSymbolicBoolean("x2");
		boolean mIsBeingDragged = Debug.makeSymbolicBoolean("x1");
		boolean mQuickReturn = Debug.makeSymbolicBoolean("x0");
		mQuickReturn = false;
		mIsBeingDragged = false;
		mIsUnableToDrag = false;
		mActivePointerId = INVALID_POINTER;

		if (Debug.makeSymbolicBoolean("x5")) {
		}
	}

	private void setScrollingCacheEnabled(boolean enabled) {
		boolean USE_CACHE = Debug.makeSymbolicBoolean("x1");
		boolean mScrollingCacheEnabled = Debug.makeSymbolicBoolean("x0");
		if (mScrollingCacheEnabled != enabled) {
			mScrollingCacheEnabled = enabled;
			if (USE_CACHE) {
				final int size = Debug.makeSymbolicInteger("x2");
				for (int i = 0; i < size; ++i) {
					if (Debug.makeSymbolicBoolean("x3")) {
					}
				}
			}
		}
	}

	public boolean arrowScroll(int direction) {
		if (Debug.makeSymbolicBoolean("x0")) {
		}

		boolean handled = false;

		if (Debug.makeSymbolicBoolean("x1")) {
			if (direction == Debug.makeSymbolicInteger("x2")) {
				handled = Debug.makeSymbolicBoolean("x3");
			} else if (direction == Debug.makeSymbolicInteger("x4")) {
				// If there is nothing to the right, or this is causing us to
				// jump to the left, then what we really want to do is page right.
				if (Debug.makeSymbolicBoolean("x5")) {
					handled = Debug.makeSymbolicBoolean("x6");
				} else {
					handled = Debug.makeSymbolicBoolean("x7");
				}
			}
		} else if (direction == Debug.makeSymbolicInteger("x8") || direction == Debug.makeSymbolicInteger("x9")) {
			// Trying to move left and nothing there; try to page.
			handled = Debug.makeSymbolicBoolean("x10");
		} else if (direction == Debug.makeSymbolicInteger("x11") || direction == Debug.makeSymbolicInteger("x12")) {
			// Trying to move right and nothing there; try to page.
			handled = Debug.makeSymbolicBoolean("x13");
		}
		if (handled) {
		}
		return handled;
	}

	boolean pageLeft() {
		int mCurItem = Debug.makeSymbolicInteger("x0");
		if (mCurItem > 0) {
			return true;
		}
		return false;
	}

	boolean pageRight() {
		int mCurItem = Debug.makeSymbolicInteger("x0");
		if (mCurItem < 1) {
			return true;
		}
		return false;
	}

}
