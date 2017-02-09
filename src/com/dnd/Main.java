package com.dnd;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application{
	protected static String dir;
	public static void main(String[] args) {
	    dir = System.getProperty("user.dir");
	    System.out.println("Dir is: " + dir);
		//launch(args);
	}

	public void start(Stage dndStage) throws Exception {
		// TODO Auto-generated method stub
		dndStage.setTitle("DND");
		FlowPane rootNode = new FlowPane(10,10);
		Scene dndScene = new Scene(rootNode, 1000, 1000);
		dndStage.setScene(dndScene);
		dndStage.show();
	}

}
