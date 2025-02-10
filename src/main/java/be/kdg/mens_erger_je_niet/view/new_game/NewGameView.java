package be.kdg.mens_erger_je_niet.view.new_game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class NewGameView extends BorderPane{
    private Button SpelerGroen;
    private Button SpelerGeel;
    private Button SpelerRood;
    private Button SpelerBlauw;
    private Button Cancel;
    private Button Create;

    public NewGameView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        double radius = 125;
        double textSize = 30;
        SpelerGroen = new Button("Klik om CPU te maken");
        SpelerGroen.setFont(Font.font("Arial", FontWeight.BOLD, textSize));
        SpelerGroen.setTextFill(Color.WHITE);
        SpelerGroen.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(radius), Insets.EMPTY)));
        SpelerGroen.setPadding(new Insets(10));

        SpelerGeel = new Button("Klik om CPU te maken");
        SpelerGeel.setFont(Font.font("Arial", FontWeight.BOLD, textSize));
        SpelerGeel.setTextFill(Color.WHITE);
        SpelerGeel.setBackground(new Background(new BackgroundFill(Color.GOLD, new CornerRadii(radius), Insets.EMPTY)));
        SpelerGeel.setPadding(new Insets(10));

        SpelerRood = new Button("Klik om CPU te maken");
        SpelerRood.setFont(Font.font("Arial", FontWeight.BOLD, textSize));
        SpelerRood.setTextFill(Color.WHITE);
        SpelerRood.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(radius), Insets.EMPTY)));
        SpelerRood.setPadding(new Insets(10));

        SpelerBlauw = new Button("Klik om CPU te maken");
        SpelerBlauw.setFont(Font.font("Arial", FontWeight.BOLD, textSize));
        SpelerBlauw.setTextFill(Color.WHITE);
        SpelerBlauw.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(radius), Insets.EMPTY)));
        SpelerBlauw.setPadding(new Insets(10));

        Cancel = new Button("CANCEL");
        Cancel.setFont(Font.font("Arial", FontWeight.BOLD, textSize));
        Cancel.setTextFill(Color.WHITE);
        Cancel.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(20), Insets.EMPTY)));
        Cancel.setPadding(new Insets(10));

        Create = new Button("CREATE");
        Create.setFont(Font.font("Arial", FontWeight.BOLD, textSize));
        Create.setTextFill(Color.WHITE);
        Create.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(20), Insets.EMPTY)));
        Create.setPadding(new Insets(10));
    }

    private void layoutNodes() {
        GridPane layoutGrid = new GridPane();
        layoutGrid.setHgap(50);
        layoutGrid.setVgap(50);
        layoutGrid.setAlignment(Pos.CENTER);

        GridPane gridGroen = new GridPane();
        GridPane gridGeel = new GridPane();
        GridPane gridRood = new GridPane();
        GridPane gridBlauw = new GridPane();

        gridGroen.setVgap(10);
        gridGeel.setVgap(10);
        gridRood.setVgap(10);
        gridBlauw.setVgap(10);


        TextField naamGroen = new TextField();
        TextField naamGeel = new TextField();
        TextField naamRood = new TextField();
        TextField naamBlauw = new TextField();

        gridGroen.add(naamGroen, 0, 0);
        gridGroen.add(SpelerGroen, 0, 1);
        gridGeel.add(naamGeel, 0, 0);
        gridGeel.add(SpelerGeel, 0, 1);
        gridRood.add(naamRood, 0, 0);
        gridRood.add(SpelerRood, 0, 1);
        gridBlauw.add(naamBlauw, 0, 0);
        gridBlauw.add(SpelerBlauw, 0, 1);

        layoutGrid.add(gridGroen, 0, 0);
        layoutGrid.add(gridGeel, 1, 0);
        layoutGrid.add(gridRood, 0, 1);
        layoutGrid.add(gridBlauw, 1, 1);
        layoutGrid.add(Cancel, 0, 2);
        layoutGrid.add(Create, 1, 2);

        this.setCenter(layoutGrid);
    }
}
