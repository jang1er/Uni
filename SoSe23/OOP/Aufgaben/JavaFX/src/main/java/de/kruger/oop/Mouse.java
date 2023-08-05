package de.kruger.oop;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Mouse extends Application {

    /** Der "Knopftext". */
    private static final String DEFAULT_TEXT = "Knopf";

    /** Der Starttext. */
    private static final String START_TEXT = "Herzlich Willkommen.\n"
            + "1. 'Button 1'. MouseListener\n" + "2. 'Button 2'. MouseLisener&MouseMotionListener\n";

    /* Definition der Fensterelemente */
    private Button buttonTop;
    private Button buttonBottom;
    private TextArea textArea;

    /**
     * Starts the application.
     */
    @Override
    public void start(Stage stage) {

        stage.setTitle("Mouse Event Handlers Example");

        /* Initialisieren der Fensterelemente */
        buttonTop = new Button("Button 1");

        buttonBottom = new Button(DEFAULT_TEXT);

        textArea = new TextArea(START_TEXT);
        textArea.setPrefColumnCount(80);
        textArea.setPrefRowCount(10);

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(buttonTop, 1, 0);
        grid.add(textArea, 1, 1);
        grid.add(buttonBottom, 1, 2);


        /*
         * Hinzufuegen von EventHandlern zum oberen Knopf
         */
        buttonTop.setOnMouseMoved(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                textArea.appendText("mouseMoved\n");
            }
        });
        buttonTop.setOnMouseEntered(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                textArea.appendText("mouseEntered\n");
            }
        });
        buttonTop.setOnMouseExited(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                textArea.appendText("mouseExited\n");
            }
        });
        buttonTop.setOnMousePressed(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                textArea.appendText("mousePressed\n");
            }
        });
        buttonTop.setOnMouseReleased(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                textArea.appendText("mouseReleased\n");
            }
        });


        /*
         * Hinzufuegen eines EventHandlers zum unteren Knopf
         */
        buttonBottom.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonBottom.setText(event.getX() + ", " + event.getY());
            }
        });
        buttonBottom.setOnMouseExited(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                buttonBottom.setText(DEFAULT_TEXT);
            }
        });

        Scene scene = new Scene(grid, 800, 500);
        stage.setScene(scene);
        stage.show();
        textArea.setEditable(false);
    }
    public static void main(String[] args){
        launch(args);
    }
}
