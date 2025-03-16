package be.kdg.mens_erger_je_niet.view.playboard;

import be.kdg.mens_erger_je_niet.model.MovementManager;
import be.kdg.mens_erger_je_niet.model.Pion;
import be.kdg.mens_erger_je_niet.model.TurnManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class PlayboardView extends BorderPane {
    private Button spelregelsButton;
    private Button stopGame;
    private Button pauseGame;
    private GridPane speelbord;
    private ImageView diceImageView;
    private Button rollButton;
    private Button spelregels;
    private Label spelerTurnLabel;
    public static final int SPEELBORD_SIZE = 15;
    public static final int CELL_SIZE = 50;
    private Pion pion;
    private final MovementManager movementManager;

    public PlayboardView() {
        initializeNodes();
        layoutNodes();
        TurnManager turnManager = new TurnManager(this);
        movementManager = new MovementManager(this, new ArrayList<>()); // Pionnen lijst moet ergens anders gedefinieerd worden

        this.setPrefSize(800, 800);
    }

    private Color getCellColor(int rij, int kolom) {
        // Startgebieden 2x2 per kleur
        if (rij < 2 && kolom < 2) return Color.BLUE;   // Blauw Start
        if (rij < 2 && kolom >= 13) return Color.YELLOW; // Geel Start
        if (rij >= 13 && kolom < 2) return Color.RED;   // Rood Start
        if (rij >= 13 && kolom >= 13) return Color.GREEN; // Groen Start

        // Middengebied (zwart vakje)
        if (rij == 7 && kolom == 7) return Color.BLACK;

        // Gekleurde eindroutes
        if (kolom == 7 && rij < 7 && rij > 0) return Color.BLUE;
        if (rij == 7 && kolom > 7 && kolom < 14) return Color.YELLOW;
        if (kolom == 7 && rij > 7 && rij < 14) return Color.GREEN;
        if (rij == 7 && kolom < 7 && kolom > 0) return Color.RED;

        // Looproute (Normale vakjes)
        if ((rij == 6 || rij == 8) && (kolom >= 0 && kolom < 15)) return Color.LIGHTGRAY;
        if ((kolom == 6 || kolom == 8) && (rij >= 0 && rij < 15)) return Color.LIGHTGRAY;
        if ((rij == 7 || kolom == 7) && (rij == 0 || rij == 14 || kolom == 0 || kolom == 14)) return Color.LIGHTGRAY;

        return Color.WHITE;
    }

    private void layoutNodes() {
        // Bovenste balk met spelregelsknop
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.TOP_RIGHT);
        topBox.setPadding(new Insets(15));
        topBox.getChildren().add(spelregels);
        this.setTop(topBox);

        // Centrale opbouw met speelbord en dobbelsteen
        HBox centerBox = new HBox();
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setPadding(new Insets(15));
        centerBox.setSpacing(25);

        VBox buttonAndDiceBox = new VBox();
        buttonAndDiceBox.setAlignment(Pos.CENTER_LEFT);
        buttonAndDiceBox.setSpacing(15);
        buttonAndDiceBox.setPadding(new Insets(15));
        buttonAndDiceBox.getChildren().addAll(diceImageView, rollButton, pauseGame, stopGame);

        centerBox.getChildren().addAll(buttonAndDiceBox, speelbord);
        this.setCenter(centerBox);
    }

    // Update de visuele positie van de pion
    public void updatePionPosition(Pion pion) {
        movementManager.updatePionPosition(pion);  // Beweeg de pion met de movement manager
    }

    // Methode om de pion op het bord te plaatsen
    public void plaatsPionOpBord(Pion pion) {
        movementManager.placePionOnBoard(pion); // Plaats de pion op het bord met behulp van movement manager
    }

    // Methode om de label van de huidige speler bij te werken
    public void updateSpelerTurnLabel(String spelerNaam) {
        spelerTurnLabel.setText("Beurt: " + spelerNaam);
    }

    // Initialisatie en layout van de GUI componenten
    private void initializeNodes() {
        spelerTurnLabel = new Label("Beurt: Speler 1");
        spelerTurnLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white;");

        // Spelregelsknop
        spelregels = new Button("Spelregels");
        spelregels.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: green;");
        spelregels.setPadding(new Insets(10));

        // Stopknop
        stopGame = new Button("Stop Game");
        stopGame.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: red;");
        stopGame.setPadding(new Insets(10));

        // Pauzeerknop
        pauseGame = new Button("Pause Game");
        pauseGame.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: green;");
        pauseGame.setPadding(new Insets(10));

        // GridPane speelbord
        speelbord = new GridPane();
        speelbord.setHgap(2);
        speelbord.setVgap(2);
        speelbord.setAlignment(Pos.CENTER);

        // Speelbord vullen met cellen
        for (int rij = 0; rij < SPEELBORD_SIZE; rij++) {
            for (int kolom = 0; kolom < SPEELBORD_SIZE; kolom++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setStroke(Color.BLACK);
                cell.setFill(getCellColor(rij, kolom));

                StackPane stackPane = new StackPane();
                stackPane.getChildren().add(cell);
                speelbord.add(stackPane, kolom, rij);
            }
        }

        // Dobbelsteen afbeelding
        diceImageView = new ImageView();
        diceImageView.setFitWidth(150);
        diceImageView.setFitHeight(150);
        diceImageView.setImage(new Image("file:src/resources/Dice1.png"));

        // Dobbelsteen knop
        rollButton = new Button("Gooi Dobbelsteen");
        rollButton.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: blue;");
    }

    // Getter voor de rollButton
    public Button getRollButton() {
        return rollButton;
    }

    // Getter voor de spelregels-button
    public Button getSpelregels() {
        if (spelregelsButton == null) {
            spelregelsButton = new Button("Spelregels");
        }
        return spelregelsButton;
    }

    // Getter voor het speelbord
    public GridPane getSpeelbord() {
        return speelbord;
    }

    // Getter voor de ImageView van de dobbelsteen
    public ImageView getDiceImageView() {
        return diceImageView;
    }
}