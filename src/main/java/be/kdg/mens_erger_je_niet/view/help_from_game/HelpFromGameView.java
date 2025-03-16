package be.kdg.mens_erger_je_niet.view.help_from_game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

public class HelpFromGameView extends BorderPane {
    private Button btnOkeekes;
    private TextFlow helpText;

    public HelpFromGameView() {
        this.initialiseNodes();
        this.layoutNodes();
        this.setPrefSize(640, 400);
    }

    private void initialiseNodes() {
        //Button met de tekst "OK" voor pop-up venster
        this.btnOkeekes = new Button("OK");
        this.btnOkeekes.setFont(Font.font("Tohoma", FontWeight.NORMAL, 25));
        this.btnOkeekes.setTextFill(Color.WHITE);
        this.btnOkeekes.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(125), Insets.EMPTY)));
        this.btnOkeekes.setPadding(new Insets(20));

        Text helpText = new Text("Het doel van Mens-Erger-Je-Niet is om al je pionnen van de startpositie naar de " +
                "thuis-positie te bewegen. Het spel wordt gespeeld met 2 tot 4 spelers, elk met 4 pionnen van een eigen " +
                "kleur. Je begint door een 6 te gooien om een pion uit de startpositie te halen. Daarna beweeg je je " +
                "pionnen volgens de dobbelsteenworp. Als je op hetzelfde vakje komt als een andere speler, sla je diens " +
                "pion terug naar de start. Pionnen moeten precies op het laatste vakje komen om thuis te zijn. Het spel " +
                "eindigt wanneer een speler al zijn pionnen thuis heeft.");
        helpText.setFont(Font.font("Arial", 28));

        this.helpText = new TextFlow(helpText);
        this.helpText.setMaxWidth(Double.MAX_VALUE);
        this.helpText.setPadding(new Insets(10));
        this.helpText.setTextAlignment(TextAlignment.CENTER);
    }

    private void layoutNodes() {
        //Stackpane aanmaken om als pop-up venster te gebruiken
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(helpText);
        stackPane.setAlignment(Pos.CENTER);

        this.setCenter(stackPane);
        BorderPane.setAlignment(this.btnOkeekes, Pos.CENTER);
        BorderPane.setMargin(this.btnOkeekes, new Insets(10.0, 0.0, 0.0, 0.0));
        this.setBottom(this.btnOkeekes);
    }

    public Button getBtnOkeekes() {
        return btnOkeekes;
    }
}
