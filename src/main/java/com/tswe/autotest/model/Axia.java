package com.tswe.autotest.model;

import com.tswe.common.util.JNAInvokeDll;

public class Axia {
	// 轴号
	int axis;
	
	/**
	 * 脉冲输出方式的设置
	 * 
	 * @param axis 轴号
	 *            
	 * @param outmode
	 *            输出模式（0-5）
	 * @return void
	 * @version 0.1
	 */
	public void setPulseOutmode(int outmode) {
		JNAInvokeDll.motionDrvDll.motion_set_pulse_outmode(this.axis, outmode);
	}

	/**
	 * 配置减速信号输入 暂时不支持该功能
	 * 
	 * @param axis 轴号
	 *            
	 * @param enable
	 *            0无效,1有效, 暂不支持使能
	 * @param sd_logic
	 *            0-低电平有效,1-高电平有效
	 * @param sd_mode
	 *            0-减速到起始速度,如果SD信号丢失,又开始加速 1-减速到起始速度,并停止,如果在减速过程中,SD信号丢失,又开始加速
	 *            2-锁存SD信号,并减速到起始速度 3-锁存SD信号,并减速到起始速度后停止
	 * @return void
	 * @version 0.1
	 */
//	public void configSDPin(int enable, int sd_logic, int sd_mode) {
//		JNAInvokeDll.motionDrvDll.motion_config_SD_PIN(this.axis, enable, sd_logic, sd_mode);
//	}

	/**
	 * 配置运动中变速信号输入 暂时不支持该功能
	 * 
	 * @param axis 轴号
	 *            
	 * @param enable
	 *            0无效,1有效, 暂不支持使能
	 * @param pcs_logic
	 * @return void
	 * @version 0.1
	 */
//	public void configPCSPin(int axis, int enable, int pcs_logic) {
//		JNAInvokeDll.motionDrvDll.motion_config_PCS_PIN(this.axis, enable, pcs_logic);
//	}

	/**
	 * 配置伺服到位信号输入 暂时不支持该功能
	 * 
	 * @param axis 轴号
	 *            
	 * @param enable
	 *            0无效,1有效, 暂不支持使能
	 * @param inp_logic
	 *            0低有效,1高有效
	 * @return void
	 * @version 0.1
	 */
//	public void configINPPin(int enable, int inp_logic) {
//		JNAInvokeDll.motionDrvDll.motion_config_INP_PIN(this.axis, enable, inp_logic);
//	}

	/**
	 * 配置误差清除信号输入.暂时不支持该功能
	 * 
	 * @param axis 轴号
	 *            
	 * @param enable
	 *            0无效,1有效, 暂不支持使能
	 * @return void
	 * @version 0.1
	 */
//	public void configERCPIN(int enable, int erc_logic, int erc_width, int erc_off_time) {
//		JNAInvokeDll.motionDrvDll.motion_config_ERC_PIN(this.axis, enable, erc_logic, erc_width, erc_off_time);
//	}

	/**
	 * 配置伺服告警信号输入.暂时不支持该功能
	 * 
	 * @return void
	 * @version 0.1
	 */
//	public void configALMPin(int axis, int alm_logic, int alm_action) {
//		JNAInvokeDll.motionDrvDll.motion_config_ALM_PIN(this.axis, alm_logic, alm_action);
//	}

	/**
	 * 配置限位信号工作模式
	 * 
	 * @param axis 轴号
	 * 
	 * @param el_mode
	 *            0-立即停,低有效 1-减速停,低有效 2-立即停,高有效 3-减速停,高有效
	 * @return void
	 * @version 0.1
	 */
	public void configELMode(int el_mode){
		JNAInvokeDll.motionDrvDll.motion_config_EL_MODE(this.axis, el_mode);
	}

	/**
	 * 配置编码器EZ信号输入.暂时不支持该功能
	 * 
	 * @param axis 轴号
	 * 
	 * @param ez_logic
	 *            EZ信号逻辑电平：0－低有效，1－高有效
	 * @param ez_mode
	 *            EZ信号的工作方式： 0－EZ信号无效 1－EZ是计数器复位信号 2－EZ是原点信号，且不复位计数器
	 *            3－EZ是原点信号，且复位计数器
	 * @return void
	 * @version 0.1
	 */
//	public void configEZPin(int ez_logic, int ez_mode) {
//		JNAInvokeDll.motionDrvDll.motion_config_EZ_PIN(this.axis, ez_logic, ez_mode);
//	}

	/**
	 * 配置锁存信号输入.暂时不支持该功能
	 * 
	 * @param axis 轴号
	 *            
	 * @param ltc_logic
	 *            0-低有效,1-高有效
	 * @param ltc_mode
	 *            保留，可设为任意值
	 * @return void
	 * @version 0.1
	 */
//	public void configLTCPin(int ltc_logic, int ltc_mode) {
//		JNAInvokeDll.motionDrvDll.motion_config_LTC_PIN(this.axis, ltc_logic, ltc_mode);
//	}

	/**
	 * 配置位置比较输出端口的功能，每轴只有一个比较输出端口CMP
	 * 
	 * @param axis 轴号
	 *            
	 * @param cmp1_enable
	 *            配置CMPn(n对应轴号) 0:配置为通用数字输出端口 1:配置为位置比较输出端
	 * @param cmp2_enable
	 *            保留
	 * @param CMP_logic
	 *            位置比较输出电平,0:低电平；1:高电平
	 * @return void
	 * @version 0.1
	 */
	public void configCMPPin(int cmp1_enable, int cmp2_enable, int CMP_logic) {
		JNAInvokeDll.motionDrvDll.motion_config_CMP_PIN(this.axis, cmp1_enable, cmp2_enable, CMP_logic);
	}

	/**
	 * 预置比较器数值
	 * 
	 * @param axis 轴号
	 *            
	 * @param cmp1_data
	 *            比较器1的值
	 * @param cmp2_data
	 *            保留
	 * @return void
	 * @version 0.1
	 */
	public void motion_set_comparator_data(int cmp1_data, int cmp2_data) {
		JNAInvokeDll.motionDrvDll.motion_set_comparator_data(this.axis, cmp1_data, cmp2_data);
	}

	/**
	 * 配置原点信号
	 * 
	 * @param axis 轴号
	 *            
	 * @param org_logic
	 *            0-低有效,1-高有效
	 * @param filter
	 *            滤波功能0-禁止,1-允许
	 * @return void
	 * @version 0.1
	 */
	public void setHOMEPinLogic(int org_logic, int filter) {
		JNAInvokeDll.motionDrvDll.motion_set_HOME_pin_logic(this.axis, org_logic, filter);
	}

	/**
	 * 设置指定轴的伺服使能端口的电平
	 * 
	 * @param axis 轴号
	 *            
	 * @param on_off
	 *            0-低,1-高
	 * @return void
	 * @version 0.1
	 */
	public void motion_write_SEVON_PIN(int on_off) {
		JNAInvokeDll.motionDrvDll.motion_write_SEVON_PIN(this.axis, on_off);
	}

	/**
	 * 读取指定轴的伺服使能端口的电平
	 * 
	 * @param axis 轴号
	 *            
	 * @return 0-低电平, 1-高电平, -1-无效值,该板卡不支持SEVON
	 * @version 0.1
	 */
	public int readSEVONPin() {
		return JNAInvokeDll.motionDrvDll.motion_read_SEVON_PIN(this.axis);
	}

	/**
	 * 读取指定轴的伺服准备好端口的电平
	 * 
	 * @param axis 轴号
	 *            
	 * @return 0-低电平, 1-高电平, -1-无效值,该板卡不支持RDY
	 * @version 0.1
	 */
	public int readRDYPin() {
		return JNAInvokeDll.motionDrvDll.motion_read_RDY_PIN(this.axis);
	}

	/*********************************************************************************
	 ******************************** 状态检测 ****************************************
	 ********************************************************************************/

	/**
	 * 读取轴运动状态
	 * 
	 * @param axis
	 *            轴号
	 * @return 0:运动 1:停止
	 * @version 0.1
	 */
	public int checkDone() {
		return JNAInvokeDll.motionDrvDll.motion_check_done(this.axis);
	}

	/**
	 * 读取轴专用输入信号
	 * 
	 * @param axis
	 *            轴号
	 * @return 目前仅以下信号有效 8-正在加速 9-正在减速 10-正在匀速运行 12-EL+ 13-EL_ 14-ORG 相应位:
	 *         0表示信号无效,1表示信号有效
	 * @version 0.1
	 */
	public int axisIoStatus() {
		return JNAInvokeDll.motionDrvDll.motion_axis_io_status(this.axis);
	}

	/**
	 * 读取轴外部信号
	 * 
	 * @param axis
	 *            轴号
	 * @return 目前仅以下信号有效 7-EMG紧急停止信号 15-INP到位信号 相应位: 0表示信号无效,1表示信号有效
	 * @version 0.1
	 */
	public long motion_get_rsts(long axis) {
		return JNAInvokeDll.motionDrvDll.motion_get_rsts(this.axis);
	}

	/**
	 * 读取指定轴的专用接口信号电平,S系列专用
	 * 
	 * @param axis
	 *            轴号
	 * @return BIT位:0-ORG, 1-SD, 2-EL+, 3-EL-, 4-ALM, 5-INP, 6-RDY, 7-板级EMG,
	 *         9-CMP, 10-SEVON, 11-ERC, 其它位保留 0表示低电平,1表示高电平
	 * @version 0.1
	 */
	public long getSig(long axis) {
		return JNAInvokeDll.motionDrvDll.motion_get_sig(this.axis);
	}

	/**
	 * 读取指定轴的专用接口信号电平,B系列专用
	 * 
	 * @param axis
	 *            轴号
	 * @return BIT位:0-EL-, 1-EL+, 2-ORG, 5-SD-, 6-SD+,其它位保留 0表示低电平,1表示高电平
	 * @version 0.1
	 */
	public long getStatus() {
		return JNAInvokeDll.motionDrvDll.motion_get_status(this.axis);
	}

	/********************************************************************************
	 ******************************** 设置速度参数 ***********************************
	 ********************************************************************************/

	/**
	 * 设置轴梯形运动曲线
	 * 
	 * @param axis
	 *            轴号
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
	public void setProfile(double Min_Vel, double Max_Vel, double Tacc, double Tdec) {
		JNAInvokeDll.motionDrvDll.motion_set_profile(this.axis, Min_Vel, Max_Vel, Tacc, Tdec);
	}

	/**
	 * 设置S形速度曲线(按S段时间)
	 * 
	 * @param axis
	 *            轴号
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
	public void setStProfile(double Min_Vel, double Max_Vel, double Tacc, double Tdec, double Tsacc, double Tsdec) {
		JNAInvokeDll.motionDrvDll.motion_set_st_profile(this.axis, Min_Vel, Max_Vel, Tacc, Tdec, Tsacc, Tsdec);
	}

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

	/**
	 * 在线改变指定轴的当前运动速度
	 * 
	 * @param axis
	 *            轴号
	 * @param Curr_Vel
	 *            新的运行速度，单位pps
	 * @version 0.1
	 */
	public void changeSpeed(double Curr_Vel) {
		JNAInvokeDll.motionDrvDll.motion_change_speed(this.axis, Curr_Vel);
	}
	
	/********************************************************************************
	  *****************************    运动与制动控制    *****************************
	  ********************************************************************************/
	 
	 /**
	 * 单轴梯形定长运动(对称的T形加减速)
	 * 
	 * @param axis 轴号
	 * @param Dist 位移
	 * @param posi_mode 0-相对位移,1-绝对位移
	 * @version 0.1
	 */
	 public void tPMove(int Dist, int posi_mode){
		 JNAInvokeDll.motionDrvDll.motion_t_pmove(this.axis, Dist, posi_mode);
	 }
	 
	 /**
	 * 单轴S形定长运动(对称的S形加减速)
	 * 
	 * @param axis 轴号
	 * @param Dist 位移
	 * @param posi_mode 0-相对位移,1-绝对位移
	 * @version 0.1
	 */
	 public void sPMove(int Dist, int posi_mode){
		 JNAInvokeDll.motionDrvDll.motion_s_pmove(this.axis, Dist, posi_mode);
	 }
	 
	 /**
	 * 单轴梯形加速连续运动
	 * 
	 * @param axis 轴号
	 * @param dir 0-负方向,1-正方向
	 * @version 0.1
	 */
	 public void tVMove(int dir){
		 JNAInvokeDll.motionDrvDll.motion_t_vmove(this.axis, dir);
	 }
	 
	 /**
	 * 单轴S形加速连续运动
	 * 
	 * @param axis 轴号
	 * @param dir 0-负方向,1-正方向
	 * @version 0.1
	 */
	 public void motion_s_vmove(int dir){
		 JNAInvokeDll.motionDrvDll.motion_s_vmove(this.axis, dir);
	 }
	 
	 /**
	 * 减速停止
	 * 
	 * @param axis      轴号
	 * @param Tdec      减速时间，单位s
	 * @version 0.1
	 */
	 public void decelStop(double Tdec){
		 JNAInvokeDll.motionDrvDll.motion_decel_stop(this.axis, Tdec);
	 }
	 
	 /**
	 * 立即停止
	 * 
	 * @param axis      轴号
	 * @version 0.1
	 */
	 public void motionImdStop(){
		 JNAInvokeDll.motionDrvDll.motion_imd_stop(this.axis);
	 }
	 
	 /**
	 * 紧急停止所有轴.暂时不支持该功能
	 * 
	 * @version 0.1
	 */
//	 public void emgStop(){
//		 JNAInvokeDll.motionDrvDll.motion_emg_stop();
//	 }
	 
	 /**
	 * 读取当前速度值，单位pps
	 * 
	 * @version 0.1
	 */
	 public double readCurrentSpeed(){
		 return JNAInvokeDll.motionDrvDll.motion_read_current_speed(this.axis);
	 }
	 
	 /********************************************************************************
	  *****************************    位置设置与读取    *****************************
	  ********************************************************************************/
	 
	 /**
	 * 读取指令脉冲位置
	 * @param axis 轴号
	 * @version 0.1
	 */
	 public int getPosition(){
		 return JNAInvokeDll.motionDrvDll.motion_get_position(this.axis);
	 }
	 
	 /**
	 * 设置指令脉冲位置
	 * @param axis 轴号
	 * @param current_position 位移
	 * @version 0.1
	 */
	 public void motion_set_position(int current_position){
		 JNAInvokeDll.motionDrvDll.motion_set_position( this.axis, current_position);
	 }
	 
	 /********************************************************************************
	  *******************************    回原点模式    *******************************
	  ********************************************************************************/
	 
	 /**
	 * 回原点信号模式
	 * @param axis     轴号
	 * @param mode     0-只计home, 1-home和EZ,目前只支持0
	 * @param EZ_count 仅mode为1时有效,取值1-16
	 * @version 0.1
	 */
	 public void configHomeMode(int mode, int EZ_count){
		 JNAInvokeDll.motionDrvDll.motion_config_home_mode(this.axis, mode, EZ_count);
	 }
	 
	 /**
	 * 回原点命令,检测到原点信号后会自动停止运动
	 * @param axis     轴号
	 * @param mhome_mode  1-正方向回原点,2-负方向回原点
	 * @param vel_mode   0-低速回原点,1-高速回原点
	 * @version 0.1
	 */
	 public void homeMove(int home_mode, int vel_mode){
		 JNAInvokeDll.motionDrvDll.motion_home_move(this.axis, home_mode, vel_mode);
	 }

	public int getAxis() {
		return axis;
	}

	public void setAxis(int axis) {
		this.axis = axis;
	}
	
	public Axia(int axis) {
		this.axis = axis;
	}
	 
}
