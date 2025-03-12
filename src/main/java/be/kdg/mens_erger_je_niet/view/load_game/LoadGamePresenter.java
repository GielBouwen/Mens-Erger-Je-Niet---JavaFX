package be.kdg.mens_erger_je_niet.view.load_game;

import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;

import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuPresenter;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

import java.io.File;

public class LoadGamePresenter {
    private MensErgerJeNietControler model;
    private LoadGameView view;

    public LoadGamePresenter(MensErgerJeNietControler model, LoadGameView view) {
        this.view = view;
        this.model = model;
        addEventHandlers();
    }

    private void showError(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }

    private void addEventHandlers() {
        view.getGoBackButton().setOnAction(new EventHandler<ActionEvent>() {
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
                fileChooser.setTitle("Load Game File");
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("GameFiles"));
                File selectedFile = fileChooser.showOpenDialog(view.getScene().getWindow());
                if (selectedFile != null) {
                    try {
                        model.load(selectedFile.getAbsolutePath());
                    } catch (Exception e) {
                        showError(e);
                    }
                }

            }
        });
    }
}

