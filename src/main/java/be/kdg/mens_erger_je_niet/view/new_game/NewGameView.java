package be.kdg.mens_erger_je_niet.view.new_game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.CheckBox;

public class NewGameView extends BorderPane{
    private Button cancelButton, createButton;
    private CheckBox checkBoxGroen, checkBoxGeel, checkBoxRood, checkBoxBlauw;
    private GridPane layoutGrid, gridGroen, gridGeel, gridRood, gridBlauw;
    private Label naamLabelGroen, naamLabelGeel, naamLabelRood, naamLabelBlauw, newGameTitel;
    private TextField vulNaamGroenIn, vulNaamGeelIn, vulNaamRoodIn, vulNaamBlauwIn;
    private VBox titel;

    public NewGameView() {
        initializeNodes();
        layoutNodes();
        this.setPrefSize(1280, 800);

    }

    private void initializeNodes() {

        //Titel
        newGameTitel = new Label("Maak nieuw spel aan");
        newGameTitel.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        titel = new VBox(10, newGameTitel);

        //Inhoud sub-grid Groen
        naamLabelGroen = new Label("Naam: ");
        naamLabelGroen.setTextFill(Color.WHITE);
        naamLabelGroen.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        vulNaamGroenIn = new TextField();
        checkBoxGroen = new CheckBox("Vink aan om CPU te maken");
        checkBoxGroen.setTextFill(Color.WHITE);
        checkBoxGroen.setFont(Font.font("Arial", FontWeight.NORMAL, 15));

        //Inhoud sub-grid Geel
        naamLabelGeel = new Label("Naam: ");
        naamLabelGeel.setTextFill(Color.WHITE);
        naamLabelGeel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        vulNaamGeelIn = new TextField();
        checkBoxGeel = new CheckBox("Vink aan om CPU te maken");
        checkBoxGeel.setTextFill(Color.WHITE);
        checkBoxGeel.setFont(Font.font("Arial", FontWeight.NORMAL, 15));

        //Inhoud sub-grid Rood
        naamLabelRood = new Label("Naam: ");
        naamLabelRood.setTextFill(Color.WHITE);
        naamLabelRood.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        vulNaamRoodIn = new TextField();
        checkBoxRood = new CheckBox("Vink aan om CPU te maken");
        checkBoxRood.setTextFill(Color.WHITE);
        checkBoxRood.setFont(Font.font("Arial", FontWeight.NORMAL, 15));

        //Inhoud sub-grid Blauw
        naamLabelBlauw = new Label("Naam: ");
        naamLabelBlauw.setTextFill(Color.WHITE);
        naamLabelBlauw.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        vulNaamBlauwIn = new TextField();
        checkBoxBlauw = new CheckBox("Vink aan om CPU te maken");
        checkBoxBlauw.setTextFill(Color.WHITE);
        checkBoxBlauw.setFont(Font.font("Arial", FontWeight.NORMAL, 15));

        //Main grid
        layoutGrid = new GridPane();

        //Sub-grids
        gridGroen = new GridPane(200,100);
        gridGroen.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(0), Insets.EMPTY)));
        gridGeel = new GridPane(200,100);
        gridGeel.setBackground(new Background(new BackgroundFill(Color.GOLD, new CornerRadii(0), Insets.EMPTY)));
        gridRood = new GridPane(200,100);
        gridRood.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(0), Insets.EMPTY)));
        gridBlauw = new GridPane(200,100);
        gridBlauw.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, new CornerRadii(0), Insets.EMPTY)));

        cancelButton = new Button("CANCEL");
        cancelButton.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        cancelButton.setTextFill(Color.WHITE);
        cancelButton.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(20), Insets.EMPTY)));
        cancelButton.setPadding(new Insets(10));

        createButton = new Button("CREATE");
        createButton.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        createButton.setTextFill(Color.WHITE);
        createButton.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(20), Insets.EMPTY)));
        createButton.setPadding(new Insets(10));


    }

    private void layoutNodes() {
        layoutGrid.setHgap(50);
        layoutGrid.setVgap(50);
        layoutGrid.setAlignment(Pos.CENTER);

        titel.setPadding(new Insets(10));
        titel.setAlignment(Pos.TOP_CENTER);

        gridGroen.setVgap(5);
        gridGeel.setVgap(5);
        gridRood.setVgap(5);
        gridBlauw.setVgap(5);

        //Voeg elementen toe aan sub-grid Groen
        gridGroen.add(naamLabelGroen, 0, 0);
        gridGroen.add(vulNaamGroenIn, 0, 1);
        gridGroen.add(checkBoxGroen, 0, 2);
        //Voeg elementen toe aan sub-grid Geel
        gridGeel.add(naamLabelGeel, 0, 0);
        gridGeel.add(vulNaamGeelIn, 0, 1);
        gridGeel.add(checkBoxGeel, 0, 2);
        //Voeg elementen toe aan sub-grid Rood
        gridRood.add(naamLabelRood, 0, 0);
        gridRood.add(vulNaamRoodIn, 0, 1);
        gridRood.add(checkBoxRood, 0, 2);
        //Voeg elementen toe aan sub-grid Blauw
        gridBlauw.add(naamLabelBlauw, 0, 0);
        gridBlauw.add(vulNaamBlauwIn, 0, 1);
        gridBlauw.add(checkBoxBlauw, 0, 2);

        //Voeg sub-grids, cancel en create toe aan main-grid
        layoutGrid.add(gridGroen, 0, 0);
        layoutGrid.add(gridGeel, 1, 0);
        layoutGrid.add(gridRood, 0, 1);
        layoutGrid.add(gridBlauw, 1, 1);
        layoutGrid.add(cancelButton, 0, 2);
        layoutGrid.add(createButton, 1, 2);

        //Zet titel bovenaan en layout-grid in het midden
        this.setTop(titel);
        this.setCenter(layoutGrid);
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public Button getCreateButton() {
        return createButton;
    }

    public TextField getVulNaamGroenIn() {
        return vulNaamGroenIn;
    }

    public TextField getVulNaamGeelIn() {
        return vulNaamGeelIn;
    }

    public TextField getVulNaamRoodIn() {
        return vulNaamRoodIn;
    }

    public TextField getVulNaamBlauwIn() {
        return vulNaamBlauwIn;
    }

    public CheckBox getCheckBoxGroen() {
        return checkBoxGroen;
    }

    public CheckBox getCheckBoxGeel() {
        return checkBoxGeel;
    }

    public CheckBox getCheckBoxRood() {
        return checkBoxRood;
    }

    public CheckBox getCheckBoxBlauw() {
        return checkBoxBlauw;
    }
}
