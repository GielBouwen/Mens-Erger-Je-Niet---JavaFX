package be.kdg.mens_erger_je_niet.view.load_game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoadGameView extends BorderPane {
    private Button goBackButton;
    private Label loadGameLabel;
    private Button loadGameButton;
    public LoadGameView() {
        initializeNodes();
        layoutNodes();
        this.setPrefSize(1280, 800);

    }

    private void initializeNodes(){
        //Button om terug te kunnen navigeren naar Main Menu
        goBackButton = new Button("Ga terug");
        goBackButton.setFont(Font.font("Tohoma", FontWeight.NORMAL, 30));
        goBackButton.setTextFill(Color.WHITE);
        goBackButton.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(125), Insets.EMPTY)));
        goBackButton.setPadding(new Insets(20));

        //Label voor de titel van het scherm
        loadGameLabel = new Label("Laad game");
        loadGameLabel.setFont(Font.font("Tohoma", FontWeight.NORMAL, 30));
        loadGameLabel.setTextFill(Color.BLACK);
        loadGameLabel.setPadding(new Insets(20));

        //Knop om een spel te kunnen laden (werkt niet)
        loadGameButton = new Button("Laad game");
        loadGameButton.setFont(Font.font("Tohoma", FontWeight.NORMAL, 30));
        loadGameButton.setTextFill(Color.WHITE);
        loadGameButton.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(125), Insets.EMPTY)));
        loadGameButton.setPadding(new Insets(20));

    }

    private void layoutNodes() {
        //Titel positioneren linksbovenaan
        BorderPane.setAlignment(loadGameLabel, Pos.TOP_LEFT);
        this.setTop(loadGameLabel);

        //Vbox aanmaken waar alle spellen verschijnen
        VBox buttonBox = new VBox(20);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

        //Vbox (buttonBox) vullen met de spellen
        buttonBox.getChildren().addAll(loadGameButton, goBackButton);

        this.setCenter(buttonBox);
    }



    public Button getGoBackButton() {
        return goBackButton;
    }
    public Button getLoadGameButton() {
        return loadGameButton;
    }
}
