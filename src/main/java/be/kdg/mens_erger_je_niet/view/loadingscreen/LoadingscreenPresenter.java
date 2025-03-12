package be.kdg.mens_erger_je_niet.view.loadingscreen;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;

import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuPresenter;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LoadingscreenPresenter {
    private MensErgerJeNietControler model;
    private LoadingscreenView view;

    public LoadingscreenPresenter(MensErgerJeNietControler model, LoadingscreenView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
    }

    private void addEventHandlers() {
        //Startknop
        view.getStartButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                MainMenuView mainMenuView = new MainMenuView();
                MainMenuPresenter mainMenuPresenter = new MainMenuPresenter(model, mainMenuView);
                view.getScene().setRoot(mainMenuView);
                mainMenuView.getScene().getWindow().sizeToScene();
            }
        });

    }
}
