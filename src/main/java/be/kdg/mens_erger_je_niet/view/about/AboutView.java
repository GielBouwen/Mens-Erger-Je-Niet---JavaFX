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
    }

    private void initializeNodes() {
        titleLabel = new Label("ABOUT");
        titleLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));


        GoBackButton = new Button("Ga terug");
        GoBackButton.setFont(Font.font("Tohoma", FontWeight.NORMAL, 30));
        GoBackButton.setTextFill(Color.WHITE);
        GoBackButton.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(125), Insets.EMPTY)));
        GoBackButton.setPadding(new Insets(20));

        Text AboutText = new Text("Deze applicatie is ontwikkeld door Wout en Giel in het kader van een " +
                "programmeeropdracht. De opdracht was om een interactief spel te creëren, en wij hebben de klassieker " +
                "Mens-Erger-Je-Niet, internationaal bekend als Ludo, toegewezen gekregen. Met veel toewijding en " +
                "enthousiasme hebben we aan deze game gewerkt, waarbij we niet alleen de basisregels hebben " +
                "geïmplementeerd, maar ook extra aandacht hebben besteed aan de gebruikservaring en het spelplezier. " +
                "We hebben hier talloze uren aan besteed en hopen dat spelers net zoveel plezier beleven aan het spelen " +
                "als wij aan het ontwikkelen ervan. Veel speelplezier!");
        AboutText.setFont(Font.font("Arial", 30));

        aboutTextFlow = new TextFlow(AboutText);
        aboutTextFlow.setMaxWidth(Double.MAX_VALUE);
        aboutTextFlow.setPadding(new Insets(10));
    }

    private void layoutNodes() {
        VBox title = new VBox(10, titleLabel);
        title.setPadding(new Insets(10));
        title.setAlignment(Pos.TOP_CENTER);

        VBox content = new VBox(10, aboutTextFlow);
        content.setPadding(new Insets(10));
        content.setAlignment(Pos.CENTER);

        VBox goBackButton = new VBox(10, GoBackButton);
        goBackButton.setPadding(new Insets(10));
        goBackButton.setAlignment(Pos.CENTER);


        this.setTop(title);
        this.setCenter(content);
        this.setBottom(goBackButton);

    }


    public Button getGoBackButton() {
        return GoBackButton;
    }
}