import java.util.*;

public class EigentuemerContainer extends Observable implements Iterable<Eigentuemer> {
	private static EigentuemerContainer unique;
	private Vector<Eigentuemer> eigentuemer = new Vector<Eigentuemer>();

	private EigentuemerContainer() {
		super();
	}
	
	public static EigentuemerContainer instance() {
		if (unique == null)
			unique = new EigentuemerContainer();
		return unique;
	}
	public void addEigentuemer(Eigentuemer e) {
		if (e != null) {
			eigentuemer.addElement(e);
			super.setChanged();
			super.notifyObservers();
		}
	}
	public void removeEigentuemer(Eigentuemer e) {
		if (e != null) {
			Vector<Grundstueck> v = e.getLinkGrundstuecke();
			if (v != null) {
				for (Grundstueck g: v) {
					g.unlinkEigentuemer();
					e.unlinkGrundstueck(g);
				}
			}
			v = null;
			super.setChanged();
			super.notifyObservers();
		}
	}
	public Eigentuemer getEigentuemer(int index) {
		return eigentuemer.get(index);
	}
	public Iterator<Eigentuemer> iterator() {
		return eigentuemer.iterator();
	}
}