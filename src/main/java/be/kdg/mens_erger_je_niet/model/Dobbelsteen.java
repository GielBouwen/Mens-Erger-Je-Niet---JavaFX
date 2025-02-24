package be.kdg.mens_erger_je_niet.model;

import java.util.Random;

public class Dobbelsteen {
    private int aantalOgen;
    private final Random random;

    public Dobbelsteen() {
        random = new Random();
        this.aantalOgen = 0;
    }

    public void werp() {
        this.aantalOgen = random.nextInt(6) + 1;
    }

    public int getAantalOgen() {
        return aantalOgen;
    }
}