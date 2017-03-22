package com.tswe.common.constant;


public class Constant {
	
	//操作系统位数，用于调用对应的dll
	public static final String systemBit;
	static{
		systemBit = String.valueOf(System.getProperties().get("sun.arch.data.model"));
	}
	
	//X轴编号
	public static final int XAXIA=0;
	//X轴长度
	public static int XAXIALENDTH;
	//Y轴编号
	public static final int YAXIA=1;
	//Y轴长度
	public static int YAXIALENDTH;
	//Z轴编号
	public static final int ZAXIA=2;
	//Z轴长度
	public static int ZAXIALENDTH;
	//W轴编号
	public static final int WAXIA=3;
	
	//原点信号低电平有效
	public static final int ORGVALIDLOGIC = 0;
	//回原点运动 高速
	public static final int HIGHV = 1;
	//回原点运动 低速
	public static final int LOWV = 0;
	//回原点运动  正向运动回原点
	public static final int POSITIVE = 1;
	//回原点运动  反向运动回原点
	public static final int REVERSE = 2;
}
