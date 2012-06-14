package m05.d02;

import java.io.*;
import java.util.Arrays;

public class VierGewinnt
{
    private static boolean steckdose = false;
    private static int Hoehe,
                       Breite;
    private static char Spieler = '♂',
                        Rechner = '♀';
    private static char[][] feld;

    public static void main(String[] args)
    {
        if (args.length != 2) {
            System.out.println("Zwei Argumente, bitte!");
            System.exit(1);
        } else {
            try {
                Hoehe  = Integer.parseInt(args[0]);
                Breite = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        feld = new char[Hoehe][Breite];
        feld = initialisiereFeld(feld);

        char aktuellerSpieler = Spieler,
             naechsterSpieler = Rechner;

        while (true) {
            steckdose = false;

            gebeFeldAus(feld);
            int eingabe = leseEingabe(aktuellerSpieler);

            feld = aktualisiereFeld(feld, eingabe, aktuellerSpieler);
            if (!steckdose)
                continue;

            char tmp = aktuellerSpieler;
            aktuellerSpieler = wechsleSpieler(aktuellerSpieler, naechsterSpieler);
            naechsterSpieler = wechsleSpieler(naechsterSpieler, tmp);
        }
    }

    private static char[][] initialisiereFeld(char[][] feld)
    {
        for (char[] zeile: feld)
            Arrays.fill(zeile, ' ');

        return feld;
    }

    private static void gebeFeldAus(char[][] feld)
    {
        System.out.println();

        for (char[] zeile: feld) {
            System.out.print("┃");

            for (char zeichen: zeile)
                System.out.print(" " + zeichen + " ┃");

            System.out.println();
        }

        for (int i = 0; i < Breite * 4 + 1; i++) {
            if (i == 0)
                System.out.print("┗");
            else if (i == Breite * 4)
                System.out.print("┛");
            else if (i % 4 == 0)
                System.out.print("┻");
            else
                System.out.print("━");
        }

        System.out.println();
    }

    private static int leseEingabe(char spieler)
    {
        int eingabe = -1;
        BufferedReader leser = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("→ ");

        try {
            if (spieler == Spieler)
                eingabe = Integer.parseInt(leser.readLine());
            else {
                eingabe = (int) (Math.random() * Breite + 1);
                Thread.sleep((int) (Math.random() * 5000));
                System.out.println(eingabe);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        return eingabe;
    }

    private static char wechsleSpieler(char von, char zu)
    {
        return zu;
    }

    private static char[][] aktualisiereFeld(char[][] feld, int spalte, char spieler)
    {
        if (spalte < 1 || spalte > Breite + 1) {
            System.out.println("Bubu!");
            System.exit(1);
        }

        for (int i = Hoehe; i >= 0; i--) {
            if (i != Hoehe &&
                feld[i][spalte - 1] != Spieler &&
                feld[i][spalte - 1] != Rechner) {
                feld[i][spalte - 1] = spieler;
                steckdose = true;
                break;
            }
        }

        return feld;
    }
}
