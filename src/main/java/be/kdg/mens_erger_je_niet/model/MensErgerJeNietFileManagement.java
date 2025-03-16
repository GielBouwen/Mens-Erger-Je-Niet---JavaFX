package be.kdg.mens_erger_je_niet.model;

import be.kdg.mens_erger_je_niet.Kleur;
import be.kdg.mens_erger_je_niet.view.new_game.NewGameView;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MensErgerJeNietFileManagement {
    private MensErgerJeNietFileManagement() {
        //Deze constructor moet niets doen (er mag hier geen instantie van worden aangemaakt).
    }

    public static void save(String filename, Spel spel) throws MensErgerJeNietException {
        try {
            DataOutputStream stream = new DataOutputStream(new FileOutputStream(filename));
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

    public static Spel load(String filename, NewGameView newGameView) throws MensErgerJeNietException {
        try {
            DataInputStream stream = new DataInputStream(new FileInputStream(filename));
            int aantalBeurten = stream.readInt();
            int aantalSpelers = stream.readInt();

            List<Speler> spelers = new ArrayList<>();
            for (int i = 0; i < aantalSpelers; i++) {
                String gebruikersnaam = stream.readUTF();
                Kleur kleur = Kleur.valueOf(stream.readUTF());
                boolean isCPU = stream.readBoolean();
                spelers.add(new Speler(kleur, i + 1, gebruikersnaam, isCPU));
            }

            Spel spel = new Spel(newGameView); // Nieuwe instantie van Spel met NewGameView
            spel.setAantalBeurten(aantalBeurten);
            spel.setSpelers(spelers);

            System.out.println("Spel succesvol geladen: " + filename);
            return spel;

        } catch (FileNotFoundException e) {
            throw new MensErgerJeNietException("Bestand " + filename + " niet gevonden.", e);
        } catch (IOException e) {
            throw new MensErgerJeNietException("Fout bij het inladen van het spelbestand " + filename, e);
        }
    }


}