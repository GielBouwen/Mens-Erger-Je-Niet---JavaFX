package be.kdg.mens_erger_je_niet.view.loadingscreen;

import be.kdg.mens_erger_je_niet.view.main_menu.MainMenuView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoadingscreenView extends BorderPane {
    private ImageView imageView;
    private Button startButton;

    public LoadingscreenView(Stage primaryStage) {
        initializeNodes();
        layoutNodes(primaryStage);
    }

    private void initializeNodes() {
        Image image = new Image(getClass().getResourceAsStream("/resources/mens_erger_je_niet.png"));
        imageView = new ImageView(image);
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);

        startButton = new Button("Start het spel");
        startButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        startButton.setTextFill(Color.WHITE);
        startButton.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, new CornerRadii(5), Insets.EMPTY)));
        startButton.setPadding(new Insets(10, 20, 10, 20));
    }

    private void layoutNodes(Stage primaryStage) {
        VBox vbox = new VBox(20, imageView, startButton);
        vbox.setAlignment(Pos.CENTER);
        this.setCenter(vbox);

        startButton.setOnAction(event -> {
            MainMenuView mainMenuView = new MainMenuView();
            Scene mainMenuScene = new Scene(mainMenuView, 1280, 720);
            primaryStage.setScene(mainMenuScene);
        });
    }
}