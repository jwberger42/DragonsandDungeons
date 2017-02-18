package com.dnd;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class Main extends Application {

    static String dir;
    private Label label;
    static int difficultyModifier;
    static int mapBoundsX;
    static int mapBoundsY;
    static ArrayList<String> loadedItems = new ArrayList<>();
    private static ArrayList<String> loadedEnemies = new ArrayList<>();
    //static ArrayList<String> loadedAllies = new ArrayList<>();
    //static ArrayList<String> loadedNpcs = new ArrayList<>();
    private static ObservableList<String> allItems;
    private static Image map;
    private static ImageView mapView;
    private static File mapImg;
    public static TextField input;
    public static ArrayList<String> output;

    static {
        allItems = FXCollections.observableArrayList();
    }

    public static void main(String[] args) {
        dir = System.getProperty("user.dir");
        //System.out.println("Dir is: " + dir);
        start_up_load_file();
        //clear_loaded_level();
        launch(args);
    }

    private static void start_up_load_file() {
        String defaultFile = "testMap";
        com.dnd.MapReader.loadMap(defaultFile);
        mapImg = new File("map/" + defaultFile + "/map_img.jpg");
    }
    private static void clear_loaded_level()
    {
        allItems.clear();
        loadedEnemies.clear();
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
        map = new Image(mapImg.toURI().toString());
        mapView = new ImageView();
        mapView.setImage(map);
        mapView.setSmooth(true);
        mapView.setCache(true);
        input = new TextField();
        input.setPromptText("Enter your input here");
        input.setEditable(true);
        output = new ArrayList<String>();
        rootNode.getChildren().addAll(/*label, availItems*/mapView,input,output);
        input.setOnAction(event -> {
            output.add(input.getText());
            input.selectAll();
        });
    }
}