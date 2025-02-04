package be.kdg.mens_erger_je_niet.model;

public class Pion {
    private int pionId;
    int huidigVeldNummer;

    public void beweegPion(int stappen) {
        huidigVeldNummer += stappen;

        if(huidigVeldNummer >= 40) { //Als de waarde 40 of groter is, moeten we deze waarde met 40 verkleinen (gaat van groen gebied 39 naar rood gebied 0)
            huidigVeldNummer -= 40;
        }
    }

    public void zetPionOpVeld(int stappen) {
        //Kijken welke kleur een pion is voor startpositie -> daarna nog de stappen bij optellen
        //Startposities: Rood = 0, Blauw = 10, Geel = 20, Groen = 30 -> Kan met switch-case?
    }
}
