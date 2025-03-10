package be.kdg.mens_erger_je_niet.view.playboard;

import be.kdg.mens_erger_je_niet.Kleur;
import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.Bord;
import be.kdg.mens_erger_je_niet.model.Dobbelsteen;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import be.kdg.mens_erger_je_niet.model.Pion;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
        plaatsPionnenOpHoeken();
    }

    public void addEventHandlers() {
        view.getSpelregels().setOnAction(event -> mainApp.helpView());
        view.getRollButton().setOnAction(event -> { gooiDobbelsteen();
        });

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

        Pion geselecteerdePion = null;

        // Zoek naar een pion op dit vakje
        for (Pion pion : model.getBord().getPionnenOpBord().values()) {
            if (pion.getRij() == rij && pion.getKolom() == kolom) {
                geselecteerdePion = pion;
                break;
            }
        }

        if (geselecteerdePion != null) {
            int nieuweRij = rij + 1;
            int nieuweKolom = kolom;

            if (model.getBord().zetPionOpBord(geselecteerdePion, nieuweRij, nieuweKolom)) {
                view.plaatsPionOpBord(geselecteerdePion);
            }
        }
    }


    private void gooiDobbelsteen() {
        int worp = model.gooiDobbelsteen();
        String imagePath = "file:src/resources/Dice" + worp + ".png";
        view.getDiceImageView().setImage(new Image(imagePath));
    }




    private void plaatsPionnenOpHoeken() {
        Bord bord = model.getBord();

        Pion pion1_1 = new Pion(1, Kleur.BLAUW);
        Pion pion1_2 = new Pion(2, Kleur.BLAUW);
        Pion pion1_3 = new Pion(3, Kleur.BLAUW);
        Pion pion1_4 = new Pion(4, Kleur.BLAUW);

        Pion pion2_1 = new Pion(5, Kleur.GEEL);
        Pion pion2_2 = new Pion(6, Kleur.GEEL);
        Pion pion2_3 = new Pion(7, Kleur.GEEL);
        Pion pion2_4 = new Pion(8, Kleur.GEEL);

        Pion pion3_1 = new Pion(9, Kleur.ROOD);
        Pion pion3_2 = new Pion(10, Kleur.ROOD);
        Pion pion3_3 = new Pion(11, Kleur.ROOD);
        Pion pion3_4 = new Pion(12, Kleur.ROOD);

        Pion pion4_1 = new Pion(13, Kleur.GROEN);
        Pion pion4_2 = new Pion(14, Kleur.GROEN);
        Pion pion4_3 = new Pion(15, Kleur.GROEN);
        Pion pion4_4 = new Pion(16, Kleur.GROEN);

        bord.zetPionOpBord(pion1_1, 0, 0);
        bord.zetPionOpBord(pion1_2, 0, 1);
        bord.zetPionOpBord(pion1_3, 1, 0);
        bord.zetPionOpBord(pion1_4, 1, 1);

        bord.zetPionOpBord(pion2_1, 0, 14);
        bord.zetPionOpBord(pion2_2, 0, 13);
        bord.zetPionOpBord(pion2_3, 1, 14);
        bord.zetPionOpBord(pion2_4, 1, 13);

        bord.zetPionOpBord(pion3_1, 14, 0);
        bord.zetPionOpBord(pion3_2, 14, 1);
        bord.zetPionOpBord(pion3_3, 13, 0);
        bord.zetPionOpBord(pion3_4, 13, 1);

        bord.zetPionOpBord(pion4_1, 14, 14);
        bord.zetPionOpBord(pion4_2, 14, 13);
        bord.zetPionOpBord(pion4_3, 13, 14);
        bord.zetPionOpBord(pion4_4, 13, 13);

        view.plaatsPionOpBord(pion1_1);
        view.plaatsPionOpBord(pion1_2);
        view.plaatsPionOpBord(pion1_3);
        view.plaatsPionOpBord(pion1_4);
        view.plaatsPionOpBord(pion2_1);
        view.plaatsPionOpBord(pion2_2);
        view.plaatsPionOpBord(pion2_3);
        view.plaatsPionOpBord(pion2_4);
        view.plaatsPionOpBord(pion3_1);
        view.plaatsPionOpBord(pion3_2);
        view.plaatsPionOpBord(pion3_3);
        view.plaatsPionOpBord(pion3_4);
        view.plaatsPionOpBord(pion4_1);
        view.plaatsPionOpBord(pion4_2);
        view.plaatsPionOpBord(pion4_3);
        view.plaatsPionOpBord(pion4_4);
    }

}
