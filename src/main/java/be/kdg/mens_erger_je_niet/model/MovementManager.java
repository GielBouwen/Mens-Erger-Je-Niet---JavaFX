package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;
import be.kdg.mens_erger_je_niet.view.playboard.PlayboardView;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

import java.util.List;

public class MovementManager {
    private PlayboardView playboardView;
    private List<Pion> pionnenList;

    public MovementManager(PlayboardView playboardView, List<Pion> pionnenList) {
        this.playboardView = playboardView;
        this.pionnenList = pionnenList;
    }

    public void updatePionPosition(Pion pion) {
        int nieuweRij = pion.getRij();
        int nieuweKolom = pion.getKolom();

        // Haal de oude StackPane en verwijder de pion
        for (Node node : playboardView.getSpeelbord().getChildren()) {
            if (node instanceof StackPane stackPane) {
                if (stackPane.getChildren().size() > 1) {  // We hebben meer dan 1 element (de pion)
                    stackPane.getChildren().clear();  // Verwijder de pion uit de oude StackPane
                }
            }
        }

        // Validate the index
        if (nieuweRij < 0 || nieuweRij >= PlayboardView.SPEELBORD_SIZE || nieuweKolom < 0 || nieuweKolom >= PlayboardView.SPEELBORD_SIZE) {
            System.err.println("Invalid position: " + nieuweRij + ", " + nieuweKolom);
            return;
        }

        // Ensure the index is valid before accessing the StackPane
        StackPane nieuweCell = (StackPane) playboardView.getSpeelbord().getChildren().get(nieuweRij * PlayboardView.SPEELBORD_SIZE + nieuweKolom);

        // Maak de pion opnieuw
        Circle pionCircle = new Circle(PlayboardView.CELL_SIZE / 3);
        pionCircle.setFill(pion.getKleur() == Kleur.ROOD ? Color.RED : Color.GREEN);

        // Voeg de pion toe aan de nieuwe StackPane
        nieuweCell.getChildren().add(pionCircle);
    }

    public void placePionOnBoard(Pion pion) {
        // Plaats pion op het bord op basis van de kleur en de startpositie
        // Gebruik logic zoals beschreven in de PlayboardView
    }
}