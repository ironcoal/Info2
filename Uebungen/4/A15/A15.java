import java.util.Date;
import java.util.Iterator;

class A15 {
    public static void main(String[] args) {
        HighscoreContainer cont = HighscoreContainer.instance();
        Date d1 = new Date();
        Highscore h1 = new Highscore("Peter", 15, d1);
        d1 = new Date();
        Highscore h2 = new Highscore("Hans", 20, d1);
        d1 = new Date();
        Highscore h3 = new Highscore("Max", 13, d1);
        cont.addHighscore(h1);
        cont.addHighscore(h2);
        cont.addHighscore(h3);


        Iterator<Highscore> it = cont.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // oder, hier zum Testen mit Ausgabe der Score:
        for (Highscore h: cont) {
            System.out.println(h.getScore());
        }
        System.out.println("Hoechste Highscore: " + cont.getHighscoreAt(0).getScore());
        cont.removeHighscoreAt(0);
        
        it = cont.iterator();

        System.out.println("Hoechste Highscore nach Loeschvorgang: " + it.next().getScore());
        cont.removeAllHighscore();
        cont.getHighscoreAt(1);
    }
}
        
