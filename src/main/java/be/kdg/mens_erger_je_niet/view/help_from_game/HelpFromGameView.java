package be.kdg.mens_erger_je_niet.view.help_from_game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class HelpFromGameView extends BorderPane {
    private Button btnOkeekes;

    public HelpFromGameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        this.btnOkeekes = new Button("OK");
        this.setCenter(new Label("Hier komen de spelregels"));
        this.setPadding(new Insets(10.0));
    }

    private void layoutNodes() {
        BorderPane.setAlignment(this.btnOkeekes, Pos.CENTER_RIGHT);
        BorderPane.setMargin(this.btnOkeekes, new Insets(10.0, 0.0, 0.0, 0.0));
        this.setBottom(this.btnOkeekes);
    }

    public Button getBtnOkeekes() {
        return btnOkeekes;
    }
}
