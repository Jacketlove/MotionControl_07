package com.tswe.autotest.service;

import com.tswe.autotest.model.Axis;
import com.tswe.autotest.model.ControlBoard;
import com.tswe.common.constant.Constant;

public class MotionControlThread implements Runnable{

	ControlBoard controlBoard;
	String cmd;
	Axis axis;
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		boolean stopFlag = false;
		switch (cmd) {
		
		
		//单轴回原点
		case "singleAxiaGoHome":
			axis.getAxisResource();
			axis.homeMove(Constant.REVERSEGOHOME, Constant.HIGHV);
			axis.releaseAxisResource();
			break;
		
		//XYZW回原点
		case "allAxiaGoHome":
			//获取轴资源
			controlBoard.getAxias()[Constant.XAXIA].getAxisResource();
			controlBoard.getAxias()[Constant.YAXIA].getAxisResource();
			controlBoard.getAxias()[Constant.ZAXIA].getAxisResource();
			controlBoard.getAxias()[Constant.WAXIA].getAxisResource();
			//Z轴回原点
			controlBoard.getAxias()[Constant.ZAXIA].
			homeMove(Constant.REVERSEGOHOME, Constant.HIGHV);
			//等待Z轴停止
			controlBoard.getAxias()[Constant.ZAXIA].waitAxisStop();
			//X轴回原点
			controlBoard.getAxias()[Constant.XAXIA].
			homeMove(Constant.REVERSEGOHOME, Constant.HIGHV);
			//Y轴回原点
			controlBoard.getAxias()[Constant.YAXIA].
			homeMove(Constant.REVERSEGOHOME, Constant.HIGHV);
			//W轴回原点
			controlBoard.getAxias()[Constant.WAXIA].
			homeMove(Constant.REVERSEGOHOME, Constant.HIGHV);
			//等待XYW停止
			controlBoard.getAxias()[Constant.XAXIA].waitAxisStop();
			controlBoard.getAxias()[Constant.YAXIA].waitAxisStop();
			controlBoard.getAxias()[Constant.WAXIA].waitAxisStop();
			//释放资源
			controlBoard.getAxias()[Constant.XAXIA].releaseAxisResource();
			controlBoard.getAxias()[Constant.YAXIA].releaseAxisResource();
			controlBoard.getAxias()[Constant.ZAXIA].releaseAxisResource();
			controlBoard.getAxias()[Constant.WAXIA].releaseAxisResource();
			break;
			
		//单轴到EL+
		case "singleAixsGoELPlus":
			axis.getAxisResource();
			axis.move(1);
			axis.releaseAxisResource();
			break;
			
		//XYW到EL+
		case "AllAxisGoELPlus":
			//获取轴资源
			controlBoard.getAxias()[Constant.XAXIA].getAxisResource();
			controlBoard.getAxias()[Constant.YAXIA].getAxisResource();
			controlBoard.getAxias()[Constant.ZAXIA].getAxisResource();
			controlBoard.getAxias()[Constant.WAXIA].getAxisResource();
			//Z轴回原点
			controlBoard.getAxias()[Constant.ZAXIA].
			homeMove(Constant.REVERSEGOHOME, Constant.HIGHV);
			//等待Z轴停止
			controlBoard.getAxias()[Constant.ZAXIA].waitAxisStop();
			//发送到EL命令
			controlBoard.getAxias()[Constant.XAXIA].move(1);
			controlBoard.getAxias()[Constant.YAXIA].move(1);
			controlBoard.getAxias()[Constant.WAXIA].move(1);
			//等待停止
			controlBoard.getAxias()[Constant.XAXIA].waitAxisStop();
			controlBoard.getAxias()[Constant.YAXIA].waitAxisStop();
			controlBoard.getAxias()[Constant.WAXIA].waitAxisStop();
			//释放资源
			controlBoard.getAxias()[Constant.XAXIA].releaseAxisResource();
			controlBoard.getAxias()[Constant.ZAXIA].releaseAxisResource();
			controlBoard.getAxias()[Constant.YAXIA].releaseAxisResource();
			controlBoard.getAxias()[Constant.WAXIA].releaseAxisResource();
			break;	
		
		case "powerOn":
			//所有轴回原点
			cmd = "allAxiaGoHome";
			run();
			//回到原点后，设置原点位置为0
			controlBoard.getAxias()[Constant.XAXIA].setPosition(0);
			controlBoard.getAxias()[Constant.YAXIA].setPosition(0);
			controlBoard.getAxias()[Constant.ZAXIA].setPosition(0);
			controlBoard.getAxias()[Constant.WAXIA].setPosition(0);
			controlBoard.getAxias()[Constant.XAXIA].writePosition(0);
			controlBoard.getAxias()[Constant.YAXIA].writePosition(0);
			controlBoard.getAxias()[Constant.ZAXIA].writePosition(0);
			controlBoard.getAxias()[Constant.WAXIA].writePosition(0);
			//所有轴移动到EL+
			cmd = "AllAxisGoELPlus";
			run();
			//轴移动到EL+后，读取位置信息，此位置信息即为轴长
			controlBoard.getAxias()[Constant.XAXIA].setLength(
					controlBoard.getAxias()[Constant.XAXIA].readPosition());
			controlBoard.getAxias()[Constant.YAXIA].setLength(
					controlBoard.getAxias()[Constant.YAXIA].readPosition());
			controlBoard.getAxias()[Constant.ZAXIA].setLength(
					controlBoard.getAxias()[Constant.ZAXIA].readPosition());
			controlBoard.getAxias()[Constant.WAXIA].setLength(
					controlBoard.getAxias()[Constant.WAXIA].readPosition());
			
			System.out.println(controlBoard.getAxias()[Constant.XAXIA].getLength());
			System.out.println(controlBoard.getAxias()[Constant.YAXIA].getLength());
			System.out.println(controlBoard.getAxias()[Constant.ZAXIA].getLength());
			System.out.println(controlBoard.getAxias()[Constant.WAXIA].getLength());
			break;
			
		//设置单轴速度
		case "singleAxisSetVel":
			//获取轴资源
			axis.getAxisResource();
			if(velType == Constant.TV){
				if(axis.setVel(MinVel, MaxVel, Tacc, Tdec)){
					axis.setMaxVel(MaxVel);
					axis.setMinVel(MinVel);
					axis.setTacc(Tacc);
					axis.setTdec(Tdec);
				}
			}else if (velType == Constant.SV) {
				if(axis.setVel(MinVel, MaxVel, Tacc, Tdec, Tsacc, Tsdec)){
					axis.setMaxVel(MaxVel);
					axis.setMinVel(MinVel);
					axis.setTacc(Tacc);
					axis.setTdec(Tdec);
					axis.setTsacc(Tsacc);
					axis.setTsdec(Tsdec);
				}
			}
			//释放资源
			axis.releaseAxisResource();
			break;
		
		//设置多轴速度	
		case "allAxisSetVel":
			axis = controlBoard.getAxias()[Constant.XAXIA];
			velType = xVelType;
			MaxVel = xMaxVel;
			MinVel = xMinVel;
			Tacc = xTacc;
			Tdec = xTdec;
			Tsacc = xTsacc;
			Tsdec = xTsdec;
			cmd = "singleAxisSetVel";
			run();
			
			axis = controlBoard.getAxias()[Constant.YAXIA];
			velType = yVelType;
			MaxVel = yMaxVel;
			MinVel = yMinVel;
			Tacc = yTacc;
			Tdec = yTdec;
			Tsacc = yTsacc;
			Tsdec = yTsdec;
			cmd = "singleAxisSetVel";
			run();
			
			axis = controlBoard.getAxias()[Constant.ZAXIA];
			velType = zVelType;
			MaxVel = zMaxVel;
			MinVel = zMinVel;
			Tacc = zTacc;
			Tdec = zTdec;
			Tsacc = zTsacc;
			Tsdec = zTsdec;
			cmd = "singleAxisSetVel";
			run();
			
			axis = controlBoard.getAxias()[Constant.WAXIA];
			velType = wVelType;
			MaxVel = wMaxVel;
			MinVel = wMinVel;
			Tacc = wTacc;
			Tdec = wTdec;
			Tsacc = wTsacc;
			Tsdec = wTsdec;
			cmd = "singleAxisSetVel";
			run();
			
			axis = controlBoard.getAxias()[Constant.TAXIA];
			velType = tVelType;
			MaxVel = tMaxVel;
			MinVel = tMinVel;
			Tacc = tTacc;
			Tdec = tTdec;
			Tsacc = tTsacc;
			Tsdec = tTsdec;
			cmd = "singleAxisSetVel";
			run();
			break;
		default:
			break;
		}
		
		//判断是否要停止
		for(Axis axis: controlBoard.getAxias()){
			if(axis.isToStop() == Constant.YES){
				axis.stop();
				axis.setToStop(Constant.NO);
				stopFlag = true;
			}
		}
		//检测到停止，终止进程
		if(stopFlag){
			Thread.currentThread().stop();
		}
	}

	public MotionControlThread(ControlBoard controlBoard) {
		super();
		this.controlBoard = controlBoard;
	}

	private double xMaxVel;
	
	private double yMaxVel;
	
	private double zMaxVel;
	
	private double wMaxVel;
	
	private double tMaxVel;
	
	private double MaxVel;
	
	private double xMinVel;
	
	private double yMinVel;
	
	private double zMinVel;
	
	private double wMinVel;
	
	private double tMinVel;
	
	private double MinVel;
	
	private double xTacc;
	
	private double yTacc;
	
	private double zTacc;
	
	private double wTacc;
	
	private double tTacc;
	
	private double Tacc;
	
	private double xTdec;
	
	private double yTdec;
	
	private double zTdec;
	
	private double wTdec;
	
	private double tTdec;
	
	private double Tdec;
	
	private double xTsacc;
	
	private double yTsacc;
	
	private double zTsacc;
	
	private double wTsacc;
	
	private double tTsacc;
	
	private double Tsacc;
	
	private double xTsdec;
	
	private double yTsdec;
	
	private double zTsdec;
	
	private double wTsdec;
	
	private double tTsdec;
	
	private double Tsdec;

	private int xVelType;
	
	private int yVelType;
	
	private int zVelType;
	
	private int wVelType;
	
	private int tVelType;
	
	private int velType;
	
	
	
	public ControlBoard getControlBoard() {
		return controlBoard;
	}

	public void setControlBoard(ControlBoard controlBoard) {
		this.controlBoard = controlBoard;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public double getxMaxVel() {
		return xMaxVel;
	}

	public void setxMaxVel(double xMaxVel) {
		this.xMaxVel = xMaxVel;
	}

	public double getyMaxVel() {
		return yMaxVel;
	}

	public void setyMaxVel(double yMaxVel) {
		this.yMaxVel = yMaxVel;
	}

	public double getzMaxVel() {
		return zMaxVel;
	}

	public void setzMaxVel(double zMaxVel) {
		this.zMaxVel = zMaxVel;
	}

	public double getwMaxVel() {
		return wMaxVel;
	}

	public void setwMaxVel(double wMaxVel) {
		this.wMaxVel = wMaxVel;
	}

	public double gettMaxVel() {
		return tMaxVel;
	}

	public void settMaxVel(double tMaxVel) {
		this.tMaxVel = tMaxVel;
	}

	public double getxMinVel() {
		return xMinVel;
	}

	public void setxMinVel(double xMinVel) {
		this.xMinVel = xMinVel;
	}

	public double getyMinVel() {
		return yMinVel;
	}

	public void setyMinVel(double yMinVel) {
		this.yMinVel = yMinVel;
	}

	public double getzMinVel() {
		return zMinVel;
	}

	public void setzMinVel(double zMinVel) {
		this.zMinVel = zMinVel;
	}

	public double getwMinVel() {
		return wMinVel;
	}

	public void setwMinVel(double wMinVel) {
		this.wMinVel = wMinVel;
	}

	public double gettMinVel() {
		return tMinVel;
	}

	public void settMinVel(double tMinVel) {
		this.tMinVel = tMinVel;
	}

	public double getxTacc() {
		return xTacc;
	}

	public void setxTacc(double xTacc) {
		this.xTacc = xTacc;
	}

	public double getyTacc() {
		return yTacc;
	}

	public void setyTacc(double yTacc) {
		this.yTacc = yTacc;
	}

	public double getzTacc() {
		return zTacc;
	}

	public void setzTacc(double zTacc) {
		this.zTacc = zTacc;
	}

	public double getwTacc() {
		return wTacc;
	}

	public void setwTacc(double wTacc) {
		this.wTacc = wTacc;
	}

	public double gettTacc() {
		return tTacc;
	}

	public void settTacc(double tTacc) {
		this.tTacc = tTacc;
	}

	public double getxTdec() {
		return xTdec;
	}

	public void setxTdec(double xTdec) {
		this.xTdec = xTdec;
	}

	public double getyTdec() {
		return yTdec;
	}

	public void setyTdec(double yTdec) {
		this.yTdec = yTdec;
	}

	public double getzTdec() {
		return zTdec;
	}

	public void setzTdec(double zTdec) {
		this.zTdec = zTdec;
	}

	public double getwTdec() {
		return wTdec;
	}

	public void setwTdec(double wTdec) {
		this.wTdec = wTdec;
	}

	public double gettTdec() {
		return tTdec;
	}

	public void settTdec(double tTdec) {
		this.tTdec = tTdec;
	}

	public double getxTsacc() {
		return xTsacc;
	}

	public void setxTsacc(double xTsacc) {
		this.xTsacc = xTsacc;
	}

	public double getyTsacc() {
		return yTsacc;
	}

	public void setyTsacc(double yTsacc) {
		this.yTsacc = yTsacc;
	}

	public double getzTsacc() {
		return zTsacc;
	}

	public void setzTsacc(double zTsacc) {
		this.zTsacc = zTsacc;
	}

	public double getwTsacc() {
		return wTsacc;
	}

	public void setwTsacc(double wTsacc) {
		this.wTsacc = wTsacc;
	}

	public double gettTsacc() {
		return tTsacc;
	}

	public void settTsacc(double tTsacc) {
		this.tTsacc = tTsacc;
	}

	public double getxTsdec() {
		return xTsdec;
	}

	public void setxTsdec(double xTsdec) {
		this.xTsdec = xTsdec;
	}

	public double getyTsdec() {
		return yTsdec;
	}

	public void setyTsdec(double yTsdec) {
		this.yTsdec = yTsdec;
	}

	public double getzTsdec() {
		return zTsdec;
	}

	public void setzTsdec(double zTsdec) {
		this.zTsdec = zTsdec;
	}

	public double getwTsdec() {
		return wTsdec;
	}

	public void setwTsdec(double wTsdec) {
		this.wTsdec = wTsdec;
	}

	public double gettTsdec() {
		return tTsdec;
	}

	public void settTsdec(double tTsdec) {
		this.tTsdec = tTsdec;
	}

	public Axis getAxis() {
		return axis;
	}

	public void setAxis(Axis axis) {
		this.axis = axis;
	}

	public double getMaxVel() {
		return MaxVel;
	}

	public void setMaxVel(double maxVel) {
		MaxVel = maxVel;
	}

	public double getMinVel() {
		return MinVel;
	}

	public void setMinVel(double minVel) {
		MinVel = minVel;
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

	public int getVelType() {
		return velType;
	}

	public void setVelType(int velType) {
		this.velType = velType;
	}

	public int getxVelType() {
		return xVelType;
	}

	public void setxVelType(int xVelType) {
		this.xVelType = xVelType;
	}

	public int getyVelType() {
		return yVelType;
	}

	public void setyVelType(int yVelType) {
		this.yVelType = yVelType;
	}

	public int getzVelType() {
		return zVelType;
	}

	public void setzVelType(int zVelType) {
		this.zVelType = zVelType;
	}

	public int getwVelType() {
		return wVelType;
	}

	public void setwVelType(int wVelType) {
		this.wVelType = wVelType;
	}

	public int gettVelType() {
		return tVelType;
	}

	public void settVelType(int tVelType) {
		this.tVelType = tVelType;
	}
}
