import java.awt.*;
import java.util.*;


public class ColorWindow extends Dialog implements Observer {
	boolean komplement;

	public ColorWindow(Frame owner, Farbe farbe, boolean komplement) {
		super(owner, "blub", false);
		this.komplement = komplement;
		farbe.addObserver(this);
		setzeFarbe(farbe);
		setPreferredSize(new Dimension(250, 50));

		pack();
		setVisible(true);
	}

	public void update(Observable farbe, Object obj) {
		setzeFarbe((Farbe) farbe);
	}
	private void setzeFarbe(Farbe farbe) {
		if (komplement)
			setBackground(farbe.getC());
		else {
			setBackground(farbe.getCk());
		}

	}
}