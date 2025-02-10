package be.kdg.mens_erger_je_niet.view.main_menu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javax.management.DescriptorKey;

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
        double radius = 75;

        newGame = new Button("New Game");
        newGame.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        newGame.setTextFill(Color.WHITE);
        newGame.setBackground(new Background(new BackgroundFill(Color.GOLD, new CornerRadii(radius), Insets.EMPTY)));
        newGame.setPadding(new Insets(10));
        newGame.setShape(new Circle(radius));
        newGame.setMinSize((radius*2), (radius*2));
        newGame.setMaxSize((radius * 2), (radius * 2));

        loadGame = new Button("Load Game");
        loadGame.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        loadGame.setTextFill(Color.WHITE);
        loadGame.setBackground(new Background(new BackgroundFill(Color.GOLD, new CornerRadii(radius), Insets.EMPTY)));
        loadGame.setPadding(new Insets(10));
        loadGame.setShape(new Circle(radius));
        loadGame.setMinSize((radius*2), (radius*2));
        loadGame.setMaxSize((radius * 2), (radius * 2));

        help = new Button("Help");
        help.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        help.setTextFill(Color.WHITE);
        help.setBackground(new Background(new BackgroundFill(Color.GOLD, new CornerRadii(5), Insets.EMPTY)));
        help.setPadding(new Insets(10));
        help.setShape(new Circle(radius));
        help.setMinSize((radius*2), (radius*2));
        help.setMaxSize((radius * 2), (radius * 2));

        about = new Button("About");
        about.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        about.setTextFill(Color.WHITE);
        about.setBackground(new Background(new BackgroundFill(Color.GOLD, new CornerRadii(5), Insets.EMPTY)));
        about.setPadding(new Insets(10));
        about.setShape(new Circle(radius));
        about.setMinSize((radius*2), (radius*2));
        about.setMaxSize((radius * 2), (radius * 2));
    }

    private void layoutNodes() {
        VBox vbox = new VBox(20, newGame, loadGame, help, about);
        vbox.setAlignment(Pos.CENTER);
        this.setCenter(vbox);
    }
}