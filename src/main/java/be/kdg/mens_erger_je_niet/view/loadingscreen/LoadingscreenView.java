package be.kdg.mens_erger_je_niet.view.loadingscreen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

public class LoadingscreenView extends BorderPane {
    private Label titleLabel;
    private Button startButton;

    public LoadingscreenView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        titleLabel = new Label("Mens-Erger-Je-Niet");
        titleLabel.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 50));
        titleLabel.setTextFill(Color.DARKGOLDENROD);


        startButton = new Button("Start het spel");
        startButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        startButton.setTextFill(Color.WHITE); // Stel de tekstkleur in
        startButton.setBackground(new Background(new BackgroundFill(Color.GOLD, new CornerRadii(5), Insets.EMPTY))); // Stel de achtergrondkleur en hoeken in
        startButton.setPadding(new Insets(10, 20, 10, 20)); // Stel de padding in

    }

    private void layoutNodes() {
        VBox vbox = new VBox(20, titleLabel, startButton);
        vbox.setAlignment(Pos.CENTER);
        this.setCenter(vbox);
    }
}