package be.kdg.mens_erger_je_niet.view.playboard;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.Bord;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import be.kdg.mens_erger_je_niet.view.help.HelpView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PlayboardPresenter {
    private Main mainApp;
    private PlayboardView view;
    private MensErgerJeNietControler model;

    public PlayboardPresenter(Main mainApp, PlayboardView view, MensErgerJeNietControler model) {
        this.mainApp = mainApp;
        this.view = view;
        this.model = model;
        this.addEventHandlers();
    }

    public void addEventHandlers(){
        view.getSpelregels().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainApp.helpView();
            }
        });
    }
}
