package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;

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
    private Map<Integer, Pion> velden = new HashMap<>();
    private Map<String, Veld> startVelden;



    private Veld[][] bord = new Veld[15][15]; //2D-array bord

    public Bord() {
        // Initialiseer alle velden
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                bord[i][j] = new Veld(i, j, i * 15 + j, null);
            }
        }

        int[][] gewoneVeldCoordinaten = {
                {8, 0}, {8, 1}, {8, 2}, {8, 3}, {8, 4}, {8, 5}, {8, 6}, {9, 6},
                {10, 6}, {11, 6}, {12, 6}, {13, 6}, {14, 6}, {14, 7}, {14, 8},
                {13, 8}, {12, 8}, {11, 8}, {10, 8}, {9, 8}, {8, 8}, {8, 9},
                {8, 10}, {8, 11}, {8, 12}, {8, 13}, {8, 14}, {7, 14}, {6, 14},
                {6, 13}, {6, 12}, {6, 11}, {6, 10}, {6, 9}, {6, 8}, {5, 8},
                {4, 8}, {3, 8}, {2, 8}, {1, 8}, {0, 8}, {0, 7}, {0, 6},
                {1, 6}, {2, 6}, {3, 6}, {4, 6}, {5, 6}, {6, 6}, {6, 5},
                {6, 4}, {6, 3}, {6, 2}, {6, 1}, {6, 0}, {7, 0}
        };

        for (int i = 0; i < gewoneVeldCoordinaten.length; i++) {
            int x = gewoneVeldCoordinaten[i][0];
            int y = gewoneVeldCoordinaten[i][1];
            gewoneVelden.add(new Veld(x, y, i, null));
        }

        startVelden.put("rood", new Veld(8, 0, 0, null));
        startVelden.put("groen", new Veld(14, 8, 14, null));
        startVelden.put("geel", new Veld(6, 14, 28, null));
        startVelden.put("blauw", new Veld(0, 6, 42, null));

        int[][] eindRood = {{7, 1}, {7, 2}, {7, 3}, {7, 4}, {7, 5}, {7, 6}};
        int[][] eindGroen = {{8, 7}, {9, 7}, {10, 7}, {11, 7}, {12, 7}, {13, 7}};
        int[][] eindGeel = {{7, 8}, {7, 9}, {7, 10}, {7, 11}, {7, 12}, {7, 13}};
        int[][] eindBlauw = {{1, 7}, {2, 7}, {3, 7}, {4, 7}, {5, 7}, {6, 7}};

        voegVeldenToe(eindVeldenRood, eindRood);
        voegVeldenToe(eindVeldenGroen, eindGroen);
        voegVeldenToe(eindVeldenGeel, eindGeel);
        voegVeldenToe(eindVeldenBlauw, eindBlauw);

        int[][] parkeerRood = {{13, 13}, {13, 14}, {14, 13}, {14, 14}};
        int[][] parkeerGroen = {{13, 13}, {13, 14}, {14, 13}, {14, 14}};
        int[][] parkeerGeel = {{0, 13}, {0, 14}, {1, 13}, {1, 14}};
        int[][] parkeerBlauw = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

        voegVeldenToe(parkeerVeldenRood, parkeerRood);
        voegVeldenToe(parkeerVeldenGroen, parkeerGroen);
        voegVeldenToe(parkeerVeldenGeel, parkeerGeel);
        voegVeldenToe(parkeerVeldenBlauw, parkeerBlauw);
    }

    private void voegVeldenToe(List<Veld> lijst, int[][] coördinaten) {
        for (int[] coord : coördinaten) {
            lijst.add(new Veld(coord[0], coord[1], lijst.size(), null));
        }
    }

    public void updatePionPosition(Pion pion, int nieuwePositie) {
        //bereken positie
        int row = nieuwePositie / 15;
        int col = nieuwePositie % 15;
        velden.remove(pion.getVeldNummer());

        bord[row][col].setPion(pion);
        //verander positi pion en voeg toe aan velden map
        pion.setAantalVakjesVer(nieuwePositie);
        velden.put(nieuwePositie, pion);
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
        for (Pion p : pionnenOpBord.values()) { //checkt of de pion op de opgegeven rij en kolom staat
            if (p.getRij() == rij && p.getKolom() == kolom) {
                return true;
            }
        }
        return false;
    }

    public Map<Integer, Pion> getPionnenOpBord() {
        return pionnenOpBord;
    }

    public void verplaatsPion(Pion pion, int dobbelsteenWorp) {
        int huidigePositie = pion.getVeldNummer();
        int nieuwePositie = berekenNieuwePositie(pion, dobbelsteenWorp);

        pion.setAantalVakjesVer(pion.getAantalVakjesVer() + dobbelsteenWorp); //verander aantal vakjes

        Pion bestaandePion = velden.get(nieuwePositie); //kijkt na of veld bezet is
        if (bestaandePion != null) {
            System.out.println("Pion " + bestaandePion.getKleur() + " van " + bestaandePion.getEigenaar().getGebruikersnaam() + " wordt geslagen!");
            bestaandePion.setAantalVakjesVer(-1); //zet geslagen pion op start
            velden.remove(nieuwePositie);
        }

        velden.remove(huidigePositie);
        pion.setAantalVakjesVer(nieuwePositie);
        velden.put(nieuwePositie, pion);

        System.out.println("Pion " + pion.getKleur() + " van " + pion.getEigenaar().getGebruikersnaam() + " staat nu op veld " + nieuwePositie);
    }


    public int berekenNieuwePositie(Pion pion, int dobbelSteenWorp) {
        int huidigePositie = pion.getVeldNummer();
        return huidigePositie + dobbelSteenWorp;
    }

    public List<Veld> getParkeerVeldenRood() {
        return parkeerVeldenRood;
    }

    public List<Veld> getParkeerVeldenGroen() {
        return parkeerVeldenGroen;
    }

    public List<Veld> getParkeerVeldenGeel() {
        return parkeerVeldenGeel;
    }

    public List<Veld> getParkeerVeldenBlauw() {
        return parkeerVeldenBlauw;
    }

    public Veld getParkeerVeldRood(int index) {
        return parkeerVeldenRood.get(index);
    }

    public Veld getParkeerVeldGroen(int index) {
        return parkeerVeldenGroen.get(index);
    }

    public Veld getParkeerVeldGeel(int index) {
        return parkeerVeldenGeel.get(index);
    }

    public Veld getParkeerVeldBlauw(int index) {
        return parkeerVeldenBlauw.get(index);
    }

    public Veld getVeld(int rij, int kolom) {
        return bord[rij][kolom];
    }

    public void plaatsPionOpStartPositie(Pion pion) {
        int startPositie = bepaalStartPositie(pion);

        pion.setVeldNummer(startPositie); //pion op startpos.

        pionnenOpBord.put(pion.getPionId(), pion); //voeg pionnen toe op bord.

        System.out.println("Pion " + pion.getKleur() + " van speler " + pion.getEigenaar().getGebruikersnaam() + " is geplaatst op startpositie: " + startPositie);
    }

    private int bepaalStartPositie(Pion pion) {
        if (pion.getKleur() == Kleur.ROOD) {
            return 1;
        } else if (pion.getKleur() == Kleur.GROEN) {
            return 10;
        } else if (pion.getKleur() == Kleur.BLAUW) {
            return 20;
        } else if (pion.getKleur() == Kleur.GEEL) {
            return 30;
        }
        return 0;
    }
}


