

/**
 * The class Configuration contains all the game parameters which may be
 * modified by the user
 */
public class Configuration {
	private static Configuration unique = null;
	private String player1Name;
	private String player2Name;
	private int player1KeyUp = 'W', player1KeyDown = 'S';
	private int player2KeyUp = 'I', player2KeyDown = 'K';
	// At most one should be true at any given time
	private boolean player1Mouse, player2Mouse;
	private double initialBallSpeed = 10;
	private double ballSpeedup = 1.1;
	private int winScore = 2;
	
	/**
	 * Constructor for Configuration. Initializes both player Names.
	 */
	private Configuration() {
		player1Name = new String();
		player2Name = new String();
	}
	
	/**
	 * Implementation of singleton pattern
	 * 
	 * @return The instance of Configuration
	 */
	public static Configuration instance() {
		if(unique==null)
			unique = new Configuration();
		return unique;
	}
	
	/**
	 * Getter for player1Name
	 * 
	 * @return Name of the left Player
	 */
	public String getPlayer1Name() {
		return player1Name;
	}
	
	/**
	 * Getter for player2Name
	 * 
	 * @return Name of the right Player
	 */
	public String getPlayer2Name() {
		return player2Name;
	}
	
	/**
	 * Setter for player1Name
	 * 
	 * @param name New name of left Player. Must not be empty
	 */
	public void setPlayer1Name(String name) {
		if(!name.isEmpty())
			player1Name = name;
	}
	
	/**
	 * Setter for player2Name
	 * 
	 * @param name New name of right Player. Must not be empty
	 */
	public void setPlayer2Name(String name) {
		if(!name.isEmpty())
			player2Name = name;
	}
	
	/**
	 * Setter for both player names. Convenience method only.
	 * 
	 * @param name1 Passed to setPlayer1Name()
	 * @param name2 Passed to setPlayer2Name()
	 */
	public void setPlayerNames(String name1, String name2) {
		setPlayer1Name(name1);
		setPlayer2Name(name2);
	}
	
	/**
	 * Getter for player1KeyUp
	 * 
	 * @return keyCode used by player 1 to move upwards
	 */
	public int getPlayer1KeyUp() {
		return player1KeyUp;
	}
	
	/**
	 * Setter for player1KeyUp
	 * 
	 * @param player1KeyUp New keyCode used by player 1 to move upwards
	 */
	public void setPlayer1KeyUp(int player1KeyUp) {
		this.player1KeyUp = player1KeyUp;
	}
	
	/**
	 * Getter for player1KeyDown
	 * 
	 * @return keyCode used by player 1 to move downwards
	 */
	public int getPlayer1KeyDown() {
		return player1KeyDown;
	}
	
	/**
	 * Setter for player1KeyDown
	 * 
	 * @param player1KeyDown New keyCode used by player 1 to move downwards
	 */
	public void setPlayer1KeyDown(int player1KeyDown) {
		this.player1KeyDown = player1KeyDown;
	}
	
	/**
	 * Getter for player2KeyUp
	 * 
	 * @return keyCode used by player 2 to move upwards
	 */
	public int getPlayer2KeyUp() {
		return player2KeyUp;
	}
	
	/**
	 * Setter for player2KeyUp
	 * 
	 * @param player2KeyUp New keyCode used by player 2 to move upwards
	 */
	public void setPlayer2KeyUp(int player2KeyUp) {
		this.player2KeyUp = player2KeyUp;
	}
	
	/**
	 * Getter for player2KeyDown
	 * 
	 * @return keyCode used by player 2 to move downwards
	 */
	public int getPlayer2KeyDown() {
		return player2KeyDown;
	}
	
	/**
	 * Setter for player1KeyDown
	 * 
	 * @param player2KeyDown New keyCode used by player 2 to move downwards
	 */
	public void setPlayer2KeyDown(int player2KeyDown) {
		this.player2KeyDown = player2KeyDown;
	}
	
	/**
	 * Getter for player1Mouse
	 * 
	 * @return Whether player 1 uses mouse control
	 */
	public boolean getPlayer1Mouse() {
		return player1Mouse;
	}
	
	/**
	 * Setter for player1Mouse. Unsets player2Mouse if player1Mouse == true.
	 * 
	 * @param player1Mouse New Value for player1Mouse
	 */
	public void setPlayer1Mouse(boolean player1Mouse) {
		if(player1Mouse) {
			this.player2Mouse = false;
			this.player1Mouse = player1Mouse;
		}
	}
	
	/**
	 * Getter for player2Mouse
	 * 
	 * @return Whether player 2 uses mouse control
	 */
	public boolean getPlayer2Mouse() {
		return player2Mouse;
	}
	
	/**
	 * Setter for player2Mouse. Unsets player1Mouse if player2Mouse == true.
	 * 
	 * @param player1Mouse New Value for player1Mouse
	 */
	public void setPlayer2Mouse(boolean player2Mouse) {
		if(player2Mouse) {
			this.player1Mouse = false;
			this.player2Mouse = player2Mouse;
		}
	}
	
	/**
	 * Getter for initialBallSpeed
	 * 
	 * @return Speed the Ball has at gameStart or after one player has scored
	 */
	public double getInitialBallSpeed() {
		return initialBallSpeed;
	}
	
	/**
	 * Setter for initialBallSpeed
	 * @param initialBallSpeed New Value of initialBallSpeed
	 */
	public void setInitialBallSpeed(double initialBallSpeed) {
		this.initialBallSpeed = initialBallSpeed;
	}
	
	/**
	 * Getter for ballSpeedup
	 * 
	 * @return Factor by which the Ball gets faster every 10 seconds
	 */
	public double getBallSpeedup() {
		return ballSpeedup;
	}
	
	/**
	 * Setter for ballSpeedup
	 * 
	 * @param ballSpeedup New value for ballSpeedup
	 */
	public void setBallSpeedup(double ballSpeedup) {
		this.ballSpeedup = ballSpeedup;
	}
	
	/**
	 * Getter for winScore
	 * 
	 * @return Score needed to win the game
	 */
	public int getWinScore() {
		return winScore;
	}
	
	/**
	 * Setter for winScore
	 * 
	 * @param winScore New value for winScore
	 */
	public void setWinScore(int winScore) {
		this.winScore = winScore;
	}
	
	/**
	 * Copies the settings of c to this
	 * 
	 * @param c The configuration which is copied into this
	 */
	public void copyFrom(Configuration c) {
		setPlayer1Name(c.getPlayer1Name());
		setPlayer1Mouse(c.getPlayer1Mouse());
		setPlayer1KeyUp(c.getPlayer1KeyUp());
		setPlayer1KeyDown(c.getPlayer1KeyDown());
		setPlayer2Name(c.getPlayer2Name());
		setPlayer2Mouse(c.getPlayer2Mouse());
		setPlayer2KeyUp(c.getPlayer2KeyUp());
		setPlayer2KeyDown(c.getPlayer2KeyDown());
		setWinScore(c.getWinScore());
		setInitialBallSpeed(c.getInitialBallSpeed());
		setBallSpeedup(c.getBallSpeedup());
	}
}
