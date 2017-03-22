package com.tswe.autotest.model;

import java.util.EnumSet;
import java.util.HashMap;

import com.tswe.common.constant.ControlBoardTypeEnum;
import com.tswe.common.util.JNAInvokeDll;

public class ControlBoard {
	//卡号
	private int controlBoardNum;
	//轴列表
	private Axis[] axias;
	//输入端口Map, Integer对应端口号
	private HashMap<Integer, Boolean> Inports;
	//输出端口Map, Integer对应端口号
	private HashMap<Integer, Boolean> outports;
	//板卡类型
	private ControlBoardTypeEnum controlBoardTypeEnum;
	
	public ControlBoard(int cardno) {
		this.controlBoardNum = cardno;
		configControlBoard();
	}
	
	public void configControlBoard(){
		motionGetCardType();
		//定义轴数量
		this.axias = new Axis[controlBoardTypeEnum.getMaxAxisNum()];
		//实例化轴
		for(int i=0; i<controlBoardTypeEnum.getMaxAxisNum(); i++){
			this.axias[i] = new Axis(i);
		}
	}
	
	/**
	 * 配置急停信号输入
	 * 
	 * @param enable 0无效,1有效
	 * @param emg_logic 0低有效,1高有效
	 * @return void
	 * @version 0.1
	 */
	public void configEMGPin(int enable, int emg_logic){
		JNAInvokeDll.motionDrvDll.motion_config_EMG_PIN(this.controlBoardNum, enable, emg_logic);
	}
	
	/*********************************************************************************
	 **********************************  通用IO读写    ***********************************
	 *********************************************************************************/
	
	/***
	 * 读取通用输入端口信号
	 * 
	 * @param controlBoardNum 卡号
	 * @param bitno  bitno  端口号,取值范围:B6612(1~16)、S8250(1~26)、B6308(1~16)、S8440(1~20)
	 * @return 0-低电平, 1-高电平
	 * @version 0.1
	 */
	public int ReadInbit(int bitno){
		return JNAInvokeDll.motionDrvDll.motion_read_inbit(this.controlBoardNum, bitno);
	}
	
	/**
	 * 写通用输出信号
	 * 
	 * @param bitno  端口号,取值范围:B6612(1~16)、S8250(1~26)、B6308(1~16)、S8440(1~20)
	 * @return 0-低电平, 1-高电平
	 * @version 0.1
	 */
	public void writeOutbit(int bitno, int on_off){
		JNAInvokeDll.motionDrvDll.motion_write_outbit(this.controlBoardNum, bitno, on_off);
	}
	
	/**
	 * 读取通用输出信号
	 * 
	 * @param controlBoardNum 卡号
	 * @param bitno  端口号,取值范围:B6612(1~28)、S8250(1~28)、B6308(1~24)、S8440(1~20)
	 * @return 0-低电平, 1-高电平
	 * @version 0.1
	 */
	public void readOutbit(int bitno){
		JNAInvokeDll.motionDrvDll.motion_read_outbit(this.controlBoardNum, bitno);
	}
	
	/**
	 * 读取指定控制卡的全部通用输入口的电平状态
	 * 
	 * @param controlBoardNum 卡号
	 * @return  bit0～bit(N-1)位值分别代表第1～N号输入端口值,N取值范围：
	 * 			B6612(1~16)、S8250(1~26)、B6308(1~16)、S8440(1~20)
	 *  		0-低电平, 1-高电平
	 * @version 0.1
	 */
	public int readInport(){
		int temp = JNAInvokeDll.motionDrvDll.motion_read_inport(this.controlBoardNum);
		for(int i=0; i<controlBoardTypeEnum.getMaxInGpioNum(); i++){
			Inports.put(i, (temp|(1<<i))>0);
		}
		return temp;
	}
	
	/**
	 * 指定控制卡的全部通用输出口的电平状态
	 * 
	 * @param controlBoardNum 卡号
	 * @param  port_value bit0～bit(N-1)位值分别代表第1～N号输入端口值,N取值范围：
	 * 			B6612(1~28)、S8250(1~28)、B6308(1~24)、S8440(1~20)
	 *  		0-低电平, 1-高电平
	 * @version 0.1
	 */
	public void writeOutport(int port_value){
		JNAInvokeDll.motionDrvDll.motion_write_outport(this.controlBoardNum, port_value);
	}
	
	/**
	 * 4轴(0-3轴)以对称的梯形加减速作直线插补
	 * 
	 * @param controlBoardNum 卡号
	 * @param Dist1 指定插补轴1的位移值，单位：脉冲数 
	 * @param Dist2 指定插补轴2的位移值，单位：脉冲数
	 * @param Dist3 指定插补轴3的位移值，单位：脉冲数
	 * @param Dist4    指定插补轴4的位移值，单位：脉冲数 
	 * @param  posi_mode 位移模式设定：0表示相对位移，1表示绝对位移
	 * 		  	当 posi_mode=0 时，作相对位移运动，运动方向由Dist的正负值确定；
	 *    		为posi_mode=1，作绝对位移运动，运动方向由Dist与当前位置的差值决定
	 * @version 0.1
	 */
	public void motionTLine4(int Dist1, int Dist2, int Dist3, int Dist4, int posi_mode){
		JNAInvokeDll.motionDrvDll.motion_t_line4(this.controlBoardNum, Dist1, Dist2, Dist3, Dist4, posi_mode);
	}
	
	/**
	 * 设置锁存方式为单轴锁存或是四轴同时锁存.暂时不支持该功能
	 * @param cardno       卡号
     * @param all_enable   锁存方式
     * 					   0－单独锁存
     *                     1－四轴同时锁存
	 * @version 0.1
	 */
//	public void motionConfigLatch_mode(int all_enable){
//		JNAInvokeDll.motionDrvDll.motion_config_latch_mode(this.cardno, all_enable);
//	}
	
	/**
	 * 选择全部锁存时外触发信号的通道.暂时不支持该功能
	 * 可以由二个信号通道输入,端子LTC1或者LTC2；默认为LTC1
	 * @param controlBoardNum       卡号
     * @param Num      信号通道选择： 
     * 				   1－ 通过端子LTC1锁存四个轴
     *          	   2－ 通过端子LTC2锁存四个轴 
	 * @version 0.1
	 */
	public void motionTrigerChunnel(int num){
		JNAInvokeDll.motionDrvDll.motion_triger_chunnel(this.controlBoardNum, num);
	}
	
	/**
	 * 查询卡类型
	 * 
	 * @param controlBoardNum 卡号0-15
	 * @return 0xFF:无效卡类型, 1:B6612, 2:S8250, 3:B6308, 4:S8440, 5:B6428, 6:M9550, 其它值保留
	 * @version 0.1
	 */
	public void motionGetCardType(){
		int temp;
		temp = JNAInvokeDll.motionDrvDll.motion_get_card_type(controlBoardNum);
		for(ControlBoardTypeEnum controlBoardTypeEnum: 
			EnumSet.range(ControlBoardTypeEnum.S8440A,ControlBoardTypeEnum.C3850)){
			if(controlBoardTypeEnum.getNumber() == temp){
				this.controlBoardTypeEnum = controlBoardTypeEnum;
			}
		}
	}
	
	/**
	 * 配置急停信号输入
	 * 
	 * @param controlBoardNum 卡号
	 * @param enable 0无效,1有效
	 * @param emg_logic 0低有效,1高有效
	 * @return void
	 * @version 0.1
	 */
	public void motionConfigEMGPIN(int enable, int emg_logic){
		JNAInvokeDll.motionDrvDll.motion_config_EMG_PIN(this.controlBoardNum, enable, emg_logic);
	}

	
	
	public HashMap<Integer, Boolean> getInports() {
		return Inports;
	}

	public void setInports(HashMap<Integer, Boolean> inports) {
		Inports = inports;
	}

	public HashMap<Integer, Boolean> getOutports() {
		return outports;
	}

	public void setOutports(HashMap<Integer, Boolean> outports) {
		this.outports = outports;
	}

	public int getCardno() {
		return controlBoardNum;
	}

	public Axis[] getAxias() {
		return axias;
	}

	public ControlBoardTypeEnum getControlBoardTypeEnum() {
		return controlBoardTypeEnum;
	}

	@Override
	public String toString() {
		String inforString = new String();
		inforString += "cardno:"+controlBoardNum+"\n";
		inforString += controlBoardTypeEnum;
		return inforString;
	}
}
