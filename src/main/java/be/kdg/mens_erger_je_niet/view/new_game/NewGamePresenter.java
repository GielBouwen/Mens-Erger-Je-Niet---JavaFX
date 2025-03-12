package be.kdg.mens_erger_je_niet.view.new_game;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuPresenter;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuView;
import be.kdg.mens_erger_je_niet.view.playboard.PlayboardPresenter;
import be.kdg.mens_erger_je_niet.view.playboard.PlayboardView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NewGamePresenter {
    private NewGameView view;
    private MensErgerJeNietControler model;

    public NewGamePresenter(MensErgerJeNietControler model, NewGameView view) {
        this.view = view;
        this.model = model;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getCancelButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MainMenuView mainMenuView = new MainMenuView();
                MainMenuPresenter mainMenuPresenter = new MainMenuPresenter(model, mainMenuView);
                view.getScene().getWindow().sizeToScene();
            }
        });

        view.getCreateButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                PlayboardView playboardView = new PlayboardView();
                PlayboardPresenter playboardPresenter = new PlayboardPresenter(model, playboardView);
                view.getScene().setRoot(playboardView);
                playboardView.getScene().getWindow().sizeToScene();
            }
        });

        view.getCheckBoxGroen().setOnAction(event -> {
            if (view.getCheckBoxGroen().isSelected()) {
                System.out.println("Groen is een CPU");
            } else {
                System.out.println("Groen is een Speler");
            }
        });
        view.getCheckBoxGeel().setOnAction(event -> {
            if (view.getCheckBoxGeel().isSelected()) {
                System.out.println("Geel is een CPU");
            } else {
                System.out.println("Geel is een Speler");
            }
        });
        view.getCheckBoxRood().setOnAction(event -> {
            if (view.getCheckBoxRood().isSelected()) {
                System.out.println("Rood is een CPU");
            } else {
                System.out.println("Rood is een Speler");
            }
        });
        view.getCheckBoxBlauw().setOnAction(event -> {
            if (view.getCheckBoxBlauw().isSelected()) {
                System.out.println("Blauw is een CPU");
            } else {
                System.out.println("Blauw is een Speler");
            }
        });
    }
}
