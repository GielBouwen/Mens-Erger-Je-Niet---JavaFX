package be.kdg.mens_erger_je_niet;

import be.kdg.mens_erger_je_niet.view.about.AboutView;
import be.kdg.mens_erger_je_niet.view.help.HelpView;
import be.kdg.mens_erger_je_niet.view.load_game.LoadGameView;
import be.kdg.mens_erger_je_niet.view.loadingscreen.LoadingscreenView;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuView;
import be.kdg.mens_erger_je_niet.view.new_game.NewGameView;
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
        MainMenuView mainMenuView = new MainMenuView(this);
        Scene mainMenu = new Scene(mainMenuView);
        primaryStage.setScene(mainMenu);
    }

    public void showNewGame() {
        NewGameView newGameView = new NewGameView();
        Scene newGame = new Scene(newGameView);
        primaryStage.setScene(newGame);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void loadGameView() {
        LoadGameView loadGameView = new LoadGameView();
        Scene loadGame = new Scene(loadGameView);
        primaryStage.setScene(loadGame);
    }

    public void aboutView() {
        AboutView aboutView = new AboutView(this);
        Scene about = new Scene(aboutView);
        primaryStage.setScene(about);
    }

    public void helpView() {
        HelpView helpView = new HelpView();
        Scene help = new Scene(helpView);
        primaryStage.setScene(help);
    }
}