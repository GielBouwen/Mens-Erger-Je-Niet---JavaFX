package be.kdg.mens_erger_je_niet.view.main_menu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainMenuView extends BorderPane {
    private Button newGame;
    private Button loadGame;
    private Button help;
    private Button about;

    public MainMenuView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        newGame = new Button("New Game");
        newGame.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        newGame.setTextFill(Color.WHITE);
        newGame.setBackground(new Background(new BackgroundFill(Color.GOLD, new CornerRadii(5), Insets.EMPTY)));
        newGame.setPadding(new Insets(10, 20, 10, 20));

        loadGame = new Button("Load Game");
        loadGame.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        loadGame.setTextFill(Color.WHITE);
        loadGame.setBackground(new Background(new BackgroundFill(Color.GOLD, new CornerRadii(5), Insets.EMPTY)));
        loadGame.setPadding(new Insets(10, 20, 10, 20));

        help = new Button("Help");
        help.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        help.setTextFill(Color.WHITE);
        help.setBackground(new Background(new BackgroundFill(Color.GOLD, new CornerRadii(5), Insets.EMPTY)));
        help.setPadding(new Insets(10, 20, 10, 20));

        about = new Button("About");
        about.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        about.setTextFill(Color.WHITE);
        about.setBackground(new Background(new BackgroundFill(Color.GOLD, new CornerRadii(5), Insets.EMPTY)));
        about.setPadding(new Insets(10, 20, 10, 20));
    }

    private void layoutNodes() {

        GridPane mainMenuGrid = new GridPane();
        mainMenuGrid.setHgap(30); //Stel de witruimte in
        mainMenuGrid.setVgap(50);

        mainMenuGrid.add(newGame, 0, 0); //Voeg de knoppen toe en zet ze op de juiste positie
        mainMenuGrid.add(loadGame, 1, 0);
        mainMenuGrid.add(help, 0, 1);
        mainMenuGrid.add(about, 1, 1);

        mainMenuGrid.setAlignment(Pos.CENTER); //Positioneer de grid in het midden
        this.setCenter(mainMenuGrid);

    }
}