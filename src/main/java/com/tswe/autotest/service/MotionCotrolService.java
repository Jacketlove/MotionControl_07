package com.tswe.autotest.service;

import org.springframework.stereotype.Component;
import com.tswe.autotest.model.Axis;
import com.tswe.autotest.model.ControlBoard;
import com.tswe.common.constant.Constant;
	
@Component
public class MotionCotrolService {
	
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
	public void setPulseOutmode(Axis axis, int outmode){
		axis.setPulseOutmode(outmode);
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
	public void configELMode(Axis axis, boolean iElStopMode, boolean iElLogic){
		if ( false == iElStopMode ){
	        if( false == iElLogic ){
	        	axis.configELMode(0);
	        }
	        else{
	        	axis.configELMode(2);
	        }
	    }
	    else{
	        if ( false == iElLogic ){
	        	axis.configELMode(1);
	        }
	        else{
	        	axis.configELMode(3);
	        }
	    }
	}
	
	/*************************************************************************************/
	/***********************************回原点配置&运动**************************************/
	/**
	 * 配置原点信号
	 * 
	 * @param axis 轴号
	 *            
	 * @param orgLogic
	 *            0-低有效,1-高有效
	 * @param filter
	 *            滤波功能0-禁止,1-允许
	 * @return void
	 * @version 0.1
	 */
	public void setHOMEPinLogic(Axis axis, int org_logic, int filter) {
		axis.setHOMEPinLogic(org_logic, filter);
	}
//	public void setHOMEPinLogic(Axis axis, int orgLogic, int filter) {
//		axis.setOrgLogic(orgLogic);
//		axis.setFilter(filter);
//		axis.setCmd("setHOMEPinLogic");
//		if(axis.getBusynessFlag() == Constant.NOBUSYNESS){
//			new Thread(axis).start();
//		}
//	}
	
	/**
	 * 回原点信号模式
	 * @param axis     轴号
	 * @param mode     0-只计home, 1-home和EZ,目前只支持0
	 * @param EZ_count 仅mode为1时有效,取值1-16
	 * @version 0.1
	 */
	public void configHomeMode(Axis axis){
		axis.configHomeMode(0, 0);
	}
	
	public void configHomeModeT(Axis axis){
		axis.setMode(0);
		axis.setEZCount(0);
		axis.setCmd("configHomeMode");
		if(axis.getBusynessFlag() == Constant.NOBUSYNESS){
			new Thread(axis).start();
		}
		axis.configHomeMode(0, 0);
	}
	
	public void configHomeMode(ControlBoard controlBoard){
		for(Axis axis: controlBoard.getAxias()){
			axis.configHomeMode(0, 0);
		}
	}
	
	/**
	 * 回原点命令,检测到原点信号后会自动停止运动
	 * @param axis     轴号
	 * @param mhome_mode  1-正方向回原点,2-负方向回原点
	 * @param vel_mode   0-低速回原点,1-高速回原点
	 * @version 0.1
	 */
	public void homeMove(Axis axis, int mhome_mode, int vel_mode){
		axis.homeMove(mhome_mode, vel_mode);
	}
	
	public void homeMove(ControlBoard controlBoard, int home_mode, int vel_mode){
		for(Axis axis: controlBoard.getAxias()){
			axis.homeMove(home_mode, vel_mode);
		}
	}
	
	/*************************************************************************************/
	/************************************速度曲线*******************************************/
	
	/**
	 * 设置轴梯形速度曲线
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
	public void setProfile(ControlBoard controlBoard, double Min_Vel, double Max_Vel, double Tacc, double Tdec){
		for(Axis axis: controlBoard.getAxias()){
			axis.setProfile(Min_Vel, Max_Vel, Tacc, Tdec);
		}
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
	 * @param Tsacc
	 * 
	 * @param Tsdec          
	 *            
	 * @version 0.1
	 */
	public void setStProfile(ControlBoard controlBoard, double Min_Vel, double Max_Vel, double Tacc, double Tdec, double Tsacc, double Tsdec){
		for(Axis axis: controlBoard.getAxias()){
			axis.setStProfile(Min_Vel, Max_Vel, Tacc, Tdec, Tsacc, Tsdec);
		}
	}
	
	/**
	 * 在线改变指定轴的当前运动速度
	 * 
	 * @param axis
	 *            轴对象
	 * @param Curr_Vel
	 *            新的运行速度，单位pps
	 * @version 0.1
	 */
	public void changeSpeed(Axis axis, double Curr_Vel) {
		axis.changeSpeed(Curr_Vel);
	}
	/**
	 * 在线改变指定轴的当前运动速度
	 * 
	 * @param controlBoard
	 *            控制板对象
	 * @param Curr_Vel
	 *            新的运行速度，单位pps
	 * @version 0.1
	 */
	public void changeSpeed(ControlBoard controlBoard, double Curr_Vel){
		for(Axis axis: controlBoard.getAxias()){
			axis.changeSpeed(Curr_Vel);
		}
	}
	
	/**
	 * 设置速度曲线
	 * 
	 * @param axis 轴对象
	 * @param velMode 速度曲线类型 Constant.TV 0 t形   / Constant.SV 1 S形
	 * @param Min_Vel 开始速度
	 * @param Max_Vel 运行速度
	 * @param Tacc 加速时间
	 * @param Tdec 减速时间
	 * @param Tsacc 
	 * @param Tsdec
	 */
	public boolean setVel(Axis axis, int velMode, double Min_Vel, double Max_Vel, double Tacc, double Tdec, double Tsacc, double Tsdec){
		switch (velMode) {
		case Constant.TV:
			return axis.setProfile(Min_Vel, Max_Vel, Tacc, Tdec);
			
		case Constant.SV:
			return axis.setStProfile(Min_Vel, Max_Vel, Tacc, Tdec, Tsacc, Tsdec);
			
		default:
			return false;
		}
	}
	
	/**
	 * 设置速度曲线为T形
	 * 
	 * @param axis 轴对象
	 * @param Min_Vel 开始速度
	 * @param Max_Vel 运行速度
	 * @param Tacc 加速时间
	 * @param Tdec 减速时间
	 * @return
	 */
	public boolean setVel(Axis axis, double Min_Vel, double Max_Vel, double Tacc, double Tdec){
		return axis.setProfile(Min_Vel, Max_Vel, Tacc, Tdec);
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
	 * @return
	 */
	public boolean setVel(Axis axis, double Min_Vel, double Max_Vel, double Tacc, double Tdec, double Tsacc, double Tsdec){
		return axis.setStProfile(Min_Vel, Max_Vel, Tacc, Tdec, Tsacc, Tsdec);
	}
	
	/*************************************************************************************/
	/************************************运动方式*******************************************/
	
	 /**
	  * 定长运动
	  * 
	  * @param axis
	  * @param Dist 0 负方向 /1 正方向
	  * @param posi_mode 0-相对位移,1-绝对位移
	  * @return
	  */
	public boolean move(Axis axis, int Dist, int posi_mode){
		switch (axis.getVelType()) {
			case Constant.TV:
				return axis.sPMove(Dist, posi_mode);
				
			case Constant.SV:
				return axis.sPMove(Dist, posi_mode);
				
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
	public boolean move(Axis axis, int dir){
		switch (axis.getVelType()) {
			case Constant.TV:
				return axis.tVMove(dir);
				
			case Constant.SV:
				return axis.sVMove(dir);
				
			default:
				return false;
			}
	}
	/********************************************************************************
	*********************************** 停止  *****************************************/
	 
	 /**
	 * 减速停止
	 * 
	 * @param axis      轴号
	 * @param Tdec      减速时间，单位s
	 * @version 0.1
	 */
	 public void decelStop(Axis axis, double Tdec){
		 axis.decelStop(Tdec);
	 }
		 
	 /**
	 * 立即停止
	 * 
	 * @param axis      轴号
	 * @version 0.1
	 */
	 public void motionImdStop(Axis axis){
		 axis.motionImdStop();
	 }
	 
	 /**
	 * 读取轴运动状态
	 * 
	 * @param axis
	 *            轴号
	 * @return 0:运动 1:停止
	 * @version 0.1
	 */
	public int checkDone(Axis axis) {
		return axis.checkDone();
	}
	
	/**
	 * 单轴回原点
	 * @param axis 轴对象
	 * @param org_logic 0-低有效,1-高有效
	 * @param mhome_mode 1-正方向回原点,2-负方向回原点
	 * @param vel_mode 0-低速回原点,1-高速回原点
	 *
	 */
	public void singleAxiaGoHome(Axis axis, int org_logic, int mhome_mode, int vel_mode){
		
		//配置运动曲线
		axis.setProfile(1000, 5000, 0.5, 0.5);
		//配置原点信号
		setHOMEPinLogic(axis, org_logic, 1);
		//设置回原点模式
		configHomeMode(axis);
		//原点运动开始 负方向回原点
		homeMove(axis, 2, 1);
	}
	
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
	public boolean configELMode(Axis axis, int el_mode){
		return axis.configELMode(el_mode);
	}
	
	
	/*************************************************************************************/
	
	
}
