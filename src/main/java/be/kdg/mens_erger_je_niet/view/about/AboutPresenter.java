package be.kdg.mens_erger_je_niet.view.about;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;


public class AboutPresenter {
    private MensErgerJeNietControler model;
    private Main mainApp;
    private AboutView view;

    public AboutPresenter(MensErgerJeNietControler model, AboutView view ,Main mainApp) {
        this.mainApp = mainApp;
        this.view = view;
        this.model = model;
        addEventHandlers();
    }


    private void addEventHandlers() {
        view.getGoBackButton().setOnAction(event -> mainApp.showMainMenu());
    }


}
