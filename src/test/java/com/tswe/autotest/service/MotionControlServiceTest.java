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
	public void homeMoveTest(){
		//配置原点信号
		motionCotrolService.setHOMEPinLogic(controlBoards.get(0).getAxias()[axis], 1);
		//设置回原点模式
		motionCotrolService.configHomeMode(controlBoards.get(0).getAxias()[axis]);
		//原点运动开始
		motionCotrolService.homeMove(controlBoards.get(0).getAxias()[axis], 1, 0);
	}
	
	@Test
	public void tPMoveTest(){
		//设置速度
		motionCotrolService.setProfile(controlBoards.get(0).getAxias()[axis], 0, 1000, 0.5, 0.5);
		//设置运动方式
		motionCotrolService.tPMove(controlBoards.get(0).getAxias()[axis], -3000, 0);
	}
	
	@Test
	public void sPMoveTest(){
		//设置S形速度曲线(按S段时间)
		motionCotrolService.setStProfile(controlBoards.get(0).getAxias()[axis], 0, 1500, 1, 1, 1, 1);
		//设置运动方式:单轴S形定长运动(对称的S形加减速)
		motionCotrolService.sPMove(controlBoards.get(0).getAxias()[axis], 3000, 0);
		String inforString = JNAInvokeDll.motionDrvDll.Motion_GetLastResultInfo();
		System.out.println(inforString);
	}
	
	@Test
	public void tVMove(){
		//设置轴梯形运动曲线
		motionCotrolService.setProfile(controlBoards.get(0).getAxias()[axis], 1000, 1500, 1, 1);
		//单轴梯形加速连续运动
		motionCotrolService.tVMove(controlBoards.get(0).getAxias()[axis], 1);
	}
	
	@After
	public void closeConnect(){
		initControlBoardService.connectControlBoardClose();
	}
	
	
}
