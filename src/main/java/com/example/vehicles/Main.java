package com.example.vehicles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


//Parent class vs child class.
public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("vehicle-chart-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("vehicle view");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();

//        System.out.println(String.format("%f -> %.1f%n",0.02222,0.12456));
//        for (int i = 1; i<=10;i++) {
//            for (int j = 1;j <=10; j++) {
//                System.out.printf("%4d ", i*j);
//            }
//            System.out.println();
//        }
    }
}

