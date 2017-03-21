package com.tswe.autotest.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.tswe.autotest.model.ControlBoard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class InitControlBoardSerivceTest {
	
	@Autowired
	private InitControlBoardService initControlBoardService;
	private ArrayList<ControlBoard> controlBoards;
	
	@BeforeClass
	public void connectControlBoardTest(){
		controlBoards = initControlBoardService.connectControlBoard("Serial Port");
		assertNotNull(controlBoards);
	}
	
}
