

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

/**
 * Textual display of game parameters such as Ball position
 */
public class PongDisplay extends Panel {
    /**
     * Uniquely identifies this class
     */
    private static final long serialVersionUID = -7663601593227816019L;

    /**
     * Position of paddle of player 1
     */
    private Label paddle1Position;
    
    /**
     * Position of paddle of player 2
     */
    private Label paddle2Position;
    
    /**
     * Position of the Ball
     */
    private Label ballPosition;
    
    /**
     * Contructor of PongDisplay
     * creates the labels and layout
     */
    public PongDisplay() {
        super();
        setLayout(new GridLayout(3, 2));
        Label paddle1 = new Label("Schlaeger 1: ");
        add(paddle1);
        paddle1Position = new Label("");
        add(paddle1Position);
        Label paddle2 = new Label("Schlaeger 2:");
        add(paddle2);
        paddle2Position = new Label("");
        add(paddle2Position);
        Label ball = new Label("Ball:");
        add(ball);
        ballPosition = new Label("");
        add(ballPosition);
    }
    
    /**
     * Sets the position of paddle of player 1
     * 
     * @param position the new position
     */
    public void setPaddle1Position(int position) {
        paddle1Position.setText("X: " + GameArea.x1 + "        Y: " + position + "-" + (position + Paddle.height));
    }
    
    /**
     * Sets the position of paddle of player 2
     * 
     * @param position the new position
     */
    public void setPaddle2Position(int position) {
        paddle2Position.setText("X: " + GameArea.x2 + "        Y: " + position + "-" + (position + Paddle.height));
    }
    
    /**
     * Sets the position of the ball
     * 
     * @param x the new y position
     * @param y the new y position
     */
    public void setBallPosition(double x, double y) {
        ballPosition.setText("X: " + (int)x + "          Y:" + (int)y);
    }
}
