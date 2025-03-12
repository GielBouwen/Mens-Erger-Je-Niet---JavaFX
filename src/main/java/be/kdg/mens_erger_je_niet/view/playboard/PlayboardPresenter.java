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
        // Lijst van spelers ophalen
        List<Speler> spelers = model.getSpelers(); // Haal de lijst van spelers via de controller
        Bord bord = model.getBord();

        // Loop door elke speler en zet hun pionnen op het bord
        for (Speler speler : spelers) {
            List<Pion> pionnen = speler.getPionnen();

            // Zet pionnen op de juiste startposities
            for (int i = 0; i < pionnen.size(); i++) {
                Pion pion = pionnen.get(i);
                int startRij = -1;
                int startKolom = -1;

                // Afhankelijk van de kleur van de speler, geef een andere startpositie
                switch (speler.getKleur()) {
                    case BLAUW:
                        startRij = i < 2 ? 0 : 1;
                        startKolom = i % 2 == 0 ? 0 : 1;
                        break;
                    case GEEL:
                        startRij = i < 2 ? 0 : 1;
                        startKolom = i % 2 == 0 ? 13 : 14;
                        break;
                    case ROOD:
                        startRij = i < 2 ? 13 : 14;
                        startKolom = i % 2 == 0 ? 0 : 1;
                        break;
                    case GROEN:
                        startRij = i < 2 ? 13 : 14;
                        startKolom = i % 2 == 0 ? 13 : 14;
                        break;
                }

                // Zet de pion op het bord op de juiste startpositie
                bord.zetPionOpBord(pion, startRij, startKolom);
                view.plaatsPionOpBord(pion); // Plaats de pion visueel op het bord
            }
        }
    }


}
