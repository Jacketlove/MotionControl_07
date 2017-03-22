package com.tswe.common.util;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.tswe.common.constant.Constant;

public interface JNAInvokeDll extends Library {
	
	JNAInvokeDll motionDrvDll = 
			(JNAInvokeDll)Native.loadLibrary(
					//根据操作系统位数调用对应的dll
					Constant.systemBit.equals("64")? 
							"dll/Motion_Drv_64":"dll/Motion_Drv_32", JNAInvokeDll.class);
	
	/********************************************************************************
	 ********************************** 板级初始化  ************************************
	 ********************************************************************************/
	
	/***
	 * 功能描述: 控制板初始化
	 * 
	 * @param void
	 * @return 0：无卡； 1-16：实际卡数,最大支持16张卡
	 * @version 0.1
	 */
	public int motion_board_init();
	
	/***
	 * 控制板初始化(串口)
	 * 
	 * @param void
	 * @return 0：无卡； 1：实际卡数,最大支持1张卡
	 * @version 0.1
	 */
	public int motion_board_init_serial();
	
	/**
	 * 关闭所有卡
	 * 
	 * @param void
	 * @return void
	 * @version 0.1
	 */
	public void motion_board_close();
	
	/***
	 * 查询卡类型
	 * 
	 * @param cardno 卡号0-15
	 * @return 0xFF:无效卡类型, 1:B6612, 2:S8250, 3:B6308, 4:S8440, 5:B6428, 6:M9550, 其它值保留
	 * @version 0.1
	 */
	public int motion_get_card_type(int cardno);
	
	/********************************************************************************
	 ************************************ 脉冲输出   ************************************
	 ********************************************************************************/
	
	/**
	 * 脉冲输出方式的设置
	 * 
	 * @param axis 轴号 
	 * @param outmode 输出模式（0-5）
	 * @return void
	 * @version 0.1
	 */
	public void motion_set_pulse_outmode(int axis, int outmode);
	
	/********************************************************************************
	 ********************************** 专用IO配置  ************************************
	 ********************************************************************************/
	
	/***
	 * 配置急停信号输入
	 * 
	 * @param cardno 卡号
	 * @param enable 0无效,1有效
	 * @param emg_logic 0低有效,1高有效
	 * @return void
	 * @version 0.1
	 */
	public void motion_config_EMG_PIN(int cardno, int enable, int emg_logic);
	
	/***
	 * 配置减速信号输入 
	 * 暂时不支持该功能
	 * @param axis 轴号
	 * @param enable 0无效,1有效, 暂不支持使能
	 * @param sd_logic 0-低电平有效,1-高电平有效
	 * @param sd_mode  0-减速到起始速度,如果SD信号丢失,又开始加速
	 * 				   1-减速到起始速度,并停止,如果在减速过程中,SD信号丢失,又开始加速
	 * 				   2-锁存SD信号,并减速到起始速度
	 * 				   3-锁存SD信号,并减速到起始速度后停止
	 * @return void
	 * @version 0.1
	 */
//	public void motion_config_SD_PIN(int axis, int enable, int sd_logic, int sd_mode);
	
	/***
	 * 配置运动中变速信号输入
	 * 暂时不支持该功能
	 * @param axis 轴号
	 * @param enable 0无效,1有效, 暂不支持使能
	 * @param pcs_logic 
	 * @return void
	 * @version 0.1
	 */
//	public void motion_config_PCS_PIN(int axis, int enable, int pcs_logic);
	
	/***
	 * 配置伺服到位信号输入
	 * 暂时不支持该功能
	 * @param axis 轴号
	 * @param enable 0无效,1有效, 暂不支持使能
	 * @param inp_logic 0低有效,1高有效
	 * @return void
	 * @version 0.1
	 */
//	public void motion_config_INP_PIN(int axis, int enable, int inp_logic);
	
	/***
	 * 配置误差清除信号输入.暂时不支持该功能
	 * 
	 * @param axis 轴号
	 * @param enable 0无效,1有效, 暂不支持使能
	 * @return void
	 * @version 0.1
	 */
//	public void motion_config_ERC_PIN(int axis, int enable, int erc_logic,
//			 int erc_width, int erc_off_time);
	 
	 /***
	 * 配置伺服告警信号输入.暂时不支持该功能
	 * 
	 * @return void
	 * @version 0.1
	 */
//	 public void motion_config_ALM_PIN(int axis, int alm_logic, int alm_action);
	 
	 /***
	 * 配置限位信号工作模式
	 * 
	 * @param axis 轴号
	 * @param el_mode 0-立即停,低有效
	 * 				  1-减速停,低有效
	 * 				  2-立即停,高有效
	 * 				  3-减速停,高有效
	 * @return void
	 * @version 0.1
	 */
	 public void motion_config_EL_MODE(int axis, int el_mode);
	 
	 /**
	 * 配置编码器EZ信号输入.暂时不支持该功能
	 * 
	 * @param axis 轴号
	 * @param ez_logic EZ信号逻辑电平：0－低有效，1－高有效 
	 * @param ez_mode  EZ信号的工作方式： 
	 *		                        	0－EZ信号无效 
	 *		                        	1－EZ是计数器复位信号  
	 *			                        2－EZ是原点信号，且不复位计数器  
	 *			                        3－EZ是原点信号，且复位计数器
	 * @return void
	 * @version 0.1
	 */
//	 public void motion_config_EZ_PIN(int axis, int ez_logic, int ez_mode);
	 
	 /***
	 * 配置锁存信号输入.暂时不支持该功能
	 * 
	 * @param axis 轴号
	 * @param ltc_logic 0-低有效,1-高有效
	 * @param ltc_mode  保留，可设为任意值 
	 * @return void
	 * @version 0.1
	 */
//	 public void motion_config_LTC_PIN(int axis, int ltc_logic, int ltc_mode);
	 
	 /***
	 * 配置位置比较输出端口的功能，每轴只有一个比较输出端口CMP
	 * 
	 * @param axis 轴号
	 * @param cmp1_enable  配置CMPn(n对应轴号)
     *                  0:配置为通用数字输出端口
     *                  1:配置为位置比较输出端
     * @param cmp2_enable  保留                 
	 * @param CMP_logic    位置比较输出电平,0:低电平；1:高电平
	 * @return void
	 * @version 0.1
	 */
	 public void motion_config_CMP_PIN(int axis, int cmp1_enable, int cmp2_enable, int CMP_logic);
	 
	 /**
	 * 读取指定轴的比较输出端口的电平
	 * 
	 * @param axis 轴号
	 * @return 0-低电平, 1-高电平, -1-无效值,该板卡不支持CMP
	 * @version 0.1
	 */
	 public int motion_read_CMP_PIN(int axis);
	 
	 /**
	 * 配置指定轴比较器的触发条件
	 * 
	 * @param axis 轴号
	 * @param on_off   0-低电平, 1-高电平
	 * @return void
	 * @version 0.1
	 */
	 public void motion_write_CMP_PIN(int axis, int on_off);
	 
	 /**
	 * 设置指定轴的位置比较输出端口的电平
	 * 
	 * @param axis 轴号
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
	 public void motion_config_comparator(int axis, int cmp1_condition, int cmp2_condition, int source_sel, int SL_action);
	 
	 /**
	 * 预置比较器数值
	 * 
	 * @param axis 轴号
	 * @param cmp1_data  比较器1的值 
	 * @param cmp2_data  保留
	 * @return void
	 * @version 0.1
	 */
	 public void motion_set_comparator_data(int axis, int cmp1_data, int cmp2_data);
	 
	 /**
	 * 配置原点信号
	 * 
	 * @param axis 轴号
	 * @param org_logic 0-低有效,1-高有效
	 * @param filter 滤波功能0-禁止,1-允许
	 * @return void
	 * @version 0.1
	 */
	 public void motion_set_HOME_pin_logic(int axis, int org_logic, int filter);
	 
	 /**
	 * 设置指定轴的伺服使能端口的电平
	 * 
	 * @param axis 轴号
	 * @param on_off  0-低,1-高
	 * @return void
	 * @version 0.1
	 */
	 public void motion_write_SEVON_PIN(int axis, int on_off);
	 
	 /**
	 * 读取指定轴的伺服使能端口的电平
	 * 
	 * @param axis 轴号
	 * @return 0-低电平, 1-高电平, -1-无效值,该板卡不支持SEVON
	 * @version 0.1
	 */
	 public int motion_read_SEVON_PIN(int axis);
	 
	 /**
	 * 读取指定轴的伺服准备好端口的电平
	 * 
	 * @param axis 轴号
	 * @return 0-低电平, 1-高电平, -1-无效值,该板卡不支持RDY
	 * @version 0.1
	 */
	 public int motion_read_RDY_PIN(int axis);
	 
	 /********************************************************************************
	  ********************************** 通用IO读写    ***********************************
	  ********************************************************************************/
	 /***
	 * 读取通用输入端口信号
	 * 
	 * @param cardno 卡号
	 * @param bitno  bitno  端口号,取值范围:B6612(1~16)、S8250(1~26)、B6308(1~16)、S8440(1~20)
	 * @return 0-低电平, 1-高电平
	 * @version 0.1
	 */
	 public int motion_read_inbit(int cardno, int bitno);
	 
	 /***
	 * 写通用输出信号
	 * 
	 * @param cardno 卡号
	 * @param bitno  端口号,取值范围:B6612(1~28)、S8250(1~28)、B6308(1~24)、S8440(1~20)
	 * @return 0-低电平, 1-高电平
	 * @version 0.1
	 */
	 public void motion_write_outbit(int cardno, int bitno, int on_off);
	 
	 /***
	 * 读取通用输出信号
	 * 
	 * @param cardno 卡号
	 * @param bitno  端口号,取值范围:B6612(1~28)、S8250(1~28)、B6308(1~24)、S8440(1~20)
	 * @return 0-低电平, 1-高电平
	 * @version 0.1
	 */
	 public int motion_read_outbit(int cardno, int bitno);
	 
	 /**
	 * 读取指定控制卡的全部通用输入口的电平状态
	 * 
	 * @param cardno 卡号
	 * @return  bit0～bit(N-1)位值分别代表第1～N号输入端口值,N取值范围：
	 * 			B6612(1~16)、S8250(1~26)、B6308(1~16)、S8440(1~20)
	 *  		0-低电平, 1-高电平
	 * @version 0.1
	 */
	 public int motion_read_inport(int cardno);
	 
	 /**
	 * 读取指定控制卡的全部通用输出口的电平状态
	 * 	
	 * @param cardno 卡号
	 * @return  bit0～bit(N-1)位值分别代表第1～N号输入端口值,N取值范围：
	 * 			B6612(1~28)、S8250(1~28)、B6308(1~24)、S8440(1~20)
	 *  		0-低电平, 1-高电平
	 * @version 0.1
	 */
	 public short motion_read_outport(int cardno);
	 
	 /**
	 * 指定控制卡的全部通用输出口的电平状态
	 * 
	 * @param cardno 卡号
	 * @param  port_value bit0～bit(N-1)位值分别代表第1～N号输入端口值,N取值范围：
	 * 			B6612(1~28)、S8250(1~28)、B6308(1~24)、S8440(1~20)
	 *  		0-低电平, 1-高电平
	 * @version 0.1
	 */
	 public void motion_write_outport(int cardno, int port_value);
	 
	 /********************************************************************************
	  ************************************ 状态检测   ************************************
	  ********************************************************************************/
	 
	 /**
	 * 读取轴运动状态
	 * 
	 * @param axis 轴号
	 * @return 0:运动 1:停止
	 * @version 0.1
	 */
	 public int motion_check_done(int axis);
	 
	 /**
	 * 读取轴专用输入信号
	 * 
	 * @param axis 轴号
	 * @return 目前仅以下信号有效
     *     	8-正在加速   9-正在减速  10-正在匀速运行
     *     	12-EL+       13-EL_      14-ORG
     *     	相应位: 0表示信号无效,1表示信号有效
	 * @version 0.1
	 */
	 public int motion_axis_io_status(int axis);
	 
	 /**
	 * 读取轴外部信号
	 * 
	 * @param axis 轴号
	 * @return 目前仅以下信号有效
     *      7-EMG紧急停止信号
     *     	15-INP到位信号
     *     	相应位: 0表示信号无效,1表示信号有效
	 * @version 0.1
	 */
	 public long motion_get_rsts(long axis);
	 
	 /**
	 * 读取指定轴的专用接口信号电平,S系列专用
	 * 
	 * @param axis 轴号
	 * @return BIT位:0-ORG, 	1-SD, 2-EL+,  3-EL-,    4-ALM, 5-INP, 6-RDY,
     *        				7-板级EMG,   9-CMP, 10-SEVON, 11-ERC, 其它位保留
     *  					0表示低电平,1表示高电平
	 * @version 0.1
	 */
	 public long motion_get_sig(long axis);
	 
	 /**
	 * 读取指定轴的专用接口信号电平,B系列专用
	 * 
	 * @param axis 轴号
	 * @return 	BIT位:0-EL-, 1-EL+, 2-ORG, 5-SD-, 6-SD+,其它位保留
     *  		0表示低电平,1表示高电平
	 * @version 0.1
	 */
	 public long motion_get_status(long axis);
	 
	 /********************************************************************************
	  ******************************    设置速度参数    ******************************
	  ********************************************************************************/
	 
	 /**
	 * 设置轴梯形运动曲线
	 * 
	 * @param axis 轴号
	 * @param Min_Vel  起始速度，单位pps
	 * @param Max_Vel  运行速度，单位pps
	 * @param Tacc     总加速时间，单位s 
	 * @param Tdec     总减速时间，单位s 
	 * @version 0.1
	 */
	 public void motion_set_profile(int axis, double Min_Vel, double Max_Vel,
             double Tacc, double Tdec);
	 
	 /**
	 * 设置S形速度曲线(按S段时间)
	 * 
	 * @param axis 轴号
	 * @param Min_Vel  起始速度，单位pps
	 * @param Max_Vel  运行速度，单位pps
	 * @param Tacc     总加速时间，单位s 
	 * @param Tdec     总减速时间，单位s 
	 * @version 0.1
	 */
	 public void motion_set_st_profile(int axis, double Min_Vel, double Max_Vel,
			 double Tacc, double Tdec, double Tsacc, double Tsdec);
	 
	 /**
	 * 设置多轴插补运动的矢量速度曲线
	 * 
	 * @param axis 轴号
	 * @param Min_Vel  起始速度，单位pps
	 * @param Max_Vel  运行速度，单位pps
	 * @param Tacc     总加速时间，单位s 
	 * @param Tdec     总减速时间，单位s 
	 * @version 0.1
	 */
	 public void motion_set_vector_profile(double Min_Vel, double Max_Vel, double Tacc, double Tdec);
	 
	 /**
	 * 设置多轴插补运动的S形加速(按S段时间)矢量速度曲线
	 * 
	 * @param axis 轴号
	 * @param Min_Vel  起始速度，单位pps
	 * @param Max_Vel  运行速度，单位pps
	 * @param Tacc     总加速时间，单位s 
	 * @param Tdec     总减速时间，单位s 
	 * @version 0.1
	 */
	 public void motion_set_st_vector_profile(double Min_Vel, double Max_Vel, double Tacc, double STacc);
	 
	 /**
	 * 在线改变指定轴的当前运动速度
	 * 
	 * @param axis 轴号
	 * @param Curr_Vel   新的运行速度，单位pps
	 * @version 0.1
	 */
	 public void motion_change_speed(int axis, double Curr_Vel);
	 
	 /********************************************************************************
	  ********************************* 运动与制动控制   **********************************
	  ********************************************************************************/
	 
	 /**
	 * 单轴梯形定长运动(对称的T形加减速)
	 * 
	 * @param axis 轴号
	 * @param Dist 位移
	 * @param posi_mode 0-相对位移,1-绝对位移
	 * @version 0.1
	 */
	 public void motion_t_pmove(int axis, int Dist, int posi_mode);
	 
	 /**
	 * 单轴S形定长运动(对称的S形加减速)
	 * 
	 * @param axis 轴号
	 * @param Dist 位移
	 * @param posi_mode 0-相对位移,1-绝对位移
	 * @version 0.1
	 */
	 public void motion_s_pmove(int axis, int Dist, int posi_mode);
	 
	 /**
	 * 单轴梯形加速连续运动
	 * 
	 * @param axis 轴号
	 * @param dir 0-负方向,1-正方向
	 * @version 0.1
	 */
	 public void motion_t_vmove(int axis, int dir);
	 
	 /**
	 * 单轴S形加速连续运动
	 * 
	 * @param axis 轴号
	 * @param dir 0-负方向,1-正方向
	 * @version 0.1
	 */
	 public void motion_s_vmove(int axis, int dir);
	 
	 /**
	 * 任意2轴以对称的梯形加减速作直线插补
	 * 
	 * @param axis1 指定两轴插补的第一轴 
	 * @param axis2 指定两轴插补的第二轴 
	 * @param Dist1 指定axis1的位移值，单位：脉冲数 
	 * @param Dist2 指定axis2的位移值，单位：脉冲数 
	 * @param posi_mode 位移模式设定：0表示相对位移，1表示绝对位移
	 * 		  	当 posi_mode=0 时，作相对位移运动，运动方向由Dist的正负值确定；
     *    		为posi_mode=1，作绝对位移运动，运动方向由Dist与当前位置的差值决定
	 * @version 0.1
	 */
	 public void motion_t_line2(int axis1, int Dist1, int axis2, int Dist2, int posi_mode);
	 
	 /**
	 * 任意3轴以对称的梯形加减速作直线插补
	 * 
	 * @param axis 轴号列表的指针 
	 * @param Dist1 指定插补轴1的位移值，单位：脉冲数 
	 * @param Dist2 指定插补轴2的位移值，单位：脉冲数  
	 * @param Dist3 指定插补轴3的位移值，单位：脉冲数
	 * @param  posi_mode 位移模式设定：0表示相对位移，1表示绝对位移
	 * 		  	当 posi_mode=0 时，作相对位移运动，运动方向由Dist的正负值确定；
     *    		为posi_mode=1，作绝对位移运动，运动方向由Dist与当前位置的差值决定
	 * @version 0.1
	 */
	 //void motion_t_line3(int *axis, int Dist1, int Dist2, int Dist3, int posi_mode);
	 
	 /**
	 * 4轴(0-3轴)以对称的梯形加减速作直线插补
	 * 
	 * @param cardno 卡号
	 * @param Dist1 指定插补轴1的位移值，单位：脉冲数 
	 * @param Dist2 指定插补轴2的位移值，单位：脉冲数  
	 * @param Dist3 指定插补轴3的位移值，单位：脉冲数
	 * @param Dist4    指定插补轴4的位移值，单位：脉冲数 
	 * @param  posi_mode 位移模式设定：0表示相对位移，1表示绝对位移
	 * 		  	当 posi_mode=0 时，作相对位移运动，运动方向由Dist的正负值确定；
     *    		为posi_mode=1，作绝对位移运动，运动方向由Dist与当前位置的差值决定
	 * @version 0.1
	 */
	 public void motion_t_line4(int cardno, int Dist1, int Dist2, int Dist3, int Dist4, int posi_mode);
	 
	 /**
	 * 同卡内任意轴直线插补
	 * 
	 * @param axisnum      轴数
	 * @param axis         轴号列表
	 * @param dist         位移列表
	 * @param posi_mode    位移模式
	 * @param  posi_mode 位移模式设定：0表示相对位移，1表示绝对位移
	 * 		  	当 posi_mode=0 时，作相对位移运动，运动方向由Dist的正负值确定；
     *    		为posi_mode=1，作绝对位移运动，运动方向由Dist与当前位置的差值决定
	 * @version 0.1
	 */
	 //void motion_line(int axisnum, int *axis, int *dist, int posi_mode);
	 
	 /**
	 * 任意两轴以当前位置为起点，按指定的圆心、目标绝对位置和方向作圆弧插补运动 
	 * 
	 * @param axis        轴号列表指针
	 * @param target_pos  目标绝对位置列表指针，坐标单位：脉冲数 
	 * @param cen_pos     圆心绝对位置列表指针，坐标单位：脉冲数 
	 * @param arc_dir     圆弧方向：0表示顺时针，1表示逆时针 
	 * @version 0.1
	 */
	 //MOTION_API _VOID MOTION_CDECL motion_arc_move(_WORD *axis, _LONG *target_pos, _LONG *cen_pos, _WORD arc_dir);
	 
	 /**
	 * 任意两轴以当前位置为起点，按指定的圆心、目标相对位置和方向作圆弧插补运动 
	 * 
	 * @param axis        轴号列表指针 
	 * @param rel_pos     目标相对位置列表指针, 单位：脉冲数 
	 * @param cen_pos     圆心相对位置列表指针, 单位：脉冲数 
	 * @param arc_dir     圆弧方向：0表示顺时针，1表示逆时针 
	 * @version 0.1
	 */
	 //MOTION_API _VOID MOTION_CDECL motion_rel_arc_move(_WORD *axis, _LONG *rel_pos, _LONG *rel_cen, _WORD arc_dir);
	 
	 /**
	 * 减速停止
	 * 
	 * @param axis      轴号
	 * @param Tdec      减速时间，单位s
	 * @version 0.1
	 */
	 public void motion_decel_stop(int axis, double Tdec);
	 
	 /**
	 * 立即停止
	 * 
	 * @param axis      轴号
	 * @version 0.1
	 */
	 public void motion_imd_stop(int axis);
	 
	 /**
	 * 紧急停止所有轴.暂时不支持该功能
	 * 
	 * @version 0.1
	 */
	 public void motion_emg_stop();
	 
	 /**
	 * 读取当前速度值，单位pps
	 * 
	 * @version 0.1
	 */
	 public double motion_read_current_speed(int axis);
	 
	 /********************************************************************************
	  *****************************    位置设置与读取    *****************************
	  ********************************************************************************/
	 
	 /**
	 * 读取指令脉冲位置
	 * @param axis 轴号
	 * @version 0.1
	 */
	 public int motion_get_position(int axis);
	 
	 /**
	 * 设置指令脉冲位置
	 * @param axis 轴号
	 * @param current_position 位移
	 * @version 0.1
	 */
	 public void motion_set_position(int axis, int current_position);
	 
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
	 public void motion_config_home_mode(int axis, int mode, int EZ_count);
	 
	 /**
	 * 回原点命令,检测到原点信号后会自动停止运动
	 * @param axis     轴号
	 * @param mhome_mode  1-正方向回原点,2-负方向回原点
	 * @param vel_mode   0-低速回原点,1-高速回原点
	 * @version 0.1
	 */
	 public void motion_home_move(int axis, int home_mode, int vel_mode);
	 
	 /********************************************************************************
	  *******************************    编码器配置    *******************************
	  ********************************************************************************/
	 
	 /**
	 * 回原点命令,检测到原点信号后会自动停止运动
	 * @param axis     轴号
	 * @param mode 	0-脉冲+方向
	 * 				1-1倍AB相脉冲
     *          	2-2倍AB相脉冲
     *          	3-4倍AB相脉冲
	 * @version 0.1
	 */
	 public void motion_counter_config(int axis, int mode);
	 
	 /**
	 * 读取编码器反馈位置脉冲计数值
	 * @param axis     轴号
     * @return 编码器反馈脉冲，单位pps
	 * @version 0.1
	 */
	 public int motion_get_encoder(int axis);
	 
	 /**
	 * 设置编码器反馈位置脉冲计数值
	 * @param axis     轴号
     * @return encoder_value    编码器反馈脉冲计数位移
	 * @version 0.1
	 */
	 public void motion_set_encoder(int axis, int encoder_value);
	 
	 /***
	 * 设置锁存方式为单轴锁存或是四轴同时锁存.暂时不支持该功能
	 * @param cardno       卡号
     * @param all_enable   锁存方式
     * 					   0－单独锁存
     *                     1－四轴同时锁存
	 * @version 0.1
	 */
	 public void motion_config_latch_mode(int cardno, int all_enable);
	 
	 /***
	 * 选择全部锁存时外触发信号的通道.暂时不支持该功能
	 * 可以由二个信号通道输入,端子LTC1或者LTC2；默认为LTC1
	 * @param cardno       卡号
     * @param Num      信号通道选择： 
     * 				   1－ 通过端子LTC1锁存四个轴
     *          	   2－ 通过端子LTC2锁存四个轴 
	 * @version 0.1
	 */
	 public void motion_triger_chunnel(int cardno, int num);
	 
	 /**
	 * 读取编码器锁存器的值.暂时不支持该功能
	 * 
	 * @param axis 轴号
	 * @return 锁存器内的编码器脉冲数，单位：脉冲
	 * @version 0.1
	 */
	 public int motion_get_latch_value(int axis);
	 
	 /**
	 * 设置多卡同步运动参数
	 * 
	 * @param TotalAxes   同步运动轴的数量  
	 * @param pAxis       轴号列表指针 
	 * @param pDist       距离列表指针,单位:脉冲数
	 * @param posi_mode   位置模式:0表示相对位置,1表示绝对位置 
	 * @return 1表示正常,-1表示参数错
	 * @version 0.1
	 */
	 //int motion_set_t_move_all(int TotalAxes, int *pAxis, int *pDist, int posi_mode);
	 
	 /**
	 * 启动多卡同步运动
	 * 
	 * @param FirstAxis   第一轴轴号
	 * @return 1表示正常,-1表示参数错
	 * @version 0.1
	 */
	 public int motion_start_move_all(int FirstAxis);
	 
	 /**
	 * 向指定轴所在卡的CSTP端口输出停止脉冲
	 * 
	 * @param axis   轴号
	 * @version 0.1
	 */
	 public void motion_simultaneous_stop(int axis);
	 
	 /**
	 * 设置多卡同步信号参数
	 * 
	 * @param axis 轴号
	 * @param sync_stop_on     CSTP信号有效时(低电平变高电平),轴是否停止,0-不停止(默认),1-停止
	 * @param cstop_output_on  异常停止时是否输出CSTP信号,0-不输出(默认),1-输出,(暂不支持该参数)
	 * @param sync_option1     是否等待CSTA后启动该功能,0-不等待立即启动(默认),1-等待,(暂不支持该参数)
	 * @param sync_option2     保留
	 * @return 1表示正常,-1表示参数错
	 * @version 0.1
	 */
	 public int motion_set_sync_option(int axis, int sync_stop_on, int cstop_output_on, int sync_option1, int sync_option2);
	 
	 /**
	 * 设置多卡同步停止模式
	 * 
	 * @param axis 轴号
	 * @param stop_mode    停止模式:0-立即停止(默认),1-减速停止
	 * @return 1表示正常,-1表示参数错
	 * @version 0.1
	 */
	 public int motion_set_sync_stop_mode(int axis, int stop_mode);
	 
	 /**
	 * 去使能指定轴多卡同步功能,相关参数恢复默认值
	 * 
	 * @param axis   轴号
	 * @version 0.1
	 */
	 public void motion_simultaneous_disable(int axis);
	 
	 /**
	  * 结果反馈开关
	  * @param dwIsEnable
	  */
	 void Motion_SetResultSwitch( int dwIsEnable );
	 
	 /**
	  * 返回执行结果
	  * @return
	  */
	 public String Motion_GetLastResultInfo();
}
