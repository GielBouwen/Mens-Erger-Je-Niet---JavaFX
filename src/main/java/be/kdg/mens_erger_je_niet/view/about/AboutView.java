package be.kdg.mens_erger_je_niet.view.about;

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

public class AboutView extends BorderPane {
    private Label titleLabel;
    private TextFlow aboutTextFlow;
    private Button GoBackButton;


    public AboutView() {
        initializeNodes();
        layoutNodes();
        this.setPrefSize(1280, 800);

    }

    private void initializeNodes() {
        //Titel van het scherm toevoegen als een label
        titleLabel = new Label("OVER");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        //Knop om terug te kunnen navigeren naar Main Menu
        GoBackButton = new Button("Ga terug");
        GoBackButton.setFont(Font.font("Arial", FontWeight.NORMAL, 30));
        GoBackButton.setTextFill(Color.WHITE);
        GoBackButton.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(125), Insets.EMPTY)));
        GoBackButton.setPadding(new Insets(20));

        //Daadwerkelijke inhoud voor de aboutview
        Text AboutText = new Text("Deze applicatie is ontwikkeld door Giel Bouwen en Wout Nagels als onderdeel " +
                "van onze eerste programmeeropdracht. We kozen voor het spel Mens-Erger-Je-Niet, maar al snel bleek " +
                "dat het een grotere uitdaging was dan we aanvankelijk hadden verwacht. Tijdens het ontwikkelen van " +
                "deze applicatie hebben we veel geleerd, niet alleen over code, maar ook over effectief time-management. " +
                "Na talloze uren werk, zijn we tot dit programma gekomen.");
        AboutText.setFont(Font.font("Arial", 30));

        aboutTextFlow = new TextFlow(AboutText);
        aboutTextFlow.setMaxWidth(Double.MAX_VALUE);
        aboutTextFlow.setPadding(new Insets(10));
    }

    private void layoutNodes() {
        //Titel toevoegen aan Vbox
        VBox title = new VBox(10, titleLabel);
        title.setPadding(new Insets(10));
        title.setAlignment(Pos.TOP_CENTER);

        //Inhoud ook toevoegen aan Vbox
        VBox content = new VBox(10, aboutTextFlow);
        content.setPadding(new Insets(10));
        content.setAlignment(Pos.CENTER);

        //goBackButton toevoegen aan de Vbox
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