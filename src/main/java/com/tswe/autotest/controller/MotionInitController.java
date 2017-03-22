package com.tswe.autotest.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;

import com.tswe.autotest.model.ControlBoard;
import com.tswe.autotest.service.InitControlBoardService;
import com.tswe.autotest.service.MotionCotrolService;
import com.tswe.common.constant.Constant;
import com.tswe.common.controller.FXMLController;
import com.tswe.common.util.DialogsUtil;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

@FXMLController
public class MotionInitController implements Initializable{
	
    @FXML 
    private Label label;
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
    private void connectButton() {
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
		}
		DialogsUtil.show(dialogType, dialogTitle, dialogMsg);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		connectPortGroup.selectToggle(serialPort);
//		label.setText(service.getText());
	}
	
	public void actionFactory(ArrayList<ControlBoard> controlBoards){
		motionControlService.setPulseOutmode(controlBoards.get(0).getAxias()[Constant.XAXIA], 0);
		motionControlService.setPulseOutmode(controlBoards.get(0).getAxias()[Constant.YAXIA], 0);
		motionControlService.setPulseOutmode(controlBoards.get(0).getAxias()[Constant.ZAXIA], 0);
		motionControlService.setPulseOutmode(controlBoards.get(0).getAxias()[Constant.WAXIA], 0);
		//配置运动曲线
		motionControlService.setProfile(controlBoards.get(0).getAxias()[Constant.ZAXIA], 1000, 5000, 0.5, 0.5);
		motionControlService.singleAxiaGoHome(controlBoards.get(0).getAxias()[Constant.ZAXIA], 
				Constant.ORGVALIDLOGIC, Constant.REVERSE, Constant.HIGHV);
		while(motionControlService.checkDone(controlBoards.get(0).getAxias()[Constant.HIGHV]) == 0){
			try {
				System.out.println(motionControlService.checkDone(controlBoards.get(0).getAxias()[Constant.HIGHV]));
				Thread.currentThread().sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		motionControlService.setProfile(controlBoards.get(0).getAxias()[Constant.WAXIA], 1000, 5000, 0.5, 0.5);
		motionControlService.singleAxiaGoHome(controlBoards.get(0).getAxias()[Constant.WAXIA], 
				Constant.ORGVALIDLOGIC, Constant.REVERSE, Constant.HIGHV);
		
		motionControlService.setProfile(controlBoards.get(0).getAxias()[Constant.XAXIA], 1000, 5000, 0.5, 0.5);
		motionControlService.singleAxiaGoHome(controlBoards.get(0).getAxias()[Constant.XAXIA], 
				Constant.ORGVALIDLOGIC, Constant.REVERSE, Constant.HIGHV);
		
		motionControlService.setProfile(controlBoards.get(0).getAxias()[Constant.YAXIA], 1000, 5000, 0.5, 0.5);
		motionControlService.singleAxiaGoHome(controlBoards.get(0).getAxias()[Constant.YAXIA], 
				Constant.ORGVALIDLOGIC, Constant.REVERSE, Constant.HIGHV);
	}
}
