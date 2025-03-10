package be.kdg.mens_erger_je_niet.view.new_game;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;

public class NewGamePresenter {
    private NewGameView view;
    private Main mainApp;
    private MensErgerJeNietControler model;

    public NewGamePresenter(NewGameView view, Main mainApp, MensErgerJeNietControler model) {
        this.mainApp = mainApp;
        this.view = view;
        this.model = model;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getCancelButton().setOnAction(event -> {
            mainApp.showMainMenu();
        });
        view.getCreateButton().setOnAction(event -> {
            mainApp.showPlayboardView();
        });
    }
}
