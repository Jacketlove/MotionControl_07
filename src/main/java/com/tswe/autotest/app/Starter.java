package com.tswe.autotest.app;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.tswe.autotest.view.MotionInitView;
import com.tswe.common.app.AbstractJavaFxApplicationSupport;
import com.tswe.common.util.JNAInvokeDll;

@Lazy
@Component
//@SpringBootApplication
public class Starter extends AbstractJavaFxApplicationSupport {
	
	public static void main(String[] args) {
		launchApp(Starter.class, MotionInitView.class, args);
	}

	@Override
	public void stop() throws Exception {
		JNAInvokeDll.motionDrvDll.motion_board_close();
		super.stop();
	}
	
	
}


