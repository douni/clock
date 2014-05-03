package com.example.clock.widget;


import android.content.Context;
import android.util.AttributeSet;
/**
 * 时针
 * @author kyson
 *
 */
public class BigPointer extends AbsPointer {

	public BigPointer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public BigPointer(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public BigPointer(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 根据角度更新
	 */
	public void postAngle(boolean isAdd, double angle) {
		if (isAdd) {
			mAngle += angle;
		} else {
			mAngle -= angle;
		}
		postInvalidate();
	}

}
