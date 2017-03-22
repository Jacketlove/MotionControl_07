package com.tswe.autotest.model;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tswe.autotest.service.InitControlBoardService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class AxiaTest {
	
	@Autowired
	private InitControlBoardService initControlBoardService;
	private ArrayList<ControlBoard> controlBoards;
	
	@Before
	public void connectControlBoardTest(){
		controlBoards = initControlBoardService.connectControlBoard("Serial Port");
	}
	
	@Test
	public void setPulseOutmodeTest(){
		for(Axis axia: controlBoards.get(0).getAxias()){
			axia.setPulseOutmode(0);
		}
	}
	
	
}
