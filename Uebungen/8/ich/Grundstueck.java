import java.util.*;

public class Grundstueck extends Observable {
	private String lage;
	private String flaeche;
	private Eigentuemer eigentuemer;

	public Grundstueck(String lage, String flaeche) {
		super();
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
		super.setChanged();
		super.notifyObservers();
	}
	public void unlinkEigentuemer() {
		eigentuemer = null;
		super.setChanged();
		super.notifyObservers();
	}
	public Eigentuemer getLinkEigentuemer() {
		return eigentuemer;
	}

}