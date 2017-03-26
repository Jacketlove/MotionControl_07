package com.tswe.autotest.model;

import com.tswe.common.util.JNAInvokeDll;

public class Drv {
	
	/********************************************************************************
	 ********************************** 板级初始化  *************************************
	 ********************************************************************************/
	
	/***
	 * 功能描述: 控制板初始化
	 * 
	 * @param void
	 * @return 0：无卡； 1-16：实际卡数,最大支持16张卡
	 * @version 0.1
	 */
	public int controlBoardInit(){
		return JNAInvokeDll.motionDrvDll.motion_board_init();
	}
	
	/***
	 * 控制板初始化(串口)
	 * 
	 * @param void
	 * @return 0：无卡； 1：实际卡数,最大支持1张卡
	 * @version 0.1
	 */
	public int controlBoardInitSerial(){
		return JNAInvokeDll.motionDrvDll.motion_board_init_serial();
	}
	
	/**
	 * 关闭所有卡
	 * 
	 * @param void
	 * @return void
	 * @version 0.1
	 */
	public void controlBoardClose(){
		JNAInvokeDll.motionDrvDll.motion_board_close();
	}
	
	/********************************************************************************
	 ******************************** 设置速度参数 **************************************
	 ********************************************************************************/
	
	/**
	 * 设置多轴插补运动的矢量速度曲线
	 * 
	 * @param axis 轴号
	 *            
	 * @param Min_Vel
	 *            起始速度，单位pps
	 * @param Max_Vel
	 *            运行速度，单位pps
	 * @param Tacc
	 *            总加速时间，单位s
	 * @param Tdec
	 *            总减速时间，单位s
	 * @version 0.1
	 */
	public void setVectorProfile(double Min_Vel, double Max_Vel, double Tacc, double Tdec) {
		JNAInvokeDll.motionDrvDll.motion_set_vector_profile(Min_Vel, Max_Vel, Tacc, Tdec);
	}

	/**
	 * 设置多轴插补运动的S形加速(按S段时间)矢量速度曲线
	 * 
	 * @param axis 轴号
	 *            
	 * @param Min_Vel
	 *            起始速度，单位pps
	 * @param Max_Vel
	 *            运行速度，单位pps
	 * @param Tacc
	 *            总加速时间，单位s
	 * @param Tdec
	 *            总减速时间，单位s
	 * @version 0.1
	 */
	public void setStVectorProfile(double Min_Vel, double Max_Vel, double Tacc, double STacc) {
		JNAInvokeDll.motionDrvDll.motion_set_st_vector_profile(Min_Vel, Max_Vel, Tacc, STacc);
	}
}
