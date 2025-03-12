package be.kdg.mens_erger_je_niet.view.help;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuPresenter;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class HelpPresenter {
    private MensErgerJeNietControler model;
    private HelpView view;

    public HelpPresenter(MensErgerJeNietControler model,  HelpView view) {
        this.view = view;
        this.model = model;
        this.addEventHandlers();
    }

    private void addEventHandlers() {
        view.getGoBackButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainMenuView mainMenuView = new MainMenuView();
                MainMenuPresenter mainMenuPresenter = new MainMenuPresenter(model, mainMenuView);
                view.getScene().setRoot(mainMenuView);
                mainMenuView.getScene().getWindow().sizeToScene();
            }
        });

    }
}
