package co.edu.uniquindio.programacion3.parcial2.parcial2.archivos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Proyecto4App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/archivos/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Oscar SA");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}