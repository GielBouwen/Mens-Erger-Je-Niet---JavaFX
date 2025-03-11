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
        return this.isBezet;
    }

    public void setBezet(boolean bezet) {
        this.isBezet = bezet;
    }

}
