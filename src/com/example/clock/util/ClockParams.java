package com.example.clock.util;

import android.graphics.Paint;
import android.graphics.Point;

/**
 * ʱ�ӵĸ��ֲ���
 * 
 * @author kyson
 * 
 */
public class ClockParams {
	/**
	 * ����
	 */
	public Paint clockPanelPaint;

	/**
	 * ��̶ȣ�3��6��9��12�̶�
	 */
	public Paint bigTickPaint;
	/**
	 * ����̶�
	 */
	public Paint middleTickPaint;
	/**
	 * ���ӿ̶�
	 */
	public Paint smallTickPaint;

	/**
	 * ����ָ��
	 */
	public Paint minutePointerPaint;
	/**
	 * ʱ��ָ��
	 */
	public Paint hourPointerPaint;
	/**
	 * ���̰뾶
	 */
	public int radius;
	/**
	 * ʱ�Ӱ뾶
	 */
	public float hourRadius;
	/**
	 * ����뾶
	 */
	public float minuteRadius;
	/**
	 * Բ��
	 */
	public Paint centerPaint;
	/**
	 * Բ��λ��
	 */
	public Point centerPoint;
	/**
	 * Բ�İ뾶
	 */
	public int centerRadius;
}
