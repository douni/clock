package com.example.clock.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.example.clock.util.ClockParams;
import com.example.clock.widget.SmallPointer.OnAngleChangedListener;

/**
 * 时钟类，主类，使用前先执行init
 * 
 * @author kyson
 * 
 */
public class ClockWidget extends ViewGroup {
	/**
	 * 圆心X
	 */
	public static final int DEFAULT_CIRCLE_CENTER_X = 240;
	/**
	 * 圆心Y
	 */
	public static final int DEFAULT_CIRCLE_CENTER_Y = 400;
	/**
	 * 表盘半径
	 */
	public static final int DEFAULT_CIRCLE_RADIUS = 200;
	/**
	 * 圆心半径
	 */
	public static final int DEFAULT_CIRCLE_CENTER_RADIUS = 10;

	/**
	 * addview使用
	 */
	private static final int INDEX_PANEL = 0;
	private static final int INDEX_HOUR_POINTER = 1;
	private static final int INDEX_MINUTE_POINTER = 2;

	private Context mContext;
	/**
	 * 表盘
	 */
	private ClockPanel mClockPanel;
	/**
	 * 时钟指针
	 */
	private BigPointer mBigPointer;
	/**
	 * 分钟指针
	 */
	private SmallPointer mSmallPointer;

	public ClockWidget(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}

	public ClockWidget(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}

	public ClockWidget(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}

	/**
	 * 供外部调用
	 */
	public void init(ClockParams mClockParams) {
		initView(mClockParams);
		initEvent();
	}

	private void initView(ClockParams mClockParams) {
		mClockPanel = new ClockPanel(mContext);
		mClockPanel.setmTickBigPaint(mClockParams.bigTickPaint);
		mClockPanel.setmTickMiddlePaint(mClockParams.middleTickPaint);
		mClockPanel.setmTickSmallPaint(mClockParams.smallTickPaint);
		mClockPanel.setmCenterPaint(mClockParams.centerPaint);
		mClockPanel.setmClockPaint(mClockParams.clockPanelPaint);
		mClockPanel.setmCenterRadius(mClockParams.centerRadius);
		mClockPanel.setmCenterX(mClockParams.centerPoint.x);
		mClockPanel.setmCenterY(mClockParams.centerPoint.y);
		mClockPanel.setmRadius(mClockParams.radius);
		this.addView(mClockPanel, INDEX_PANEL);

		mBigPointer = new BigPointer(mContext);
		mBigPointer
				.init(mClockParams.hourRadius, mClockParams.hourPointerPaint);
		mBigPointer.setmCenterX(mClockParams.centerPoint.x);
		mBigPointer.setmCenterY(mClockParams.centerPoint.y);
		this.addView(mBigPointer, INDEX_HOUR_POINTER);

		mSmallPointer = new SmallPointer(mContext);
		mSmallPointer.init(mClockParams.minuteRadius,
				mClockParams.minutePointerPaint);
		mSmallPointer.setmCenterX(mClockParams.centerPoint.x);
		mSmallPointer.setmCenterY(mClockParams.centerPoint.y);

		this.addView(mSmallPointer, INDEX_MINUTE_POINTER);
	}

	private void initEvent() {
		mSmallPointer.setOnAngleChangedListener(new OnAngleChangedListener() {

			@Override
			public void onAngleChanged(boolean isAdd, double angle) {
				// TODO Auto-generated method stub
				mBigPointer.postAngle(isAdd, minuteToHourAngle(angle));
			}
		});
	}

	/**
	 * 时间转化率
	 */
	public static final double CONVERTION_PERCENT = 60d;

	/**
	 * 分钟的指针角度差转化为时针的角度差
	 * 
	 * @param isAdd
	 * @param angle
	 * @return
	 */
	private double minuteToHourAngle(double angle) {
		return angle / CONVERTION_PERCENT;
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		mClockPanel.layout(l, t, r, b);
		mBigPointer.layout(l, t, r, b);
		mSmallPointer.layout(l, t, r, b);
	}

	public static class ParamsBuilder {
		private ClockParams mClockParams;

		public ParamsBuilder() {
			this.mClockParams = new ClockParams();
		}

		/**
		 * 设置表盘边框
		 * 
		 * @param paint
		 * @return
		 */
		public ParamsBuilder setPanelPaint(Paint paint) {
			mClockParams.clockPanelPaint = paint;
			return this;
		}

		/**
		 * 3点6点9点12点刻度
		 * 
		 * @param paint
		 */
		public ParamsBuilder setTSNTHourTickPaint(Paint paint) {
			mClockParams.bigTickPaint = paint;
			return this;
		}

		/**
		 * 设置小时的刻度paint
		 * 
		 * @param paint
		 */
		public ParamsBuilder setHourTickPaint(Paint paint) {
			mClockParams.middleTickPaint = paint;
			return this;
		}

		/**
		 * 分钟刻度线
		 * 
		 * @param paint
		 */
		public ParamsBuilder setMinuteTickPaint(Paint paint) {
			mClockParams.smallTickPaint = paint;
			return this;
		}

		/**
		 * 时钟指针
		 * 
		 * @param paint
		 */
		public ParamsBuilder setHourPointerPaint(Paint paint) {
			mClockParams.hourPointerPaint = paint;
			return this;
		}

		/**
		 * 分钟指针
		 * 
		 * @param paint
		 */
		public ParamsBuilder setMinutePointerPaint(Paint paint) {
			mClockParams.minutePointerPaint = paint;
			return this;
		}

		/**
		 * 圆心
		 * 
		 * @param paint
		 * @return
		 */
		public ParamsBuilder setCenterPaint(Paint paint) {
			mClockParams.centerPaint = paint;
			return this;
		}

		/**
		 * 圆心半径
		 * 
		 * @param centerRadius
		 * @return
		 */
		public ParamsBuilder setCenterRadius(int centerRadius) {
			mClockParams.centerRadius = centerRadius;
			return this;
		}

		/**
		 * 圆心位置
		 * 
		 * @param centerPoint
		 * @return
		 */
		public ParamsBuilder setCenterPoint(Point centerPoint) {
			mClockParams.centerPoint = centerPoint;
			return this;
		}

		/**
		 * 表盘半径
		 * 
		 * @param radius
		 * @return
		 */
		public ParamsBuilder setRadius(int radius) {
			mClockParams.radius = radius;
			return this;
		}

		private void setPaint(Paint paint, int color, Paint.Style style,
				float strokeWidth) {
			paint.setColor(color);
			paint.setStyle(style);
			paint.setAntiAlias(true);
			paint.setStrokeWidth(strokeWidth);
		}

		public ClockParams createClockParams() {
			if (mClockParams.bigTickPaint == null) {
				mClockParams.bigTickPaint = new Paint();
				setPaint(mClockParams.bigTickPaint, Color.BLACK,
						Paint.Style.STROKE, 18.0F);
			}
			if (mClockParams.middleTickPaint == null) {
				mClockParams.middleTickPaint = new Paint();
				setPaint(mClockParams.middleTickPaint, Color.DKGRAY,
						Paint.Style.STROKE, 12.0F);
			}
			if (mClockParams.smallTickPaint == null) {
				mClockParams.smallTickPaint = new Paint();
				setPaint(mClockParams.smallTickPaint, Color.DKGRAY,
						Paint.Style.STROKE, 8.0F);
			}
			if (mClockParams.hourPointerPaint == null) {
				mClockParams.hourPointerPaint = new Paint();
				setPaint(mClockParams.hourPointerPaint, Color.DKGRAY,
						Paint.Style.STROKE, 10.0F);
			}
			if (mClockParams.minutePointerPaint == null) {
				mClockParams.minutePointerPaint = new Paint();
				setPaint(mClockParams.minutePointerPaint, Color.DKGRAY,
						Paint.Style.STROKE, 5.0F);
			}
			if (mClockParams.centerPaint == null) {
				mClockParams.centerPaint = new Paint();
				setPaint(mClockParams.centerPaint, Color.DKGRAY,
						Paint.Style.STROKE, 12.0F);
			}
			if (mClockParams.clockPanelPaint == null) {
				mClockParams.clockPanelPaint = new Paint();
				setPaint(mClockParams.clockPanelPaint, Color.DKGRAY,
						Paint.Style.STROKE, 6.0F);
			}
			if (mClockParams.centerPoint == null) {
				mClockParams.centerPoint = new Point(DEFAULT_CIRCLE_CENTER_X,
						DEFAULT_CIRCLE_CENTER_Y);
			}
			if (mClockParams.centerRadius == 0) {
				mClockParams.centerRadius = DEFAULT_CIRCLE_CENTER_RADIUS;
			}
			if (mClockParams.radius == 0) {
				mClockParams.radius = DEFAULT_CIRCLE_RADIUS;
			}
			if (mClockParams.minuteRadius == 0) {
				mClockParams.minuteRadius = DEFAULT_CIRCLE_RADIUS * 0.8f;
			}
			if (mClockParams.hourRadius == 0) {
				mClockParams.hourRadius = DEFAULT_CIRCLE_RADIUS * 0.5f;
			}
			return mClockParams;
		}
	}
}
