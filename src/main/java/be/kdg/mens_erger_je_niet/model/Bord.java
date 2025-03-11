package be.kdg.mens_erger_je_niet.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bord {
    private List<Veld> gewoneVelden = new ArrayList<>();
    private List<Veld> eindVeldenRood = new ArrayList<>();
    private List<Veld> eindVeldenGroen = new ArrayList<>();
    private List<Veld> eindVeldenGeel = new ArrayList<>();
    private List<Veld> eindVeldenBlauw = new ArrayList<>();
    private List<Veld> parkeerVeldenRood = new ArrayList<>();
    private List<Veld> parkeerVeldenGroen = new ArrayList<>();
    private List<Veld> parkeerVeldenGeel = new ArrayList<>();
    private List<Veld> parkeerVeldenBlauw = new ArrayList<>();
    private Map<Integer, Pion> pionnenOpBord = new HashMap<>();



    public Bord() {
            // Initialiseer gewone velden
        gewoneVelden.add(new Veld(8, 0, 0, null)); //Beginvakje Rood
        gewoneVelden.add(new Veld(8, 1, 1, null));
        gewoneVelden.add(new Veld(8, 2, 2, null));
        gewoneVelden.add(new Veld(8, 3, 3, null));
        gewoneVelden.add(new Veld(8, 4, 4, null));
        gewoneVelden.add(new Veld(8, 5, 5, null));
        gewoneVelden.add(new Veld(8, 6, 6, null));
        gewoneVelden.add(new Veld(9, 6, 7, null));
        gewoneVelden.add(new Veld(10, 6, 8, null));
        gewoneVelden.add(new Veld(11, 6, 9, null));
        gewoneVelden.add(new Veld(12, 6, 10, null));
        gewoneVelden.add(new Veld(13, 6, 11, null));
        gewoneVelden.add(new Veld(14, 6, 12, null));
        gewoneVelden.add(new Veld(14, 7, 13, null));
        gewoneVelden.add(new Veld(14, 8, 14, null)); //Beginvakje Groen
        gewoneVelden.add(new Veld(13, 8, 15, null));
        gewoneVelden.add(new Veld(12, 8, 16, null));
        gewoneVelden.add(new Veld(11, 8, 17, null));
        gewoneVelden.add(new Veld(10, 8, 18, null));
        gewoneVelden.add(new Veld(9, 8, 19, null));
        gewoneVelden.add(new Veld(8, 8, 20, null));
        gewoneVelden.add(new Veld(8, 9, 21, null));
        gewoneVelden.add(new Veld(8, 10, 22, null));
        gewoneVelden.add(new Veld(8, 11, 23, null));
        gewoneVelden.add(new Veld(8, 12, 24, null));
        gewoneVelden.add(new Veld(8, 13, 25, null));
        gewoneVelden.add(new Veld(8, 14, 26, null));
        gewoneVelden.add(new Veld(7, 14, 27, null));
        gewoneVelden.add(new Veld(6, 14, 28, null)); //Beginvakje Geel
        gewoneVelden.add(new Veld(6, 13, 29, null));
        gewoneVelden.add(new Veld(6, 12, 30, null));
        gewoneVelden.add(new Veld(6, 11, 31, null));
        gewoneVelden.add(new Veld(6, 10, 32, null));
        gewoneVelden.add(new Veld(6, 9, 33, null));
        gewoneVelden.add(new Veld(6, 8, 34, null));
        gewoneVelden.add(new Veld(5, 8, 35, null));
        gewoneVelden.add(new Veld(4, 8, 36, null));
        gewoneVelden.add(new Veld(3, 8, 37, null));
        gewoneVelden.add(new Veld(2, 8, 38, null));
        gewoneVelden.add(new Veld(1, 8, 39, null));
        gewoneVelden.add(new Veld(0, 8, 40, null));
        gewoneVelden.add(new Veld(0, 7, 41, null));
        gewoneVelden.add(new Veld(0, 6, 42, null)); //Beginvakje Blauw
        gewoneVelden.add(new Veld(1, 6, 43, null));
        gewoneVelden.add(new Veld(2, 6, 44, null));
        gewoneVelden.add(new Veld(3, 6, 45, null));
        gewoneVelden.add(new Veld(4, 6, 46, null));
        gewoneVelden.add(new Veld(5, 6, 47, null));
        gewoneVelden.add(new Veld(6, 6, 48, null));
        gewoneVelden.add(new Veld(6, 5, 49, null));
        gewoneVelden.add(new Veld(6, 4, 50, null));
        gewoneVelden.add(new Veld(6, 3, 51, null));
        gewoneVelden.add(new Veld(6, 2, 52, null));
        gewoneVelden.add(new Veld(6, 1, 53, null));
        gewoneVelden.add(new Veld(6, 0, 54, null));
        gewoneVelden.add(new Veld(7, 0, 55, null));

            // Initialiseer eindvelden
        //KLAAR
        eindVeldenRood.add(new Veld(7, 1, 56, null));
        eindVeldenRood.add(new Veld(7, 2, 57, null));
        eindVeldenRood.add(new Veld(7, 3, 58, null));
        eindVeldenRood.add(new Veld(7, 4, 59, null));
        eindVeldenRood.add(new Veld(7, 5, 60, null));
        eindVeldenRood.add(new Veld(7, 6, 61, null));

        //KLAAR
        eindVeldenGroen.add(new Veld(8, 7, 62, null));
        eindVeldenGroen.add(new Veld(9, 7, 63, null));
        eindVeldenGroen.add(new Veld(10, 7, 64, null));
        eindVeldenGroen.add(new Veld(11, 7, 65, null));
        eindVeldenGroen.add(new Veld(12, 7, 66, null));
        eindVeldenGroen.add(new Veld(13, 7, 67, null));


        //inProgress
        eindVeldenGeel.add(new Veld(7, 8, 68, null));
        eindVeldenGeel.add(new Veld(7, 9, 69, null));
        eindVeldenGeel.add(new Veld(7, 10, 70, null));
        eindVeldenGeel.add(new Veld(7, 11, 71, null));
        eindVeldenGeel.add(new Veld(7, 12, 72, null));
        eindVeldenGeel.add(new Veld(7, 13, 73, null));

        eindVeldenBlauw.add(new Veld(1, 7, 74, null));
        eindVeldenBlauw.add(new Veld(2, 7, 75, null));
        eindVeldenBlauw.add(new Veld(3, 7, 76, null));
        eindVeldenBlauw.add(new Veld(4, 7, 77, null));
        eindVeldenBlauw.add(new Veld(5, 7, 78, null));
        eindVeldenBlauw.add(new Veld(6, 7, 79, null));



        // Initialiseer parkeervelden
        parkeerVeldenRood.add(new Veld(13, 13, 80, null));
        parkeerVeldenRood.add(new Veld(13, 14, 81, null));
        parkeerVeldenRood.add(new Veld(14, 13, 82, null));
        parkeerVeldenRood.add(new Veld(14, 14, 83, null));

        parkeerVeldenGroen.add(new Veld(13, 13, 84, null));
        parkeerVeldenGroen.add(new Veld(13, 14, 85, null));
        parkeerVeldenGroen.add(new Veld(14, 13, 86, null));
        parkeerVeldenGroen.add(new Veld(14, 14, 87, null));

        parkeerVeldenGeel.add(new Veld(0, 13, 88, null));
        parkeerVeldenGeel.add(new Veld(0, 14, 89, null));
        parkeerVeldenGeel.add(new Veld(1, 13, 90, null));
        parkeerVeldenGeel.add(new Veld(1, 14, 91, null));

        parkeerVeldenBlauw.add(new Veld(0, 0, 92, null));
        parkeerVeldenBlauw.add(new Veld(0, 1, 93, null));
        parkeerVeldenBlauw.add(new Veld(1, 0, 94, null));
        parkeerVeldenBlauw.add(new Veld(1, 1, 95, null));

    }


    public boolean zetPionOpBord(Pion pion, int rij, int kolom) {
        if (isBezet(rij, kolom)) {
            System.out.println("Deze plek is bezet");
            return false;
        }
        pion.plaatsOpStartpositie(rij, kolom);
        pionnenOpBord.put(pion.getPionId(), pion);
        return true;
    }

    private boolean isBezet(int rij, int kolom) {
        for (Pion p : pionnenOpBord.values()) { // checkt of de pion op de opgegeven rij en kolom staat
            if (p.getRij() == rij && p.getKolom() == kolom) {
                return true;
            }
        }
        return false;
    }

    public Map<Integer, Pion> getPionnenOpBord() {
        return pionnenOpBord;
    }

    public Pion getPionOpVeld(int positie){
        return velden.get(positie);
    }

    public void verplaatsPion(Pion pion, int dobbelsteenWorp){
        int huidigePositie = pion.getVeldNummer();
        int nieuwePositie = berekenNieuwePositie(pion, dobbelsteenWorp);

        pion.setAantalVakjesVer(pion.getAantalVakjesVer()+dobbelsteenWorp); //Verandert het aantalvakjesver van de pion. Wordt gebruikt om einde te kunnen controleren

        Pion bestaandePion = velden.get(nieuwePositie); //Haalt de pion die al staat op de locatie waar de huidige pion naartoe gaat
        if(bestaandePion != null){ //Als de nieuwe positie bezet is, wordt er geslagen
            System.out.println("Pion" + bestaandePion.getKleur() + " van " + bestaandePion.getEigenaar().getGebruikersnaam() + " wordt geslagen!");
            bestaandePion.setAantalVakjesVer(-1); //Zet geslagen pion naar start
            velden.remove(nieuwePositie); //Haalt pion weg uit de hashmap
        }

        velden.remove(huidigePositie); //Haalt pion weg van de huidige positie
        pion.setAantalVakjesVer(nieuwePositie); //Verplaatst de pion naar de nieuwe positie
        velden.put(nieuwePositie, pion); //Plaatst de pion terug in de map met de nieuwe positie

        System.out.println("Pion " + pion.getKleur() + " van " +pion.getEigenaar().getGebruikersnaam() + " staat nu op veld " + nieuwePositie);
    }
    public int berekenNieuwePositie(Pion pion, int dobbelSteenWorp){
        int huidigePositie = pion.getVeldNummer();

        return huidigePositie + dobbelSteenWorp;
    }
}


