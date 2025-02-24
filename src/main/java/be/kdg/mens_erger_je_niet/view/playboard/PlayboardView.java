package be.kdg.mens_erger_je_niet.view.playboard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PlayboardView extends BorderPane {
    private Button spelregels;
    private GridPane speelbord;
    private static final int SPEELBORD_SIZE = 15; // Afmetingen 15x15
    private static final int CELL_SIZE = 55;

    public PlayboardView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        // Spelregels-knop aanmaken
        spelregels = new Button("Spelregels");
        spelregels.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: green;");
        spelregels.setPadding(new Insets(10));
        BorderPane.setAlignment(spelregels, Pos.TOP_RIGHT);

        // GridPane speelbord
        speelbord = new GridPane();
        speelbord.setHgap(2);
        speelbord.setVgap(2);
        speelbord.setAlignment(Pos.CENTER);

        // Speelbord vullen met cellen
        for (int row = 0; row < SPEELBORD_SIZE; row++) {
            for (int col = 0; col < SPEELBORD_SIZE; col++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setStroke(Color.BLACK);
                cell.setFill(getCellColor(row, col));

                speelbord.add(cell, col, row);
            }
        }
    }

    private void layoutNodes() {
        this.setCenter(speelbord);  // Bord in het midden
        this.setRight(spelregels);  // Spelregels-knop rechts
        BorderPane.setAlignment(spelregels, Pos.CENTER);

    }

    public Button getSpelregels() {
        return spelregels;
    }

    public GridPane getSpeelbord() {
        return speelbord;
    }

    // Bepaalt de kleur van de vakjes
    private Color getCellColor(int rij, int kolom) {
        //Startgebieden 2x2 per kleur
        if (rij < 2 && kolom < 2) return Color.BLUE;   // Blauw Start
        if (rij < 2 && kolom >= 13) return Color.YELLOW; // Geel Start
        if (rij >= 13 && kolom < 2) return Color.RED;   // Rood Start
        if (rij >= 13 && kolom >= 13) return Color.GREEN; // Groen Start

        //Middengebied
        if (rij == 7 && kolom == 7) return Color.BLACK;

        //Gekleurde eindroutes
        if (kolom == 7 && rij < 7 && rij > 0) return Color.YELLOW; // Geel eindpad
        if (rij == 7 && kolom > 7 && kolom < 14) return Color.GREEN; // Groen eindpad
        if (kolom == 7 && rij > 7 && rij < 14) return Color.RED; // Rood eindpad
        if (rij == 7 && kolom < 7 && kolom > 0) return Color.BLUE; // Blauw eindpad

        //Looproute (Normale vakjes)
        if ((rij == 6 || rij == 8) && (kolom >= 0 && kolom < 15)) return Color.LIGHTGRAY; // Horizontale route
        if ((kolom == 6 || kolom == 8) && (rij >= 0 && rij < 15)) return Color.LIGHTGRAY; // Verticale route
        if ((rij == 7 || kolom == 7) && (rij == 0 || rij == 14 || kolom == 0 || kolom == 14)) return Color.LIGHTGRAY;


        return Color.WHITE; // Overige vakjes
    }


}
