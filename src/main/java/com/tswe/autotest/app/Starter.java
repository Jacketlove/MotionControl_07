package com.tswe.autotest.app;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.tswe.autotest.view.MotionInitView;
import com.tswe.common.app.AbstractJavaFxApplicationSupport;

@Lazy
@Component
//@SpringBootApplication
public class Starter extends AbstractJavaFxApplicationSupport {
	
	public static void main(String[] args) {
		launchApp(Starter.class, MotionInitView.class, args);
	}
}
