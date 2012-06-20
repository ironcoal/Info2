
public class Main {

	public static void main(String[] args) {
		GrundstueckContainer.instance().addGrundstueck(new Grundstueck("Hier","15 m2"));
		GrundstueckContainer.instance().addGrundstueck(new Grundstueck("Dort","23 m2"));
		EigentuemerContainer.instance().addEigentuemer(new Eigentuemer("Ich","1.1.1970"));
		EigentuemerContainer.instance().addEigentuemer(new Eigentuemer("Du","spaeter"));
		new Grundstueckverwaltung();
	}
}