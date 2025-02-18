package be.kdg.mens_erger_je_niet.view.load_game;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;

public class LoadGamePresenter {
    private MensErgerJeNietControler model;
    private Main mainApp;
    private LoadGameView view;

    public LoadGamePresenter(MensErgerJeNietControler model, LoadGameView view, Main mainApp) {
        this.mainApp = mainApp;
        this.view = view;
        this.model = model;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getGoBackButton().setOnAction(event -> mainApp.showMainMenu());
    }
}
