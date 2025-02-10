package be.kdg.mens_erger_je_niet.view.main_menu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import be.kdg.mens_erger_je_niet.Main;

public class MainMenuView extends BorderPane {
    private Button newGame;
    private Button loadGame;
    private Button help;
    private Button about;

    public MainMenuView() {
        initializeNodes();
        layoutNodes();
        setupEventHandlers(mainApp);
    }

    private void initializeNodes() {
        double radius = 125;
        double textSize = 30;

        newGame = new Button("New Game");
        newGame.setFont(Font.font("Arial", FontWeight.BOLD, textSize));
        newGame.setTextFill(Color.WHITE);
        newGame.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(radius), Insets.EMPTY)));
        newGame.setPadding(new Insets(10));
        newGame.setShape(new Circle(radius));
        newGame.setMinSize((radius * 2), (radius * 2));
        newGame.setMaxSize((radius * 2), (radius * 2));

        loadGame = new Button("Load Game");
        loadGame.setFont(Font.font("Arial", FontWeight.BOLD, textSize));
        loadGame.setTextFill(Color.WHITE);
        loadGame.setBackground(new Background(new BackgroundFill(Color.GOLD, new CornerRadii(radius), Insets.EMPTY)));
        loadGame.setPadding(new Insets(10));
        loadGame.setShape(new Circle(radius));
        loadGame.setMinSize((radius * 2), (radius * 2));
        loadGame.setMaxSize((radius * 2), (radius * 2));

        help = new Button("Help");
        help.setFont(Font.font("Arial", FontWeight.BOLD, textSize));
        help.setTextFill(Color.WHITE);
        help.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), Insets.EMPTY)));
        help.setPadding(new Insets(10));
        help.setShape(new Circle(radius));
        help.setMinSize((radius * 2), (radius * 2));
        help.setMaxSize((radius * 2), (radius * 2));

        about = new Button("About");
        about.setFont(Font.font("Arial", FontWeight.BOLD, textSize));
        about.setTextFill(Color.WHITE);
        about.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, new CornerRadii(5), Insets.EMPTY)));
        about.setPadding(new Insets(10));
        about.setShape(new Circle(radius));
        about.setMinSize((radius * 2), (radius * 2));
        about.setMaxSize((radius * 2), (radius * 2));
    }

    private void layoutNodes() {
        GridPane mainMenuGrid = new GridPane();
        mainMenuGrid.setHgap(50);
        mainMenuGrid.setVgap(50);

        mainMenuGrid.add(newGame, 0, 0);
        mainMenuGrid.add(loadGame, 1, 0);
        mainMenuGrid.add(help, 0, 1);
        mainMenuGrid.add(about, 1, 1);

        mainMenuGrid.setAlignment(Pos.CENTER);
        this.setCenter(mainMenuGrid);
    }

    private void setupEventHandlers(Main mainApp) {
        newGame.setOnAction(event -> mainApp.showNewGame());
        loadGame.setOnAction(event -> mainApp.loadGameView());
        about.setOnAction(event -> mainApp.aboutView());
    }
}