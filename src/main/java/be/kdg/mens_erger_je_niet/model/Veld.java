package be.kdg.mens_erger_je_niet.model;

public class Veld {
    int veldNummer;
    boolean isBezet = false;
    int rij;
    int kolom;

    public Veld(int kolom, int rij, int veldNummer) {
        this.kolom = kolom; //x
        this.rij = rij; //y
        this.veldNummer = veldNummer;
        isBezet = false;
    }

    public int getVeldNummer() {
        return veldNummer;
    }

    public boolean isBezet(){
        return false; //Tijdelijke code om foutmeldingen tegen te gaan
    }

    public void setBezet(boolean bezet) {
        isBezet = bezet;
    }

    public void verwijderPion(){
    }

    public void plaatsPion(){
    }

}
