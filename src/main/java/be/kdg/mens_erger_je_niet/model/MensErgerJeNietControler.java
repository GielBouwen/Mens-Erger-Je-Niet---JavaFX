package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.view.playboard.PlayboardView;

public class MensErgerJeNietControler {
    private Dobbelsteen dobbelsteen;
    private Bord bord;

    public MensErgerJeNietControler() {
        this.dobbelsteen = new Dobbelsteen();
        this.bord = new bord();
    }

    public int gooiDobbelsteen() {
        dobbelsteen.werp();
        return dobbelsteen.getAantalOgen();
    }

}
