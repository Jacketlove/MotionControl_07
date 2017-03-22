package com.tswe.common.constant;

/**
 * 板卡类型枚举
 *  S8440A       = 0,
 *  B6612        = 1,
 *  S8250        = 2,
 *  B6308        = 3,
 *  S8440B       = 4,
 *  B6428        = 5,
 *  M9550        = 6,
 *  P2250        = 7,
 *  C3850        = 8,
 * @author Administrator
 *
 */
public enum ControlBoardTypeEnum {
	
	S8440A("S8440A", 0,
			ControlBoardTypeCfg.MAX_AXIS_NUM_S8440A, 
			ControlBoardTypeCfg.MAX_IN_GPIO_NUM_S8440A, 
			ControlBoardTypeCfg.MAX_OUT_GPIO_NUM_S8440A),
	
	B6612("B6612", 1,
			ControlBoardTypeCfg.MAX_AXIS_NUM_B6612, 
			ControlBoardTypeCfg.MAX_IN_GPIO_NUM_B6612, 
			ControlBoardTypeCfg.MAX_OUT_GPIO_NUM_B6612),
	
	S8250("S8250", 2,
			ControlBoardTypeCfg.MAX_AXIS_NUM_S8250, 
			ControlBoardTypeCfg.MAX_IN_GPIO_NUM_S8250, 
			ControlBoardTypeCfg.MAX_OUT_GPIO_NUM_S8250),
	
	B6308("B6308", 3,
			ControlBoardTypeCfg.MAX_AXIS_NUM_B6308, 
			ControlBoardTypeCfg.MAX_IN_GPIO_NUM_B6308, 
			ControlBoardTypeCfg.MAX_OUT_GPIO_NUM_B6308),
	
	S8440B("S8440B", 4,
			ControlBoardTypeCfg.MAX_AXIS_NUM_S8440B, 
			ControlBoardTypeCfg.MAX_IN_GPIO_NUM_S8440B, 
			ControlBoardTypeCfg.MAX_OUT_GPIO_NUM_S8440B,
			ControlBoardTypeCfg.MAX_IN_EXPAND_NUM_S8440B,
			ControlBoardTypeCfg.MAX_OUT_EXPAND_NUM_S8440B),
	
	B6428("B6428", 5,
			ControlBoardTypeCfg.MAX_AXIS_NUM_B6428, 
			ControlBoardTypeCfg.MAX_IN_GPIO_NUM_B6428, 
			ControlBoardTypeCfg.MAX_OUT_GPIO_NUM_B6428),
	
	M9550("M9550", 6,
			ControlBoardTypeCfg.MAX_AXIS_NUM_M9550, 
			ControlBoardTypeCfg.MAX_IN_GPIO_NUM_M9550, 
			ControlBoardTypeCfg.MAX_OUT_GPIO_NUM_M9550,
			ControlBoardTypeCfg.MAX_IN_EXPAND_NUM_M9550,
			ControlBoardTypeCfg.MAX_OUT_EXPAND_NUM_M9550),
	
	P2250("P2250", 7,
			ControlBoardTypeCfg.MAX_AXIS_NUM_P2250, 
			ControlBoardTypeCfg.MAX_IN_GPIO_NUM_P2250, 
			ControlBoardTypeCfg.MAX_OUT_GPIO_NUM_P2250),
	
	C3850("C3850", 8,
			ControlBoardTypeCfg.MAX_AXIS_NUM_C3850, 
			ControlBoardTypeCfg.MAX_IN_GPIO_NUM_C3850, 
			ControlBoardTypeCfg.MAX_OUT_GPIO_NUM_C3850);
	
	
	//类型名称
	private String nameString;
	//对应类型编号
	private int number;
	//�?大轴�?
	private int maxAxisNum;
	//输入IO数量
	private int maxInGpioNum;
	//输出IO数量
	private int maxOutGpioNum;
	//扩展慢�?�输入IO数量
	private int maxInExpendNum;
	//扩张慢�?�输出IO数量
	private int maxOutExpendNum;
	
	
	
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getMaxAxisNum() {
		return maxAxisNum;
	}
	public void setMaxAxisNum(int maxAxisNum) {
		this.maxAxisNum = maxAxisNum;
	}
	public int getMaxInGpioNum() {
		return maxInGpioNum;
	}
	public void setMaxInGpioNum(int maxInGpioNum) {
		this.maxInGpioNum = maxInGpioNum;
	}
	public int getMaxOutGpioNum() {
		return maxOutGpioNum;
	}
	public void setMaxOutGpioNum(int maxOutGpioNum) {
		this.maxOutGpioNum = maxOutGpioNum;
	}
	public int getMaxInExpendNum() {
		return maxInExpendNum;
	}
	public void setMaxInExpendNum(int maxInExpendNum) {
		this.maxInExpendNum = maxInExpendNum;
	}
	public int getMaxOutExpendNum() {
		return maxOutExpendNum;
	}
	public void setMaxOutExpendNum(int maxOutExpendNum) {
		this.maxOutExpendNum = maxOutExpendNum;
	}
	
	private ControlBoardTypeEnum(String nameString, int number, int maxAxisNum, int maxInGpioNum, int maxOutGpioNum,
			int maxInExpendNum, int maxOutExpendNum) {
		this.nameString = nameString;
		this.number = number;
		this.maxAxisNum = maxAxisNum;
		this.maxInGpioNum = maxInGpioNum;
		this.maxOutGpioNum = maxOutGpioNum;
		this.maxInExpendNum = maxInExpendNum;
		this.maxOutExpendNum = maxOutExpendNum;
	}
	
	private ControlBoardTypeEnum(String nameString, int number, int maxAxisNum, int maxInGpioNum, int maxOutGpioNum) {
		this.nameString = nameString;
		this.number = number;
		this.maxAxisNum = maxAxisNum;
		this.maxInGpioNum = maxInGpioNum;
		this.maxOutGpioNum = maxOutGpioNum;
		this.maxInExpendNum = 0;
		this.maxOutExpendNum = 0;
	}
	
	@Override
	public String toString() {
		String temp = new String();
		temp += "ControlBoardTypeEnum.nameString: "+ nameString+"\n";
		temp += "ControlBoardTypeEnum.number: "+ number+"\n";
		temp += "ControlBoardTypeEnum.maxAxisNum: "+ maxAxisNum+"\n";
		temp += "ControlBoardTypeEnum.maxInGpioNum: "+ maxInGpioNum+"\n";
		temp += "ControlBoardTypeEnum.maxOutGpioNum: "+ maxOutGpioNum+"\n";
		temp += "ControlBoardTypeEnum.maxInExpendNum: "+ maxInExpendNum+"\n";
		temp += "ControlBoardTypeEnum.maxOutExpendNum: "+ maxOutExpendNum+"\n";
		return super.toString()+temp;
	}
}
