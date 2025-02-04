package be.kdg.mens_erger_je_niet.model;

public class Dobbelsteen {
    private int aantalOgen;


    public int getAantalOgen() {
        return aantalOgen;
    }

    public void gooiDobbelsteen() {
        aantalOgen = (int)(Math.random() * 6 + 1);
    }
}