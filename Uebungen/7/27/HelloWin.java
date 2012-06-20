import java.awt.*;
import java.awt.event.*;

public class HelloWin extends Frame implements ActionListener {
	
	public HelloWin(String s) {
		super("Fenster");
		setLayout(new BorderLayout());
		TextField tf = new TextField();
		tf.setText("Hallo");
		tf.setEnabled(false);
		add(tf, BorderLayout.NORTH);
		Button b = new Button();
		b.setLabel("Schliessen");
		b.addActionListener(this);
		add(b, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new HelloWin("Hallo");
	}

	public void actionPerformed(ActionEvent e) {

	}

}