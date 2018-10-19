package de.feu.javafxdemo;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SelectionDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(createPane(), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Parent createPane() {
    	BorderPane root = new BorderPane();
    	SelectionHandler selectionHandler = new SelectionHandler(root);
    	root.addEventHandler(MouseEvent.MOUSE_PRESSED, selectionHandler.getMousePressedEventHandler());
    	
    	MyCircle c1 = new MyCircle(40, 40, 20);
        MyCircle c2 = new MyCircle(40, 100, 20);
        MyCircle c3 = new MyCircle(40, 160, 20);
        root.getChildren().addAll(c1, c2, c3);

        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}