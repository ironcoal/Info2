import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class ControllerWindow extends Frame implements AdjustmentListener {
	Scrollbar r;
	Scrollbar g;
	Scrollbar b;
	Farbe farbe;

	public ControllerWindow() {
		super("Farbenbeobachterspiel");
		
		setLayout(new GridLayout(3,1));
		
		r = new Scrollbar(Scrollbar.HORIZONTAL, 0, 25, 0, 280);
		r.addAdjustmentListener(this);
		add(r);
		g = new Scrollbar(Scrollbar.HORIZONTAL, 0, 25, 0, 280);
		g.addAdjustmentListener(this);
		add(g);
		b = new Scrollbar(Scrollbar.HORIZONTAL, 0, 25, 0, 280);
		b.addAdjustmentListener(this);
		add(b);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		
		setSize(250, 75);
		setLocation(220, 125);

		farbe = new Farbe();
		new ColorWindow(this, farbe, false).setLocation(20, 350);
		new ColorWindow(this, farbe, true).setLocation(420, 350);
		new StringWindow(this, farbe, false).setLocation(92,600);
		new StringWindow(this, farbe, true).setLocation(492,600);
		setVisible(true);	
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e) {
		farbe.setR(r.getValue());
		farbe.setG(g.getValue());
		farbe.setB(b.getValue());
	}
	
	public static void main(String[] args) {
		new ControllerWindow();
	}
}