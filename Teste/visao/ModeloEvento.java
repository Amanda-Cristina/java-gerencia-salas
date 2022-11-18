/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package visao;

import javafx.application.Application;
import javafx.event.*;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Monica
 */
public class ModeloEvento extends Application implements EventHandler<ActionEvent> {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button(); // fonte do evento
        btn.setText("Say 'Hello World'");
        btn.setOnAction(this);

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // manipulador de evento
    @Override
    public void handle(ActionEvent event) {
        System.out.println("Hello World!");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
