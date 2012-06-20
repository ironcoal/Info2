import java.util.*;

public class Eigentuemer extends Observable {
	private String name;
	private String geburtsdatum;
	private Vector<Grundstueck> grundstuecke = new Vector<Grundstueck>();

	public Eigentuemer(String name, String geburtsdatum) {
		super();
		this.name = name;
		this.geburtsdatum = geburtsdatum;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	public String getGeburtsdatum() {
		return geburtsdatum;
	}
	public boolean equals(Object o) {
		return (name.equals(((Eigentuemer) o).name) && 
			geburtsdatum.equals(((Eigentuemer) o).geburtsdatum));
	}
	public String toString() {
		return "Eigentuemer mit Name: " + name +
			" und Geburtsdatum: " + geburtsdatum + ".";
	}
	public void linkGrundstueck(Grundstueck g) {
		grundstuecke.addElement(g);
		super.setChanged();
		super.notifyObservers();
	}
	public void unlinkGrundstueck(Grundstueck g) {
		grundstuecke.removeElement(g);
		super.setChanged();
		super.notifyObservers();
	}
	public Grundstueck getLinkGrundstueck(int index) {
		return grundstuecke.elementAt(index);
	}
	public Vector<Grundstueck> getLinkGrundstuecke() {
		return grundstuecke;
	}
}