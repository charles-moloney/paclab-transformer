package com.jacob.circle.disc;

import gov.nasa.jpf.symbc.Debug;

/**
 * Package : com.jacob.circle.disc
 * Author : jacob
 * Date : 15-4-1
 * Description : 这个类是用�?�xxx
 */
public class CircleIndexView {

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        float mCenterXY = (float) Debug.makeSymbolicReal("x9");
		int width = 0;
        int height = 0;

        int widthSize = Debug.makeSymbolicInteger("x0");
        int widthMode = Debug.makeSymbolicInteger("x1");

        int heightSize = Debug.makeSymbolicInteger("x2");
        int heightMode = Debug.makeSymbolicInteger("x3");

        if (widthMode == Debug.makeSymbolicInteger("x4")) {
            width = widthSize;
        } else {
            width = Debug.makeSymbolicInteger("x5");
        }

        if (heightMode == Debug.makeSymbolicInteger("x6")) {
            height = heightSize;
        } else {
            height = Debug.makeSymbolicInteger("x7");
        }

        int layoutSize = Debug.makeSymbolicInteger("x8");
        mCenterXY = layoutSize / 2.0f;
        int count = Debug.makeSymbolicInteger("x10");
        for (int i = 0; i < count; i++) {
        }
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            int childW = Debug.makeSymbolicInteger("x0");
            int childH = Debug.makeSymbolicInteger("x1");

            int left = Debug.makeSymbolicInteger("x2") / 2 - childW / 2;
            int top = Debug.makeSymbolicInteger("x3") / 2 - childH / 2;
        }
    }


    /**
     * 当旋转圆盘�?�需�?更新中心点的View的背景
     */
    private void updateCenterLetterAndView() {
        float sPerAngle = (float) Debug.makeSymbolicReal("x2");
		float mStartAngle = (float) Debug.makeSymbolicReal("x1");
		float mAngle = (float) Debug.makeSymbolicReal("x0");
		int index = Debug.makeSymbolicInteger("x4");
        int length = Debug.makeSymbolicInteger("x5");
        if (index > 0) {
            index = (length - index) % length;
        } else {
            index = Debug.makeSymbolicInteger("x6");
        }
        if (Debug.makeSymbolicBoolean("x7")){
        }
    }


    /**
     * 获得当�?触摸点所在第几象�?
     */
    private int getQuaDrant(float x, float y) {
        float mCenterXY = (float) Debug.makeSymbolicReal("x0");
		float tempX = x - mCenterXY;
        float tempY = y - mCenterXY;

        if (tempX >= 0 && tempY <= 0) {
            return 1;
        } else if (tempX >= 0 && tempY >= 0) {
            return 4;
        } else if (tempX <= 0 && tempY <= 0) {
            return 2;
        } else {
            return 3;
        }
    }

    /**
     * 获�?��?个触摸点的角度
     */
    private float getTranslateAngle(float xTouch, float yTouch) {
        float mCenterXY = (float) Debug.makeSymbolicReal("x0");
		float x = xTouch - mCenterXY;
        float y = yTouch - mCenterXY;
        float distance = (float) (float) Debug.makeSymbolicReal("x1");
        return (float) Debug.makeSymbolicReal("x4");
    }

    private int dpToPx(int dp) {
        return (int) Debug.makeSymbolicInteger("x0");
    }
}
