

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Dialog for the configuration of the player parameters
 */
public class PlayerConfigurationDialog extends Dialog implements ActionListener, KeyListener, ItemListener {
	/**
	 * Uniquely identifies this class
	 */
	private static final long serialVersionUID = -9205628920634515528L;

	/**
	 * TextFields for input of player Names
	 */
	private TextField tfPlayer1Name, tfPlayer2Name;
	
	/**
	 * Checkbox for input of mouse use
	 */
	private Checkbox cbPlayer1Mouse, cbPlayer2Mouse;
	
	/**
	 * Contain the key codes to move a paddle up
	 */
	private int player1KeyCodeUp, player2KeyCodeUp;
	
	/**
	 * Contain the key codes to move a paddle down
	 */
	private int player1KeyCodeDown, player2KeyCodeDown;
	
	/**
	 * Buttons for input of key code for upwards movement
	 */
	private Button bPlayer1Up, bPlayer2Up;
	
	/**
	 * Buttons for input of key code for downwards movement
	 */
	private Button bPlayer1Down, bPlayer2Down;
	
	/**
	 * Button to save changes
	 */
	private Button bOK;
	
	/**
	 * Button to discard changes
	 */
	private Button bCancel;
	
	/**
	 * Set to true when waiting for user input
	 */
	private boolean waitForInput;
	
	/**
	 * References the Button which is waiting for user input
	 */
	private Button waitingButton;
	
	/**
	 * Constructor for class PlayerConfigurationDialog
	 * initializes all the gui elements
	 * 
	 * @param owner the Frame which created the Dialog
	 */
	public PlayerConfigurationDialog(Frame owner) {
		super(owner,"Spieler konfigurieren",true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints constraints = new GridBagConstraints();
		Label l1 = new Label("Spieler 1:");
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = 1;
		layout.setConstraints(l1, constraints);
		add(l1);
		Panel spacer1 = new Panel();
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(spacer1, constraints);
		add(spacer1);
		Label lname1 = new Label("Name:");
		constraints.gridwidth = 1;
		constraints.gridx = 1;
		layout.setConstraints(lname1, constraints);
		add(lname1);
		tfPlayer1Name = new TextField();
		tfPlayer1Name.setPreferredSize(new Dimension(200, 20));
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridx = GridBagConstraints.RELATIVE;
		constraints.weightx = 2.0;
		layout.setConstraints(tfPlayer1Name, constraints);
		add(tfPlayer1Name);
		Label lcb1 = new Label("Maus verwenden:");
		constraints.gridx = 1;
		constraints.gridwidth = 1;
		constraints.weightx = 1.0;
		layout.setConstraints(lcb1, constraints);
		add(lcb1);
		cbPlayer1Mouse = new Checkbox();
		cbPlayer1Mouse.addItemListener(this);
		constraints.gridx = GridBagConstraints.RELATIVE;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(cbPlayer1Mouse, constraints);
		add(cbPlayer1Mouse);
		Label lup1 = new Label("Nach oben:");
		constraints.gridx = 1;
		constraints.gridwidth = 1;
		layout.setConstraints(lup1, constraints);
		add(lup1);
		bPlayer1Up = new Button();
		bPlayer1Up.addActionListener(this);
		bPlayer1Up.addKeyListener(this);
		constraints.gridx = GridBagConstraints.RELATIVE;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(bPlayer1Up, constraints);
		add(bPlayer1Up);
		Label ldown1 = new Label("Nach unten:");
		constraints.gridx = 1;
		constraints.gridwidth = 1;
		layout.setConstraints(ldown1, constraints);
		add(ldown1);
		bPlayer1Down = new Button();
		bPlayer1Down.addActionListener(this);
		bPlayer1Down.addKeyListener(this);
		constraints.gridx = GridBagConstraints.RELATIVE;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(bPlayer1Down, constraints);
		add(bPlayer1Down);
		Label l2 = new Label("Spieler 2:");
		layout.setConstraints(l2, constraints);
		add(l2);
		Label lname2 = new Label("Name:");
		constraints.gridwidth = 1;
		constraints.gridx = 1;
		layout.setConstraints(lname2, constraints);
		add(lname2);
		tfPlayer2Name = new TextField();
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.gridx = GridBagConstraints.RELATIVE;
		layout.setConstraints(tfPlayer2Name, constraints);
		add(tfPlayer2Name);
		Label lcb2 = new Label("Maus verwenden:");
		constraints.gridx = 1;
		constraints.gridwidth = 1;
		layout.setConstraints(lcb2, constraints);
		add(lcb2);
		cbPlayer2Mouse = new Checkbox();
		cbPlayer2Mouse.addItemListener(this);
		constraints.gridx = GridBagConstraints.RELATIVE;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(cbPlayer2Mouse, constraints);
		add(cbPlayer2Mouse);
		Label lup2 = new Label("Nach oben:");
		constraints.gridx = 1;
		constraints.gridwidth = 1;
		layout.setConstraints(lup2, constraints);
		add(lup2);
		bPlayer2Up = new Button();
		bPlayer2Up.addActionListener(this);
		bPlayer2Up.addKeyListener(this);
		constraints.gridx = GridBagConstraints.RELATIVE;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(bPlayer2Up, constraints);
		add(bPlayer2Up);
		Label ldown2 = new Label("Nach unten:");
		constraints.gridx = 1;
		constraints.gridwidth = 1;
		layout.setConstraints(ldown2, constraints);
		add(ldown2);
		bPlayer2Down = new Button();
		bPlayer2Down.addActionListener(this);
		bPlayer2Down.addKeyListener(this);
		constraints.gridx = GridBagConstraints.RELATIVE;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(bPlayer2Down, constraints);
		add(bPlayer2Down);
		Panel spacer2 = new Panel();
		spacer2.setPreferredSize(new Dimension(0, 30));
		layout.setConstraints(spacer2, constraints);
		add(spacer2);
		bOK = new Button("Uebernehmen");
		bOK.addActionListener(this);
		constraints.gridwidth = 2;
		layout.setConstraints(bOK, constraints);
		add(bOK);
		bCancel = new Button("Abbrechen");
		bCancel.addActionListener(this);
		layout.setConstraints(bCancel, constraints);
		add(bCancel);

		this.addKeyListener(this);
		
		this.waitForInput = false;
		this.waitingButton = null;
		
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
		} else if(e.getSource().equals(bCancel)) {
			dispose();
		} else if(e.getSource().equals(bPlayer1Up)) {
			if(waitingButton == null) {
				bPlayer1Up.setLabel("waiting for input...");
				waitingButton = bPlayer1Up;
				waitForInput = true;
			}
		} else if(e.getSource().equals(bPlayer1Down)) {
			if(waitingButton == null) {
				bPlayer1Down.setLabel("waiting for input...");
				waitingButton = bPlayer1Down;
				waitForInput = true;
			}
		} else if(e.getSource().equals(bPlayer2Up)) {
			if(waitingButton == null) {
				bPlayer2Up.setLabel("waiting for input...");
				waitingButton = bPlayer2Up;
				waitForInput = true;
			}
		} else if(e.getSource().equals(bPlayer2Down)) {
			if(waitingButton == null) {
				bPlayer2Down.setLabel("waiting for input...");
				waitingButton = bPlayer2Down;
				waitForInput = true;
			}
		}
	}
	
	/**
	 * Called when the users presses a key
	 * 
	 * @param e A KeyEvent which contains information about which key was pressed
	 */
	public void keyPressed(KeyEvent e) {}
	
	/**
	 * Called when the users presses and releases a key
	 * 
	 * @param e A KeyEvent which contains information about which key was typed
	 */
	public void keyTyped(KeyEvent e) {}
	
	/**
	 * Called when the users releases a key
	 * 
	 * @param e A KeyEvent which contains information about which key was released
	 */
	public void keyReleased(KeyEvent e) {
		if(waitForInput) {
			waitForInput = false;
			this.keyInput(e.getKeyCode());
		}
	}
	
	/**
	 * Called when the user toggles a Checkbox
	 * 
	 * @param e A ItemEvent which contains information about which checkbox was clicked
	 */
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals(cbPlayer1Mouse)) {
			if(cbPlayer1Mouse.getState())
				cbPlayer2Mouse.setState(false);
		} else if(e.getSource().equals(cbPlayer2Mouse)) {
			if(cbPlayer2Mouse.getState())
				cbPlayer1Mouse.setState(false);
		}
	}
	
	/**
	 * Called when the user presses a key while the dialog is waiting for input
	 * 
	 * @param key The key code of the key which was pressed
	 */
	public void keyInput(int key) {
		if(key > 0)
			waitingButton.setLabel(KeyEvent.getKeyText(key));
		else
			waitingButton.setLabel("");
		if(waitingButton.equals(bPlayer1Up))
			player1KeyCodeUp = key;
		else if(waitingButton.equals(bPlayer1Down))
			player1KeyCodeDown = key;
		else if(waitingButton.equals(bPlayer2Up))
			player2KeyCodeUp = key;
		else if(waitingButton.equals(bPlayer2Down))
			player2KeyCodeDown = key;		
		waitingButton = null;
	}
	
	/**
	 * Saves the new values into the instance of Configuration
	 */
	private void save() {
		Configuration c = Configuration.instance();
		c.setPlayer1Name(tfPlayer1Name.getText());
		c.setPlayer1Mouse(cbPlayer1Mouse.getState());
		c.setPlayer1KeyUp(player1KeyCodeUp);
		c.setPlayer1KeyDown(player1KeyCodeDown);
		c.setPlayer2Name(tfPlayer2Name.getText());
		c.setPlayer2Mouse(cbPlayer2Mouse.getState());
		c.setPlayer2KeyUp(player2KeyCodeUp);
		c.setPlayer2KeyDown(player2KeyCodeDown);
	}
	
	/**
	 * Loads the values of Configuration into the gui elements
	 */
	private void load() {
		Configuration c = Configuration.instance();
		tfPlayer1Name.setText(c.getPlayer1Name());
		cbPlayer1Mouse.setState(c.getPlayer1Mouse());
		player1KeyCodeUp = c.getPlayer1KeyUp();
		if(player1KeyCodeUp > 0)
			bPlayer1Up.setLabel(KeyEvent.getKeyText(player1KeyCodeUp));
		player1KeyCodeDown = c.getPlayer1KeyDown();
		if(player1KeyCodeDown > 0)
			bPlayer1Down.setLabel(KeyEvent.getKeyText(player1KeyCodeDown));
		player2KeyCodeUp = c.getPlayer2KeyUp();
		if(player2KeyCodeUp > 0)
			bPlayer2Up.setLabel(KeyEvent.getKeyText(player2KeyCodeUp));
		player2KeyCodeDown = c.getPlayer2KeyDown();
		if(player2KeyCodeDown > 0)
			bPlayer2Down.setLabel(KeyEvent.getKeyText(player2KeyCodeDown));
		tfPlayer2Name.setText(c.getPlayer2Name());
		cbPlayer2Mouse.setState(c.getPlayer2Mouse());
	}
}
