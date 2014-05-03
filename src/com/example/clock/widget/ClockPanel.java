package com.example.clock.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/**
 * 表盘
 * @author kyson
 *
 */
public class ClockPanel extends View {
	private Paint mClockPaint;
	private Paint mTickBigPaint;
	private Paint mTickMiddlePaint;
	private Paint mTickSmallPaint;
	private Paint mCenterPaint;

	/**
	 * 表盘圆心坐标X
	 */
	private float mCenterX;
	/**
	 * 表盘圆心坐标Y
	 */
	private float mCenterY;
	private float mRadius;
	private float mCenterRadius;

	public ClockPanel(Context context) {
		super(context);
	}

	public ClockPanel(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
	}

	public ClockPanel(Context context, AttributeSet attributeSet, int defStytle) {
		super(context, attributeSet, defStytle);
	}

	public void invalidate() {
		super.invalidate();
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		/**
		 * 外形
		 */
		canvas.drawCircle(mCenterX, mCenterY, mRadius, this.mClockPaint);

		/**
		 * 画圆形时钟的刻度，每6度便有一个刻度
		 */
		for (int i = 0; i < 360; i = i + 6) {
			if (i % 90 == 0) {
				drawTick(canvas, this.mTickBigPaint, i);
			} else if (i % 30 == 0) {
				drawTick(canvas, this.mTickMiddlePaint, i);
			} else {
				drawTick(canvas, this.mTickSmallPaint, i);
			}
		}
		/**
		 * 圆心
		 */
		canvas.drawCircle(mCenterX, mCenterY, mCenterRadius, this.mCenterPaint);
	}

	/**
	 * 画刻度
	 * 
	 * @param canvas
	 * @param paint
	 * @param angle
	 */
	private void drawTick(Canvas canvas, Paint paint, int angle) {
		canvas.drawPoint(
				mCenterX + (int) (mRadius * Math.cos(Math.PI * angle / 180.0D)),
				mCenterY + (int) (mRadius * Math.sin(Math.PI * angle / 180.0D)),
				paint);
	}

	public boolean onTouchEvent(MotionEvent motionEvent) {
		switch (motionEvent.getAction()) {
		}
		return super.onTouchEvent(motionEvent);
	}

	public Paint getmClockPaint() {
		return mClockPaint;
	}

	public void setmClockPaint(Paint mClockPaint) {
		this.mClockPaint = mClockPaint;
	}

	public Paint getmTickBigPaint() {
		return mTickBigPaint;
	}

	public void setmTickBigPaint(Paint mTickBigPaint) {
		this.mTickBigPaint = mTickBigPaint;
	}

	public Paint getmTickMiddlePaint() {
		return mTickMiddlePaint;
	}

	public void setmTickMiddlePaint(Paint mTickMiddlePaint) {
		this.mTickMiddlePaint = mTickMiddlePaint;
	}

	public Paint getmTickSmallPaint() {
		return mTickSmallPaint;
	}

	public void setmTickSmallPaint(Paint mTickSmallPaint) {
		this.mTickSmallPaint = mTickSmallPaint;
	}

	public Paint getmCenterPaint() {
		return mCenterPaint;
	}

	public void setmCenterPaint(Paint mCenterPaint) {
		this.mCenterPaint = mCenterPaint;
	}

	public float getmCenterX() {
		return mCenterX;
	}

	public void setmCenterX(int mCenterX) {
		this.mCenterX = mCenterX;
	}

	public float getmCenterY() {
		return mCenterY;
	}

	public void setmCenterY(int mCenterY) {
		this.mCenterY = mCenterY;
	}

	public float getmRadius() {
		return mRadius;
	}

	public void setmRadius(int mRadius) {
		this.mRadius = mRadius;
	}

	public float getmCenterRadius() {
		return mCenterRadius;
	}

	public void setmCenterRadius(int mCenterRadius) {
		this.mCenterRadius = mCenterRadius;
	}
}
