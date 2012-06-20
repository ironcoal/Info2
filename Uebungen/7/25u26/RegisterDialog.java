

import java.awt.Button;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegisterDialog extends Dialog implements ActionListener {
	private static final long serialVersionUID = 8239409087862529871L;
	private TextField tfUser, tfPassword;
	private Button bOK, bAbort;
	public RegisterDialog(Dialog owner) {
		super(owner);
		setModalityType(ModalityType.APPLICATION_MODAL);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setLayout(new GridLayout(3,2));
		Label lUser = new Label("User Name:");
		add(lUser);
		tfUser = new TextField(20);
		add(tfUser);
		Label lPassword = new Label("Passwort:");
		add(lPassword);
		tfPassword = new TextField(20);
		tfPassword.setEchoChar('*');
		add(tfPassword);
		bOK = new Button("OK");
		bOK.addActionListener(this);
		add(bOK);
		bAbort = new Button("Abbrechen");
		bAbort.addActionListener(this);
		add(bAbort);
		
		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bOK)) {
			doCreateUser();
		} else if(e.getSource().equals(bAbort)) {
			dispose();
		}
	}
	private void doCreateUser() {
		Online o = Online.instance();
		if(o.addUser(tfUser.getText(), tfPassword.getText())) {
			dispose();
		} else {
			new WarnDialog(this, "Fehler beim Anlegen des Benutzers");
		}
	}
}
