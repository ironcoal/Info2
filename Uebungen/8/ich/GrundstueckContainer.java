import java.util.*;

public class GrundstueckContainer extends Observable implements Iterable<Grundstueck> {
	private static GrundstueckContainer unique;
	private Vector<Grundstueck> grundstuecke = new Vector<Grundstueck>();

	private GrundstueckContainer() {
		super();
	}
	
	public static GrundstueckContainer instance() {
		if (unique == null)
			unique = new GrundstueckContainer();
		return unique;
	}

	public void addGrundstueck(Grundstueck g) {
		if (g != null) {
			grundstuecke.addElement(g);
			super.setChanged();
			super.notifyObservers();
		}
	}

	public void removeGrundstueck(Grundstueck g) {
		if (g != null) {
			Eigentuemer e = g.getLinkEigentuemer();
			if (e != null) {
				e.unlinkGrundstueck(g);
				g.unlinkEigentuemer();
			}
			grundstuecke.removeElement(g);
			super.setChanged();
			super.notifyObservers();
		}
	}

	public Grundstueck getGrundstueck(int index) {
		return grundstuecke.get(index);
	}

	public Iterator<Grundstueck> iterator() {
		return grundstuecke.iterator();
	}
}