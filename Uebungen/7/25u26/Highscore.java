

import java.util.Date;

/**
 * The class Highscore represents a score of a player who has won
 */
public class Highscore implements Comparable<Highscore> {
	/**
	 * The name of the player who has achieved the score
	 */
	private String name;
	
	/**
	 * The score which the player has achieved
	 */
	private int score;
	
	/**
	 * The date this score was created
	 */
	private Date date;
	
	/**
	 * Constructor setting all attributes
	 * 
	 * @param name  The name of the player
	 * @param score The score
	 * @param date  The date this score was created
	 */
	public Highscore(String name, int score, Date date) {
		this.name = name;
		this.score = score;
		this.date = date;
	}
	
	/**
	 * Getter for name
	 * 
	 * @return The name of the player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter for score
	 * 
	 * @return The score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Getter for date
	 * 
	 * @return The date this score was created
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Compares this Highscore with the given parameter Highscore.
	 * If both have the same score, the score which was created earlier is
	 * considered to be better.
	 */
	public int compareTo(Highscore h) {
		if(h.score != score)
			return h.score - score;
		return (int)(this.date.getTime() - h.date.getTime());
	}
	
	/**
	 * Checks whether this Highscore is equal to the given parameter.
	 * Two Highscore Objects are equal if they match in all attribute values.
	 */
	public boolean equals(Object o) {
		if(! (o instanceof Highscore))
			return false;
		Highscore h = (Highscore)o;
		if(h.date != this.date)
			return false;
		if(h.name != this.name)
			return false;
		if(h.score != this.score)
			return false;
		return true;
	}
	
	/**
	 * Override of generic toString() method
	 */
	public String toString() {
		return this.score + ": " + this.name + " - " + this.date;
	}
}
