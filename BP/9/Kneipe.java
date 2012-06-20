import java.util.ArrayList;
import java.util.Iterator;

public class Kneipe implements Iterable<Trinker>{
	private double bierVorrat;
	private int plaetze;
	private ArrayList<Trinker> arTrinker = new ArrayList<Trinker>();

	public Kneipe(double bierVorrat, int plaetze) {
		this.bierVorrat = bierVorrat;
		this.plaetze = plaetze;
	}
	public int gaeste() {
		return arTrinker.size();
	}
	public Trinker getGast(int i) throws NoSuchTrinkerException{
		return arTrinker.get(i);
	}
	public boolean betreteKneipe(Trinker gast) {
		try {
			if (gaeste() >= plaetze) {
				throw new KneipeVollException();
			} else {
				arTrinker.add(gast);
				System.out.println(gast.getName() + " hat erfolgreich Kneipe betreten");
				return true;
			}
		} catch(KneipeVollException e) {
			System.out.println(gast.getName() + " bekommt leider keinen Platz und muss wieder gehen!");
			System.out.println(e.getMessage());
			return false;
		} catch(Exception e) {
			System.out.print("Probleme beim Betreten der Kneipe: " + e.getMessage());
			return false;
		}
	}
	public void verlasseKneipe(Trinker gast) throws NoSuchTrinkerException {
		if ((gast != null) && (arTrinker.contains(gast) == true))
			arTrinker.remove(gast);
		else
			throw new NoSuchTrinkerException();
	}
	public void reduziereBierVorrat(double menge) throws BierIstAusgegangenException {
		if ((bierVorrat - menge) < 0)
			throw new BierIstAusgegangenException();
		else
			bierVorrat -= menge;
	}
	public Iterator<Trinker> iterator() {
		return arTrinker.iterator();
	}
}