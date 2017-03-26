package com.tswe.autotest.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import com.tswe.autotest.model.Axis;
import com.tswe.autotest.model.ControlBoard;
import com.tswe.autotest.service.InitControlBoardService;
import com.tswe.autotest.service.MotionControlThread;
import com.tswe.common.constant.Constant;
import com.tswe.common.controller.FXMLController;
import com.tswe.common.util.DialogsUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
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
    private ComboBox<String> xVelType;
    @FXML
    private ComboBox<String> yVelType;
    @FXML
    private ComboBox<String> zVelType;
    @FXML
    private ComboBox<String> wVelType;
    @FXML
    private ComboBox<String> tVelType;
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
	
	private ArrayList<ControlBoard> controlBoards;
	
	private MotionControlThread motionControlThread;
	
	@FXML
    private void connectButton(){
		//提示框类容
		String dialogType="";
		//提示框标容
		String dialogTitle = "";
		//提示框内容
		String dialogMsg = "";
		//如果已经连接则直接退出
		if(null != controlBoards){
			return;
		}
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
			motionControlThread = new MotionControlThread(controlBoards.get(0));
		}
		DialogsUtil.show(dialogType, dialogTitle, dialogMsg);
	}

	@FXML
	public void disConnectButton(){
		//如果已经断开连接 则直接退出
		if(controlBoards == null)
			return;
		initControlBoardService.connectControlBoardClose();
		controlBoards = null;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		connectPortGroup.selectToggle(serialPort);
		//初始化4个轴的EL配置
	}
	
	@FXML
	public void actionFactory(){
		
	}
	
	/*********************************************************************************
	 ********************************** GoELPlus *************************************
	 *********************************************************************************/
	@FXML
	public void xAxisGoELPlus(){
		singleAAxisGoELPlus(controlBoards.get(0).getAxias()[Constant.XAXIA]);
	}
	
	@FXML
	public void yAxisGoELPlus(){
		singleAAxisGoELPlus(controlBoards.get(0).getAxias()[Constant.YAXIA]);
	}
	
	@FXML
	public void zAxisGoELPlus(){
		//singleAAxisGoELPlus(controlBoards.get(0).getAxias()[Constant.ZAXIA]);
	}
	
	@FXML
	public void wAxisGoELPlus(){
		singleAAxisGoELPlus(controlBoards.get(0).getAxias()[Constant.WAXIA]);
	}
	
	public void singleAAxisGoELPlus(Axis axis){
		if(axis.isBusynessFlag())
			return ;
		motionControlThread.setAxis(axis);
		motionControlThread.setCmd("singleAixsGoELPlus");
		new Thread(motionControlThread).start();
	}
	
	@FXML
	public void allAxisGoELPlus(){
		//判断是否有资源执行此操作
		if(controlBoards.get(0).getAxias()[Constant.XAXIA].isBusynessFlag() == Constant.ISBUSYNESS||
				controlBoards.get(0).getAxias()[Constant.YAXIA].isBusynessFlag() == Constant.ISBUSYNESS||
				controlBoards.get(0).getAxias()[Constant.WAXIA].isBusynessFlag() == Constant.ISBUSYNESS)
			return ;
		motionControlThread.setCmd("AllAxisGoELPlus");
		new Thread(motionControlThread).start();
	}
	
	public void goFixedPoint(){
		
	}
	
	/*********************************************************************************
	 ********************************** goHome ***************************************
	 *********************************************************************************/
	
	@FXML
	public void xAxisGoHome(){
		singleAxiaGoHome(controlBoards.get(0).getAxias()[Constant.XAXIA]);
	}
	
	@FXML
	public void yAxisGoHome(){
		singleAxiaGoHome(controlBoards.get(0).getAxias()[Constant.YAXIA]);
	}
	
	@FXML
	public void zAxisGoHome(){
		singleAxiaGoHome(controlBoards.get(0).getAxias()[Constant.ZAXIA]);
	}
	
	@FXML
	public void wAxisGoHome(){
		singleAxiaGoHome(controlBoards.get(0).getAxias()[Constant.WAXIA]);
	}
	
	public void singleAxiaGoHome(Axis axis){
		//判断是否有资源执行此操作
		if(axis.isBusynessFlag())
			return ;
		motionControlThread.setAxis(axis);
		motionControlThread.setCmd("singleAxiaGoHome");
		new Thread(motionControlThread).start();
	}
	
	@FXML
	public void allAxiaGoHome(){
		//判断是否有资源执行此操作
		if(controlBoards.get(0).getAxias()[Constant.XAXIA].isBusynessFlag()||
				controlBoards.get(0).getAxias()[Constant.YAXIA].isBusynessFlag()||
				controlBoards.get(0).getAxias()[Constant.ZAXIA].isBusynessFlag()||
				controlBoards.get(0).getAxias()[Constant.WAXIA].isBusynessFlag())
			return ;
		motionControlThread.setCmd("allAxiaGoHome");
		new Thread(motionControlThread).start();
	}
	
	/*********************************************************************************
	 ********************************** 速度设置  ***************************************
	 *********************************************************************************/
	@FXML
	public void xAxisSetVel(){
		if(controlBoards.get(0).getAxias()[Constant.XAXIA].isBusynessFlag())
			return ;
		motionControlThread.setMaxVel(Double.parseDouble(xMaxVel.getText()));
		motionControlThread.setMinVel(Double.parseDouble(xMinVel.getText()));
		motionControlThread.setTacc(Double.parseDouble(xTacc.getText()));
		motionControlThread.setTdec(Double.parseDouble(xTdec.getText()));
		if("T形速度曲线".equals(xVelType.getSelectionModel().getSelectedItem())){
			motionControlThread.setVelType(Constant.TV);
		}else if ("S形速度曲线".equals(xVelType.getSelectionModel().getSelectedItem())) {
			motionControlThread.setVelType(Constant.SV);
			motionControlThread.setTsacc(Double.parseDouble(xTsacc.getText()));
			motionControlThread.setTsdec(Double.parseDouble(xTsdec.getText()));
		}
		motionControlThread.setCmd("singleAxisSetVel");
		motionControlThread.setAxis(controlBoards.get(0).getAxias()[Constant.XAXIA]);
		new Thread(motionControlThread).start();
	}
	
	@FXML
	public void yAxisSetVel(){
		if(controlBoards.get(0).getAxias()[Constant.YAXIA].isBusynessFlag())
			return ;
		motionControlThread.setMaxVel(Double.parseDouble(yMaxVel.getText()));
		motionControlThread.setMinVel(Double.parseDouble(yMinVel.getText()));
		motionControlThread.setTacc(Double.parseDouble(yTacc.getText()));
		motionControlThread.setTdec(Double.parseDouble(yTdec.getText()));
		if("T形速度曲线".equals(yVelType.getSelectionModel().getSelectedItem())){
			motionControlThread.setVelType(Constant.TV);
		}else if ("S形速度曲线".equals(yVelType.getSelectionModel().getSelectedItem())) {
			motionControlThread.setVelType(Constant.SV);
			motionControlThread.setTsacc(Double.parseDouble(yTsacc.getText()));
			motionControlThread.setTsdec(Double.parseDouble(yTsdec.getText()));
		}
		motionControlThread.setCmd("singleAxisSetVel");
		motionControlThread.setAxis(controlBoards.get(0).getAxias()[Constant.YAXIA]);
		new Thread(motionControlThread).start();
	}
	
	@FXML//Z轴速度设置
	public void zAxisSetVel(){
		if(controlBoards.get(0).getAxias()[Constant.ZAXIA].isBusynessFlag())
			return ;
		motionControlThread.setMaxVel(Double.parseDouble(zMaxVel.getText()));
		motionControlThread.setMinVel(Double.parseDouble(zMinVel.getText()));
		motionControlThread.setTacc(Double.parseDouble(zTacc.getText()));
		motionControlThread.setTdec(Double.parseDouble(zTdec.getText()));
		if("T形速度曲线".equals(zVelType.getSelectionModel().getSelectedItem())){
			motionControlThread.setVelType(Constant.TV);
		}else if ("S形速度曲线".equals(zVelType.getSelectionModel().getSelectedItem())) {
			motionControlThread.setVelType(Constant.SV);
			motionControlThread.setTsacc(Double.parseDouble(zTsacc.getText()));
			motionControlThread.setTsdec(Double.parseDouble(zTsdec.getText()));
		}
		motionControlThread.setCmd("singleAxisSetVel");
		motionControlThread.setAxis(controlBoards.get(0).getAxias()[Constant.ZAXIA]);
		new Thread(motionControlThread).start();
	}
	
	@FXML//W轴速度设置
	public void wAxisSetVel(){
		if(controlBoards.get(0).getAxias()[Constant.WAXIA].isBusynessFlag())
			return ;
		motionControlThread.setMaxVel(Double.parseDouble(wMaxVel.getText()));
		motionControlThread.setMinVel(Double.parseDouble(wMinVel.getText()));
		motionControlThread.setTacc(Double.parseDouble(wTacc.getText()));
		motionControlThread.setTdec(Double.parseDouble(wTdec.getText()));
		if("T形速度曲线".equals(wVelType.getSelectionModel().getSelectedItem())){
			motionControlThread.setVelType(Constant.TV);
		}else if ("S形速度曲线".equals(wVelType.getSelectionModel().getSelectedItem())) {
			motionControlThread.setVelType(Constant.SV);
			motionControlThread.setTsacc(Double.parseDouble(wTsacc.getText()));
			motionControlThread.setTsdec(Double.parseDouble(wTsdec.getText()));
		}
		motionControlThread.setCmd("singleAxisSetVel");
		motionControlThread.setAxis(controlBoards.get(0).getAxias()[Constant.WAXIA]);
		new Thread(motionControlThread).start();
	}
	
	@FXML//T轴速度设置
	public void tAxisSetVel(){
		if(controlBoards.get(0).getAxias()[Constant.TAXIA].isBusynessFlag())
			return ;
		motionControlThread.setMaxVel(Double.parseDouble(tMaxVel.getText()));
		motionControlThread.setMinVel(Double.parseDouble(tMinVel.getText()));
		motionControlThread.setTacc(Double.parseDouble(tTacc.getText()));
		motionControlThread.setTdec(Double.parseDouble(tTdec.getText()));
		if("T形速度曲线".equals(tVelType.getSelectionModel().getSelectedItem())){
			motionControlThread.setVelType(Constant.TV);
		}else if ("S形速度曲线".equals(tVelType.getSelectionModel().getSelectedItem())) {
			motionControlThread.setVelType(Constant.SV);
			motionControlThread.setTsacc(Double.parseDouble(tTsacc.getText()));
			motionControlThread.setTsdec(Double.parseDouble(tTsdec.getText()));
		}
		motionControlThread.setCmd("singleAxisSetVel");
		motionControlThread.setAxis(controlBoards.get(0).getAxias()[Constant.TAXIA]);
		new Thread(motionControlThread).start();
	}
	
	@FXML
	public void allAxisSetVel(){
		//判断是否有资源执行此操作
		if(controlBoards.get(0).getAxias()[Constant.XAXIA].isBusynessFlag()||
				controlBoards.get(0).getAxias()[Constant.YAXIA].isBusynessFlag()||
				controlBoards.get(0).getAxias()[Constant.ZAXIA].isBusynessFlag()||
				controlBoards.get(0).getAxias()[Constant.WAXIA].isBusynessFlag()||
				controlBoards.get(0).getAxias()[Constant.TAXIA].isBusynessFlag())
			return ;
		//X轴参数传递
		if("T形速度曲线".equals(xVelType.getSelectionModel().getSelectedItem())){
			motionControlThread.setxVelType(Constant.TV);
			motionControlThread.setxMaxVel(Double.parseDouble(xMaxVel.getText()));
			motionControlThread.setxMinVel(Double.parseDouble(xMinVel.getText()));
			motionControlThread.setxTacc(Double.parseDouble(xTacc.getText()));
			motionControlThread.setxTdec(Double.parseDouble(xTdec.getText()));
		}else if ("S形速度曲线".equals(xVelType.getSelectionModel().getSelectedItem())) {
			motionControlThread.setxVelType(Constant.SV);
			motionControlThread.setxMaxVel(Double.parseDouble(xMaxVel.getText()));
			motionControlThread.setxMinVel(Double.parseDouble(xMinVel.getText()));
			motionControlThread.setxTacc(Double.parseDouble(xTacc.getText()));
			motionControlThread.setxTdec(Double.parseDouble(xTdec.getText()));
			motionControlThread.setxTsacc(Double.parseDouble(xTsacc.getText()));
			motionControlThread.setxTsdec(Double.parseDouble(xTsdec.getText()));
		}
		//Y轴参数传递
		if("T形速度曲线".equals(yVelType.getSelectionModel().getSelectedItem())){
			motionControlThread.setyVelType(Constant.TV);
			motionControlThread.setyMaxVel(Double.parseDouble(yMaxVel.getText()));
			motionControlThread.setyMinVel(Double.parseDouble(yMinVel.getText()));
			motionControlThread.setyTacc(Double.parseDouble(yTacc.getText()));
			motionControlThread.setyTdec(Double.parseDouble(yTdec.getText()));
		}else if ("S形速度曲线".equals(yVelType.getSelectionModel().getSelectedItem())) {
			motionControlThread.setyVelType(Constant.SV);
			motionControlThread.setyMaxVel(Double.parseDouble(yMaxVel.getText()));
			motionControlThread.setyMinVel(Double.parseDouble(yMinVel.getText()));
			motionControlThread.setyTacc(Double.parseDouble(yTacc.getText()));
			motionControlThread.setyTdec(Double.parseDouble(yTdec.getText()));
			motionControlThread.setyTsacc(Double.parseDouble(yTsacc.getText()));
			motionControlThread.setyTsdec(Double.parseDouble(yTsdec.getText()));
		}
		//Z轴参数传递
		if("T形速度曲线".equals(zVelType.getSelectionModel().getSelectedItem())){
			motionControlThread.setzVelType(Constant.TV);
			motionControlThread.setzMaxVel(Double.parseDouble(zMaxVel.getText()));
			motionControlThread.setzMinVel(Double.parseDouble(zMinVel.getText()));
			motionControlThread.setzTacc(Double.parseDouble(zTacc.getText()));
			motionControlThread.setzTdec(Double.parseDouble(zTdec.getText()));
		}else if ("S形速度曲线".equals(zVelType.getSelectionModel().getSelectedItem())) {
			motionControlThread.setzVelType(Constant.SV);
			motionControlThread.setzMaxVel(Double.parseDouble(zMaxVel.getText()));
			motionControlThread.setzMinVel(Double.parseDouble(zMinVel.getText()));
			motionControlThread.setzTacc(Double.parseDouble(zTacc.getText()));
			motionControlThread.setzTdec(Double.parseDouble(zTdec.getText()));
			motionControlThread.setzTsacc(Double.parseDouble(zTsacc.getText()));
			motionControlThread.setzTsdec(Double.parseDouble(zTsdec.getText()));
		}
		//W轴参数传递
		if("T形速度曲线".equals(wVelType.getSelectionModel().getSelectedItem())){
			motionControlThread.setwVelType(Constant.TV);
			motionControlThread.setwMaxVel(Double.parseDouble(wMaxVel.getText()));
			motionControlThread.setwMinVel(Double.parseDouble(wMinVel.getText()));
			motionControlThread.setwTacc(Double.parseDouble(wTacc.getText()));
			motionControlThread.setwTdec(Double.parseDouble(wTdec.getText()));
		}else if ("S形速度曲线".equals(wVelType.getSelectionModel().getSelectedItem())) {
			motionControlThread.setwVelType(Constant.SV);
			motionControlThread.setwMaxVel(Double.parseDouble(wMaxVel.getText()));
			motionControlThread.setwMinVel(Double.parseDouble(wMinVel.getText()));
			motionControlThread.setwTacc(Double.parseDouble(wTacc.getText()));
			motionControlThread.setwTdec(Double.parseDouble(wTdec.getText()));
			motionControlThread.setwTsacc(Double.parseDouble(wTsacc.getText()));
			motionControlThread.setwTsdec(Double.parseDouble(wTsdec.getText()));
		}
		//T轴参数传递
		if("T形速度曲线".equals(tVelType.getSelectionModel().getSelectedItem())){
			motionControlThread.settVelType(Constant.TV);
			motionControlThread.settMaxVel(Double.parseDouble(tMaxVel.getText()));
			motionControlThread.settMinVel(Double.parseDouble(tMinVel.getText()));
			motionControlThread.settTacc(Double.parseDouble(tTacc.getText()));
			motionControlThread.settTdec(Double.parseDouble(tTdec.getText()));
		}else if ("S形速度曲线".equals(tVelType.getSelectionModel().getSelectedItem())) {
			motionControlThread.settVelType(Constant.SV);
			motionControlThread.settMaxVel(Double.parseDouble(tMaxVel.getText()));
			motionControlThread.settMinVel(Double.parseDouble(tMinVel.getText()));
			motionControlThread.settTacc(Double.parseDouble(tTacc.getText()));
			motionControlThread.settTdec(Double.parseDouble(tTdec.getText()));
			motionControlThread.settTsacc(Double.parseDouble(tTsacc.getText()));
			motionControlThread.settTsdec(Double.parseDouble(tTsdec.getText()));
		}
		motionControlThread.setCmd("allAxisSetVel");
		new Thread(motionControlThread).start();
	}
	
	/*********************************************************************************
	 ********************************** powerOn **************************************
	 *********************************************************************************/
	@FXML
	public void powerOn(){
		//判断是否有资源执行此操作
		if(controlBoards.get(0).getAxias()[Constant.XAXIA].isBusynessFlag()||
				controlBoards.get(0).getAxias()[Constant.YAXIA].isBusynessFlag()||
				controlBoards.get(0).getAxias()[Constant.ZAXIA].isBusynessFlag()||
				controlBoards.get(0).getAxias()[Constant.WAXIA].isBusynessFlag()||
				controlBoards.get(0).getAxias()[Constant.TAXIA].isBusynessFlag())
			return ;
		motionControlThread.setCmd("powerOn");
		new Thread(motionControlThread).start();
	}
	
	/*********************************************************************************
	 ********************************** stop  ****************************************
	 *********************************************************************************/
	public void singleAxisStop(Axis axis){
		if(axis.isBusynessFlag() == Constant.ISBUSYNESS){
			axis.setToStop(Constant.YES);
		}
		else {
			axis.stop();
		}
	}
	@FXML
	public void xAxisStop(){
		singleAxisStop(controlBoards.get(0).getAxias()[Constant.XAXIA]);
	}
	@FXML
	public void yAxisStop(){
		singleAxisStop(controlBoards.get(0).getAxias()[Constant.YAXIA]);
	}
	@FXML
	public void zAxisStop(){
		singleAxisStop(controlBoards.get(0).getAxias()[Constant.ZAXIA]);
	}
	@FXML
	public void wAxisStop(){
		singleAxisStop(controlBoards.get(0).getAxias()[Constant.WAXIA]);
	}
	@FXML
	public void tAxisStop(){
		singleAxisStop(controlBoards.get(0).getAxias()[Constant.TAXIA]);
	}
		
	@FXML
	public void allAxisStop(){
		singleAxisStop(controlBoards.get(0).getAxias()[Constant.XAXIA]);
		singleAxisStop(controlBoards.get(0).getAxias()[Constant.YAXIA]);
		singleAxisStop(controlBoards.get(0).getAxias()[Constant.ZAXIA]);
		singleAxisStop(controlBoards.get(0).getAxias()[Constant.WAXIA]);
		singleAxisStop(controlBoards.get(0).getAxias()[Constant.TAXIA]);
	}
	
	
}
