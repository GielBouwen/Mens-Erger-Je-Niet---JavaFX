package be.kdg.mens_erger_je_niet.view.help;

import be.kdg.mens_erger_je_niet.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class HelpView extends BorderPane {
    private Label titleLabel;
    private TextFlow aboutTextFlow;
    private Button GoBackButton;
    private boolean komtVanMainMenu = false;


    public HelpView(Main mainApp) {
        initializeNodes();
        layoutNodes(mainApp);
    }

    private void initializeNodes() {
        titleLabel = new Label("HELP");
        titleLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));

        GoBackButton = new Button("Ga terug");
        GoBackButton.setFont(Font.font("Tohoma", FontWeight.NORMAL, 30));
        GoBackButton.setTextFill(Color.WHITE);
        GoBackButton.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(125), Insets.EMPTY)));
        GoBackButton.setPadding(new Insets(20));

        Text AboutText = new Text("Spelregels komen hier");
        AboutText.setFont(Font.font("Arial", 30));

        aboutTextFlow = new TextFlow(AboutText);
        aboutTextFlow.setMaxWidth(Double.MAX_VALUE);
        aboutTextFlow.setPadding(new Insets(10));
    }

    private void layoutNodes(Main mainApp) {
        VBox title = new VBox(10, titleLabel);
        title.setPadding(new Insets(10));
        title.setAlignment(Pos.TOP_CENTER);

        VBox content = new VBox(10, aboutTextFlow);
        content.setPadding(new Insets(10));
        content.setAlignment(Pos.CENTER);

        VBox goBackButton = new VBox(10, GoBackButton);
        goBackButton.setPadding(new Insets(10));
        goBackButton.setAlignment(Pos.CENTER);


        this.setTop(title);
        this.setCenter(content);
        this.setBottom(goBackButton);

        GoBackButton.setOnAction(event -> mainApp.showMainMenu());
        //Boolean gebruiken om te bepalen of je terug gaat naar spel of naar mainmenu, bijv "komtVanMainmenu"
    }
}