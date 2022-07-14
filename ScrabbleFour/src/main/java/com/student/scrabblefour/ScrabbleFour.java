package com.student.scrabblefour;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class ScrabbleFour extends Application {
    ScrabbleController sc = new ScrabbleController();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ScrabbleFour.class.getResource("GameView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 1200);
        fxmlLoader.setRoot(sc);
        fxmlLoader.setController(sc);
        stage.setTitle("Four Letter Scrabble!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();

    }
}