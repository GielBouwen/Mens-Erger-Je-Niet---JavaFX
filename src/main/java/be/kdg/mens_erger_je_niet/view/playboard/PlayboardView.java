package be.kdg.mens_erger_je_niet.view.playboard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class PlayboardView extends BorderPane {
    private Button spelregels;
    private Button stopGame;
    private Button pauseGame;
    private GridPane speelbord;
    private ImageView diceImageView;
    private Button rollButton;
    private static final int SPEELBORD_SIZE = 15; // Afmetingen 15x15
    private static final int CELL_SIZE = 50;

    public PlayboardView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        //Cellen met cirkels (dubbele array (Y en X, (vanaf 0 tellen))
        int [][] cirkelPositions = {{0, 0}, {0, 1}, {8, 0}, {0, 13}, {0,14},
                {1, 0}, {1, 1}, {1, 13}, {1, 14},
                {0, 6}, {14, 8},
                {13, 0}, {13, 1}, {13, 13}, {13, 14},
                {14, 0}, {14, 1}, {6, 14}, {14, 13}, {14, 14}};


        // Spelregelsknop
        spelregels = new Button("Spelregels");
        spelregels.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: green;");
        spelregels.setPadding(new Insets(10));
        BorderPane.setAlignment(spelregels, Pos.TOP_RIGHT);

        //StopKnop
        stopGame = new Button("Stop Game");
        stopGame.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: red;");
        stopGame.setPadding(new Insets(10));
        BorderPane.setAlignment(stopGame, Pos.BOTTOM_LEFT);

        //pauzeerKnop
        pauseGame = new Button("Pause Game");
        pauseGame.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: green;");
        pauseGame.setPadding(new Insets(10));
        BorderPane.setAlignment(pauseGame, Pos.BOTTOM_LEFT);

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


            for (int[] position : cirkelPositions) {
                if(rij == position[0] && kolom == position[1]) {
                    Circle circle = new Circle(CELL_SIZE /3);
                    circle.setFill(Color.WHITE);
                    circle.setStroke(Color.BLACK);
                    stackPane.getChildren().add(circle);
                }
            }
            speelbord.add(stackPane, rij, kolom);

            }
        }

        //Dobbelsteen Afbeelding
        diceImageView = new ImageView(new Image("file:src/resources/Dice1.png"));
        diceImageView.setFitWidth(150);
        diceImageView.setFitHeight(150);


        //Rol dobbelsteen Knop
        rollButton = new Button("Gooi Dobbelsteen");
        rollButton.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: blue;");

    }

    private void layoutNodes() {
        //VBOX Spelvord
        this.setCenter(speelbord);

        // HBox Spelregels Boven Rechts
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.TOP_RIGHT);
        topBox.setPadding(new Insets(15));
        topBox.getChildren().add(spelregels);
        this.setTop(topBox);

        // HBox and VBox Dice en speelbord
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

    // Bepaalt de kleur van de vakjes
    private Color getCellColor(int rij, int kolom) {
        //Startgebieden 2x2 per kleur
        if (rij < 2 && kolom < 2) return Color.BLUE;   // Blauw Start
        if (rij < 2 && kolom >= 13) return Color.YELLOW; // Geel Start
        if (rij >= 13 && kolom < 2) return Color.RED;   // Rood Start
        if (rij >= 13 && kolom >= 13) return Color.GREEN; // Groen Start

        //Middengebied (zwart vakje)
        if (rij == 7 && kolom == 7) return Color.BLACK;

        //Gekleurde eindroutes
        if (kolom == 7 && rij < 7 && rij > 0) return Color.YELLOW; // Geel eindpad
        if (rij == 7 && kolom > 7 && kolom < 14) return Color.GREEN; // Groen eindpad
        if (kolom == 7 && rij > 7 && rij < 14) return Color.RED; // Rood eindpad
        if (rij == 7 && kolom < 7 && kolom > 0) return Color.BLUE; // Blauw eindpad

        //Looproute (Normale vakjes)
        if ((rij == 6 || rij == 8) && (kolom >= 0 && kolom < 15)) return Color.LIGHTGRAY; // Horizontale route
        if ((kolom == 6 || kolom == 8) && (rij >= 0 && rij < 15)) return Color.LIGHTGRAY; // Verticale route
        if ((rij == 7 || kolom == 7) && (rij == 0 || rij == 14 || kolom == 0 || kolom == 14)) return Color.LIGHTGRAY;


        return Color.WHITE; // Overige vakjes
    }


    public Button getSpelregels() {
        return spelregels;
    }

    public GridPane getSpeelbord() {
        return speelbord;
    }

    public Button getRollButton() {
        return rollButton;
    }

    public ImageView getDiceImageView() {
        return diceImageView;
    }


}
