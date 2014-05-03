package com.example.clock.widget;

import com.example.clock.util.Point2AngleUtil;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
/**
 * ����
 * @author kyson
 *
 */
public class SmallPointer extends AbsPointer {
	/**
	 * �Ƕȷ����仯������
	 * 
	 * @author kyson
	 * 
	 */
	public interface OnAngleChangedListener {
		void onAngleChanged(boolean isAdd, double angle);
	}

	private OnAngleChangedListener mOnAngleChangedListener;

	public SmallPointer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public SmallPointer(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public SmallPointer(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public void setOnAngleChangedListener(
			OnAngleChangedListener onAngleChangedListener) {
		this.mOnAngleChangedListener = onAngleChangedListener;
	}

	@Override
	public boolean onTouchEvent(MotionEvent motionEvent) {
		double preAngle = 0;
		switch (motionEvent.getAction()) {
		case MotionEvent.ACTION_DOWN:
			preAngle = mAngle;
			mAngle =  pointToAngle(motionEvent.getX(), motionEvent.getY());
			commitChanged(preAngle, mAngle);
			break;
		case MotionEvent.ACTION_MOVE:
			preAngle = mAngle;
			mAngle =  pointToAngle(motionEvent.getX(), motionEvent.getY());
			commitChanged(preAngle, mAngle);
			break;
		case MotionEvent.ACTION_UP:

			break;
		}
		postInvalidate();
		return true;
	}

	/**
	 * ֪ͨ���������ݱ仯
	 * @param pre
	 * @param cur
	 */
	private void commitChanged(double pre,double cur){
		if (mOnAngleChangedListener != null) {
			AngleChange angleChange = angleToChange(pre, cur);
			mOnAngleChangedListener.onAngleChanged(angleChange.isAdd,angleChange.changedAngle);
		}
	}

	public static final double DIFFER_CHANGE = 180d;

	/**
	 * �Ƕȵı仯
	 * 
	 * @author kyson
	 * 
	 */
	public class AngleChange {
		/**
		 * ���ӻ����
		 */
		public boolean isAdd;
		/**
		 * �仯�ĽǶȣ���ֵ
		 */
		public double changedAngle;
	}

	/**
	 * ���ǶȻ���Ϊ�Ƕȵı仯ֵ�����ǽǶȵ��ٽ�ֵ ÿ�α仯ֵ����ܴ�
	 * 
	 * @param preAngle
	 * @param curAngle
	 */
	private AngleChange angleToChange(double preAngle, double curAngle) {
		AngleChange angleChange = new AngleChange();
		//�仯Ϊ����С���߱仯���ĺܶࣨ����300��
		if (curAngle >= preAngle && (curAngle - preAngle) < DIFFER_CHANGE) {
			angleChange.changedAngle = curAngle - preAngle;
			angleChange.isAdd = true;
			return angleChange;
		}
		if((curAngle - preAngle) < -DIFFER_CHANGE){
			angleChange.changedAngle = 360 + curAngle -  preAngle;
			angleChange.isAdd = true;
			return angleChange;
		}
		//�仯Ϊ����С���߱仯���ܶ�
		if(curAngle <= preAngle && (curAngle - preAngle) > -DIFFER_CHANGE){
			angleChange.isAdd = false;
			angleChange.changedAngle = preAngle - curAngle;
			return angleChange;
		}
	    if((curAngle - preAngle) > DIFFER_CHANGE){
			angleChange.isAdd = false;
			angleChange.changedAngle = 360 + preAngle - curAngle;
			return angleChange;
		}
	    return null;
	}

	/**
	 * ��ת��Ϊ�Ƕ�
	 * 
	 * @return
	 */
	private double pointToAngle(double x, double y) {
		return Point2AngleUtil.pointToAngle(x, y, mCenterX, mCenterY);
	}
}
