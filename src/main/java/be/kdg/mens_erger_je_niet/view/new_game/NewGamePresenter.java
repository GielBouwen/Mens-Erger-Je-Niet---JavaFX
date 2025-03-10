package be.kdg.mens_erger_je_niet.view.new_game;

import be.kdg.mens_erger_je_niet.Main;
import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;

public class NewGamePresenter {
    private NewGameView view;
    private Main mainApp;
    private MensErgerJeNietControler model;

    public NewGamePresenter(NewGameView view, Main mainApp, MensErgerJeNietControler model) {
        this.mainApp = mainApp;
        this.view = view;
        this.model = model;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getCancelButton().setOnAction(event -> {
            mainApp.showMainMenu();
        });
        view.getCreateButton().setOnAction(event -> {
            mainApp.showPlayboardView();
        });
        view.getCheckBoxGroen().setOnAction(event -> {
            if(view.getCheckBoxGroen().isSelected()) {
                System.out.println("Groen is een CPU");
            } else{
                System.out.println("Groen is een Speler");
            }
        });
        view.getCheckBoxGeel().setOnAction(event -> {
            if(view.getCheckBoxGeel().isSelected()) {
                System.out.println("Geel is een CPU");
            } else{
                System.out.println("Geel is een Speler");
            }
        });
        view.getCheckBoxRood().setOnAction(event -> {
            if(view.getCheckBoxRood().isSelected()) {
                System.out.println("Rood is een CPU");
            } else{
                System.out.println("Rood is een Speler");
            }
        });
        view.getCheckBoxBlauw().setOnAction(event -> {
            if(view.getCheckBoxBlauw().isSelected()) {
                System.out.println("Blauw is een CPU");
            } else{
                System.out.println("Blauw is een Speler");
            }
        });
    }
}
