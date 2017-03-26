package com.tswe.autotest.service;

import java.util.ArrayList;

import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tswe.autotest.model.ControlBoard;
import com.tswe.common.util.CommonUtil;
import com.tswe.common.util.JNAInvokeDll;


@Component
public class InitControlBoardService {
	//连接方式
	private static String connectType;
	private Logger logger = LoggerFactory.getLogger(InitControlBoardService.class);
 
	/**
	 * 控制板初始化函数，线程同步，防止多个线程同时初始化端口造成错误
	 * 
	 * @param connectType 连接类型，Serial Port或者PCI Port
	 * @return
	 */
	public synchronized ArrayList<ControlBoard> connectControlBoard(String connectType){
		ArrayList<ControlBoard> controlBoards= new ArrayList<ControlBoard>();
		InitControlBoardService.connectType = connectType;
		int controlBoardNum = 0;
		if("Serial Port".equals(connectType)){
			controlBoardNum = JNAInvokeDll.motionDrvDll.motion_board_init_serial();
			//串口只支持一张卡，一台电脑就自带一个串口
			if(controlBoardNum == 1){
				controlBoards.add(new ControlBoard(0));
				logger.info("connectType：{}, controlBoardNum:{},info:{}", 
						connectType, controlBoardNum, "connectsuccess");
				return controlBoards;
			}else {
				logger.info("connectType：{}, controlBoardNum:{},info:{}", 
						connectType, controlBoardNum, "connectType error");
				return null;
			}
		}else if("PCI Port".equals(connectType)){
			controlBoardNum = JNAInvokeDll.motionDrvDll.motion_board_init();
			//PCI端口最多可以扩展到控制17张板子
			if(controlBoardNum>0 && controlBoardNum<17){
				for(int i=0; i<=controlBoardNum; i++){
					controlBoards.add(new ControlBoard(i));
				}
				logger.info("connectType：{},controlBoardNum:{},info:{}", 
						connectType, controlBoardNum, "connect success");
				return controlBoards;
			}else{
				logger.info("connectType：{},controlBoardNum:{},info:{}", 
						connectType, controlBoardNum, "no find controlBoard");
				return null;
			}
		}
		logger.info("connectType：{},controlBoardNum:{},info:{}",
				connectType, controlBoardNum, "connectType error");
		return null;
	}

	public boolean connectControlBoardClose(){
		JNAInvokeDll.motionDrvDll.motion_board_close();
		if(CommonUtil.dllReturn("motion_board_close")){
			logger.info("motion_board_close return: true");
			return true;
		}else {
			logger.info("motion_board_close return: false");
			return false;
		}
	}
}
