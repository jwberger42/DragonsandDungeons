package com.dnd;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    static String dir;
    public Label label;

    public static void main(String[] args) {
        dir = System.getProperty("user.dir");
        System.out.println("Dir is: " + dir);
        start_up_load_file();
        //launch(args);
    }

    public static void start_up_load_file() {
        com.dnd.MapReader.loadMap("testMap");
    }

    public void start(Stage dndStage) throws Exception {
        // TODO Auto-generated method stub
        dndStage.setTitle("DND");
        FlowPane rootNode = new FlowPane(10, 10);
        Scene dndScene = new Scene(rootNode, 1000, 1000);
        dndStage.setScene(dndScene);
        dndStage.show();
        //ObservableList<String> allItems = FXCollections.observableArrayList();
        ObservableList<String> seeItems = FXCollections.observableArrayList();
        ListView<String> availItems;
        availItems = new ListView<>(seeItems);
        availItems.setPrefSize(300, 600);
        availItems.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    label.setText(new_val);
                });
        rootNode.getChildren().addAll(label,availItems);
    }
}