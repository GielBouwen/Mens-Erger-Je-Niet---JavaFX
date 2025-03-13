package be.kdg.mens_erger_je_niet.view.playboard;

import be.kdg.mens_erger_je_niet.Kleur;
import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.*;
import be.kdg.mens_erger_je_niet.view.help.HelpPresenter;
import be.kdg.mens_erger_je_niet.view.help.HelpView;
import be.kdg.mens_erger_je_niet.view.help_from_game.HelpFromGamePresenter;
import be.kdg.mens_erger_je_niet.view.help_from_game.HelpFromGameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.util.List;

public class PlayboardPresenter {
    private final PlayboardView view;
    private final MensErgerJeNietControler model;

    public PlayboardPresenter(MensErgerJeNietControler model, PlayboardView view) {
        this.view = view;
        this.model = model;
        this.addEventHandlers();

        initialiseerPionnen();
    }

    public void addEventHandlers() {
        view.getSpelregels().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HelpFromGameView helpFromGameView = new HelpFromGameView();
                HelpFromGamePresenter helpFromGamePresenter = new HelpFromGamePresenter(model, helpFromGameView);
                Stage helpFromGameStage = new Stage();
                helpFromGameStage.initOwner(view.getScene().getWindow());
                helpFromGameStage.initModality(Modality.APPLICATION_MODAL);
                helpFromGameStage.setScene(new Scene(helpFromGameView));
                helpFromGameStage.setX(view.getScene().getWindow().getX() + 100);
                helpFromGameStage.setY(view.getScene().getWindow().getY() + 100);
                helpFromGameStage.showAndWait();
            }
        });



        view.getRollButton().setOnAction(event -> {
            gooiDobbelsteen();
        });

        /*view.getStopGame().setOnAction(event -> {
            // Maak een bevestigingsdialoog voor het stoppen van het spel
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Stop Game");
            alert.setHeaderText("Weet je zeker dat je het spel wilt stoppen?");
            alert.setContentText("Je moet je voortgang opslaan voordat je stopt.");

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    // Als de gebruiker op OK klikt, open de Save As dialoog
                    showSaveFileDialog();
                }
            });
        });

         */
        addBoardEventHandlers();
    }

    /* private void showSaveFileDialog() {
        // Maak een FileChooser voor het opslaan van het bestand
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Mens Erger Je Niet Spel", "*.dat"));

        // Laat de gebruiker een bestandslocatie kiezen
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            // Als een bestand gekozen is, sla het spel op met de gekozen naam
            saveGame(file);
        }
    }

    private void saveGame(File file) {
        try {
            // Sla het spel op met behulp van de MensErgerJeNietFileManagement klasse
            MensErgerJeNietFileManagement.save(file.getAbsolutePath(), model.getSpel());
            System.out.println("Spel succesvol opgeslagen!");
        } catch (MensErgerJeNietException e) {
            System.out.println("Fout bij opslaan van het spel: " + e.getMessage());
        }
    }

     */


    private void addBoardEventHandlers() {
        GridPane speelbord = view.getSpeelbord();
        for (Node node : speelbord.getChildren()) {
            if (node instanceof Rectangle cell) {
                cell.setOnMouseClicked(event -> handleBoardClick(event, cell));
            }
        }
    }


    private void handleBoardClick(MouseEvent event, Rectangle cell) {
        int kolom = GridPane.getColumnIndex(cell);
        int rij = GridPane.getRowIndex(cell);

        Pion geselecteerdePion = null;

        // Zoek naar een pion op dit vakje
        for (Pion pion : model.getBord().getPionnenOpBord().values()) {
            if (pion.getRij() == rij && pion.getKolom() == kolom) {
                geselecteerdePion = pion;
                break;
            }
        }

        if (geselecteerdePion != null) {
            int nieuweRij = rij + 1;
            int nieuweKolom = kolom;

            if (model.getBord().zetPionOpBord(geselecteerdePion, nieuweRij, nieuweKolom)) {
                view.plaatsPionOpBord(geselecteerdePion);
            }
        }
    }


    private void gooiDobbelsteen() {
        int worp = model.gooiDobbelsteen();
        String imagePath = "file:src/resources/Dice" + worp + ".png";
        view.getDiceImageView().setImage(new Image(imagePath));
    }

    private void initialiseerPionnen() {
        List<Speler> spelers = model.getSpelers();
        Bord bord = model.getBord();

        for (Speler speler : spelers) {
            for (Pion pion : speler.getPionnen()) {
                bord.plaatsPionOpStartPositie(pion); // Model bepaalt de startpositie
                view.plaatsPionOpBord(pion); // View plaatst de pion visueel
            }
        }
    }


}
