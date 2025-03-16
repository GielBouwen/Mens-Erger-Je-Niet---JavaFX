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

    public PlayboardPresenter(MensErgerJeNietControler model, PlayboardView view) {
        this.view = view;
        this.model = model;
        addEventHandlers();
        initialiseerPionnen();
    }

    public void addEventHandlers() {
        view.getSpelregels().setOnAction(new EventHandler<ActionEvent>() { //(Nieuwe window spelregels)
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

        view.getRollButton().setOnAction(event -> gooiDobbelsteen());

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


    private void addBoardEventHandlers() {
        GridPane speelbord = view.getSpeelbord();
        for (Node node : speelbord.getChildren()) {
            if (node instanceof Rectangle cell) {
                // Voeg mouse click handler toe voor elke cel
                cell.setOnMouseClicked(event -> handleBoardClick(event, cell));
            }
        }
    }

    private void handleBoardClick(MouseEvent event, Rectangle cell) {
        int kolom = GridPane.getColumnIndex(cell);
        int rij = GridPane.getRowIndex(cell);

        Pion geselecteerdePion = null;

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

    public void gooiDobbelsteen() {
        try {
            Speler huidigeSpeler = model.getHuidigeSpeler();
            int worp = model.gooiDobbelsteen();
            String imagePath = "file:src/resources/Dice" + worp + ".png";
            view.getDiceImageView().setImage(new Image(imagePath));

            showPionKiezenPopup();

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showPionKiezenPopup() {
        List<Pion> pionnen = model.getHuidigeSpeler().getPionnen();
        ChoiceDialog<Pion> pionKeuzeDialog = new ChoiceDialog<>(pionnen.get(0), pionnen);
        pionKeuzeDialog.setTitle("Kies een pion");
        pionKeuzeDialog.setHeaderText("Kies de pion die je wilt verplaatsen:");

        pionKeuzeDialog.showAndWait().ifPresent(pion -> {
            int startRij = 0;
            int startKolom = 0;

            pion.plaatsOpStartpositie(startRij, startKolom);

            int gegooidAantalOgen = model.gooiDobbelsteen();

            for (int i = 0; i < gegooidAantalOgen; i++) {
                model.verplaatsPion(pion, pion.getRij() + 1, pion.getKolom());
            }
            view.plaatsPionOpBord(pion);
            model.volgendeSpeler();
            String spelerNaam = model.getHuidigeSpeler().getGebruikersnaam();
            view.updateSpelerTurnLabel(spelerNaam);
        });
    }

    private void initialiseerPionnen() {
        List<Speler> spelers = model.getSpelers();
        Bord bord = model.getBord();

        for (Speler speler : spelers) {
            for (Pion pion : speler.getPionnen()) {
                bord.plaatsPionOpStartPositie(pion);
                view.plaatsPionOpBord(pion);
            }
        }
    }

    public void verplaatsPionNaWorp(Pion pion, int aantalOgen) {
        int nieuweRij = pion.getRij() + aantalOgen;
        int nieuweKolom = pion.getKolom();

        model.verplaatsPion(pion, nieuweRij, nieuweKolom);


        view.updatePionPosition(pion);
    }
}
