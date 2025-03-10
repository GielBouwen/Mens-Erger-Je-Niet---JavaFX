package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;

import java.util.ArrayList;
import java.util.List;

public class MensErgerJeNietControler {
    private Dobbelsteen dobbelsteen;
    private Bord bord;
    private List<Speler> spelers;


    public MensErgerJeNietControler() {
        this.dobbelsteen = new Dobbelsteen();
        this.bord = new Bord();
        this.spelers = new ArrayList<>();
        // Voeg bijvoorbeeld enkele spelers toe
        this.spelers.add(new Speler(Kleur.BLAUW, 1, "Speler1"));
        this.spelers.add(new Speler(Kleur.GEEL, 2, "Speler2"));
        this.spelers.add(new Speler(Kleur.ROOD, 3, "Speler3"));
        this.spelers.add(new Speler(Kleur.GROEN, 4, "Speler4"));
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
}
