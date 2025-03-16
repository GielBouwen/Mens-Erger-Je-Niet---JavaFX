package be.kdg.mens_erger_je_niet.model;

public class Veld {
    int veldNummer;
    Pion pionAlInVeld;
    int rij;
    int kolom;

    public Veld(int kolom, int rij, int veldNummer, Pion pionAlInVeld) {
        this.kolom = kolom; //x
        this.rij = rij; //y
        this.veldNummer = veldNummer;
        this.pionAlInVeld = pionAlInVeld;
    }

    public int getVeldNummer() {
        return veldNummer;
    }

    public void setVeldNummer(int veldNummer) {
        this.veldNummer = veldNummer;
    }

    public Pion getPionAlInVeld() {
        return pionAlInVeld;
    }

    public void setPionAlInVeld(Pion pionAlInVeld) {
        this.pionAlInVeld = pionAlInVeld;
    }

    public int getRij() {
        return rij;
    }

    public void setRij(int rij) {
        this.rij = rij;
    }

    public int getKolom() {
        return kolom;
    }

    public void setKolom(int kolom) {
        this.kolom = kolom;
    }

    public void setPion(Pion pion) {
    }
}