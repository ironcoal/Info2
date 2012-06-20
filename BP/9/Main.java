import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		int bierVorrat = (int) ((Math.random() * 30) + 50);
		int resistenz = 9;
		int plaetze = 3;
		Kneipe k = new Kneipe(bierVorrat, plaetze);
		ArrayList<Trinker> trinker = new ArrayList<Trinker>();

		System.out.println(	"===========================\n" +
							"*   Kneipe \"Zum Lorenz\"   *\n"	+
							"===========================\n");

		System.out.println("Es sind heute " + bierVorrat + 
			" Liter Bier im Fass und " + plaetze + " Plaetze frei!");

		trinker.add(new Trinker("Herbert", (int) ((Math.random() * 3) + resistenz)));
		trinker.add(new Trinker("Horscht", (int) ((Math.random() * 3) + resistenz)));
		trinker.add(new Trinker("Sepp", (int) ((Math.random() * 3) + resistenz)));
		trinker.add(new Trinker("Max", (int) ((Math.random() * 3) + resistenz)));

		for (Trinker t: trinker)
			k.betreteKneipe(t);
		
		System.out.println(	"\n==============" +
							"  Der Ausschank beginnt! " +
							"================\n");
		double menge;

		while (k.gaeste() > 0) {
			System.out.println("Neue Runde!");		
			for (int i = 0; i < k.gaeste(); i++) {
				try {
					menge = Math.round(Math.random() * 2);			
					k.reduziereBierVorrat(menge);
					k.getGast(i).trinke(menge);
				} catch (BetrunkenException be) {
					System.out.println(">>  " + be.getMessage());
					try {
						k.verlasseKneipe(k.getGast(i));
						i--;
					} catch(NoSuchTrinkerException nste) {
						System.out.println(nste.getMessage());
					}
				} catch(BierIstAusgegangenException biae) {
					System.out.println(biae.getMessage());
					System.exit(0);
				} catch (Exception e) {
					System.out.println("Programmfehler!");
				}
			}
		}
		
		System.out.println("Programm wird beendet!");

	}
}