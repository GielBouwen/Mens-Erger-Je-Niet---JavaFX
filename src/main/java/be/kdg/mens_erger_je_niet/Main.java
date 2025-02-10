package be.kdg.mens_erger_je_niet;

import be.kdg.mens_erger_je_niet.view.loadingscreen.LoadingscreenView;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuView;
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

    private void showLoadingScreen() {
        LoadingscreenView loadingscreenView = new LoadingscreenView(this);
        Scene loadingscreen = new Scene(loadingscreenView);
        primaryStage.setScene(loadingscreen);
        primaryStage.show();
    }

    public void showMainMenu() {
        MainMenuView mainMenuView = new MainMenuView();
        Scene mainMenu = new Scene(mainMenuView);
        primaryStage.setScene(mainMenu);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}