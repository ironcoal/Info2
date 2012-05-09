class GameArea {
	private static int x1 = 15;
	private static int y1 = 15;
	private static int x2 = 285;
	private static int y2 = 185;

	public static int getX1() {
		return x1;
	}
	public static int getX2() {
		return x2;
	}
	public static int getY1() {
		return y1;
	}
	public static int getY2() {
		return y2;
	}
	public static int calcWidth() {
		return x2 - x1;
	}
	public static int calcHeight() {
		return y2 - y1;
	}

}