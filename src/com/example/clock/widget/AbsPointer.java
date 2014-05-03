package com.example.clock.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/**
 * 指针抽象类
 * @author kyson
 *
 */
public abstract class AbsPointer extends View {
	/**
	 * 角度变化的临界值，也就是说，当角度从0到270之后，变为-90，然后增加
	 */
	public static final double CRITICAL = 270d;
	/**
	 * 圆心X，与表盘类的圆心保持一致
	 */
	protected float mCenterX;
	/**
	 * 圆心Y，与表盘类的圆心保持一致
	 */
	protected float mCenterY;
	/**
	 * 指针长度
	 */
	protected float mLength;
	/**
	 * 画笔
	 */
	protected Paint mPaint;
	/**
	 * 按长度或者比例
	 */
	// protected boolean isProportion;
	/**
	 * 角度
	 */
	protected double mAngle;

	public AbsPointer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public AbsPointer(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public AbsPointer(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 初始化画笔，长度等
	 */
	protected void init(float length, Paint paint) {
		this.mLength = length;
		this.mPaint = paint;
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		drawPointerByLength(canvas, mPaint, mAngle, mLength);
	}

	/**
	 * 画指针
	 * 
	 * @param canvas
	 * @param paint
	 * @param angle
	 * @param length
	 */
	private void drawPointerByLength(Canvas canvas, Paint paint, double angle,
			float length) {
		canvas.drawLine(mCenterX, mCenterY,
				mCenterX + (float) (length * Math.cos(Math.PI * angle / 180.0D)),
				mCenterY + (float) (length * Math.sin(Math.PI * angle / 180.0D)),
				paint);
	}

	public float getmLength() {
		return mLength;
	}

	public void setmLength(float mLength) {
		this.mLength = mLength;
	}

	public Paint getmPaint() {
		return mPaint;
	}

	public void setmPaint(Paint mPaint) {
		this.mPaint = mPaint;
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
}
