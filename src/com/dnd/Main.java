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

    static String dir;
    private Label label;
    static int difficultyModifier;
    static int mapBoundsX;
    static int mapBoundsY;
    static ArrayList<String> loadedItems = new ArrayList<>();
    private static ObservableList<String> allItems;

    static {
        allItems = FXCollections.observableArrayList();
    }

    public static void main(String[] args) {
        dir = System.getProperty("user.dir");
        System.out.println("Dir is: " + dir);
        start_up_load_file();
        launch(args);
    }

    private static void start_up_load_file() {
        String defaultFile = "testMap";
        com.dnd.MapReader.loadMap(defaultFile);
    }

    public void start(Stage dndStage) throws Exception {
        // TODO Auto-generated method stub
        dndStage.setTitle("DND");
        FlowPane rootNode = new FlowPane(10, 10);
        Scene dndScene = new Scene(rootNode, 1000, 1000);
        dndStage.setScene(dndScene);
        dndStage.show();
        label = new Label("click");
        //ObservableList<String> seeItems = FXCollections.observableArrayList();
        for(String q : loadedItems)
        {
            allItems.add(q);
        }
        ListView<String> availItems = new ListView<>(allItems);
        availItems.setPrefSize(300, 600);
        availItems.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val, String new_val) -> label.setText(new_val));
        rootNode.getChildren().addAll(label, availItems);
    }
}