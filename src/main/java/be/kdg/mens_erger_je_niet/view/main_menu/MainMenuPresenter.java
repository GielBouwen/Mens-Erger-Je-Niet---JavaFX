package be.kdg.mens_erger_je_niet.view.main_menu;

import be.kdg.mens_erger_je_niet.model.MensErgerJeNietControler;
import be.kdg.mens_erger_je_niet.view.about.AboutPresenter;
import be.kdg.mens_erger_je_niet.view.about.AboutView;
import be.kdg.mens_erger_je_niet.view.help.HelpPresenter;
import be.kdg.mens_erger_je_niet.view.help.HelpView;
import be.kdg.mens_erger_je_niet.view.load_game.LoadGamePresenter;
import be.kdg.mens_erger_je_niet.view.load_game.LoadGameView;

import be.kdg.mens_erger_je_niet.view.new_game.NewGamePresenter;
import be.kdg.mens_erger_je_niet.view.new_game.NewGameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainMenuPresenter {
    private MensErgerJeNietControler model;
    private MainMenuView view;


    public MainMenuPresenter(MensErgerJeNietControler model, MainMenuView view) {
        this.view = view;
        this.model = model;
        addEventHandlers();
    }

    private void addEventHandlers() {
        //Nieuw spel
        view.getNewGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                NewGameView newGameView = new NewGameView();
                NewGamePresenter newGamePresenter = new NewGamePresenter(model, newGameView);
                view.getScene().setRoot(newGameView);
                newGameView.getScene().getWindow().sizeToScene();
            }
        });

        //Bestaande Game Inladen
        view.getLoadGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                LoadGameView loadGameView = new LoadGameView();
                LoadGamePresenter loadGamePresenter = new LoadGamePresenter(model, loadGameView);
                view.getScene().setRoot(loadGameView);
                loadGameView.getScene().getWindow().sizeToScene();
            }
        });

        //help
        view.getHelp().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HelpView helpView = new HelpView();
                HelpPresenter helpPresenter = new HelpPresenter(model, helpView);
                view.getScene().setRoot(helpView);
                helpView.getScene().getWindow().sizeToScene();
            }
        });

        //over
        view.getAbout().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AboutView aboutView = new AboutView();
                AboutPresenter aboutPresenter = new AboutPresenter(model, aboutView);
                view.getScene().setRoot(aboutView);
                aboutView.getScene().getWindow().sizeToScene();
            }
        });

    }
}
