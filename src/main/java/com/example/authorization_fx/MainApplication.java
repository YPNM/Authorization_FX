package com.example.authorization_fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-frame.fxml")));
            //Parent root = FXMLLoader.load(Paths.get("D:\\Универ\\IT\\1 курс\\2 трим\\Java\\Authorization_FX\\src\\main\\resources\\com\\example\\authorization_fx\\main-frame.fxml").toUri().toURL());
            Scene scene = new Scene(root, 900, 600);
            stage.setTitle("Автоматиз");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        catch(Exception e){
            System.out.println("Чет не так");
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        launch();
    }
}