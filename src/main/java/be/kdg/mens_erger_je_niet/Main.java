package be.kdg.mens_erger_je_niet;

import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import be.kdg.mens_erger_je_niet.view.loadingscreen.LoadingscreenPresenter;
import be.kdg.mens_erger_je_niet.view.loadingscreen.LoadingscreenView;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuView;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuPresenter;
import be.kdg.mens_erger_je_niet.view.playboard.PlayboardPresenter;
import be.kdg.mens_erger_je_niet.view.playboard.PlayboardView;
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

    // Het hoofdmenu tonen
    private void showMainMenu() {
        MainMenuView mainMenuView = new MainMenuView();
        MensErgerJeNietControler model = new MensErgerJeNietControler();
        new MainMenuPresenter(model, mainMenuView);

        Scene mainMenuScene = new Scene(mainMenuView);
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }

    // Het laadscherm tonen na klikken op "Start"
    public void showLoadingScreen() {
        LoadingscreenView loadingscreenView = new LoadingscreenView();
        MensErgerJeNietControler model = new MensErgerJeNietControler();
        new LoadingscreenPresenter(model, loadingscreenView);

        // Simuleer enige laadtijd (bijvoorbeeld 2 seconden)
        new Thread(() -> {
            try {
                Thread.sleep(2000);  // 2 seconden wachten (je kunt dit aanpassen)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Zodra het laadscherm is afgelopen, ga naar het speelbord
            javafx.application.Platform.runLater(() -> {
                showMainMenu();  // Het speelbord wordt getoond
            });
        }).start();

        Scene loadingscreen = new Scene(loadingscreenView);
        primaryStage.setScene(loadingscreen);
        primaryStage.show();
    }

    // Het speelbord tonen na het laadscherm
    private void showPlayboardScreen(MensErgerJeNietControler model) {
        PlayboardView playboardView = new PlayboardView();
        new PlayboardPresenter(model, playboardView);

        Scene playboardScene = new Scene(playboardView);
        primaryStage.setScene(playboardScene);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}