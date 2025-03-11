package be.kdg.mens_erger_je_niet.view.load_game;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.LoadGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoadGameView extends BorderPane {
    //private final VBox radioButtons;
    //private final Button loadButton;
    private Button goBackButton;
    private Label LoadGameLabel;
    //private final ToggleGroup toggleGroup;

    public LoadGameView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes(){
        //radioButtons = new VBox();
        //loadButton = new Button("Load Game");
        //toggleGroup = new ToggleGroup();
        goBackButton = new Button("Go Back");
        goBackButton.setFont(Font.font("Tohoma", FontWeight.NORMAL, 30));
        goBackButton.setTextFill(Color.WHITE);
        goBackButton.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(125), Insets.EMPTY)));
        goBackButton.setPadding(new Insets(20));

        LoadGameLabel = new Label("Laad game");
        LoadGameLabel.setFont(Font.font("Tohoma", FontWeight.NORMAL, 30));
        LoadGameLabel.setTextFill(Color.BLACK);
        LoadGameLabel.setPadding(new Insets(20));
    }

    private void layoutNodes() {
        BorderPane.setAlignment(LoadGameLabel, Pos.TOP_LEFT);
        this.setTop(LoadGameLabel);

        VBox vbox = new VBox(goBackButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        this.setBottom(vbox);
    }


    public Button getGoBackButton() {
        return goBackButton;
    }
}
