package be.kdg.mens_erger_je_niet;

import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import be.kdg.mens_erger_je_niet.model.Speler;
import be.kdg.mens_erger_je_niet.view.about.AboutPresenter;
import be.kdg.mens_erger_je_niet.view.about.AboutView;
import be.kdg.mens_erger_je_niet.view.help.HelpPresenter;
import be.kdg.mens_erger_je_niet.view.help.HelpView;
import be.kdg.mens_erger_je_niet.view.load_game.LoadGamePresenter;
import be.kdg.mens_erger_je_niet.view.load_game.LoadGameView;
import be.kdg.mens_erger_je_niet.view.loadingscreen.LoadingscreenPresenter;
import be.kdg.mens_erger_je_niet.view.loadingscreen.LoadingscreenView;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuPresenter;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuView;
import be.kdg.mens_erger_je_niet.view.new_game.NewGamePresenter;
import be.kdg.mens_erger_je_niet.view.new_game.NewGameView;
import be.kdg.mens_erger_je_niet.view.playboard.PlayboardPresenter;
import be.kdg.mens_erger_je_niet.view.playboard.PlayboardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {
    private Stage primaryStage;
    private boolean komtVanMainMenu = true;

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
        MensErgerJeNietControler model = new MensErgerJeNietControler();
        new LoadingscreenPresenter(model, loadingscreenView, this);

        Scene loadingscreen = new Scene(loadingscreenView);
        primaryStage.setScene(loadingscreen);
        primaryStage.show();
    }


    public void showMainMenu() {
        komtVanMainMenu = true; //Voor navigatie spelregels
        MainMenuView mainMenuView = new MainMenuView(this);
        MensErgerJeNietControler model = new MensErgerJeNietControler();
        new MainMenuPresenter(this, mainMenuView, model);

        Scene mainMenu = new Scene(mainMenuView);
        primaryStage.setScene(mainMenu);
        primaryStage.show();
    }

    public void showNewGame() {
        NewGameView newGameView = new NewGameView();
        MensErgerJeNietControler model = new MensErgerJeNietControler();
        new NewGamePresenter(newGameView, this, model);

        Scene newGame = new Scene(newGameView);
        primaryStage.setScene(newGame);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }

    public void loadGameView() {
        LoadGameView loadGameView = new LoadGameView();
        MensErgerJeNietControler model = new MensErgerJeNietControler();
        new LoadGamePresenter(model, loadGameView, this);

        Scene loadGame = new Scene(loadGameView);
        primaryStage.setScene(loadGame);
        primaryStage.show();
    }

    public void aboutView() {
        AboutView aboutView = new AboutView();
        MensErgerJeNietControler model = new MensErgerJeNietControler();
        new AboutPresenter(model, aboutView, this);

        Scene about = new Scene(aboutView);
        primaryStage.setScene(about);
        primaryStage.show();
    }


    public void helpView() {
        HelpView helpView = new HelpView(this);
        MensErgerJeNietControler model = new MensErgerJeNietControler();
        new HelpPresenter(model, helpView, this);

        Scene help = new Scene(helpView);
        primaryStage.setScene(help);
        primaryStage.show();
    }

    public void showPlayboardView(){
        komtVanMainMenu = false; //Voor navigatie naar spelregels
        PlayboardView playboardView = new PlayboardView();
        MensErgerJeNietControler model = new MensErgerJeNietControler();
        new PlayboardPresenter(this, playboardView, model);

        Scene playboard = new Scene(playboardView);
        primaryStage.setScene(playboard);
        primaryStage.show();
    }

    public void gaTerugVanSpelregels(){ //Om van help menu naar het juiste scherm terug te kunnen gaan
        if (komtVanMainMenu) {
            showMainMenu();
        } else {
            showPlayboardView();
        }
    }
}