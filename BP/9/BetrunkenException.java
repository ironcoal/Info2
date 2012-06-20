
public class BetrunkenException extends Exception {
	public BetrunkenException(String name, int liter) {
		super(name + " ist nach " + liter + " Litern Bier total breit und muss die Kneipe verlassen!");
	}
}