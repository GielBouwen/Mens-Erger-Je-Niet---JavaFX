package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;
import be.kdg.mens_erger_je_niet.view.new_game.NewGameView;

import java.util.ArrayList;
import java.util.List;

public class MensErgerJeNietControler {
    private Spel spel;
    private Dobbelsteen dobbelsteen;
    private Bord bord;
    private List<Speler> spelers;
    private int huidigeSpelerIndex;

    public MensErgerJeNietControler() {
        this.dobbelsteen = new Dobbelsteen();
        this.bord = new Bord();
        this.spelers = new ArrayList<>();
        this.huidigeSpelerIndex = 0;
    }




    public Speler getHuidigeSpeler() {
        if (spelers == null || spelers.isEmpty()) {
            throw new IllegalStateException("Er zijn geen spelers beschikbaar.");
        }
        return spelers.get(0);
    }

    public void volgendeSpeler() {
        huidigeSpelerIndex = (huidigeSpelerIndex + 1) % spelers.size();
    }


    public int gooiDobbelsteen() {
        dobbelsteen.werp();
        return dobbelsteen.getAantalOgen();
    }

    public Bord getBord() {
        return bord;
    }

    public List<Speler> getSpelers() {
        return spelers;
    }



    public void verplaatsPion(Pion pion, int dobbelsteenWorp, int extraPositie) {
        int huidigePositie = pion.getVeldNummer();
        int nieuwePositie = berekenNieuwePositie(pion, dobbelsteenWorp, extraPositie);
        pion.setAantalVakjesVer(pion.getAantalVakjesVer() + dobbelsteenWorp);
        bord.updatePionPosition(pion, nieuwePositie);
        System.out.println("Pion " + pion.getKleur() + " van " + pion.getEigenaar().getGebruikersnaam() + " is nu op veld " + nieuwePositie);
    }

    public int berekenNieuwePositie(Pion pion, int dobbelsteenWorp, int extraPositie) {
        int huidigePositie = pion.getVeldNummer();
        return huidigePositie + dobbelsteenWorp + extraPositie;
    }

    public void load(String filename) throws MensErgerJeNietException {
        this.spel = MensErgerJeNietFileManagement.load(filename, new NewGameView());
    }

    public void save(String filename) throws MensErgerJeNietException {
        MensErgerJeNietFileManagement.save(filename, this.spel);
    }
}