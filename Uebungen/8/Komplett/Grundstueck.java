
public class Grundstueck {
	private String lage;
	private String flaeche;
	private Eigentuemer eigentuemer;

	public Grundstueck(String lage, String flaeche) {
		this.lage = lage;
		this.flaeche = flaeche;
	}
	public void setLage(String lage) {
		this.lage = lage;
	}
	public String getLage() {
		return lage;
	}
	public void setFlaeche(String flaeche) {
		this.flaeche = flaeche;
	}
	public String getFlaeche() {
		return flaeche;
	}
	public boolean equals(Object o) {
		return (lage.equals(((Grundstueck) o).lage) && 
			flaeche.equals(((Grundstueck) o).flaeche));
	}
	public String toString() {
		return "Grundstueck mit Lage: " + lage +
			" und Flaeche: " + flaeche + ".";
	}
	public void linkEigentuemer(Eigentuemer e) {
		eigentuemer = e;
	}
	public void unlinkEigentuemer() {
		eigentuemer = null;
	}
	public Eigentuemer getLinkEigentuemer() {
		return eigentuemer;
	}

}