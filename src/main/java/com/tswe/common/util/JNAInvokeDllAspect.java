package com.tswe.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tswe.autotest.service.InitControlBoardService;

public class JNAInvokeDllAspect {
	private Logger logger = LoggerFactory.getLogger(InitControlBoardService.class);
	
	public void after() {
		logger.info(JNAInvokeDll.motionDrvDll.Motion_GetLastResultInfo());
    }
}
