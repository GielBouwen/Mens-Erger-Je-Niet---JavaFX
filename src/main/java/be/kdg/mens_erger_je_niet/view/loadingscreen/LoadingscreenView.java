package be.kdg.mens_erger_je_niet.view.loadingscreen;

import be.kdg.mens_erger_je_niet.model.LoadingScreen;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;

public class LoadingscreenView extends BorderPane {
    private LoadingScreen model;
    private Label titleLabel;
    private Button startButton;

    public LoadingscreenView(LoadingScreen model) {
        this.model = model;
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        titleLabel = new Label("Welkom bij Mens Erger Je Niet!");
        startButton = new Button("Start het spel");
    }

    private void layoutNodes() {
        VBox vbox = new VBox(20, titleLabel, startButton);
        vbox.setAlignment(Pos.CENTER);
        this.setCenter(vbox);
    }
}

