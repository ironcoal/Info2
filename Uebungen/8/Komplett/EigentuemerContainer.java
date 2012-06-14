import java.util.*;

public class EigentuemerContainer implements Iterable<Eigentuemer>{
	private static EigentuemerContainer unique;
	private Vector<Eigentuemer> eigentuemer = new Vector<Eigentuemer>();

	private EigentuemerContainer() {};
	
	public static EigentuemerContainer instance() {
		if (unique == null)
			unique = new EigentuemerContainer();
		return unique;
	}
	public void addEigentuemer(Eigentuemer e) {
		if (e != null) {
			eigentuemer.addElement(e);
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
		}
	}
	public Eigentuemer getEigentuemer(int index) {
		return eigentuemer.get(index);
	}
	public Iterator<Eigentuemer> iterator() {
		return eigentuemer.iterator();
	}
}