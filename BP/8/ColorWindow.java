

public class ColorWindow extends Dialog, Observable{
	boolean komplement;

	public ColorWindow(Frame owner, Farbe farbe, boolean komplement) {
		super(owner, "blub");
		this.komplement = komplement;
		setzeFarbe(farbe);
	}

	public update(Observable farbe, Object obj) {
		setzeFarbe((Farbe) farbe);
	}
	private setzeFarbe(Farbe farbe) {
		if (komplement)
			setBackground(farbe.getC);
		else {
			setBackground(farbe.getCk);
		}

	}
}