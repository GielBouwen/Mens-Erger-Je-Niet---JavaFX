package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MensErgerJeNietControler {
    private Spel spel;
    private Dobbelsteen dobbelsteen;
    private Bord bord;
    private List<Speler> spelers;


    public MensErgerJeNietControler() {

        this.dobbelsteen = new Dobbelsteen();
        this.bord = new Bord();
        this.spelers = new ArrayList<>();
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

    /* public void load(String filename) throws MensErgerJeNietException {
     this.spel = MensErgerJeNietFileManagement.load(filename);
    }

     */
}
