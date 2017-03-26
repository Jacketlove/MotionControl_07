package com.tswe.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tswe.autotest.model.Axis;
import com.tswe.autotest.service.InitControlBoardService;
import com.tswe.common.constant.DllReturnInfo;

public class CommonUtil{
	
	public static Logger logger = LoggerFactory.getLogger(InitControlBoardService.class);
	
	/**
	 * dll函数库返回数据处理，通过返回数据判断是否调用成功
	 * @param methodName dll函数库名称
	 * @return false调用失败， true 调用成功
	 */
	public static boolean dllReturn(Axis axis, String methodName){
		if(null != methodName&& !"".equals(methodName)){
			//信息枚举迭代，查找对应与函数名对应的枚举类型
			for(DllReturnInfo dllReturnInfo: DllReturnInfo.values()){
				if(dllReturnInfo.getMethodName() == methodName){
					String returnInfo = JNAInvokeDll.motionDrvDll.Motion_GetLastResultInfo();
					logger.info("AxisNum:{}",axis.getAxisNum());
					logger.info(returnInfo);
					if(dllReturnInfo.getFailedInfo() != null &&dllReturnInfo.getSuccessInfo().length != 0){
						//失败信息不为空,和返回信息比较
						for(String failedInfo: dllReturnInfo.getFailedInfo()){
							//返回信息和失败信息相匹配，返回false
							if( failedInfo.equals(returnInfo)){
								return false;
							}
						}
					}
					
					if(dllReturnInfo.getSuccessInfo() == null ||dllReturnInfo.getSuccessInfo().length != 0){
						//枚举中成功信息为空，直接返回true,不用判断
						return true;
					}else{
						//枚举中成功信息不为空，和返回信息比较
						for(String successInfo: dllReturnInfo.getSuccessInfo()){
							//返回信息和成功信息相匹配 返回true
							if( successInfo.equals(returnInfo)){
								return true;
							}
						}
					}
				}
			}
			//未找到和函数名对应的枚举,返回true
			return true;
		}
		//函数名为空
		return false;
	}
	
	/**
	 * dll函数库返回数据处理，通过返回数据判断是否调用成功
	 * @param methodName dll函数库名称
	 * @return false调用失败， true 调用成功
	 */
	public static boolean dllReturn(String methodName){
		if(null != methodName&& !"".equals(methodName)){
			//信息枚举迭代，查找对应与函数名对应的枚举类型
			for(DllReturnInfo dllReturnInfo: DllReturnInfo.values()){
				if(dllReturnInfo.getMethodName() == methodName){
					String returnInfo = JNAInvokeDll.motionDrvDll.Motion_GetLastResultInfo();
					logger.info(returnInfo);
					if(dllReturnInfo.getFailedInfo() != null &&dllReturnInfo.getSuccessInfo().length != 0){
						//失败信息不为空,和返回信息比较
						for(String failedInfo: dllReturnInfo.getFailedInfo()){
							//返回信息和失败信息相匹配，返回false
							if( failedInfo.equals(returnInfo)){
								return false;
							}
						}
					}
					
					if(dllReturnInfo.getSuccessInfo() == null ||dllReturnInfo.getSuccessInfo().length != 0){
						//枚举中成功信息为空，直接返回true,不用判断
						return true;
					}else{
						//枚举中成功信息不为空，和返回信息比较
						for(String successInfo: dllReturnInfo.getSuccessInfo()){
							//返回信息和成功信息相匹配 返回true
							if( successInfo.equals(returnInfo)){
								return true;
							}
						}
					}
				}
			}
			//未找到和函数名对应的枚举,返回true
			return true;
		}
		//函数名为空
		return false;
	}
	
	public String isVelInputValid(double Min_Vel, double Max_Vel, double Tacc, double Tdec){
		String msg = "";
		return msg;
	}
	
	public String isVelInputValid(double Min_Vel, double Max_Vel, double Tacc, double Tdec, double Tsacc, double Tsdec){
		String msg = "";
		return msg;
	}
	
	public String isVelInputValid(double CurrVel){
		String msg = "";
		return msg;
	}
}