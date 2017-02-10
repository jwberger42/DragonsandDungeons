package com.dnd;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    public static String dir;
    public Label label;
    public static int difficultyModifier;
    public static int mapBoundsX;
    public static int mapBoundsY;
    public static ArrayList<String> loadedItems = new ArrayList<>();
    public static void main(String[] args) {
        dir = System.getProperty("user.dir");
        System.out.println("Dir is: " + dir);
        start_up_load_file();
        //launch(args);
    }

    public static void start_up_load_file() {
        com.dnd.MapReader.loadMap("testMap");
        com.dnd.MapReader.bufferObjects("testMap");
    }

    public void start(Stage dndStage) throws Exception {
        // TODO Auto-generated method stub
        dndStage.setTitle("DND");
        FlowPane rootNode = new FlowPane(10, 10);
        Scene dndScene = new Scene(rootNode, 1000, 1000);
        dndStage.setScene(dndScene);
        dndStage.show();
        ObservableList<String> allItems = FXCollections.observableArrayList();
        //ObservableList<String> seeItems = FXCollections.observableArrayList();
        for(String q : loadedItems)
        {
            allItems.add(q);
        }
        ListView<String> availItems;
        availItems = new ListView<>(allItems);
        availItems.setPrefSize(300, 600);
        availItems.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    label.setText(new_val);
                });
        rootNode.getChildren().addAll(label,availItems);
    }
}