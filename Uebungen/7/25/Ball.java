

/**
 * The class Ball represents the Ball with which Pong is played
 */
public class Ball {
	/**
	 *  Radius of the Ball
	 */
	public static final int size = 10;
	
	/**
	 *  Instance of Pong which this Ball belongs to
	 */
	private Pong pong;
	
	/**
	 *  Current Ball position 
	 */
	private double xPosition, yPosition;

	/**
	 *  angle measured in radians, multiples of pi, counterclockwise
	 *        {0 <= angle < 2}
	 *        0 means up
	 *  speed measured in pixel/step
	 */
	private double angle, speed;
	
	/**
	 *  Whether the Ball has been missed by a player after movement start
	 *  If set the Ball will not be reflected by a Paddle
	 */
	private boolean missed;
	
	/**
	 * Creates a new Ball and sets its initial position to the center of the GameArea.
	 * 
	 * @param pong Instance of Pong which this Ball belongs to
	 */
	public Ball(Pong pong) {
		this.pong = pong;
		this.xPosition = (GameArea.x1 + GameArea.x2)/2;
		this.yPosition = (GameArea.y1 + GameArea.y2)/2;
	}

	/**
	 * Resets initial speed, position and direction.
	 * 
	 * @param direction The direction in which the Ball should move
	 */
	public void startMovement(double direction) {
		this.missed = false;
		this.xPosition = (GameArea.x1 + GameArea.x2)/2;
		this.yPosition = (GameArea.y1 + GameArea.y2)/2;
		if(direction < 1) {
			this.angle = 0.25 + 0.5*Math.random();			
		} else {
			this.angle = 1.25 + 0.5*Math.random();			
		}
		this.speed = Configuration.instance().getInitialBallSpeed();
	}

	/**
	 * Stops movement of the Ball. Has nothing to do right now.
	 */
	public void stopMovement() {
	}
	
	/**
	 * Restarts the movement of the Ball by stopping and starting it.
	 * 
	 * @param direction Is passed to call of startMovement()
	 */
	public void restartMovement(double direction) {
		this.stopMovement();
		this.startMovement(direction);
	}

	/**
	 * Does a single movement step with current speed in the current direction
	 * and checks if the Ball has left the GameArea on the left or right side.
	 */
	public void step() {
		double x = this.xPosition - (speed * Math.sin(angle * Math.PI));
		double y = this.yPosition + (speed * Math.cos(angle * Math.PI));
		move(x,y);
		pong.checkBallLeftGameArea();
	}

	/**
	 * Moves the Ball to the given coordinates and checks if it gets reflected
	 * by a wall or a Paddle or if it is missed by a player.
	 * 
	 * @param x The x coordinate to which the Ball is moved
	 * @param y The y coordinate to which the Ball is moved
	 */
	public void move(double x, double y) {
		// calculate new y position
		if(y < GameArea.y1 || y > GameArea.y2) {
			this.yPosition = reflectY(y);
		} else {
			this.yPosition = y;
		}
		
		if(missed) {
			// ball already missed by player
			this.xPosition = x;
		} else {
			if((x <= GameArea.x1 && angle < 1) ||
					(x >= GameArea.x2 && angle > 1)) {
				// player now has to hit the ball
				this.xPosition = reflectX(x,y);
			} else {
				// ball anywhere in the middle of the game area
				this.xPosition = x;
			}
		}
	}
	
	/**
	 * Checks for collision of Ball with Paddle and calculates the new direction
	 * and x position of the Ball after the collision. The new direction is set
	 * and the y coordinate remains untouched
	 * 
	 * @param x The x coordinate at which the Ball would be if the is no collision
	 * @param y The y coordinate at which the Ball would be if the is no collision
	 * @return The x position at which the Ball is after the collision
	 */
	private double reflectX(double x, double y) {
		if(x <= GameArea.x1) {
			double hitPosition = pong.calculatePaddleHitPosition(0,y);
			this.angle = calculateReflectXAngle(hitPosition);
			if(hitPosition == -1) {
				this.missed = true;
				return x;
			}
		} else if(x >= GameArea.x2) {
			double hitPosition = pong.calculatePaddleHitPosition(1,y);
			this.angle = calculateReflectXAngle(hitPosition);
			if(hitPosition == -1) {
				this.missed = true;
				return x;
			}
		}
		return x;
	}

	/**
	 * Calculates the reflection of the Ball at a wall. This method may only
	 * be called if there is a collision
	 * 
	 * @param y The y coordinate at which the Ball would be if the would be no
	 * 			reflection
	 * @return The y coordinate after the reflection
	 */
	private double reflectY(double y) {
		if(y < GameArea.y1)
			y = 2*GameArea.y1 - y;
		if(y > GameArea.y2)
			y = 2*GameArea.y2 - y;
		if(angle <= 1)
			angle = 1 - angle;
		else
			angle = 3 - angle;
		return y;
	}
	
	/**
	 * Calculates the new direction of the Ball after a collision with a Paddle.
	 * 
	 * @param ballHitPosition The relative hit position of the Ball on the
	 * 		                  Paddle. Range [0..1]
	 * @return The new direction of the Ball
	 */
	private double calculateReflectXAngle(double ballHitPosition) {
		if(this.angle < 1)
			return 1.25 + 0.5 * ballHitPosition;
		else
			return 0.75 - 0.5 * ballHitPosition;
	}
	
/*	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}*/

	/**
	 * Getter for xPosition
	 * 
	 * @return Value of xPosition
	 */
	public double getXPosition() {
		return xPosition;
	}
	
	/**
	 * Getter for yPosition
	 * 
	 * @return Value of yPosition
	 */
	public double getYPosition() {
		return yPosition;
	}

	/**
	 * Getter for angle
	 * 
	 * @return Value of angle
	 */
	public double getAngle() {
		return angle;
	}
/*	public void setAngle(double angle) {
		this.angle = angle;
	}*/

	/**
	 * Getter for speed
	 * 
	 * @return Value of speed
	 */
	public double getSpeed() {
		return this.speed;
	}

	/**
	 * Increases the speed by the factor ballSpeedup set in Configuration
	 */
	public void increaseSpeed() {
		this.speed = this.speed * Configuration.instance().getBallSpeedup();
	}
}
