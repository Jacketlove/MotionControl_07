package com.tswe.common.constant;


public class Constant {
	
	//操作系统位数，用于调用对应的dll
	public static final String systemBit;
	static{
		//读取操作系统位数
		systemBit = String.valueOf(System.getProperties().get("sun.arch.data.model"));
	}
	
	//板卡编号
	public static final int CONTROLBOARDNUM = 0;
	//X轴编号
	public static final int XAXIA = 0;
	//X轴长度
	public static int XAXIALENDTH;
	//Y轴编号
	public static final int YAXIA = 1;
	//Y轴长度
	public static int YAXIALENDTH;
	//Z轴编号
	public static final int ZAXIA = 2;
	//Z轴长度
	public static int ZAXIALENDTH;
	//W轴编号
	public static final int WAXIA = 3;
	//W轴长度
	public static int WAXIALENDTH;
	//T轴编号
	public static final int TAXIA = 4;
	//脉冲输出模式  默认0
	public static final int PULSEMODE = 0;
	
	//原点信号低电平有效
	public static final int ORGVALIDLOGIC = 0;
	//回原点运动 高速
	public static final int HIGHV = 1;
	//回原点运动 低速
	public static final int LOWV = 0;
	//回原点运动  正向运动回原点
	public static final int POSITIVEGOHOME = 1;
	//回原点运动  反向运动回原点
	public static final int REVERSEGOHOME = 2;
	//EL模式
	public static final int ELMODE = 0;
	//轴繁忙，则bussnessFlag置0
	public static final int ISBUSYNESS = 0;
	//轴空闲，则bussnessFlag置1
	public static final int NOBUSYNESS = 1;
	
	
	//速度曲线类型
	public static final int TV = 0;
	public static final int SV = 1;
}
