package be.kdg.mens_erger_je_niet.view.playboard;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.Dobbelsteen;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class PlayboardPresenter {
    private final Main mainApp;
    private final PlayboardView view;
    private final MensErgerJeNietControler model;

    public PlayboardPresenter(Main mainApp, PlayboardView view, MensErgerJeNietControler model) {
        this.mainApp = mainApp;
        this.view = view;
        this.model = model;
        this.addEventHandlers();
    }

    public void addEventHandlers() {
        view.getSpelregels().setOnAction(event -> mainApp.helpView());

        view.getRollButton().setOnAction(event -> gooiDobbelsteen());

        addBoardEventHandlers();
    }

    private void addBoardEventHandlers() {
        GridPane speelbord = view.getSpeelbord();

        for (Node node : speelbord.getChildren()) {
            if (node instanceof Rectangle cell) {
                cell.setOnMouseClicked(event -> handleBoardClick(event, cell));
            }
        }
    }

    private void handleBoardClick(MouseEvent event, Rectangle cell) {
        int kolom = GridPane.getColumnIndex(cell);
        int rij = GridPane.getRowIndex(cell);

        System.out.println("Klik op vakje: (" + rij + ", " + kolom + ")");

    }

    private void gooiDobbelsteen() {
        int worp = model.gooiDobbelsteen();
        String imagePath = "file:src/resources/Dice" + worp + ".png";
        view.getDiceImageView().setImage(new Image(imagePath));
    }

}
