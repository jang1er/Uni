package de.kruger.oop;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.text.Position;


public class Main extends Application {
    public static  void main (String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.setTitle("Advanced Colour Selector");


        BorderPane pane = new BorderPane();

        ObservableList<String> colors = FXCollections.observableArrayList("red","green","blue");

        ComboBox<String> box = new ComboBox<>(colors);


        box.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                switch(box.getValue()){
                    case "red":
                        pane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                        break;
                    case "green":
                        pane.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                        break;
                    case "blue":
                        pane.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                        break;
                    default:
                        break;
                }
            }
        });

        RadioButton redButton = new RadioButton("red");
        redButton.setUserData("red");
        RadioButton greenButton = new RadioButton("green");
        greenButton.setUserData("green");
        RadioButton blueButton = new RadioButton("blue");
        blueButton.setUserData("blue");

        ToggleGroup toggleGroup = new ToggleGroup();
        redButton.setToggleGroup(toggleGroup);
        greenButton.setToggleGroup(toggleGroup);
        blueButton.setToggleGroup(toggleGroup);

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.add(redButton, 0, 0);
        grid.add(greenButton, 0, 1);
        grid.add(blueButton, 0, 2);
        pane.setCenter(grid);

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if(newValue.getUserData() != null){
                    switch (newValue.getUserData().toString()) {
                        case "red":
                            pane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                        case "green":
                            pane.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                        case "blue":
                            pane.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                            break;
                        default:
                            break;
                    }
                }
            }
        });

        pane.setTop(box);
        Scene scene = new Scene(pane, 450, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
