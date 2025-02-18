package be.kdg.mens_erger_je_niet;

import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import be.kdg.mens_erger_je_niet.view.about.AboutView;
import be.kdg.mens_erger_je_niet.view.about.HelpView;
import be.kdg.mens_erger_je_niet.view.load_game.LoadGameView;
import be.kdg.mens_erger_je_niet.view.loadingscreen.LoadingscreenPresenter;
import be.kdg.mens_erger_je_niet.view.loadingscreen.LoadingscreenView;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuPresenter;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuView;
import be.kdg.mens_erger_je_niet.view.new_game.NewGameView;
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

    private void showLoadingScreen() {
        LoadingscreenView loadingscreenView = new LoadingscreenView(this);  // Dit geeft mainApp door aan de view
        MensErgerJeNietControler model = new MensErgerJeNietControler();
        new LoadingscreenPresenter(model, loadingscreenView, this);           // Maak de presenter aan

        Scene loadingscreen = new Scene(loadingscreenView);
        primaryStage.setScene(loadingscreen);
        primaryStage.show();
    }

    public void showMainMenu() {
        MainMenuView mainMenuView = new MainMenuView(this);
        MensErgerJeNietControler model = new MensErgerJeNietControler();
        new MainMenuPresenter(this, mainMenuView, model);

        Scene mainMenu = new Scene(mainMenuView);
        primaryStage.setScene(mainMenu);
        primaryStage.show();
    }

    public void showNewGame() {
        NewGameView newGameView = new NewGameView(this);
        Scene newGame = new Scene(newGameView);
        primaryStage.setScene(newGame);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void loadGameView() {
        LoadGameView loadGameView = new LoadGameView(this);
        Scene loadGame = new Scene(loadGameView);
        primaryStage.setScene(loadGame);
    }

    public void aboutView() {
        AboutView aboutView = new AboutView(this);
        Scene about = new Scene(aboutView);
        primaryStage.setScene(about);
    }

    public void helpView() {
        HelpView helpView = new HelpView(this);
        Scene help = new Scene(helpView);
        primaryStage.setScene(help);
    }

    public void playboardView() {
        PlayboardView playboardView = new PlayboardView();
        Scene playboard = new Scene(playboardView);
        primaryStage.setScene(playboard);
    }
}
