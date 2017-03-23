package com.tswe.autotest.controller;

import java.awt.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.omg.CORBA.COMM_FAILURE;
import org.springframework.beans.factory.annotation.Autowired;

import com.tswe.autotest.model.ControlBoard;
import com.tswe.autotest.service.InitControlBoardService;
import com.tswe.autotest.service.MotionCotrolService;
import com.tswe.autotest.service.ActionFactoryThread;
import com.tswe.common.constant.Constant;
import com.tswe.common.controller.FXMLController;
import com.tswe.common.util.CommonUtil;
import com.tswe.common.util.DialogsUtil;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

@FXMLController
public class MotionInitController implements Initializable{
	@FXML
	private TextField xMaxVel;
	@FXML
	private TextField yMaxVel;
	@FXML
	private TextField zMaxVel;
	@FXML
	private TextField wMaxVel;
	@FXML
	private TextField tMaxVel;
	@FXML
	private TextField xMinVel;
	@FXML
	private TextField yMinVel;
	@FXML
	private TextField zMinVel;
	@FXML
	private TextField wMinVel;
	@FXML
	private TextField tMinVel;
	@FXML
	private TextField xTacc;
	@FXML
	private TextField yTacc;
	@FXML
	private TextField zTacc;
	@FXML
	private TextField wTacc;
	@FXML
	private TextField tTacc;
	@FXML
	private TextField xTdec;
	@FXML
	private TextField yTdec;
	@FXML
	private TextField zTdec;
	@FXML
	private TextField wTdec;
	@FXML
	private TextField tTdec;
	@FXML
	private TextField xTsacc;
	@FXML
	private TextField yTsacc;
	@FXML
	private TextField zTsacc;
	@FXML
	private TextField wTsacc;
	@FXML
	private TextField tTsacc;
	@FXML
	private TextField xTsdec;
	@FXML
	private TextField yTsdec;
	@FXML
	private TextField zTsdec;
	@FXML
	private TextField wTsdec;
	@FXML
	private TextField tTsdec;
	
    @FXML
    private Label label;
    @FXML
    private Label statusInfo;
	@FXML
	private RadioButton serialPort;
	@FXML
	private ToggleGroup connectPortGroup;
	@Autowired
	private InitControlBoardService initControlBoardService;
	@Autowired
	private MotionCotrolService motionControlService;
	
	private ArrayList<ControlBoard> controlBoards;
	
	@FXML
    private void connectButton(){
		//提示框类容
		String dialogType="";
		//提示框标容
		String dialogTitle = "";
		//提示框内容
		String dialogMsg = "";
		
		String connectType = ((RadioButton)connectPortGroup.getSelectedToggle()).getText();
		this.controlBoards = initControlBoardService.connectControlBoard(connectType);
		if(null == controlBoards){
			dialogType += "Warning";
			dialogTitle += "连接失败";
			dialogMsg += "连接方式:"+connectType+"\n";
			dialogMsg += "连接控制板数量: 0";
		}else {
			dialogType += "information";
			dialogTitle += "连接成功";
			dialogMsg += "连接方式:"+connectType+"\n";
			dialogMsg += "连接控制板量?"+controlBoards.size();
			motionControlService.configELMode(controlBoards.get(Constant.CONTROLBOARDNUM).getAxias()[Constant.XAXIA], Constant.ELMODE);
			motionControlService.configELMode(controlBoards.get(Constant.CONTROLBOARDNUM).getAxias()[Constant.YAXIA], Constant.ELMODE);
			motionControlService.configELMode(controlBoards.get(Constant.CONTROLBOARDNUM).getAxias()[Constant.ZAXIA], Constant.ELMODE);
			motionControlService.configELMode(controlBoards.get(Constant.CONTROLBOARDNUM).getAxias()[Constant.WAXIA], Constant.ELMODE);
		}
		DialogsUtil.show(dialogType, dialogTitle, dialogMsg);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		connectPortGroup.selectToggle(serialPort);
		//初始化4个轴的EL配置
	}
	
	@SuppressWarnings("static-access")
	@FXML
	public void actionFactory(){
		Thread thread = new Thread(new ActionFactoryThread(controlBoards.get(0)));
		thread.start();
	}
	
	public void goELPlus(){
		//Z轴回原点
		statusInfo.setText("Z轴回原点");
		motionControlService.setVel(controlBoards.get(0).getAxias()[Constant.ZAXIA], 1000, 5000, 0.5, 0.5);
		motionControlService.singleAxiaGoHome(controlBoards.get(0).getAxias()[Constant.ZAXIA], 
				Constant.ORGVALIDLOGIC, Constant.REVERSEGOHOME, Constant.HIGHV);
		while(motionControlService.checkDone(controlBoards.get(0).getAxias()[Constant.HIGHV]) == 0){
			try {
				System.out.println(motionControlService.checkDone(controlBoards.get(0).getAxias()[Constant.HIGHV]));
				Thread.currentThread().sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void goFixedPoint(){
		
	}
	
	public void setProfile(){
		
	}
}
