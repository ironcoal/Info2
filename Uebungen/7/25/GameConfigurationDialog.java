

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Dialog for the configuration of the game parameters
 */
public class GameConfigurationDialog extends Dialog implements ActionListener {
	/**
	 * Uniquely identifies this class
	 */
	private static final long serialVersionUID = 2849337069941322808L;

	/**
	 * TextField for the number of points needed to win
	 */
	private TextField tfPoints;
	
	/**
	 * TextField for the initialBallspeed
	 */
	private TextField tfSpeed;
	
	/**
	 * TextField for the acceleration time of the Ball
	 */
	private TextField tfAccel;
	
	/**
	 * Button to save changes
	 */
	private Button bOK;
	
	/**
	 * Button to discard changes
	 */
	private Button bCancel;
	
	/**
	 * Constructor for class GameConfigurationDialog
	 * initializes all the gui elements
	 * 
	 * @param owner the Frame which created the Dialog
	 */
	public GameConfigurationDialog(Frame owner) {
		super(owner);
		setModalityType(ModalityType.APPLICATION_MODAL);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setLayout(new GridLayout(0, 2));
		add(new Label("Siegpunkte:"));
		tfPoints = new TextField();
		add(tfPoints);
		add(new Label("Ballgeschwindigkeit"));
		tfSpeed = new TextField();
		add(tfSpeed);
		add(new Label("Beschleunigung"));
		tfAccel = new TextField();
		add(tfAccel);
		bOK = new Button("OK");
		bOK.addActionListener(this);
		add(bOK);
		bCancel = new Button("Abbrechen");
		bCancel.addActionListener(this);
		add(bCancel);
		
		load();
		pack();
		setVisible(true);
	}
	
	/**
	 * Called when the users clicks on a button
	 * 
	 * @param e An ActionEvent which contains information about what was clicked
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bOK)) {
			save();
			dispose();
		} else if(e.getSource().equals(bCancel))
			dispose();
	}
	
	/**
	 * Writes all the changes into the instance of Configuration
	 */
	private void save() {
		Configuration c = Configuration.instance();
		c.setWinScore(Integer.parseInt(tfPoints.getText()));
		c.setInitialBallSpeed(Double.parseDouble(tfSpeed.getText()));
		c.setBallSpeedup(Double.parseDouble(tfAccel.getText()));
	}
	
	/**
	 * Loads the current configuration into the TextFields
	 */
	private void load() {
		Configuration c = Configuration.instance();
		tfPoints.setText(Integer.toString(c.getWinScore()));
		tfSpeed.setText(Double.toString(c.getInitialBallSpeed()));
		tfAccel.setText(Double.toString(c.getBallSpeedup()));
	}
}
