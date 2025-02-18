package be.kdg.mens_erger_je_niet.view.loadingscreen;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;

public class LoadingscreenPresenter {
    private MensErgerJeNietControler model;
    private LoadingscreenView view;
    private Main mainApp;

    public LoadingscreenPresenter(MensErgerJeNietControler model, LoadingscreenView view, Main mainApp) {
        this.model = model;
        this.view = view;
        this.mainApp = mainApp; //voor navigatie
        this.addEventHandlers();
    }

    private void addEventHandlers() {
        view.getStartButton().setOnAction(event -> mainApp.showMainMenu());

    }
}
