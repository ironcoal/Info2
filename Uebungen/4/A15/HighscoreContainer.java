import java.util.Iterator;
import java.util.Vector;

public class HighscoreContainer implements Iterable<Highscore> {

	private Vector<Highscore> highscore_liste;
	private static HighscoreContainer unique;
	private int anzahl = 0;
	  
	private HighscoreContainer() {
		highscore_liste = new Vector<Highscore>();
	}
	  
	public static HighscoreContainer instance() {
		if (unique == null)
            unique = new HighscoreContainer();
		return unique;
    }
	  
    /* Fuegt den neuen Highscore so in den Vektor ein, dass die Highscores der Groesse nach
     * geordnet sind, angefangen mit dem hoechsten */
	public void addHighscore(Highscore h) {
        if (!highscore_liste.contains(0))
            highscore_liste.addElement(0)
        else {
            for (int i = 0; i < highscore_liste.size(); i++) {
                if (highscore_liste.ElementAt(i).getScore() < h.getScore())
                    highscore_liste.addElement(i, h);
            } 
	}	
	  
	public void removeAllHighscore(Highscore h) {
        highscore_liste.removeAll(highscore_liste);
        anzahl = 0;
    }
	  
	public Highscore getHighscore(int i) {
		return highscore_liste.elementAt(i);
	}

    /*
	public Iterator<Higscore> iterator() {
		return highscore_liste.iterator();
	} */

}