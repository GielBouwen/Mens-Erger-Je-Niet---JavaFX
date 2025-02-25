package be.kdg.mens_erger_je_niet.model;

public class MensErgerJeNietControler {
    private final Dobbelsteen dobbelsteen;

    public MensErgerJeNietControler() {
        this.dobbelsteen = new Dobbelsteen();
    }

    public int gooiDobbelsteen() {
        dobbelsteen.werp();
        return dobbelsteen.getAantalOgen();
    }
}
