package be.kdg.mens_erger_je_niet.view.playboard;

import be.kdg.mens_erger_je_niet.model.*;
import be.kdg.mens_erger_je_niet.view.help_from_game.HelpFromGamePresenter;
import be.kdg.mens_erger_je_niet.view.help_from_game.HelpFromGameView;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuPresenter;
import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;

public class PlayboardPresenter {
    private final PlayboardView view;
    private final MensErgerJeNietControler model;

    // Constructor: model en view worden meegegeven
    public PlayboardPresenter(MensErgerJeNietControler model, PlayboardView view) {
        this.view = view;
        this.model = model;

        // Event handlers toevoegen en pionnen initialiseren
        addEventHandlers();
        initialiseerPionnen();
    }

    // Methode om alle event handlers toe te voegen
    public void addEventHandlers() {
        // Spelregels knop handler
        view.getSpelregels().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Maak een Help view en presenter voor spelregels
                HelpFromGameView helpFromGameView = new HelpFromGameView();
                HelpFromGamePresenter helpFromGamePresenter = new HelpFromGamePresenter(model, helpFromGameView);

                // Maak een nieuw window voor de spelregels
                Stage helpFromGameStage = new Stage();
                helpFromGameStage.initOwner(view.getScene().getWindow());
                helpFromGameStage.initModality(Modality.APPLICATION_MODAL);
                helpFromGameStage.setScene(new Scene(helpFromGameView));
                helpFromGameStage.setX(view.getScene().getWindow().getX() + 100);
                helpFromGameStage.setY(view.getScene().getWindow().getY() + 100);
                helpFromGameStage.showAndWait();
            }
        });

        // Dobbelsteen knop handler
        view.getRollButton().setOnAction(event -> gooiDobbelsteen());

        // Bord cellen event handlers
        addBoardEventHandlers();
        view.getSpelregels().setOnAction(event -> toonSpelregels());

        view.getStopGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Bevestiging");
                alert.setHeaderText("Ben je zeker dat je wilt stoppen?");
                alert.setContentText("Kies je optie.");

                ButtonType buttonTypeYes = new ButtonType("Ja");
                ButtonType buttonTypeNo = new ButtonType("Nee");

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == buttonTypeYes) {
                    MainMenuView mainMenuView = new MainMenuView();
                    MainMenuPresenter mainMenuPresenter = new MainMenuPresenter(model, mainMenuView);
                    view.getScene().setRoot(mainMenuView);
                    mainMenuView.getScene().getWindow().sizeToScene();
                } else {
                    alert.close();
                }
            }
        });
    }

    private void toonSpelregels() {
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



    // Methode om event handlers toe te voegen aan het speelbord
    private void addBoardEventHandlers() {
        GridPane speelbord = view.getSpeelbord();
        for (Node node : speelbord.getChildren()) {
            if (node instanceof Rectangle cell) {
                // Voeg mouse click handler toe voor elke cel
                cell.setOnMouseClicked(event -> handleBoardClick(event, cell));
            }
        }
    }

    // Verwerking van een klik op een bordcel
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

        // Als een pion geselecteerd is, verplaats deze
        if (geselecteerdePion != null) {
            int nieuweRij = rij + 1;
            int nieuweKolom = kolom;

            if (model.getBord().zetPionOpBord(geselecteerdePion, nieuweRij, nieuweKolom)) {
                view.plaatsPionOpBord(geselecteerdePion);
            }
        }
    }

    // Methode om dobbelsteen te gooien
    public void gooiDobbelsteen() {
        try {
            Speler huidigeSpeler = model.getHuidigeSpeler();
            // Gooi de dobbelsteen via het model
            int worp = model.gooiDobbelsteen();
            String imagePath = "file:src/resources/Dice" + worp + ".png";  // Afbeelding op basis van de worp
            view.getDiceImageView().setImage(new Image(imagePath));  // Werk de dobbelsteen afbeelding bij in de view

            // Toon een pop-up voor pionselectie na de worp
            showPionKiezenPopup();

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());  // Foutafhandelingslogica
        }
    }

    // Toon een popup voor het kiezen van een pion na dobbelsteenworp
    public void showPionKiezenPopup() {
        List<Pion> pionnen = model.getHuidigeSpeler().getPionnen(); // Pionnen van de huidige speler
        ChoiceDialog<Pion> pionKeuzeDialog = new ChoiceDialog<>(pionnen.get(0), pionnen);
        pionKeuzeDialog.setTitle("Kies een pion");
        pionKeuzeDialog.setHeaderText("Kies de pion die je wilt verplaatsen:");

        pionKeuzeDialog.showAndWait().ifPresent(pion -> {
            // Zet de gekozen pion op de startpositie
            int startRij = 0;
            int startKolom = 0;

            pion.plaatsOpStartpositie(startRij, startKolom);

            // Gooi de dobbelsteen en verplaats de pion
            int gegooidAantalOgen = model.gooiDobbelsteen();

            // Verplaats de gekozen pion volgens het aantal ogen
            for (int i = 0; i < gegooidAantalOgen; i++) {
                model.verplaatsPion(pion, pion.getRij() + 1, pion.getKolom());
            }

            // Werk de visuele weergave bij
            view.plaatsPionOpBord(pion);

            // Werk de beurt bij naar de volgende speler
            model.volgendeSpeler();

            // Verkrijg de naam van de huidige speler
            String spelerNaam = model.getHuidigeSpeler().getGebruikersnaam();
            view.updateSpelerTurnLabel(spelerNaam);  // Geef de naam door aan de view
        });
    }

    // Initialiseer de pionnen en zet ze op de startpositie
    private void initialiseerPionnen() {
        List<Speler> spelers = model.getSpelers();
        Bord bord = model.getBord();

        for (Speler speler : spelers) {
            for (Pion pion : speler.getPionnen()) {
                bord.plaatsPionOpStartPositie(pion);  // Model bepaalt de startpositie
                view.plaatsPionOpBord(pion);  // View plaatst de pion visueel
            }
        }
    }

    // Verplaats een pion na de dobbelsteenworp
    public void verplaatsPionNaWorp(Pion pion, int aantalOgen) {
        // Verplaats de pion in het model
        int nieuweRij = pion.getRij() + aantalOgen;
        int nieuweKolom = pion.getKolom();  // Kolom kan bijvoorbeeld hetzelfde blijven

        model.verplaatsPion(pion, nieuweRij, nieuweKolom); // Pion verplaatsen in het model

        // Werk de view bij met de nieuwe positie van de pion
        view.updatePionPosition(pion);  // View wordt bijgewerkt met de nieuwe positie
    }
}
