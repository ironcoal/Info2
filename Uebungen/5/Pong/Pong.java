

import java.util.Date;

/**
 * The main class which controls the game.
 */
public class Pong {
    /**
     * The Ball and players participating in the game
     */
    private Ball ball;
    private Player[] players;
    
    /**
     * Whether the game is currently running
     */
    private boolean gameRunning;

    /**
     * Constructor for Pong.
     * Initializes the Players and the Ball.
     */
    public Pong() {
        gameRunning = false;
        
        this.players = new Player[2];
        this.players[0] = new Player(0);
        this.players[1] = new Player(1);
        this.ball = new Ball(this);
    }

    /**
     * Starts the game.
     * If already running the game is aborted prior to being started.
     */
    public void gameStart() {
        if(gameRunning)
            gameAbort();
        this.players[0].setScore(0);
        this.players[1].setScore(0);
        ball.startMovement(2 * Math.random());
        gameRunning = true;
    }

    /**
     * Aborts the currently running game.
     */
    public void gameAbort() {
        ball.stopMovement();
        gameRunning = false;
    }

    /**
     * Gets called when the game is about to quit
     */
    public void gameExit() {
    }
    
    /**
     * Getter for gameRunning
     * 
     * @return Whether the game is currently running
     */
    public boolean getGameRunning() {
        return gameRunning;
    }
    
    /**
     * Calculates at which position a Player has hit the Ball with his Paddle.
     * 
     * @param player The Player which has to hit the Ball
     * @param y The y Position at which the Ball may hit the Paddle
     * @return The relative position at which the Paddle hit the Ball, range [0..1]
     *         or -1 if the Ball was not hit
     */
    public double calucalatePaddleHitPosition(int player, double y) {
        if(y < this.players[player].getLinkPaddle().getPosition() ||
                y > this.players[player].getLinkPaddle().getPosition() + Paddle.height)
            return -1;
        return ((double)y - this.players[player].getLinkPaddle().getPosition())/Paddle.height;
    }

    /**
     * Check whether the Ball has left the visible Space
     * Increase the corresponding score if so
     */
    public void checkBallLeftGameArea() {
        if(ball.getXPosition() < 0)
            incPlayerScore(1);
        if(ball.getXPosition() > (GameArea.x1 + GameArea.x2))
            incPlayerScore(0);
    }

    /**
     * Increase the score of the given Player. Reset the Ball movement and
     * check whether the game has been won.
     * 
     * @param player The player who scored the Point
     */
    private void incPlayerScore(int player) {
        this.players[player].increaseScore();
        this.ball.restartMovement(2 - this.ball.getAngle());
        checkWin();
    }
    /**
     * Creates a new Highscore Object representing the Player who has won
     * 
     * @return The created Highscore Object
     */
    private Highscore createHighscore() {
        Highscore hs = null;
        if(players[0].getScore() > players[1].getScore()) {
            hs = new Highscore(Configuration.instance().getPlayer1Name(),
                    players[0].getScore()*(players[0].getScore() - players[1].getScore()),
                    new Date());
        } else if(players[1].getScore() > players[0].getScore()) {
            hs = new Highscore(Configuration.instance().getPlayer2Name(),
                    players[1].getScore()*(players[1].getScore() - players[0].getScore()),
                    new Date());
        }
        return hs;
    }
    
    /**
     * Check whether a player has reached the winScore set in Configuration.
     * If yes create a Highscore, link it to the Container and stop the game.
     */
    private void checkWin() {
        Configuration conf = Configuration.instance();
        if(players[0].getScore() >= conf.getWinScore() || players[1].getScore() >= conf.getWinScore()) {
            Highscore hs = createHighscore();
            if(hs != null) {
                HighscoreContainer.instance().insertHighscore(hs);
            }
            // stop the game
            this.gameAbort();
        }
    }
    
    /**
     * Getter for attribute players
     * 
     * @param player Which player to return
     * @return The selected Player
     */
    public Player getLinkPlayer(int player) {
        return this.players[player];
    }

    /**
     * Getter for Ball
     * 
     * @return The Ball used by Pong
     */
    public Ball getLinkBall() {
        return ball;
    }
}
