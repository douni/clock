package com.example.clock.util;

import android.graphics.Paint;
import android.graphics.Point;

/**
 * 时钟的各种参数
 * 
 * @author kyson
 * 
 */
public class ClockParams {
	/**
	 * 表盘
	 */
	public Paint clockPanelPaint;

	/**
	 * 大刻度，3、6、9、12刻度
	 */
	public Paint bigTickPaint;
	/**
	 * 整点刻度
	 */
	public Paint middleTickPaint;
	/**
	 * 分钟刻度
	 */
	public Paint smallTickPaint;

	/**
	 * 分钟指针
	 */
	public Paint minutePointerPaint;
	/**
	 * 时钟指针
	 */
	public Paint hourPointerPaint;
	/**
	 * 表盘半径
	 */
	public int radius;
	/**
	 * 时钟半径
	 */
	public float hourRadius;
	/**
	 * 分针半径
	 */
	public float minuteRadius;
	/**
	 * 圆心
	 */
	public Paint centerPaint;
	/**
	 * 圆心位置
	 */
	public Point centerPoint;
	/**
	 * 圆心半径
	 */
	public int centerRadius;
}
