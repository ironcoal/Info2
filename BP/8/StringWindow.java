
public class StringWindow extends Dialog implements Observer{
	boolean komplement;
	Label lr;
	Label lg;
	Label lb;

	public StringWindow(Frame owner, Farbe farbe, boolean komplement) {
		super(owner);
		this.komplement = komplement;
		setzeStrings(farbe);

		lr = new Label;
		lg = new Label;
		lb = new Label;
	}
	public update(Observable farbe, Object obj) {
		setzeStrings((Farbe) farbe);
	}
	private setzeStrings(Farbe farbe) {
		if (komplement)
			lr.setText(255 - farbe.getR());
			lg.setText(255 - farbe.getG());
			lb.setText(255 - farbe.getB());
		else
			lr.setText(farbe.getR());
			lg.setText(farbe.getG());
			lb.setText(farbe.getB());
	}
}	