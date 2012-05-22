

/**
 * The class Paddle represents a Paddle which is used by a Player to hit the Ball.
 */
public class Paddle {
    /**
     * The Dimensions of the Paddle
     */
    public static final int height = 50;
    public static final int width = 10;
    
    /**
     * The current position of the Paddle
     */
    private int position;
    
    /**
     * Getter for position
     * 
     * @return The current position of the Paddle
     */
    public int getPosition() {
        return this.position;
    }
    
    /**
     * Moves the Paddle by the given distance
     * 
     * @param diff The amount of pixels to move
     *             Negative means up, positive down
     */
    public void move(int diff) {
        position += diff;
        if(position < 0)
            position = 0;
        if(position + height > GameArea.y1 + GameArea.y2)
            position = GameArea.y1 + GameArea.y2 - Paddle.height;
    }
}
