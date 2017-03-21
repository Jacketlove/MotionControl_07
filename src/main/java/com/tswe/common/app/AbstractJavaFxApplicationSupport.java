package com.tswe.common.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.tswe.common.view.AbstractFxmlView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Felix Roske 
 */
public abstract class AbstractJavaFxApplicationSupport extends Application {
	//private static String[] savedArgs;
	private static Class<? extends AbstractFxmlView> savedInitialView;
	private ConfigurableApplicationContext applicationContext;
	private Stage stage;
	private Scene scene;

	@Override
	public void init() throws Exception {
		//applicationContext = SpringApplication.run(getClass(), savedArgs);
		applicationContext = new FileSystemXmlApplicationContext("classpath:applicationContext.xml"); 
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		showView(savedInitialView);
	}

	public void showView(Class<? extends AbstractFxmlView> newView) {
		AbstractFxmlView view = applicationContext.getBean(newView);
		stage.titleProperty().bind(view.titleProperty());
		if (scene == null) {
			scene = new Scene(view.getView());
		}
		else {  
			scene.setRoot(view.getView());
		}
		
		//stage.setTitle(windowTitle);
		stage.setScene(scene);
		//stage.setResizable(true);
		//stage.centerOnScreen();
		stage.show();
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		applicationContext.close();
	}

	protected static void launchApp(Class<? extends AbstractJavaFxApplicationSupport> appClass,
			Class<? extends AbstractFxmlView> view, String[] args) {
		savedInitialView = view;
		//savedArgs = args;
		Application.launch(appClass, args);
	}
}
