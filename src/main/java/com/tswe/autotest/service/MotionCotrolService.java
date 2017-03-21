package com.tswe.autotest.service;

import org.springframework.stereotype.Component;
import com.tswe.autotest.model.Axia;
import com.tswe.autotest.model.ControlBoard;
import com.tswe.common.util.JNAInvokeDll;

@Component
public class MotionCotrolService {
	
	public void motionControl(Axia axia){
		
	}
	
	public void goHome(ControlBoard controlBoard){
		
	}
	
	/**
	 * 脉冲输出方式的设置
	 * 
	 * @param axia 轴号
	 *            
	 * @param outmode
	 *            输出模式（0-5）
	 * @return void
	 * @version 0.1
	 */
	public void setPulseOutmode(Axia axia, int outmode){
		axia.setPulseOutmode(outmode);
	}
	
	/**
	 * 配置限位信号工作模式
	 * 
	 * @param axia 轴号
	 * @param iElStopMode 停止模式 0立即停止，1减速停止
	 * @param iElLogic EL有效电平标志，0低电平有效，1高电平有效
	 * @return void
	 * @version 0.1
	 */
	public void configELMode(Axia axia, boolean iElStopMode, boolean iElLogic){
		if ( false == iElStopMode ){
	        if( false == iElLogic ){
	        	axia.configELMode(0);
	        }
	        else{
	        	axia.configELMode(2);
	        }
	    }
	    else{
	        if ( false == iElLogic ){
	        	axia.configELMode(1);
	        }
	        else{
	        	axia.configELMode(3);
	        }
	    }
	}
	
	public void configELMode(ControlBoard controlBoard, boolean iElStopMode, boolean iElLogic){
		for(Axia axia: controlBoard.getAxias()){
			configELMode(axia, iElStopMode, iElLogic);
		}
	}
	
	/*************************************************************************************/
	/***********************************回原点配置&运动**************************************/
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
	public void setHOMEPinLogic(Axia axia, int org_logic) {
		axia.setHOMEPinLogic(org_logic, 1);
	}
	
	/**
	 * 回原点信号模式
	 * @param axia     轴号
	 * @param mode     0-只计home, 1-home和EZ,目前只支持0
	 * @param EZ_count 仅mode为1时有效,取值1-16
	 * @version 0.1
	 */
	public void configHomeMode(Axia axia){
		axia.configHomeMode(0, 0);
	}
	
	public void configHomeMode(ControlBoard controlBoard){
		for(Axia axia: controlBoard.getAxias()){
			axia.configHomeMode(0, 0);
		}
	}
	
	/**
	 * 回原点命令,检测到原点信号后会自动停止运动
	 * @param axia     轴号
	 * @param mhome_mode  1-正方向回原点,2-负方向回原点
	 * @param vel_mode   0-低速回原点,1-高速回原点
	 * @version 0.1
	 */
	public void homeMove(Axia axia, int mhome_mode, int vel_mode){
		axia.homeMove(mhome_mode, vel_mode);
	}
	
	public void homeMove(ControlBoard controlBoard, int home_mode, int vel_mode){
		for(Axia axia: controlBoard.getAxias()){
			axia.homeMove(home_mode, vel_mode);
		}
	}
	
	/*************************************************************************************/
	/************************************速度曲线*******************************************/
	
	/**
	 * 设置轴梯形运动曲线
	 * 
	 * @param axia
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
	public void setProfile(Axia axia, double Min_Vel, double Max_Vel, double Tacc, double Tdec) {
		axia.setProfile(Min_Vel, Max_Vel, Tacc, Tdec);
	}
	
	public void setProfile(ControlBoard controlBoard, double Min_Vel, double Max_Vel, double Tacc, double Tdec, int home_mode, int vel_mode){
		for(Axia axia: controlBoard.getAxias()){
			axia.setProfile(Min_Vel, Max_Vel, Tacc, Tdec);
		}
	}
	
	/**
	 * 设置S形速度曲线(按S段时间)
	 * 
	 * @param axia
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
	public void setStProfile(Axia axia, double Min_Vel, double Max_Vel, double Tacc, double Tdec, double Tsacc, double Tsdec) {
		axia.setStProfile(Min_Vel, Max_Vel, Tacc, Tdec, Tsacc, Tsdec);
	}
	
	public void setStProfile(ControlBoard controlBoard, double Min_Vel, double Max_Vel, double Tacc, double Tdec, double Tsacc, double Tsdec){
		for(Axia axia: controlBoard.getAxias()){
			axia.setStProfile(Min_Vel, Max_Vel, Tacc, Tdec, Tsacc, Tsdec);
		}
	}
	
	/**
	 * 在线改变指定轴的当前运动速度
	 * 
	 * @param axia
	 *            轴号
	 * @param Curr_Vel
	 *            新的运行速度，单位pps
	 * @version 0.1
	 */
	public void changeSpeed(Axia axia, double Curr_Vel) {
		axia.changeSpeed(Curr_Vel);
	}
	
	public void changeSpeed(ControlBoard controlBoard, double Curr_Vel){
		for(Axia axia: controlBoard.getAxias()){
			axia.changeSpeed(Curr_Vel);
		}
	}
	
	/*************************************************************************************/
	/************************************运动方式*******************************************/
	
	/**
	 * 单轴梯形定长运动(对称的T形加减速)
	 * 
	 * @param axis 轴号
	 * @param Dist 位移
	 * @param posi_mode 0-相对位移,1-绝对位移
	 * @version 0.1
	 */
	public void tPMove(Axia axia, int Dist, int posi_mode){
		axia.tPMove(Dist, posi_mode);
	}
	
	/**
	 * 单轴S形定长运动(对称的S形加减速)
	 * 
	 * @param axis
	 *            轴号
	 * @param Dist
	 *            位移
	 * @param posi_mode
	 *            0-相对位移,1-绝对位移
	 * @version 0.1
	 */
	public void sPMove(Axia axia, int Dist, int posi_mode){
		axia.sPMove(Dist, posi_mode);
	}
	
	/**
	 * 单轴梯形加速连续运动
	 * 
	 * @param axis 轴号
	 * @param dir 0-负方向,1-正方向
	 * @version 0.1
	 */
	 public void tVMove(Axia axia, int dir){
		 axia.tVMove(dir);
	 }
	 
	 
}
