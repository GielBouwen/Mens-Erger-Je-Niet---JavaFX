package be.kdg.mens_erger_je_niet.view.load_game;

import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;

import be.kdg.mens_erger_je_niet.model.MensErgerJeNietException;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietFileManagement;
import be.kdg.mens_erger_je_niet.model.Spel;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuPresenter;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuView;
import be.kdg.mens_erger_je_niet.view.new_game.NewGameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class LoadGamePresenter {
    private MensErgerJeNietControler model;
    private LoadGameView view;

    public LoadGamePresenter(MensErgerJeNietControler model, LoadGameView view) {
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

        view.getLoadGameButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Selecteer een bestand om te laden");
                fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
                Stage stage = (Stage) view.getScene().getWindow();
                File selectedFile = fileChooser.showOpenDialog(stage);
                if (selectedFile != null) {
                    try {
                        NewGameView newGameView = new NewGameView();
                        Spel spel = MensErgerJeNietFileManagement.load(selectedFile.getAbsolutePath(), newGameView);
                    } catch (MensErgerJeNietException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}

