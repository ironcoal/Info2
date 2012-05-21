class Sperrgut extends Paket {
	private boolean brauchtPalette = true;

	public Sperrgut(int laenge, int breite, int hoehe, int gewicht) {
		super(laenge, breite, hoehe, gewicht);
	}
	public String toString() {
		if (this.checkPaketdaten(laenge, breite, hoehe, gewicht) && (brauchtPalette == true))
			return ("Sperrgut (Laenge, Breite, Hoehe, Gewicht): " +
				laenge + ", " + breite + ", " + hoehe + ", " + gewicht + " auf Palette");
		else
			return "Fehler - Paketattribute entsprechen nicht den Vorgaben!";
	}

}