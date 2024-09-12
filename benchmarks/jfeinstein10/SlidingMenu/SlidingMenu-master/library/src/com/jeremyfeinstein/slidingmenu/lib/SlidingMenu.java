package com.jeremyfeinstein.slidingmenu.lib;

import gov.nasa.jpf.symbc.Debug;
import java.lang.reflect.Method;

public class SlidingMenu {

	/**
	 * Set the above view content from a layout resource. The resource will be inflated, adding all top-level views
	 * to the above view.
	 *
	 * @param res the new content
	 */
	public void setContent(int res) {
	}

	/**
	 * Retrieves the current content.
	 * @return the current content
	 */
	public Object getContent() {
		return new Object();
	}

	/**
	 * Set the behind view (menu) content from a layout resource. The resource will be inflated, adding all top-level views
	 * to the behind view.
	 *
	 * @param res the new content
	 */
	public void setMenu(int res) {
	}

	/**
	 * Retrieves the main menu.
	 * @return the main menu
	 */
	public Object getMenu() {
		return new Object();
	}

	/**
	 * Set the secondary behind view (right menu) content from a layout resource. The resource will be inflated, adding all top-level views
	 * to the behind view.
	 *
	 * @param res the new content
	 */
	public void setSecondaryMenu(int res) {
	}

	/**
	 * Retrieves the current secondary menu (right).
	 * @return the current menu
	 */
	public Object getSecondaryMenu() {
		return new Object();
	}


	/**
	 * Sets the sliding enabled.
	 *
	 * @param b true to enable sliding, false to disable it.
	 */
	public void setSlidingEnabled(boolean b) {
	}

	/**
	 * Checks if is sliding enabled.
	 *
	 * @return true, if is sliding enabled
	 */
	public boolean isSlidingEnabled() {
		return Debug.makeSymbolicBoolean("x0");
	}

	/**
	 * Sets which side the SlidingMenu should appear on.
	 * @param mode must be either SlidingMenu.LEFT or SlidingMenu.RIGHT
	 */
	public void setMode(int mode) {
		int LEFT_RIGHT = Debug.makeSymbolicInteger("x2");
		int RIGHT = Debug.makeSymbolicInteger("x1");
		int LEFT = Debug.makeSymbolicInteger("x0");
		if (mode != LEFT && mode != RIGHT && mode != LEFT_RIGHT) {
			throw new IllegalStateException("SlidingMenu mode must be LEFT, RIGHT, or LEFT_RIGHT");
		}
	}

	/**
	 * Returns the current side that the SlidingMenu is on.
	 * @return the current mode, either SlidingMenu.LEFT or SlidingMenu.RIGHT
	 */
	public int getMode() {
		return Debug.makeSymbolicInteger("x0");
	}

	/**
	 * Sets whether or not the SlidingMenu is in static mode (i.e. nothing is moving and everything is showing)
	 *
	 * @param b true to set static mode, false to disable static mode.
	 */
	public void setStatic(boolean b) {
		if (b) {
		} else {
		}
	}

	/**
	 * Opens the menu and shows the menu view.
	 */
	public void showMenu() {
	}

	/**
	 * Opens the menu and shows the menu view.
	 *
	 * @param animate true to animate the transition, false to ignore animation
	 */
	public void showMenu(boolean animate) {
	}

	/**
	 * Opens the menu and shows the secondary menu view. Will default to the regular menu
	 * if there is only one.
	 */
	public void showSecondaryMenu() {
	}

	/**
	 * Opens the menu and shows the secondary (right) menu view. Will default to the regular menu
	 * if there is only one.
	 *
	 * @param animate true to animate the transition, false to ignore animation
	 */
	public void showSecondaryMenu(boolean animate) {
	}

	/**
	 * Closes the menu and shows the above view.
	 */
	public void showContent() {
	}

	/**
	 * Closes the menu and shows the above view.
	 *
	 * @param animate true to animate the transition, false to ignore animation
	 */
	public void showContent(boolean animate) {
	}

	/**
	 * Toggle the SlidingMenu. If it is open, it will be closed, and vice versa.
	 */
	public void toggle() {
	}

	/**
	 * Toggle the SlidingMenu. If it is open, it will be closed, and vice versa.
	 *
	 * @param animate true to animate the transition, false to ignore animation
	 */
	public void toggle(boolean animate) {
		if (Debug.makeSymbolicBoolean("x0")) {
		} else {
		}
	}

	/**
	 * Checks if is the behind view showing.
	 *
	 * @return Whether or not the behind view is showing
	 */
	public boolean isMenuShowing() {
		return Debug.makeSymbolicBoolean("x2");
	}
	
	/**
	 * Checks if is the behind view showing.
	 *
	 * @return Whether or not the behind view is showing
	 */
	public boolean isSecondaryMenuShowing() {
		return Debug.makeSymbolicInteger("x0") == 2;
	}

	/**
	 * Gets the behind offset.
	 *
	 * @return The margin on the right of the screen that the behind view scrolls to
	 */
	public int getBehindOffset() {
		return Debug.makeSymbolicInteger("x0");
	}

	/**
	 * Sets the behind offset.
	 *
	 * @param i The margin, in pixels, on the right of the screen that the behind view scrolls to.
	 */
	public void setBehindOffset(int i) {
	}

	/**
	 * Sets the behind offset.
	 *
	 * @param resID The dimension resource id to be set as the behind offset.
	 * The menu, when open, will leave this width margin on the right of the screen.
	 */
	public void setBehindOffsetRes(int resID) {
		int i = (int) Debug.makeSymbolicInteger("x0");
	}

	/**
	 * Sets the above offset.
	 *
	 * @param i the new above offset, in pixels
	 */
	public void setAboveOffset(int i) {
	}

	/**
	 * Sets the above offset.
	 *
	 * @param resID The dimension resource id to be set as the above offset.
	 */
	public void setAboveOffsetRes(int resID) {
		int i = (int) Debug.makeSymbolicInteger("x0");
	}

	/**
	 * Sets the behind width.
	 *
	 * @param i The width the Sliding Menu will open to, in pixels
	 */
	public void setBehindWidth(int i) {
		int width;
		try {
			width = Debug.makeSymbolicInteger("x0");
		} catch (Exception e) {
			width = Debug.makeSymbolicInteger("x1");
		}
	}

	/**
	 * Sets the behind width.
	 *
	 * @param res The dimension resource id to be set as the behind width offset.
	 * The menu, when open, will open this wide.
	 */
	public void setBehindWidthRes(int res) {
		int i = (int) Debug.makeSymbolicInteger("x0");
	}

	/**
	 * Gets the behind scroll scale.
	 *
	 * @return The scale of the parallax scroll
	 */
	public float getBehindScrollScale() {
		return (float) Debug.makeSymbolicReal("x0");
	}
	
	/**
	 * Gets the touch mode margin threshold
	 * @return the touch mode margin threshold
	 */
	public int getTouchmodeMarginThreshold() {
		return Debug.makeSymbolicInteger("x0");
	}
	
	/**
	 * Set the touch mode margin threshold
	 * @param touchmodeMarginThreshold
	 */
	public void setTouchmodeMarginThreshold(int touchmodeMarginThreshold) {
	}

	/**
	 * Sets the behind scroll scale.
	 *
	 * @param f The scale of the parallax scroll (i.e. 1.0f scrolls 1 pixel for every
	 * 1 pixel that the above view scrolls and 0.0f scrolls 0 pixels)
	 */
	public void setBehindScrollScale(float f) {
		if (f < 0 && f > 1)
			throw new IllegalStateException("ScrollScale must be between 0 and 1");
	}

	/**
	 * Gets the touch mode above.
	 *
	 * @return the touch mode above
	 */
	public int getTouchModeAbove() {
		return Debug.makeSymbolicInteger("x0");
	}

	/**
	 * Controls whether the SlidingMenu can be opened with a swipe gesture.
	 * Options are {@link #TOUCHMODE_MARGIN TOUCHMODE_MARGIN}, {@link #TOUCHMODE_FULLSCREEN TOUCHMODE_FULLSCREEN},
	 * or {@link #TOUCHMODE_NONE TOUCHMODE_NONE}
	 *
	 * @param i the new touch mode
	 */
	public void setTouchModeAbove(int i) {
		int TOUCHMODE_NONE = Debug.makeSymbolicInteger("x2");
		int TOUCHMODE_MARGIN = Debug.makeSymbolicInteger("x1");
		int TOUCHMODE_FULLSCREEN = Debug.makeSymbolicInteger("x0");
		if (i != TOUCHMODE_FULLSCREEN && i != TOUCHMODE_MARGIN
				&& i != TOUCHMODE_NONE) {
			throw new IllegalStateException("TouchMode must be set to either" +
					"TOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
		}
	}

	/**
	 * Controls whether the SlidingMenu can be opened with a swipe gesture.
	 * Options are {@link #TOUCHMODE_MARGIN TOUCHMODE_MARGIN}, {@link #TOUCHMODE_FULLSCREEN TOUCHMODE_FULLSCREEN},
	 * or {@link #TOUCHMODE_NONE TOUCHMODE_NONE}
	 *
	 * @param i the new touch mode
	 */
	public void setTouchModeBehind(int i) {
		int TOUCHMODE_NONE = Debug.makeSymbolicInteger("x2");
		int TOUCHMODE_MARGIN = Debug.makeSymbolicInteger("x1");
		int TOUCHMODE_FULLSCREEN = Debug.makeSymbolicInteger("x0");
		if (i != TOUCHMODE_FULLSCREEN && i != TOUCHMODE_MARGIN
				&& i != TOUCHMODE_NONE) {
			throw new IllegalStateException("TouchMode must be set to either" +
					"TOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
		}
	}

	/**
	 * Sets the shadow drawable.
	 *
	 * @param resId the resource ID of the new shadow drawable
	 */
	public void setShadowDrawable(int resId) {
	}

	/**
	 * Sets the secondary (right) shadow drawable.
	 *
	 * @param resId the resource ID of the new shadow drawable
	 */
	public void setSecondaryShadowDrawable(int resId) {
	}

	/**
	 * Sets the shadow width.
	 *
	 * @param resId The dimension resource id to be set as the shadow width.
	 */
	public void setShadowWidthRes(int resId) {
	}

	/**
	 * Sets the shadow width.
	 *
	 * @param pixels the new shadow width, in pixels
	 */
	public void setShadowWidth(int pixels) {
	}

	/**
	 * Enables or disables the SlidingMenu's fade in and out
	 *
	 * @param b true to enable fade, false to disable it
	 */
	public void setFadeEnabled(boolean b) {
	}

	/**
	 * Sets how much the SlidingMenu fades in and out. Fade must be enabled, see
	 * {@link #setFadeEnabled(boolean) setFadeEnabled(boolean)}
	 *
	 * @param f the new fade degree, between 0.0f and 1.0f
	 */
	public void setFadeDegree(float f) {
	}

	/**
	 * Enables or disables whether the selector is drawn
	 *
	 * @param b true to draw the selector, false to not draw the selector
	 */
	public void setSelectorEnabled(boolean b) {
	}

	/**
	 * Sets the selector drawable.
	 *
	 * @param res a resource ID for the selector drawable
	 */
	public void setSelectorDrawable(int res) {
	}

	/**
	 * Clear the list of Views ignored by the Touch Down event when mode is Fullscreen
	 */
	public void clearIgnoredViews() {
	}

	public static class SavedState {

		public int getItem() {
			int mItem = Debug.makeSymbolicInteger("x0");
			return mItem;
		}

	}

	/* (non-Javadoc)
	 * @see android.view.View#onSaveInstanceState()
	 */
	protected Object onSaveInstanceState() {
		return new Object();
	}

	public void manageLayers(float percentOpen) {
		if (Debug.makeSymbolicInteger("x0") < 11) return;

		boolean layer = percentOpen > 0.0f && percentOpen < 1.0f;
		final int layerType = layer ? Debug.makeSymbolicInteger("x1") : Debug.makeSymbolicInteger("x2");

		if (layerType != Debug.makeSymbolicInteger("x3")) {
		}
	}

}
