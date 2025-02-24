package be.kdg.mens_erger_je_niet.view.help;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import be.kdg.mens_erger_je_niet.view.help.HelpView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class HelpPresenter {
    private Main mainApp;
    private HelpView view;
    private MensErgerJeNietControler model;

    public HelpPresenter(Main mainApp, HelpView view, MensErgerJeNietControler model) {
        this.mainApp = mainApp;
        this.view = view;
        this.model = model;
       // this.addEventHandlers();
    }

   /* public void addEventHandlers(){
        view.getGoBackButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                mainApp.goBack();
            }
        });
    */
}

