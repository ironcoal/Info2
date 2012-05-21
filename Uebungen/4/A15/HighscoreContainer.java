import java.util.Iterator;
import java.util.Vector;

public class HighscoreContainer implements Iterable<Highscore> {

	private Vector<Highscore> highscore_liste;
	private static HighscoreContainer unique;
	  
	private HighscoreContainer() {
		highscore_liste = new Vector<Highscore>();
	}
	  
	public static HighscoreContainer instance() {
		if (unique == null)
            unique = new HighscoreContainer();
		return unique;
    }
	  
    /* Fuegt den neuen Highscore so in den Vektor ein, dass die Highscores der Groesse nach
     * geordnet sind, angefangen mit dem Hoechsten */
	public void addHighscore(Highscore h) {
		int size = highscore_liste.size();
		boolean found = false;
        if (size == 0)
            highscore_liste.add(0, h);
        else {
            for (int i = 0; i < size; i++) {
                if (highscore_liste.elementAt(i).getScore() < h.getScore()) {
                    highscore_liste.add(i, h);
                    found = true;
                	break;
                }
            }
            if (!found)
            	highscore_liste.add(size, h);
        } 
	}	
	  
	public void removeAllHighscore() {
        highscore_liste.removeAll(highscore_liste);
    }
	  
	public Highscore getHighscoreAt(int i) {
		try {
            return highscore_liste.elementAt(i);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Index nicht vorhanden!");
            return null;
        }
	}
	
	public void removeHighscoreAt(int i) {
		if (i >= 0 && highscore_liste.size() > i)
			highscore_liste.removeElementAt(i);
		else
			System.out.println("Element nicht vorhanden!");
	}

	public Iterator<Highscore> iterator() {
		return highscore_liste.iterator();
	} 

}