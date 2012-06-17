

import java.util.Iterator;
import java.util.TreeSet;

/**
 * The class HighscoreContainer represents an ordered list of Highscores.
 */
public class HighscoreContainer implements Iterable<Highscore>{
	/**
	 * The actual container in wich the Highscores are held
	 */
	private TreeSet<Highscore> scores;
	
	/**
	 * singleton pattern instance variable
	 */
	private static HighscoreContainer unique;
	
	/**
	 * Constructor of HighscoreContainer initializes the scores container.
	 */
	private HighscoreContainer() {
		scores = new TreeSet<Highscore>();
	}
	
	/**
	 * Implementation of singleton pattern
	 * 
	 * @return The instance of HighscoreContainer
	 */
	public static HighscoreContainer instance() {
		if(unique == null)
			unique = new HighscoreContainer();
		return unique;
	}
	
	/**
	 * Provides an iterator to iterate over all Highscores
	 */
	public Iterator<Highscore> iterator() {
		return scores.iterator();
	}
	
	/**
	 * Inserts a new Highscore in the container
	 * 
	 * @param s The Highscore to be inserted
	 */
	public void insertHighscore(Highscore s) {
		scores.add(s);
	}
	
	/**
	 * Deletes all Highscores from the Container
	 */
	public void clear() {
		scores.clear();
	}
}
