package be.kdg.mens_erger_je_niet.view.help;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class HelpPresenter {
    private MensErgerJeNietControler model;
    private HelpView view;
    private Main mainApp;

    public HelpPresenter(MensErgerJeNietControler model,  HelpView view, Main mainApp) {
        this.mainApp = mainApp;
        this.view = view;
        this.model = model;
        this.addEventHandlers();
    }

    private void addEventHandlers(){
        view.getGoBackButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                mainApp.gaTerugVanSpelregels();
            }
        });
    }
}
