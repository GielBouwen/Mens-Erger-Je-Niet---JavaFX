package be.kdg.mens_erger_je_niet.view.loadingscreen;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;

public class LoadingscreenView extends BorderPane {
    private Label titleLabel;
    private Button startButton;

    public LoadingscreenView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        titleLabel = new Label("Mens erger je niet");
        startButton = new Button("Start het spel");
    }

    private void layoutNodes() {
        VBox vbox = new VBox(20, titleLabel, startButton);
        vbox.setAlignment(Pos.CENTER);
        this.setCenter(vbox);
    }
}