package be.kdg.mens_erger_je_niet;

import be.kdg.mens_erger_je_niet.view.loadingscreen.LoadingscreenView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mens-Erger-Je-Niet");
        primaryStage.setWidth(1280);
        primaryStage.setHeight(720);

        LoadingscreenView loadingscreenView = new LoadingscreenView();
        Scene scene = new Scene(loadingscreenView);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}