

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
	 * TextArea which displays all Highscores
	 */
	private TextArea scoreField;
	
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
		add(btnPanel, BorderLayout.NORTH);
		
		scoreField = new TextArea();
		add(scoreField, BorderLayout.CENTER);
		
		pack();
		setVisible(true);
		
		showHighscores();
	}
	
	/**
	 * Loads and displays all the Highscores 
	 */
	private void showHighscores() {
		scoreField.setText("");
		HighscoreContainer c = HighscoreContainer.instance();
		for(Highscore h : c)
			scoreField.append(h.getScore() + ": " + h.getName() + " - " + h.getDate() + "\n");
	}
	
	/**
	 * Called when the users clicks on a button
	 * 
	 * @param e An ActionEvent which contains information about what was clicked
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnReload)) {
			showHighscores();
		}
	}
}
