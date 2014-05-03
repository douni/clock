package com.example.clock.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/**
 * ָ�������
 * @author kyson
 *
 */
public abstract class AbsPointer extends View {
	/**
	 * �Ƕȱ仯���ٽ�ֵ��Ҳ����˵�����Ƕȴ�0��270֮�󣬱�Ϊ-90��Ȼ������
	 */
	public static final double CRITICAL = 270d;
	/**
	 * Բ��X����������Բ�ı���һ��
	 */
	protected float mCenterX;
	/**
	 * Բ��Y����������Բ�ı���һ��
	 */
	protected float mCenterY;
	/**
	 * ָ�볤��
	 */
	protected float mLength;
	/**
	 * ����
	 */
	protected Paint mPaint;
	/**
	 * �����Ȼ��߱���
	 */
	// protected boolean isProportion;
	/**
	 * �Ƕ�
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
	 * ��ʼ�����ʣ����ȵ�
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
	 * ��ָ��
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
