package be.kdg.mens_erger_je_niet.view.playboard;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import be.kdg.mens_erger_je_niet.Main;

public class PlayboardView extends BorderPane{
    private Button spelregels;

    public PlayboardView(Main mainApp) {
        initializeNodes();
        layoutNodes();
        setupEventHandlers(mainApp);
    }

    private void initializeNodes() {

        //Spelregels knop aanmaken
        spelregels = new Button("Spelregels");
        spelregels.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));
        spelregels.setTextFill(Color.WHITE);
        spelregels.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(10), Insets.EMPTY)));
        spelregels.setPadding(new Insets(10));
    }

    private void layoutNodes() {

        //Spelregels knop positioneren
        this.setRight(spelregels);
        spelregels.setAlignment(Pos.CENTER);
    }

    private void setupEventHandlers(Main mainApp){
        spelregels.setOnAction(event -> mainApp.helpView());
    }

    public Button getSpelregels() {
        return spelregels;
    }
}
