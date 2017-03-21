package com.tswe.common.constant;


public class Constant {
	//操作系统位数，用于调用对应的dll
	public static final String systemBit;
	static{
		systemBit = String.valueOf(System.getProperties().get("sun.arch.data.model"));
	}
	
	
	/********************************************************************************/
	/****************************各个类型板卡的基本参数配置********************************/
	
	public static final int MAX_AXIS_NUM = 6;//----此处增大需要修改界面
	public static final int MAX_IN_GPIO_NUM = 32;  //通用输入端口数----此处增大需要修改界面
	public static final int MAX_OUT_GPIO_NUM = 28;  //通用输出端口数----此处增大需要修改界面
	public static final int MAX_IN_EXPAND_NUM = 32;  //扩展输入端口数
	public static final int MAX_OUT_EXPAND_NUM = 32;  //扩展输出端口数

	public static final int MAX_AXIS_NUM_S8250 = 2;   //S8250
	public static final int MAX_IN_GPIO_NUM_S8250 = 26;  //通用输入端口数
	public static final int MAX_OUT_GPIO_NUM_S8250 = 28;  //通用输出端口数******MAX

	public static final int MAX_AXIS_NUM_S8440A = 4;   //S8440旧板=103ZET6;
	public static final int MAX_IN_GPIO_NUM_S8440A = 20;  //通用输入端口数
	public static final int MAX_OUT_GPIO_NUM_S8440A = 18;  //通用输出端口数

	public static final int MAX_AXIS_NUM_B6612 =6;   //B6612
	public static final int MAX_IN_GPIO_NUM_B6612 = 16;  //通用输入端口数,0+16
	public static final int MAX_OUT_GPIO_NUM_B6612 = 28;  //通用输出端口数,12+16

	public static final int MAX_AXIS_NUM_B6308 = 3;   //B6308
	public static final int MAX_IN_GPIO_NUM_B6308 = 16;  //通用输入端口数,0+16
	public static final int MAX_OUT_GPIO_NUM_B6308 = 24;  //通用输出端口数,8+16

	public static final int MAX_AXIS_NUM_S8440B = 4;   //S8440B
	public static final int MAX_IN_GPIO_NUM_S8440B = 20;  //通用输入端口数
	public static final int MAX_OUT_GPIO_NUM_S8440B = 20;  //通用输出端口数
	public static final int MAX_IN_EXPAND_NUM_S8440B = 8;   //扩展慢速IN
	public static final int MAX_OUT_EXPAND_NUM_S8440B = 8;   //扩展慢速OUT

	public static final int MAX_AXIS_NUM_B6428 = 4;   //B6428
	public static final int MAX_IN_GPIO_NUM_B6428 = 32;  //通用输入端口数,16+16******MAX
	public static final int MAX_OUT_GPIO_NUM_B6428 =27;  //通用输出端口数,12+15

	public static final int MAX_AXIS_NUM_M9550 = 5;   //M9550
	public static final int MAX_AXIS_NUM_M9550_ENCODER = 3;   //S轴
	public static final int MAX_IN_GPIO_NUM_M9550 =24;  //通用输入端口数
	public static final int MAX_OUT_GPIO_NUM_M9550 =24;  //通用输出端口数
	public static final int MAX_IN_EXPAND_NUM_M9550 =12;  //扩展慢速IN
	public static final int MAX_OUT_EXPAND_NUM_M9550 =12;  //扩展慢速OUT

	public static final int MAX_AXIS_NUM_P2250 =2;   //P2250
	public static final int MAX_IN_GPIO_NUM_P2250 =24;  //通用输入端口数,24
	public static final int MAX_OUT_GPIO_NUM_P2250 =21;  //通用输出端口数,21

	public static final int MAX_AXIS_NUM_C3850 =8;   //C3850******MAX
	public static final int MAX_IN_GPIO_NUM_C3850 =21;  //通用输入端口数,21
	public static final int MAX_OUT_GPIO_NUM_C3850 =24;  //通用输出端口数,24
	
	
	
}
