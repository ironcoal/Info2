

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


public class LoginDialog extends Dialog implements ActionListener {
	private static final long serialVersionUID = 1702083272480108081L;
	private Online onlinecon = Online.instance();
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
		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bLogin)) {
			if (onlinecon.logIn(tfUser.getText(), tfPassword.getText())) {
				dispose();
			} else {
				new WarnDialog(this, "Problem beim Login-Vorgang!");
			}
		} else if(e.getSource().equals(bRegister)) {
			new RegisterDialog(this);
		}
	}
}
