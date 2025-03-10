package be.kdg.mens_erger_je_niet.view.loadingscreen;

import be.kdg.mens_erger_je_niet.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoadingscreenView extends BorderPane {
    private Label mensErgerJeNiet;
    private Button startButton;
    private ImageView mensErgerJeNietImage;

    public LoadingscreenView(Main mainApp) {
        initializeNodes();
        layoutNodes(mainApp);
    }

    private void initializeNodes() {
        mensErgerJeNiet = new Label("MENS-ERGER-JE-NIET");
        mensErgerJeNiet.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 80));
        mensErgerJeNiet.setTextFill(Color.BLACK);
        mensErgerJeNiet.setPadding(new Insets(10, 10, 10, 10));

        startButton = new Button("Start het spel");
        startButton.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        startButton.setTextFill(Color.WHITE);
        startButton.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5), Insets.EMPTY)));
        startButton.setPadding(new Insets(10, 20, 10, 20));

        String imageUrl = "file:src/resources/Ludo Logo.jpg";
        Image mensErgerJeNietURL = new Image(imageUrl);
        mensErgerJeNietImage = new ImageView(mensErgerJeNietURL);
        mensErgerJeNietImage.setFitWidth(300);
        mensErgerJeNietImage.setPreserveRatio(true);
    }

    private void layoutNodes(Main mainApp) {
        VBox vbox = new VBox(20, mensErgerJeNietImage, mensErgerJeNiet, startButton);
        vbox.setAlignment(Pos.CENTER);
        this.setCenter(vbox);
        };


    public Button getStartButton() {
        return startButton;
    }
}
