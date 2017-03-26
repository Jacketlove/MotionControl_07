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
	public static final boolean YES = true;
	public static final boolean NO = false;
	
	/*********************************轴相关参数********************************/
	/**************轴编号*************/
	//X轴编号
	public static final int XAXIA = 0;
	//Y轴编号
	public static final int YAXIA = 1;
	//Z轴编号
	public static final int ZAXIA = 2;
	//W轴编号
	public static final int WAXIA = 3;
	//T轴编号
	public static final int TAXIA = 4;
	
	/***********速度曲线类型************/
	//T形
	public static final int TV = 0;
	//S形
	public static final int SV = 1;
	//恒定
	public static final int CV = 2;
	
	/***********状态相关************/
	//轴繁忙，则bussnessFlag置0
	public static final boolean ISBUSYNESS 	= true;
	//轴空闲，则bussnessFlag置1
	public static final boolean NOBUSYNESS 	= false;
	//轴在运动  则返回 RUNNING
	public static final boolean RUNNING 	= true;
	//轴在停止中 则返回 STOPING
	public static final boolean STOPING 	= false;
	
	/***********脉冲输出模式************/
	//脉冲输出模式0  初始化为0
	public static final int PULSEMODEZERO 	= 0;
	//脉冲输出模式1
	public static final int PULSEMODEONE 	= 1;
	//脉冲输出模式2
	public static final int PULSEMODETOW 	= 2;
	//脉冲输出模式3
	public static final int PULSEMODETHREE 	= 3;
	//脉冲输出模式4
	public static final int PULSEMODEFOUR 	= 4;
	//脉冲输出模式5
	public static final int PULSEMODEFIVE 	= 5;
	
	/***********脉冲输出模式************/
	//0-立即停,低有效   初始化为0
	public static final int ELMODEZERO		= 0;
	//1-减速停,低有效
	public static final int ELMODEONE		= 1;
	//2-立即停,高有效
	public static final int ELMODETWO		= 2;
	//3-减速停,高有效
	public static final int ELMODETHREE		= 3;
	
	/***********原点运动相关**************/
	//ORG信号低电平有效  默认为低电平有效
	public static final int ORGENABLELOW 	= 0;
	//ORG信号高电平有效
	public static final int ORGENABLEHIGH 	= 1;
	//回原点滤波使能 默认使能
	public static final int ORGFILTERENABLE = 1;
	//回原点铝箔禁止
	public static final int ORGFILTERDISABLE= 0;
	//0-只计home
	public static final int ORGMODEZERO		= 0;
	//1-home和EZ,目前只支持0
	public static final int ORGMODEONE		= 1;
	//回原点运动 高速
	public static final int HIGHV 			= 1;
	//回原点运动 低速
	public static final int LOWV 			= 0;
	//回原点运动  正向运动回原点
	public static final int POSITIVEGOHOME 	= 1;
	//回原点运动  反向运动回原点
	public static final int REVERSEGOHOME 	= 2;
}
