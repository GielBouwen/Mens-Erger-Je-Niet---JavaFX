package be.kdg.mens_erger_je_niet.model;

    public class Bord {

        Thuisveld[] thuisveldenRood = new Thuisveld[4];
        Thuisveld[] thuisveldenBlauw = new Thuisveld[4];
        Thuisveld[] thuisveldenGeel = new Thuisveld[4];
        Thuisveld[] thuisveldenGroen = new Thuisveld[4]; //Misschien nog aanpassen naar gewoon Veld

        Veld[] speelVelden = new Veld[40];
        //Rood gebied = Veld 0 tem 9 (starten met 0)
        //Blauw gebied = Veld 10 tem 19 (starten met 1)
        //Geel gebied = Veld 20 tem 29 (starten met 2
        //Groen gebied = Veld 30 tem 39 (starten met 3)

        Veld[] eindVeldenRood = new Veld[4];
        Veld[] eindVeldenBlauw = new Veld[4];
        Veld[] eindVeldenGeel = new Veld[4];
        Veld[] eindVeldenGroen = new Veld[4];
    }