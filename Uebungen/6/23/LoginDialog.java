

import java.awt.Button;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import com.mysql.jdbc.Driver;

public class LoginDialog extends Dialog implements ActionListener {
	private static final long serialVersionUID = 1702083272480108081L;

	//Luecke 02: Deklaration eines Attributs fuer eine Datenbankverbindung
	private Connection c;
	private TextField tfUser, tfPassword;
	private Button bLogin, bRegister;
	public LoginDialog(Frame owner) {
		super(owner, "Login");
		setModalityType(ModalityType.APPLICATION_MODAL);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = 1;
		Label lUser = new Label("User Name:");
		layout.setConstraints(lUser, constraints);
		add(lUser);
		tfUser = new TextField(20);
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(tfUser, constraints);
		add(tfUser);
		Label lPassword = new Label("Passwort:");
		constraints.gridwidth = 1;
		layout.setConstraints(lPassword, constraints);
		add(lPassword);
		tfPassword = new TextField(20);
		tfPassword.setEchoChar('*');
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(tfPassword, constraints);
		add(tfPassword);
		bLogin = new Button("Login");
		bLogin.addActionListener(this);
		layout.setConstraints(bLogin, constraints);
		add(bLogin);
		Panel spacer = new Panel();
		spacer.setPreferredSize(new Dimension(0, 30));
		layout.setConstraints(spacer, constraints);
		add(spacer);
		bRegister = new Button("Neu? Jetzt registrieren");
		bRegister.addActionListener(this);
		layout.setConstraints(bRegister, constraints);
		add(bRegister);
		
		//Luecke 03: Holen einer Datenbankverbindung ueber den Datenbanktreiber
		//mit vorgegebener Serveradresse, Datenbank, Benutzernamen und Passwort
		//Zuweisung dieser Datenbankverbindung
		//Im Fehlerfall einen Warndialog mit geeigneter Fehlermeldung ausgeben
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.c = DriverManager.getConnection("jdbc:mysql://aiomr.informatik.uni-augsburg.de:3306/pong","user","password");
		} catch (Exception e) {
			new WarnDialog(this, e.getMessage());
		}

		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bLogin)) {
			//Luecke 04: Aufruf der Login-Methode von Luecke 05 mit eingegebenen
			//Anmeldedaten und bei Erfolg Schliessen dieses Dialogfensters
			//Im Fehlerfall Ausgabe eines Warndialogs mit geeigneter Fehlermeldung
			if (logIn(tfUser.getText(), tfPassword.getText())) {
				dispose();
			} else {
				new WarnDialog(this, "Problem beim Login-Vorgang!");
			}
		} else if(e.getSource().equals(bRegister)) {
			new RegisterDialog(this);
		}
	}
		
	//Luecke 05: Implementierung einer oeffentlich zugaenglichen Login-Methode mit
	//zwei Zeichenketten als Eingabeparameter und einem Wahrheitswert als Rueckgabewert.
	//In den beiden Zeichenketten sind die Anmeldedaten (Benutzername, Passwort) enthalten.
	//In der Login-Methode soll mit einer geeigneten Datenbankabfrage ueberpruft werden,
	//ob die eingegebenen Anmeldedaten in der Datenbank vorhanden sind. Wenn dies der
	//Fall ist, soll der Benutzername von Spieler 1 auf den eingegebenen Benutzernamen
	//gesetzt (in der Klasse Configuration) und "wahr" zurueckgegeben werden.
	//In allen anderen Faellen sowie bei Fehlern (z.B. auch wenn der Verbindungsaufbau
	//in Luecke 03 nicht geklappt hat) soll "falsch" zurueckgegeben werden.
	public boolean logIn(String user, String password) {

      	try {
      		Statement abfrage = c.createStatement();
	      	String befehl = "SELECT * FROM Users WHERE username = '" + user + "' AND password = '" + password + "'";
	      	ResultSet ergebnis = abfrage.executeQuery(befehl);
	    
	      	if (ergebnis.next()) {
	      		Configuration.instance().setPlayer1Name(user);
	      		return true;
	      	}
	      	new WarnDialog(this, "Nutzer nicht vorhanden!");
	      	return false;
	    } catch (Exception e) {
	    	new WarnDialog(this, "Fehler bei der Datenbankverbindung!");
	    	return false;
	    }

      
	}


	//Luecke 06: Implementierung einer oeffentlich zugaenglichen BenutzerAnlegen-Methode mit
	//zwei Zeichenketten als Eingabeparameter und einem Wahrheitswert als Rueckgabewert.
	//In den beiden Zeichenketten sind die Anmeldedaten (Benutzername, Passwort) enthalten.
	//In der BenutzerAnlegen-Methode soll mit einer geeigneten Datenbankabfrage ueberpruft werden,
	//ob die eingegebene Benutzername bereits in der Datenbank vorhanden ist. Wenn dies nicht der
	//Fall ist, sollen die ubergebenen Anmeldedaten als neuer Eintrag in Datenbank eingefuegt
	//und "wahr" zurueckgegeben werden.
	//In allen anderen Faellen sowie bei Fehlern (z.B. auch wenn der Verbindungsaufbau
	//in Luecke 03 nicht geklappt hat) soll "falsch" zurueckgegeben werden.
	public boolean addUser(String user, String password) {
		try {
			Statement abfrage = c.createStatement();
	      	String befehl = "select * from Users where " + 
                "username = '" + user + "' and " +
                "password = '" + password + "'";
	      	ResultSet ergebnis = abfrage.executeQuery(befehl);
	    	
	      	if (!ergebnis.next()) {
	      		befehl = "insert into Users values (0,'" + user + "','"+ password + "')";
		        abfrage.executeUpdate(befehl);
		        return true;
	      	} else {
	      		new WarnDialog(this, "Eintrag schon vorhanden!");
	      		return false;
	      	}
	    } catch (Exception e) {
	    	System.out.print("blub");
	    	new WarnDialog(this, "Fehler bei der Datenbankverbindung");
	    	return false;
	    }

	}

}
