package com.example.seguimiento_14;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        openStage("register-view.fxml");
    }

    public static void openStage(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(fxml));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.getIcons().add(new Image(MainApp.class.getResourceAsStream("/logo.png")));
            stage.setTitle("ALFA BANK FINANCES S.A");
            stage.setScene(scene);
            if (fxml.equals("register-view.fxml")){
                stage.setResizable(false);
            }
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}