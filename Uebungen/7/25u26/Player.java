

/**
 * The class Player represents a player which plays Pong
 */
public class Player {
	/**
	 * The current score of the Player
	 */
	private int score;
	
	/**
	 * The paddle used by this Player
	 */
	private Paddle paddle;
	
	/**
	 * Constructor of Player. Sets score to 0 and creates a new Paddle.
	 * @param player
	 */
	public Player(int player) {
		this.score = 0;
		this.paddle = new Paddle();
	}
	
	/**
	 * Getter for paddle
	 * 
	 * @return The Paddle used by the Player
	 */
	public Paddle getLinkPaddle() {
		return paddle;
	}
	
	/**
	 * Adds 1 to the current score
	 */
	public void increaseScore() {
		this.score++;
	}
	
	/**
	 * Getter for score
	 * 
	 * @return The current score of the Player
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Setter for Score
	 * 
	 * @param score The new Score
	 */
	public void setScore(int score) {
		this.score = score;
	}
}
