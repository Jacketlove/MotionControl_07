package com.tswe.autotest.service;

import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.tswe.autotest.model.ControlBoard;
import com.tswe.common.constant.Constant;
import com.tswe.common.util.JNAInvokeDll;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MotionControlServiceTest {
	@Autowired
	private InitControlBoardService initControlBoardService;
	@Autowired
	private MotionCotrolService motionCotrolService;
	private ArrayList<ControlBoard> controlBoards;
	
	private int axis = 1;
	
	@Before
	public void connectControlBoardTest(){
		//打开结果反馈
		JNAInvokeDll.motionDrvDll.Motion_SetResultSwitch(1);
		controlBoards = initControlBoardService.connectControlBoard("Serial Port");
		assertNotNull(controlBoards);
		//设置脉冲模式
		motionCotrolService.setPulseOutmode(controlBoards.get(0).getAxias()[axis], 0);
	}
	
	@Test
	public void motionImdStopTest(){
		//停止运动
		motionCotrolService.motionImdStop(controlBoards.get(0).getAxias()[axis]);
	}
	
	@Test
	public void homeMoveTest(){
		
		//配置运动曲线
		motionCotrolService.setVel(controlBoards.get(0).getAxias()[axis], 1000.0, 2000.0, 0.5, 0.5);
		//配置原点信号
		motionCotrolService.setHOMEPinLogic(controlBoards.get(0).getAxias()[axis], 0, 1);
		//设置回原点模式
		motionCotrolService.configHomeMode(controlBoards.get(0).getAxias()[axis]);
		//原点运动开始 负方向回原点
		motionCotrolService.homeMove(controlBoards.get(0).getAxias()[axis], 2, 1);
	}
	
	@Test
	public void tPMoveTest(){
		//设置速度
		motionCotrolService.setVel(controlBoards.get(0).getAxias()[1], 2000, 4000, 0.5, 0.5);
		//设置运动方式
		motionCotrolService.move(controlBoards.get(0).getAxias()[1], -150000, 0);
	}
	
	@Test
	public void sPMoveTest(){
		//设置S形速度曲线(按S段时间)
		motionCotrolService.setVel(controlBoards.get(0).getAxias()[axis], 0, 1500, 1, 1, 0.5, 0.5);
		//设置运动方式:单轴S形定长运动(对称的S形加减速)
		motionCotrolService.move(controlBoards.get(0).getAxias()[axis], 3000, 0);
	}
	
	@Test
	public void tVMove(){
		//设置轴梯形运动曲线
		motionCotrolService.setVel(controlBoards.get(0).getAxias()[axis], 1000, 1500, 1, 1);
		//单轴梯形加速连续运动
		motionCotrolService.move(controlBoards.get(0).getAxias()[axis], 1);
	}
	
	@Test
	public void singleAxiaGoHomeTest(){
		//配置运动曲线
		motionCotrolService.setVel(controlBoards.get(0).getAxias()[2], 1000, 5000, 0.5, 0.5);
		motionCotrolService.singleAxiaGoHome(controlBoards.get(0).getAxias()[2], 
				Constant.ORGVALIDLOGIC, Constant.REVERSEGOHOME, Constant.HIGHV);
	}
	
	@Test
	public void configELModeTest(){
		//配置EL
		motionCotrolService.configELMode(controlBoards.get(0).getAxias()[axis], 0);
		//设置轴梯形运动曲线
		motionCotrolService.setVel(controlBoards.get(0).getAxias()[axis], 2000, 5000, 1, 1);
		//单轴梯形加速连续运动
		motionCotrolService.move(controlBoards.get(0).getAxias()[axis], 1);
	}
	
	@SuppressWarnings("static-access")
	@After
	public void closeConnect(){
		while(motionCotrolService.checkDone(controlBoards.get(0).getAxias()[axis]) == 0){
			try {
				System.out.println(motionCotrolService.checkDone(controlBoards.get(0).getAxias()[axis]));
				Thread.currentThread().sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		initControlBoardService.connectControlBoardClose();
	}
}
