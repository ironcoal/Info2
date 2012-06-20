

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * The class HighscoreDialog displays all Highscores created so far
 */
public class HighscoreDialog extends Dialog implements ActionListener {
	/**
	 * Uniquely identifies this class
	 */
	private static final long serialVersionUID = 4746719338797231213L;

	/**
	 * Button to refresh the list of Highscores
	 */
	private Button btnReload;
	
	/**
	 * Button to show local Highscores
	 */
	private Button btnShowLocal;
	
	/**
	 * Button to show online Highscores
	 */
	private Button btnShowOnline;

	/**
	 * TextArea which displays all Highscores
	 */
	private TextArea scoreField;
	
	/**
	 * Whether online records are currently displayed
	 */
	private boolean showOnline;
	
	/**
	 * Constructor for class HighscoreDialog
	 * initializes all the gui elements
	 * 
	 * @param owner the Frame which created the Dialog
	 */
	public HighscoreDialog(Frame owner) {
		super(owner);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		Panel btnPanel = new Panel();
		btnPanel.setLayout(new FlowLayout());
		btnReload = new Button("Aktualisieren");
		btnReload.addActionListener(this);
		btnPanel.add(btnReload);
		btnShowLocal = new Button("Lokal");
		btnShowLocal.addActionListener(this);
		btnPanel.add(btnShowLocal);
		btnShowOnline = new Button("Online");
		btnShowOnline.addActionListener(this);
		btnPanel.add(btnShowOnline);
		add(btnPanel, BorderLayout.NORTH);
		
		scoreField = new TextArea();
		add(scoreField, BorderLayout.CENTER);
		
		pack();
		setVisible(true);
		
		showLocalHighscores();
	}
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnShowLocal)) {
			setShowOnline(false);
			showLocalHighscores();
		}
		if (o.equals(btnShowOnline)) {
			setShowOnline(true);
			showOnlineHighscores();
		}
		if (o.equals(btnReload)) {
			if (showOnline = true)
				showOnlineHighscores();
			else 
				showLocalHighscores();
		}
	}
	
	/**
	 * Set method for boolean attribute showOnline
	 * 
	 * @param b Boolean variable
	 */
	private void setShowOnline(boolean b) {
		showOnline=b;
	}
	public void showLocalHighscores() {
		scoreField.setText("");
		HighscoreContainer hc = HighscoreContainer.instance();
		for (Highscore h: hc) {
			scoreField.append(h.getScore() +
				": " + h.getName() + "-" + h.getDate() + "\n");
		}
	}
	public void showOnlineHighscores() {
		scoreField.setText("");
		Online on = Online.instance();
		ArrayList<Highscore> ar = on.getHighscores();
		for (Highscore h: ar) {
			scoreField.append(h.getScore() + ": " + h.getName() +
				"-" + h.getDate() + "\n");
		}
	}

}
