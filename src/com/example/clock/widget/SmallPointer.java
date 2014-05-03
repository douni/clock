package com.example.clock.widget;

import com.example.clock.util.Point2AngleUtil;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
/**
 * 分针
 * @author kyson
 *
 */
public class SmallPointer extends AbsPointer {
	/**
	 * 角度发生变化监听器
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
	 * 通知监听器数据变化
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
	 * 角度的变化
	 * 
	 * @author kyson
	 * 
	 */
	public class AngleChange {
		/**
		 * 增加或减少
		 */
		public boolean isAdd;
		/**
		 * 变化的角度，正值
		 */
		public double changedAngle;
	}

	/**
	 * 将角度换算为角度的变化值，考虑角度的临界值 每次变化值相差不会很大
	 * 
	 * @param preAngle
	 * @param curAngle
	 */
	private AngleChange angleToChange(double preAngle, double curAngle) {
		AngleChange angleChange = new AngleChange();
		//变化为正很小或者变化负的很多（差了300）
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
		//变化为负很小或者变化正很多
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
	 * 点转换为角度
	 * 
	 * @return
	 */
	private double pointToAngle(double x, double y) {
		return Point2AngleUtil.pointToAngle(x, y, mCenterX, mCenterY);
	}
}
