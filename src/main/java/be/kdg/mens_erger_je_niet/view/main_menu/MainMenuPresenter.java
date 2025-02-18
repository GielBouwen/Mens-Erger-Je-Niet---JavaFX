package be.kdg.mens_erger_je_niet.view.main_menu;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import be.kdg.mens_erger_je_niet.view.loadingscreen.LoadingscreenView;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuView;

public class MainMenuPresenter {
    private MensErgerJeNietControler model;
    private Main mainApp;
    private MainMenuView view;


    public MainMenuPresenter(Main mainApp, MainMenuView view, MensErgerJeNietControler model) {
        this.mainApp = mainApp;
        this.view = view;
        this.model = model;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getNewGame().setOnAction(event -> mainApp.showNewGame());
        view.getLoadGame().setOnAction(event -> mainApp.loadGameView());
        view.getHelp().setOnAction(event -> mainApp.helpView());
        view.getAbout().setOnAction(event -> mainApp.aboutView());
    }
}
