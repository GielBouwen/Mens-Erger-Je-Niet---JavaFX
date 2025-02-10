package be.kdg.mens_erger_je_niet.view.about;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class AboutView extends BorderPane {
    private Button GoBackButton;
    private Text AboutText;

    public AboutView() {
        initializeNodes();
        layoutNodes();
    }
    private void initializeNodes() {
        double radius = 125;
        double textSize = 30;
        GoBackButton = new Button("Ga terug");
        GoBackButton.setFont(Font.font("Arial", FontWeight.BOLD, textSize));
        GoBackButton.setTextFill(Color.WHITE);
        GoBackButton.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(radius), Insets.EMPTY)));
        GoBackButton.setPadding(new Insets(10));
    }

    private void layoutNodes() {
        /*AboutText = new Text("Dit is een lange tekst die gaat vertellen wie we zijn en wat we hier doen en ik maak deze tekst zo lang mogelijk om te zien hoe die uitgelijnd zou worden in het tekstvak en of die zou kunnen resizen of niet");
        AboutText.setFont(Font.font("Arial", 30));

        TextFlow AboutTextFlow = new TextFlow(AboutText);
        AboutTextFlow.setMaxWidth(500);
        AboutText.setWrappingWidth(500);

        GridPane tekst = new GridPane();
        tekst.getChildren().add(AboutTextFlow);

        this.setTop(AboutText);
        //this.setBottom(GoBackButton);
        //BorderPane.setAlignment(AboutText, Pos.TOP_CENTER);*/
    }
}
