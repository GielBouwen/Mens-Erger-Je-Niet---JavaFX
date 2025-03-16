package be.kdg.mens_erger_je_niet.view.help;

import be.kdg.mens_erger_je_niet.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class HelpView extends BorderPane {
    private Label titleLabel;
    private TextFlow aboutTextFlow;
    private Button GoBackButton;


    public HelpView() {
        initializeNodes();
        layoutNodes();
        this.setPrefSize(1280, 800);

    }

    private void initializeNodes() {
        //Titel
        titleLabel = new Label("HELP");
        titleLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));

        //Knop om terug te kunnen navigeren naar Main Menu
        GoBackButton = new Button("Ga terug");
        GoBackButton.setFont(Font.font("Tohoma", FontWeight.NORMAL, 30));
        GoBackButton.setTextFill(Color.WHITE);
        GoBackButton.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(125), Insets.EMPTY)));
        GoBackButton.setPadding(new Insets(20));

        //Inhoud van de spelregels-tekst
        Text AboutText = new Text("Het doel van Mens-Erger-Je-Niet is om al je pionnen van de startpositie naar de " +
                "thuis-positie te bewegen. Het spel wordt gespeeld met 2 tot 4 spelers, elk met 4 pionnen van een eigen " +
                "kleur. Je begint door een 6 te gooien om een pion uit de startpositie te halen. Daarna beweeg je je " +
                "pionnen volgens de dobbelsteenworp. Als je op hetzelfde vakje komt als een andere speler, sla je diens " +
                "pion terug naar de start. Pionnen moeten precies op het laatste vakje komen om thuis te zijn. Het spel " +
                "eindigt wanneer een speler al zijn pionnen thuis heeft.");
        AboutText.setFont(Font.font("Arial", 30));
        aboutTextFlow = new TextFlow(AboutText);
        aboutTextFlow.setMaxWidth(Double.MAX_VALUE);
        aboutTextFlow.setPadding(new Insets(10));
    }

    private void layoutNodes() {

        //Titel toevoegen en layouten aan Vbox
        VBox title = new VBox(10, titleLabel);
        title.setPadding(new Insets(10));
        title.setAlignment(Pos.TOP_CENTER);

        //Inhoud toevoegen en layouten aan Vbox
        VBox content = new VBox(10, aboutTextFlow);
        content.setPadding(new Insets(10));
        content.setAlignment(Pos.CENTER);

        //goBackButton toevoegen en layouten aan Vbox
        VBox goBackButton = new VBox(10, GoBackButton);
        goBackButton.setPadding(new Insets(10));
        goBackButton.setAlignment(Pos.CENTER);

        //Titel, inhoud en goBackButton onder elkaar plaatsen
        this.setTop(title);
        this.setCenter(content);
        this.setBottom(goBackButton);

    }

    public Button getGoBackButton() {
        return GoBackButton;
    }

}