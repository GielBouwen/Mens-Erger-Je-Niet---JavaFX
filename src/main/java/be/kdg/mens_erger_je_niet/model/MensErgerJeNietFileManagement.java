package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MensErgerJeNietFileManagement {
    private MensErgerJeNietFileManagement() {
        //Deze constructor moet niet doen, het voorkomt dat er een new kan worden gemaakt.
    }

    public static void save(String filename, Spel spel) throws MensErgerJeNietException {
        try {
            DataOutputStream stream = new DataOutputStream(new FileOutputStream(filename));
            stream.writeInt(spel.getSpelerTeller());
            stream.writeInt(spel.getAantalBeurten());

            List<Speler> spelers = spel.getSpelers();
            stream.writeInt(spelers.size());
            for (Speler speler : spelers) {
                stream.writeUTF(speler.gebruikersnaam);
                stream.writeUTF(speler.getKleur().name());
                stream.writeBoolean(speler.GetIsCPU());
            }
            System.out.println("spel is succesvol opgeslagen: " + filename);
        } catch (FileNotFoundException e) {
            throw new MensErgerJeNietException("Bestand " + filename + " niet gevonden.", e);
        } catch (IOException e) {
            throw new MensErgerJeNietException("Fout bij het oplsaan van het spelbestand " + filename, e);
        }

    }

    public static Spel load(String filename) throws MensErgerJeNietException {
        try (DataInputStream stream = new DataInputStream(new FileInputStream(filename))) {
            int spelerTeller = stream.readInt();
            LocalDateTime datum = LocalDateTime.parse(stream.readUTF());
            boolean beurtBlauw = stream.readBoolean();
            boolean beurtGeel = stream.readBoolean();
            boolean beurtGroen = stream.readBoolean();
            boolean beurtRood = stream.readBoolean();
            int aantalBeurten = stream.readInt();

            Spel spel = new Spel(null);
            spel.setSpelerTeller(spelerTeller);
            spel.setAantalBeurten(aantalBeurten);

            int aantalSpelers = stream.readInt();
            List<Speler> spelers = new ArrayList<>();

            for (int i = 0; i < aantalSpelers; i++) {
                Kleur kleur = Kleur.valueOf(stream.readUTF());
                String naam = stream.readUTF();
                boolean isCPU = stream.readBoolean();

                Speler speler = new Speler(kleur, i + 1, naam);
                spelers.add(speler);
                speler.setCPU(isCPU);
            }

            spel.setSpelers(spelers);
            System.out.println("Spel is met succes geladne: " + filename);
            return spel;
        } catch (FileNotFoundException e) {
            throw new MensErgerJeNietException("Bestand " + filename + " niet gevonden.", e);
        } catch (IOException e) {
            throw new MensErgerJeNietException("Fout bij het inladen van " + filename, e);
        }
    }
}
