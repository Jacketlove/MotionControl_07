package com.tswe.autotest.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tswe.autotest.service.InitControlBoardService;
import com.tswe.common.constant.Constant;
import com.tswe.common.util.CommonUtil;
import com.tswe.common.util.JNAInvokeDll;

public class Axis {
	private Logger logger = LoggerFactory.getLogger(InitControlBoardService.class);
	//轴号
	private int axisNum;
	private int elMode;
	private int orgLogic;
	private int filter;
	private int Dist;
	private int posiMode;
	private int dir;
	private int mode;
	private int EZCount;
	private int homeMode;
	private int velMode;
	//脉冲输出模式
	private int pulseMode;
	//相对于原点的位移
	private int position;
	//是否繁忙标志
	private boolean busynessFlag;
	//错误标志
	private boolean errorFlag;
	//速度曲线形状  T/S
	private int velType;
	//运动模式
	private int MoveType;
	//T形速度曲线  速度最小值
	private double MinVel;
	//T形速度曲线  速度最大值
	private double MaxVel;
	//T形速度曲线  加速时间
	private double Tacc;
	//T形速度曲线  减速时间
	private double Tdec;
	private double Tsacc;
	private double Tsdec;
	private double CurrVel;
	private String cmd;
	//强制停止标志位
	private boolean toStop;
	
	

//	@SuppressWarnings("static-access")
//	@Override
//	public void run() {
//		busynessFlag = Constant.ISBUSYNESS;
//		if(null != cmd&& !"".equals(cmd)){
//			switch (cmd) {
//			case "configELMode":
//				errorFlag = configELMode(elMode);
//				busynessFlag = Constant.NOBUSYNESS;
//				break;
//			
//			case "setHOMEPinLogic":
//				errorFlag = setHOMEPinLogic(orgLogic, filter);
//				busynessFlag = Constant.NOBUSYNESS;
//				break;
//			
//			case "setProfile":
//				errorFlag = setProfile(MinVel, MaxVel, Tacc, Tdec);
//				busynessFlag = Constant.NOBUSYNESS;
//				break;
//				
//			case "setStProfile":
//				errorFlag = setStProfile(MinVel, MaxVel, Tacc, Tdec, Tsacc, Tsdec);
//				busynessFlag = Constant.NOBUSYNESS;
//				break;	
//			
//			case "changeSpeed":
//				errorFlag = changeSpeed(CurrVel);
//				busynessFlag = Constant.NOBUSYNESS;
//				break;		
//				
//			case "tPMove":
//				errorFlag = tPMove(Dist, posiMode);
//				busynessFlag = Constant.ISBUSYNESS;
//				break;
//				
//			case "sPMove":
//				errorFlag = sPMove(Dist, posiMode);
//				busynessFlag = Constant.ISBUSYNESS;
//				break;
//				
//			case "tVMove":
//				errorFlag = tVMove(dir);
//				busynessFlag = Constant.ISBUSYNESS;
//				break;
//				
//			case "sVMove":
//				errorFlag = sVMove(dir);
//				busynessFlag = Constant.ISBUSYNESS;
//				break;
//				
//			case "config":
//				errorFlag = configHomeMode(mode, EZCount);
//				busynessFlag = Constant.NOBUSYNESS;
//				break;
//				
//			case "homeMove":
//				errorFlag = homeMove(homeMode, velMode);
//				busynessFlag = Constant.ISBUSYNESS;
//				break;
//			default:
//				errorFlag = false;
//				busynessFlag = Constant.NOBUSYNESS;
//				break;
//			}
//			//命令执行完毕，删除命令
//			cmd = "";
//			//判断轴是否停止，未停止则间隔1s判断一次是否停止
//			if(busynessFlag == Constant.ISBUSYNESS){
//				while(checkDone() == 0){
//					try {
//						Thread.currentThread().sleep(1000l);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			//轴停止，将标志位置为空闲状态
//			busynessFlag = Constant.NOBUSYNESS;
//			
//			//如果命令列表不为空，重启一个线程继续执行
//			if(null != cmd&& !"".equals(cmd)){
//				Thread thread = new Thread(this);
//				thread.start();
//			}
//		}
//	}
	
	/********************************************************************************
	 ******************************** 基本配置  ****************************************
	 ********************************************************************************/
	/**
	* 脉冲输出方式的设置
	* 
	* @param axisNum 轴号
	*            
	* @param outmode
	*            输出模式（0-5）
	* @return false 调用失败, true 调用成功
	* @version 0.1
	*/
	public boolean setPulseOutmode(int outmode) {
		JNAInvokeDll.motionDrvDll.motion_set_pulse_outmode(this.axisNum, outmode);
		return CommonUtil.dllReturn(this, "motion_set_pulse_outmode");
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
	 * @param axisNum 轴号
	 * 
	 * @param el_mode
	 *            0-立即停,低有效 1-减速停,低有效 2-立即停,高有效 3-减速停,高有效
	 * @return false 调用失败, true 调用成功
	 * @version 0.1
	 */
	public boolean configELMode(int el_mode){
		JNAInvokeDll.motionDrvDll.motion_config_EL_MODE(this.axisNum, el_mode);
		return CommonUtil.dllReturn(this, "motion_config_EL_MODE");
	}

	/**
	 * 配置限位信号工作模式
	 * 
	 * @param axis 轴号
	 * @param iElStopMode 停止模式 0立即停止，1减速停止
	 * @param iElLogic EL有效电平标志，0低电平有效，1高电平有效
	 * @return void
	 * @version 0.1
	 */
	public void configELMode(boolean iElStopMode, boolean iElLogic){
		if ( false == iElStopMode ){
	        if( false == iElLogic ){
	        	configELMode(0);
	        }
	        else{
	        	configELMode(2);
	        }
	    }
	    else{
	        if ( false == iElLogic ){
	        	configELMode(1);
	        }
	        else{
	        	configELMode(3);
	        }
	    }
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
	 * @param axisNum 轴号
	 *            
	 * @param cmp1_enable
	 *            配置CMPn(n对应轴号) 0:配置为通用数字输出端口 1:配置为位置比较输出端
	 * @param cmp2_enable
	 *            保留
	 * @param CMP_logic
	 *            位置比较输出电平,0:低电平；1:高电平
	 * @return false 调用失败, true 调用成功
	 * @version 0.1
	 */
	public boolean configCMPPin(int cmp1_enable, int cmp2_enable, int CMP_logic) {
		JNAInvokeDll.motionDrvDll.motion_config_CMP_PIN(this.axisNum, cmp1_enable, cmp2_enable, CMP_logic);
		return CommonUtil.dllReturn(this,"motion_config_CMP_PIN");
		
	}
	
	/**
	 * 读取指定轴的比较输出端口的电平
	 * 
	 * @param axisNum 轴号
	 * @return 0-低电平, 1-高电平, -1-无效值,该板卡不支持CMP
	 * @version 0.1
	 */
	public int readCMPPin(){
		return JNAInvokeDll.motionDrvDll.motion_read_CMP_PIN(this.axisNum);
	}
	
	/**
	 * 设置指定轴的位置比较输出端口的电平
	 * 
	 * @param axisNum 轴号
	 * @param cmp1_condition  比较器1的触发条件 
     *          0：关闭比较器1功能 
     *          1：计数器的值等于比较器1 
     *          2：计数器的值小于比较器1 
     *          3：计数器的值大于比较器1
     * @param cmp2_condition  保留
     * @param source_sel 配置计数器类型 
     * 					 	0：比较器与指令脉冲计数器比较 
     *          		 	1：比较器与编码器脉冲比较 
     * @param SL_action 0：保留
	 * @return void
	 * @version 0.1
	 */
	public void configComparator(int cmp1_condition, int cmp2_condition, int source_sel, int SL_action){
		JNAInvokeDll.motionDrvDll.motion_config_comparator(this.axisNum, cmp1_condition, cmp2_condition, source_sel, SL_action);
	}
	
	/**
	 * 预置比较器数值
	 * 
	 * @param axisNum 轴号
	 *            
	 * @param cmp1_data
	 *            比较器1的值
	 * @param cmp2_data
	 *            保留
	 * @return void
	 * @version 0.1
	 */
	public void setComparatorData(int cmp1_data, int cmp2_data) {
		JNAInvokeDll.motionDrvDll.motion_set_comparator_data(this.axisNum, cmp1_data, cmp2_data);
	}
	
	/**
	 * 配置原点信号
	 * 
	 * @param axisNum 轴号
	 *            
	 * @param org_logic
	 *            0-低有效,1-高有效
	 * @param filter
	 *            滤波功能0-禁止,1-允许
	 * @return false 调用失败, true 调用成功
	 * @version 0.1
	 */
	public boolean setHOMEPinLogic(int org_logic, int filter) {
		JNAInvokeDll.motionDrvDll.motion_set_HOME_pin_logic(this.axisNum, org_logic, filter);
		return CommonUtil.dllReturn(this, "motion_set_HOME_pin_logic");
	}

	/**
	 * 设置指定轴的伺服使能端口的电平
	 * 
	 * @param axisNum 轴号
	 *            
	 * @param on_off
	 *            0-低,1-高
	 * @return void
	 * @version 0.1
	 */
	public void motion_write_SEVON_PIN(int on_off) {
		JNAInvokeDll.motionDrvDll.motion_write_SEVON_PIN(this.axisNum, on_off);
	}

	/**
	 * 读取指定轴的伺服使能端口的电平
	 * 
	 * @param axisNum 轴号
	 *            
	 * @return 0-低电平, 1-高电平, -1-无效值,该板卡不支持SEVON
	 * @version 0.1
	 */
	public int readSEVONPin() {
		return JNAInvokeDll.motionDrvDll.motion_read_SEVON_PIN(this.axisNum);
	}
	
	/**
	 * 读取指定轴的伺服准备好端口的电平
	 * 
	 * @param axis 轴号
	 *            
	 * @return 0-低电平, 1-高电平, -1-无效值,该板卡不支持RDY
	 * @version 0.1
	 */
//	public int readRDYPin() {
//		return JNAInvokeDll.motionDrvDll.motion_read_RDY_PIN(this.axis);
//	}

	/********************************************************************************
	 ******************************** 状态检测  ****************************************
	 ********************************************************************************/

	/**
	 * 读取轴运动状态
	 * 
	 * @param axisNum
	 *            轴号
	 * @return 0:运动 1:停止
	 * @version 0.1
	 */
	public boolean checkDone() {
		CommonUtil.dllReturn(this, "motion_check_done");
		int temp = JNAInvokeDll.motionDrvDll.motion_check_done(this.axisNum);
		if(temp == 0){
			logger.info("motion_check_done return:RUNNING");
			return Constant.RUNNING;
		}else if (temp == 1) {
			logger.info("motion_check_done return:STOPING");
			return Constant.STOPING;
		}else {
			logger.info("motion_check_done return:STOPING");
			return Constant.STOPING;
		}
	}
	
	/**
	 * 读取轴专用输入信号
	 * 
	 * @param axisNum
	 *            轴号
	 * @return 目前仅以下信号有效 8-正在加速 9-正在减速 10-正在匀速运行 12-EL+ 13-EL_ 14-ORG 相应位:
	 *         0表示信号无效,1表示信号有效
	 * @version 0.1
	 */
	public int axisIoStatus() {
		return JNAInvokeDll.motionDrvDll.motion_axis_io_status(this.axisNum);
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
		return JNAInvokeDll.motionDrvDll.motion_get_rsts(this.axisNum);
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
		return JNAInvokeDll.motionDrvDll.motion_get_sig(this.axisNum);
	}

	/**
	 * 读取指定轴的专用接口信号电平,B系列专用
	 * 
	 * @param axisNum
	 *            轴号
	 * @return BIT位:0-EL-, 1-EL+, 2-ORG, 5-SD-, 6-SD+,其它位保留 0表示低电平,1表示高电平
	 * @version 0.1
	 */
	public long getStatus() {
		return JNAInvokeDll.motionDrvDll.motion_get_status(this.axisNum);
	}
	
	
	/********************************************************************************
	 ******************************** 设置速度参数 **************************************
	 ********************************************************************************/

	/**
	 * 设置轴梯形运动曲线
	 * 
	 * @param axisNum
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
	private boolean setProfile(double Min_Vel, double Max_Vel, double Tacc, double Tdec) {
		JNAInvokeDll.motionDrvDll.motion_set_profile(this.axisNum, Min_Vel, Max_Vel, Tacc, Tdec);
		if(CommonUtil.dllReturn(this, "motion_set_profile")){
			this.velType = Constant.TV;
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 设置S形速度曲线(按S段时间)
	 * 
	 * @param axisNum
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
	private boolean setStProfile(double Min_Vel, double Max_Vel, double Tacc, double Tdec, double Tsacc, double Tsdec) {
		JNAInvokeDll.motionDrvDll.motion_set_st_profile(this.axisNum, Min_Vel, Max_Vel, Tacc, Tdec, Tsacc, Tsdec);
		if(CommonUtil.dllReturn(this, "motion_set_st_profile")){
			this.velType = Constant.SV;
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 在线改变指定轴的当前运动速度
	 * 
	 * @param axisNum
	 *            轴号
	 * @param CurrVel
	 *            新的运行速度，单位pps
	 * @return false 调用失败, true 调用成功
	 * @version 0.1
	 */
	private boolean changeSpeed(double CurrVel) {
		JNAInvokeDll.motionDrvDll.motion_change_speed(this.axisNum, CurrVel);
		return CommonUtil.dllReturn(this, "motion_change_speed");
	}
	
	/**
	 * 设置速度曲线为T形
	 * 
	 * @param axis 轴对象
	 * @param Min_Vel 开始速度
	 * @param Max_Vel 运行速度
	 * @param Tacc 加速时间
	 * @param Tdec 减速时间
	 * @return false 调用失败, true 调用成功
	 */
	public boolean setVel(double Min_Vel, double Max_Vel, double Tacc, double Tdec){
		if(setProfile(Min_Vel, Max_Vel, Tacc, Tdec)){
			velType = Constant.TV;
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 设置速度曲线为S形
	 * 
	 * @param axis
	 * @param Min_Vel
	 * @param Max_Vel
	 * @param Tacc
	 * @param Tdec
	 * @param Tsacc
	 * @param Tsdec
	 * @return false 调用失败, true 调用成功
	 */
	public boolean setVel(double minVel, double maxVel, double Tacc, double Tdec, double Tsacc, double Tsdec){
		if(setStProfile(minVel, maxVel, Tacc, Tdec, Tsacc, Tsdec)){
			velType = Constant.SV;
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 在线改变指定轴的当前运动速度
	 * 
	 * @param axisNum
	 *            轴号
	 * @param CurrVel
	 *            新的运行速度，单位pps
	 * @return false 调用失败, true 调用成功
	 * @version 0.1
	 */
	public boolean setVel(double CurrVel){
		return changeSpeed(CurrVel);
	}
	
	/*********************************************************************************
	********************************** 运动与制动控制  ************************************
	**********************************************************************************/
	 /**
	 * 单轴梯形定长运动(对称的T形加减速)
	 * 
	 * @param axisNum 轴号
	 * @param Dist 位移
	 * @param posiMode 0-相对位移,1-绝对位移
	 * @return false 调用失败, true 调用成功
	 * @version 0.1
	 */
	 private boolean tPMove(int Dist, int posiMode){
		 JNAInvokeDll.motionDrvDll.motion_t_pmove(this.axisNum, Dist, posiMode);
		 return CommonUtil.dllReturn(this, "motion_t_pmove");
	 }
	 
	/**
	* 单轴S形定长运动(对称的S形加减速)
	* 
	* @param axisNum 轴号
	* @param Dist 位移
	* @param posiMode 0-相对位移,1-绝对位移
	* @return false 调用失败, true 调用成功
	* @version 0.1
	*/
	private boolean sPMove(int Dist, int posiMode){
		JNAInvokeDll.motionDrvDll.motion_s_pmove(this.axisNum, Dist, posiMode);
		return CommonUtil.dllReturn(this, "motion_s_pmove");
	}
	 
	/**
	* 单轴梯形加速连续运动
	* 
	* @param axisNum 轴号
	* @param dir 0-负方向,1-正方向
	* @return false 调用失败, true 调用成功
	* @version 0.1
	*/
	private boolean tVMove(int dir){
		JNAInvokeDll.motionDrvDll.motion_t_vmove(this.axisNum, dir);
		return CommonUtil.dllReturn(this, "motion_t_vmove");
	}
	 
	/**
	* 单轴S形加速连续运动
	* 
	* @param axisNum 轴号
	* @param dir 0-负方向,1-正方向
	* @return false 调用失败, true 调用成功
	* @version 0.1
	*/
	private boolean sVMove(int dir){
		JNAInvokeDll.motionDrvDll.motion_s_vmove(this.axisNum, dir);
		return CommonUtil.dllReturn(this, "motion_s_vmove");
	}
	
	/**
	 * 定长运动
	 * 
	 * @param axis
	 * @param Dist 0 负方向 /1 正方向
	 * @param posi_mode 0-相对位移,1-绝对位移
	 * @return
	 */
	public boolean move(int Dist, int posi_mode){
		switch (getVelType()) {
			case Constant.TV:
				return tPMove(Dist, posi_mode);
				
			case Constant.SV:
				return sPMove(Dist, posi_mode);
				
			default:
				return false;
		}
	}
	
	/**
	 * 单轴连续运动
	 * @param axis 轴对象
	 * @param Dist 0 负方向 /1 正方向
	 * @return
	 */
	public boolean move(int dir){
		switch (getVelType()) {
			case Constant.TV:
				return tVMove(dir);
				
			case Constant.SV:
				return sVMove(dir);
				
			default:
				return false;
		}
	}
	
	/**
	* 减速停止
	* 
	* @param axisNum      轴号
	* @param Tdec      减速时间，单位s
	* @return false 调用失败, true 调用成功
	* @version 0.1
	*/
	public boolean Stop(double Tdec){
		JNAInvokeDll.motionDrvDll.motion_decel_stop(this.axisNum, Tdec);
		return CommonUtil.dllReturn(this, "motion_decel_stop");
	}
	 
	/**
	* 立即停止
	* 
	* @param axisNum      轴号
	* @version 0.1
	*/
	public boolean stop(){
		JNAInvokeDll.motionDrvDll.motion_imd_stop(this.axisNum);
		return CommonUtil.dllReturn(this, "motion_imd_stop");
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
	* @return false 调用失败, true 调用成功
	* @version 0.1
	*/
	public double readCurrentSpeed(){
		return JNAInvokeDll.motionDrvDll.motion_read_current_speed(this.axisNum);
	}
	 
	 /********************************************************************************
	  ********************************** 位置设置与读取  **********************************
	  ********************************************************************************/
	 
	/**
	* 读取指令脉冲位置
	* 
	* @param axisNum 轴号
	* @return false 调用失败, true 调用成功
	* @version 0.1
	*/
	public int getPosition(){
		return JNAInvokeDll.motionDrvDll.motion_get_position(this.axisNum);
	}
	 
	/**
	* 设置指令脉冲位置
	* @param axisNum 轴号
	* @param current_position 位移
	* 
	* @version 0.1
	*/
	public void motion_set_position(int current_position){
		JNAInvokeDll.motionDrvDll.motion_set_position( this.axisNum, current_position);
	}
	 
	 /********************************************************************************
	 ************************************* 回原点模式  ***********************************
	 ********************************************************************************/
	 
	/**
	* 回原点信号模式
	* @param axisNum     轴号
	* @param mode     0-只计home, 1-home和EZ,目前只支持0
	* @param EZCount 仅mode为1时有效,取值1-16
	* @return false 调用失败, true 调用成功
	* @version 0.1
	*/
	public boolean configHomeMode(){
		JNAInvokeDll.motionDrvDll.motion_config_home_mode(this.axisNum, 0, 0);
		return CommonUtil.dllReturn(this, "motion_config_home_mode");
	}
	 
	/**
	* 回原点命令,检测到原点信号后会自动停止运动
	* @param axisNum     轴号
	* @param mhomeMode  1-正方向回原点,2-负方向回原点
	* @param velMode   0-低速回原点,1-高速回原点0
	* @return false 调用失败, true 调用成功
	* @version 0.1
	*/
	public boolean homeMove(int homeMode, int velMode){
		JNAInvokeDll.motionDrvDll.motion_home_move(this.axisNum, homeMode, velMode);
		return CommonUtil.dllReturn(this, "motion_home_move");
	}
	
	public String goHome(int org_logic, int mhome_mode, int vel_mode){
		String msg = "";
		//配置原点信号
		if(!setHOMEPinLogic(org_logic, 1))
			return msg+="setHOMEPinLogic<-goHome error!";
		//设置回原点模式
		if(!configHomeMode())
			return msg+="configHomeMode<-goHome error!";
		//原点运动开始 负方向回原点
		if(!homeMove(mhome_mode, vel_mode))
			return msg+="homeMove<-goHome error!";
		return msg;
	}
	
	/********************************************************************************
	 ************************************轴资源操作*************************************
	 ********************************************************************************/
	/**
	 * 获取轴资源，一旦调用就必然会获得轴资源
	 * 所有最多只能有一个线程调用
	 * 
	 */
	@SuppressWarnings("static-access")
	public synchronized void getAxisResource(){
		while(checkDone() == Constant.RUNNING){
			if(toStop == Constant.YES){
				stop();
				toStop = Constant.NO;
			}
			try {
				Thread.currentThread().sleep(1000L);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while(busynessFlag == Constant.ISBUSYNESS){};
		busynessFlag = Constant.ISBUSYNESS;
	}
	
	/**
	 * 释放资源
	 */
	public void releaseAxisResource(){
		busynessFlag = Constant.NOBUSYNESS;
	}
	
	/**
	 * 等待轴停止
	 */
	@SuppressWarnings("static-access")
	public synchronized void waitAxisStop(){
		while(checkDone() == Constant.RUNNING){
			if(toStop == Constant.YES){
				stop();
				toStop = Constant.NO;
			}
		}
	}
	
	
	/********************************************************************************
	 ************************************getter/setter*******************************
	 ********************************************************************************/
	
	public Axis(int axisNum) {
		this.axisNum = axisNum;
		this.position = 0;
		this.busynessFlag = Constant.NOBUSYNESS;
		this.toStop = Constant.NO;
		//在初始化轴的时候就将脉冲输出模式设置进入
		if(setPulseOutmode(Constant.PULSEMODE)){
			pulseMode = Constant.PULSEMODE;
		}else {
			logger.info("Axis初始化失败，设置脉冲模式失败！");
		}
	}
	
	
	
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getAxisNum() {
		return axisNum;
	}

	public void setAxisNum(int axisNum) {
		this.axisNum = axisNum;
	}

	public int getElMode() {
		return elMode;
	}

	public void setElMode(int elMode) {
		this.elMode = elMode;
	}

	public int getOrgLogic() {
		return orgLogic;
	}

	public void setOrgLogic(int orgLogic) {
		this.orgLogic = orgLogic;
	}

	public int getFilter() {
		return filter;
	}

	public void setFilter(int filter) {
		this.filter = filter;
	}

	public int getDist() {
		return Dist;
	}

	public void setDist(int dist) {
		Dist = dist;
	}

	public int getPosiMode() {
		return posiMode;
	}

	public void setPosiMode(int posiMode) {
		this.posiMode = posiMode;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getEZCount() {
		return EZCount;
	}

	public void setEZCount(int eZCount) {
		EZCount = eZCount;
	}

	public int gethomeMode() {
		return homeMode;
	}

	public void sethomeMode(int homeMode) {
		this.homeMode = homeMode;
	}

	public int getVelMode() {
		return velMode;
	}

	public void setVelMode(int velMode) {
		this.velMode = velMode;
	}

	public int getPulseMode() {
		return pulseMode;
	}

	public void setPulseMode(int pulseMode) {
		this.pulseMode = pulseMode;
	}

	public boolean isBusynessFlag() {
		return busynessFlag;
	}

	public void setBusynessFlag(boolean busynessFlag) {
		this.busynessFlag = busynessFlag;
	}

	public int getVelType() {
		return velType;
	}

	public void setVelType(int velType) {
		this.velType = velType;
	}

	public int getMoveType() {
		return MoveType;
	}

	public void setMoveType(int moveType) {
		MoveType = moveType;
	}

	public double getMinVel() {
		return MinVel;
	}

	public void setMinVel(double minVel) {
		MinVel = minVel;
	}

	public double getMaxVel() {
		return MaxVel;
	}

	public void setMaxVel(double maxVel) {
		MaxVel = maxVel;
	}

	public double getTacc() {
		return Tacc;
	}

	public void setTacc(double tacc) {
		Tacc = tacc;
	}

	public double getTdec() {
		return Tdec;
	}

	public void setTdec(double tdec) {
		Tdec = tdec;
	}

	public double getTsacc() {
		return Tsacc;
	}

	public void setTsacc(double tsacc) {
		Tsacc = tsacc;
	}

	public double getTsdec() {
		return Tsdec;
	}

	public void setTsdec(double tsdec) {
		Tsdec = tsdec;
	}

	public double getCurrVel() {
		return CurrVel;
	}

	public void setCurrVel(double currVel) {
		CurrVel = currVel;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getHomeMode() {
		return homeMode;
	}

	public void setHomeMode(int homeMode) {
		this.homeMode = homeMode;
	}

	public boolean isErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(boolean errorFlag) {
		this.errorFlag = errorFlag;
	}

	public boolean isToStop() {
		return toStop;
	}

	public void setToStop(boolean toStop) {
		this.toStop = toStop;
	}
	
}