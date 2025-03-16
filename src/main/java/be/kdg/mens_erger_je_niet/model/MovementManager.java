package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;
import be.kdg.mens_erger_je_niet.view.playboard.PlayboardView;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

import java.util.List;

//Lijkt op een viewklasse, maar is model (beheerd logica zonder UI echte te beïnvloeden)
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

        for (Node node : playboardView.getSpeelbord().getChildren()) {
            if (node instanceof StackPane stackPane) {
                if (stackPane.getChildren().size() > 1) {
                    stackPane.getChildren().clear();  //delete  pion uit de  StackPane
                }
            }
        }

        //controle ofdat niewe positie op het bord is.
        if (nieuweRij < 0 || nieuweRij >= PlayboardView.SPEELBORD_SIZE || nieuweKolom < 0 || nieuweKolom >= PlayboardView.SPEELBORD_SIZE) {
            System.err.println("Niet valide: " + nieuweRij + ", " + nieuweKolom);
            return;
        }

        //controleer de positie v/d pion voor de StackPane wordt gebruikt
        StackPane nieuweCell = (StackPane) playboardView.getSpeelbord().getChildren().get(nieuweRij * PlayboardView.SPEELBORD_SIZE + nieuweKolom);


        Circle pionCircle = new Circle(PlayboardView.CELL_SIZE / 3);
        pionCircle.setFill(pion.getKleur() == Kleur.ROOD ? Color.RED : Color.GREEN);

        nieuweCell.getChildren().add(pionCircle); //pion naar stackpane
    }

    public void placePionOnBoard(Pion pion) {
        // Plaats pion op het bord op basis van de kleur en de startpositie
    }
}