package be.kdg.mens_erger_je_niet;

import be.kdg.mens_erger_je_niet.model.Bord;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import be.kdg.mens_erger_je_niet.view.loadingscreen.LoadingscreenPresenter;
import be.kdg.mens_erger_je_niet.view.loadingscreen.LoadingscreenView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Mens-Erger-Je-Niet");
        primaryStage.setWidth(1280);
        primaryStage.setHeight(720);

        showLoadingScreen();
    }

    public void showLoadingScreen() {
        LoadingscreenView loadingscreenView = new LoadingscreenView();
        MensErgerJeNietControler model = new MensErgerJeNietControler();
        new LoadingscreenPresenter(model, loadingscreenView);
        Scene loadingscreen = new Scene(loadingscreenView);
        primaryStage.setScene(loadingscreen);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
