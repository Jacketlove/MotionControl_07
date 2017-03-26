package com.tswe.autotest.controller;

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
import com.tswe.autotest.service.InitControlBoardService;
import com.tswe.autotest.service.MotionCotrolService;
import com.tswe.common.constant.Constant;
import com.tswe.common.util.JNAInvokeDll;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MotionInitControllerTest {
	@Autowired
	private InitControlBoardService initControlBoardService;
	@Autowired
	private MotionCotrolService motionCotrolService;
	@Autowired
	private MotionInitController motionInitController;
	
	private ArrayList<ControlBoard> controlBoards;
	
	@Before
	public void connectControlBoardTest(){
		//打开结果反馈
		JNAInvokeDll.motionDrvDll.Motion_SetResultSwitch(1);
		controlBoards = initControlBoardService.connectControlBoard("Serial Port");
		assertNotNull(controlBoards);

	}
	
	@Test
	public void actionFactoryTest(){
		//motionInitController.actionFactory(controlBoards);
	}
	
	@After
	public void closeConnect(){
	}
}
