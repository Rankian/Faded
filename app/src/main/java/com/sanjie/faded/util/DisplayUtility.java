package com.sanjie.faded.util;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

/**
 * 屏幕操作工具类,包括:
 * 1.像素转换为DIP值, px2dip()
 * 2.DIP转换像素值,dip2px()
 * 3.像素转换为SP值,px2sp()
 * 4.SP转换为像素,sp2px()
 */
public class DisplayUtility {
	/**
	 * 将px值转换为dip或dp值，保证尺寸大小不变
	 * 
	 * @param context
	 * @param pxValue
	 *            （DisplayMetrics类中属性density）
	 * @return
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 将dip或dp值转换为px值，保证尺寸大小不变
	 * 
	 * @param context
	 * @param dipValue
	 *            （DisplayMetrics类中属性density）
	 * @return
	 */
	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

	/**
	 * 将px值转换为sp值，保证文字大小不变
	 * 
	 * @param context
	 * @param pxValue
	 *            （DisplayMetrics类中属性scaledDensity）
	 * @return
	 */
	public static int px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	/**
	 * 将sp值转换为px值，保证文字大小不变
	 * 
	 * @param context
	 * @param spValue
	 *            （DisplayMetrics类中属性scaledDensity）
	 * @return
	 */
	public static int sp2px(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}

	/**
	 * 取得当前手机屏幕宽度
	 *
	 * @return
	 */
	public static int getScreenWidth(Activity activity) {
		WindowManager manage = activity.getWindowManager();
		Display display = manage.getDefaultDisplay();
		return display.getWidth();
	}

	/**
	 * 取得当前手机屏幕高度
	 *
	 * @return
	 */
	public static int getScreenHeight(Activity activity) {
		WindowManager manage = activity.getWindowManager();
		Display display = manage.getDefaultDisplay();
		return display.getHeight();
	}
}
