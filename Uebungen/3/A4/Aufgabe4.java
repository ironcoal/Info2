public class Aufgabe4 {
	public static void main(String[] args) {
		Ball ball = new Ball (2 * Math.random());
		while (!ball.missed) {
			System.out.println("Ball ist an Position " + ball.getXPosition() + ", " + ball.getYPosition());
			ball.step();
		}
	}
}