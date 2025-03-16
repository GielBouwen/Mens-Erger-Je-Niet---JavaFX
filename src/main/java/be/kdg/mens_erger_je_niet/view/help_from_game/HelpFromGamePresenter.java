package be.kdg.mens_erger_je_niet.view.help_from_game;

import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HelpFromGamePresenter {
    public HelpFromGamePresenter(MensErgerJeNietControler model, final HelpFromGameView helpFromGameView) {
        helpFromGameView.getBtnOkeekes().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                helpFromGameView.getScene().getWindow().hide(); //Verberg scherm na klikken op "OK"
            }
        });
    }
}
