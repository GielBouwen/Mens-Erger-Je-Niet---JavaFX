package be.kdg.mens_erger_je_niet.view.load_game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoadGameView extends BorderPane {
    //private final VBox radioButtons;
    //private final Button loadButton;
    private Button goBackButton;
    private Label loadGameLabel;
    private Button loadGameButton;
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

        loadGameLabel = new Label("Laad game");
        loadGameLabel.setFont(Font.font("Tohoma", FontWeight.NORMAL, 30));
        loadGameLabel.setTextFill(Color.BLACK);
        loadGameLabel.setPadding(new Insets(20));

        loadGameButton = new Button("Load game");
        loadGameButton.setFont(Font.font("Tohoma", FontWeight.NORMAL, 30));
        loadGameButton.setTextFill(Color.WHITE);
        loadGameButton.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(125), Insets.EMPTY)));
        loadGameButton.setPadding(new Insets(20));

    }

    private void layoutNodes() {
        BorderPane.setAlignment(loadGameLabel, Pos.TOP_LEFT);
        this.setTop(loadGameLabel);

        VBox buttonBox = new VBox(20);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

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
