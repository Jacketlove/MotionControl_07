package com.tswe.autotest.view;

import org.springframework.stereotype.Component;

import com.tswe.common.view.AbstractFxmlView;
import com.tswe.common.view.FXMLView;

@Component
@FXMLView("/fxml/MotionInitView.fxml")
public class MotionInitView extends AbstractFxmlView{
	
	public MotionInitView() {
		setTitle("控制板连接");
	}
}
