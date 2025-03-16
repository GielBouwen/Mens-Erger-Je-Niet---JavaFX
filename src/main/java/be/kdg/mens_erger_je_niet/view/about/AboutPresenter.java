package be.kdg.mens_erger_je_niet.view.about;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuPresenter;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class AboutPresenter {
    private MensErgerJeNietControler model;
    private AboutView view;

    public AboutPresenter(MensErgerJeNietControler model, AboutView view) {
        this.view = view;
        this.model = model;
        addEventHandlers();
    }


    private void addEventHandlers() {
        view.getGoBackButton().setOnAction(new EventHandler<ActionEvent>() { //Ga terug naar Main Menu
            @Override
            public void handle(ActionEvent actionEvent) {
                MainMenuView mainMenuView = new MainMenuView();
                MainMenuPresenter mainMenuPresenter = new MainMenuPresenter(model, mainMenuView);
                view.getScene().setRoot(mainMenuView);
                mainMenuView.getScene().getWindow().sizeToScene();
            }
        });
    }


}
