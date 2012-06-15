import java.awt.*;
import java.util.*;

public class StringWindow extends Dialog implements Observer {
	private boolean komplement;
	private Label lr;
	private Label lg;
	private Label lb;

	public StringWindow(Frame owner, Farbe farbe, boolean komplement) {
		super(owner, "Farbe", false);
		setLayout(new GridLayout(1,3));
		lr = new Label("sd");
		add(lr);
		lg = new Label("sd");
		add(lg);
		lb = new Label("sdsd");
		add(lb);

		this.komplement = komplement;
		farbe.addObserver(this);
		this.setzeStrings(farbe);



		setPreferredSize(new Dimension(250, 50));
		pack();
		setVisible(true);
	}
	public void update(Observable farbe, Object obj) {
		setzeStrings((Farbe) farbe);
	}
	private void setzeStrings(Farbe farbe) {
		
		if (komplement) {
			Color c = farbe.getCk();
			lr.setText(Integer.toString(c.getRed()));
			lg.setText(Integer.toString(c.getGreen()));
			lb.setText(Integer.toString(c.getBlue()));
		} else {
			Color c = farbe.getC();
			lr.setText(Integer.toString(c.getRed()));
			lg.setText(Integer.toString(c.getGreen()));
			lb.setText(Integer.toString(c.getBlue()));
		}
	}
}	