

import java.awt.Button;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Dialog which displays a warning
 */
public class WarnDialog extends Dialog implements ActionListener {
	/**
	 * Uniquely identifies this class
	 */
	private static final long serialVersionUID = -7645587187431998755L;
	
	/**
	 * Button to close the dialog
	 */
	Button bOK;
	
	/**
	 * Constructor of class WarnDialog
	 * 
	 * @param owner The window which created the WarnDialog
	 * @param message The message to display
	 */
	public WarnDialog(Window owner, String message) {
		super(owner, "Fehler");
		init(message);
	}
	
	/**
	 * Constructor of class WarnDialog
	 * 
	 * @param owner The dialog which created the WarnDialog
	 * @param message The message to display
	 */
	public WarnDialog(Dialog owner, String message) {
		super(owner, "Fehler");
		init(message);
	}
	
	/**
	 * Creates the gui elements and layout
	 * 
	 * @param message The message to display
	 */
	private void init(String message) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setLayout(new GridLayout(2,1));
		Label l = new Label(message);
		add(l);
		bOK = new Button("Schliessen");
		bOK.addActionListener(this);
		add(bOK);
		pack();
		setVisible(true);
	}
	
	/**
	 * Called when the user clicks a button
	 * 
	 * @param e An ActionEvent which contains information about what was clicked
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bOK))
			dispose();
	}
}
