package be.kdg.mens_erger_je_niet.view.load_game;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietException;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietFileManagement;
import be.kdg.mens_erger_je_niet.model.Spel;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class LoadGamePresenter {
    private MensErgerJeNietControler model;
    private Main mainApp;
    private LoadGameView view;

    public LoadGamePresenter(MensErgerJeNietControler model, LoadGameView view, Main mainApp) {
        this.mainApp = mainApp;
        this.view = view;
        this.model = model;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getGoBackButton().setOnAction(event -> mainApp.showMainMenu());

        view.getLoadGameButton().setOnAction(event -> openFileChooser());

    }


    void openFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Mens Erger Je Niet bestanden", "*.menserger")
        );

        Stage stage = (Stage) view.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            // Bestanden succesvol geladen
            try {
                Spel spel = MensErgerJeNietFileManagement.load(file.getAbsolutePath());
                System.out.println("Spel geladen: " + file.getAbsolutePath());
            } catch (MensErgerJeNietException e) {
                System.out.println("Inladen is Mislukt");
            }
        }
    }
}

