class Ball {
	private static final int size = 10;
	public static boolean missed;
	private double xPosition;
	private double yPosition;
	private int speed;
	private double angle;

	public Ball(double direction) {
		missed = false;
		xPosition = GameArea.calcWidth() / 2 + GameArea.getX1();
		yPosition = GameArea.calcHeight() / 2 + GameArea.getY1();
		speed = 10;
		if (direction < 1.0)
			angle = Math.random() * 90 + 45;
		else
			angle = Math.random() * 90 + 225;
	}
	public static int getSize() {
		return size;
	}
	public double getXPosition() {
		return xPosition;
	}
	public double getYPosition() {
		return yPosition;
	}
	public double getAngle() {
		return angle;
	}
	public double getSpeed() {
		return speed;
	}
	public void step() {
		move(Math.sin(angle * speed) + xPosition,
			Math.cos(angle * speed) + yPosition);
	}
	public void move(double x, double y) {
		if ((y < GameArea.getY1()) || (y > GameArea.getY2())) {
			System.out.println(y);
			System.out.println("Ball hat Wand erreicht");
			missed = true;
		} else if ((x < GameArea.getX1()) || (x > GameArea.getX2())) {
			System.out.println("Spieler muss Ball treffen");
			missed = true;
		} else {
			xPosition = x;
			yPosition = y;
		}
	}
}