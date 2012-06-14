import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Fenster extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private TextField sendungsnummer;
	private Choice gewichtsklasse;
	private Choice status;
	private TextField statusleiste;
	private List liste;

	private PaketeContainer container;
	private Paket subject;

	public Fenster() {

		super("Paketverwaltung");

		container = PaketeContainer.instance();

		Button n = new Button("Neu");
		n.addActionListener(this);
		Label s = new Label("Sendungsnummer: ");
		Label g = new Label("Gewichtsklasse: ");
		Label t = new Label("Status: ");

		Panel oben = new Panel();
		oben.setLayout(new GridLayout(0, 4));

		Panel pv = new Panel();
		pv.add(s);
		sendungsnummer = new TextField(12);
		pv.add(sendungsnummer);

		Panel pn = new Panel();
		pn.add(g);
		gewichtsklasse = new Choice();
		gewichtsklasse.addItem("");
		gewichtsklasse.addItem("1");
		gewichtsklasse.addItem("2");
		gewichtsklasse.addItem("3");
		pn.add(gewichtsklasse);

		Panel pm = new Panel();
		pm.add(t);
		status = new Choice();
		status.addItem("");
		status.addItem("im Versandlager");
		status.addItem("auf Fahrzeug 1");
		status.addItem("auf Fahrzeug 2");
		status.addItem("auf Fahrzeug 3");
		pm.add(status);

		oben.add(n);
		oben.add(pv);
		oben.add(pn);
		oben.add(pm);

		Button a = new Button("Anlegen");
		a.addActionListener(this);
		oben.add(a);

		Button b = new Button("Auswaehlen");
		b.addActionListener(this);
		oben.add(b);

		Button c = new Button("Aendern");
		c.addActionListener(this);
		oben.add(c);

		Button d = new Button("Loeschen");
		d.addActionListener(this);
		oben.add(d);

		liste = new List();
		liste.addActionListener(this);

		statusleiste = new TextField();

		aktualisiereListe();

		setLayout(new BorderLayout());

		add(oben, BorderLayout.NORTH);
		add(liste, BorderLayout.CENTER);
		add(statusleiste, BorderLayout.SOUTH);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});

		sendungsnummer.setEnabled(false);
		gewichtsklasse.setEnabled(false);
		status.setEnabled(false);
		pack();
		setVisible(true);
	}

	public void save() {
		subject.setSendungsnummer(sendungsnummer.getText());
		subject.setGewichtsklasse(Integer.parseInt(gewichtsklasse
				.getSelectedItem()));
		subject.setStatus(status.getSelectedItem());
	}

	public void aktualisiereListe() {
		liste.removeAll();
		for (Paket p : container)
			liste.add(p.toString());
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Neu")) {
			sendungsnummer.setEnabled(true);
			gewichtsklasse.setEnabled(true);
			status.setEnabled(true);
			sendungsnummer.setText("");
			gewichtsklasse.select(0);
			status.select(0);
			statusleiste.setText("Neues Paket anlegen");
		}
		if (e.getActionCommand().equals("Anlegen")) {
			if (!sendungsnummer.getText().equals("")
					&& !(gewichtsklasse.getSelectedIndex() == 0)
					&& !(status.getSelectedIndex() == 0)) {
				boolean isSame = false;
				for (Paket p : container)
					if (p.getSendungsnummer().equals(sendungsnummer.getText()))
						isSame = true;
				if (!isSame) {
					subject = new Paket(sendungsnummer.getText());
					subject.setGewichtsklasse(gewichtsklasse.getSelectedIndex());
					subject.setStatus(status.getSelectedItem());
					save();
					container.addPaket(subject);
					sendungsnummer.setText("");
					gewichtsklasse.select(0);
					status.select(0);
					sendungsnummer.setEnabled(false);
					gewichtsklasse.setEnabled(false);
					status.setEnabled(false);
					aktualisiereListe();
					statusleiste.setText("Sendung "
							+ subject.getSendungsnummer() + " abgespeichert");
				} else
					statusleiste.setText("Sendungsnummer bereits vergeben");
			}
			else {
				statusleiste.setText("Felder nicht alle ausgefuellt");
			}
		}
		if (e.getActionCommand().equals("Auswaehlen")
				|| e.getSource().equals(liste)) {
			if (liste.getSelectedItem() != null) {
				subject = container.getPaket(liste.getSelectedIndex());
				sendungsnummer.setText(subject.getSendungsnummer());
				sendungsnummer.setEnabled(false);
				gewichtsklasse.setEnabled(true);
				status.setEnabled(true);
				gewichtsklasse.select(Integer.toString(subject
						.getGewichtsklasse()));
				status.select(subject.getStatus());
				statusleiste.setText("Sendung " + subject.getSendungsnummer()
						+ " ausgewaehlt");
			} else
				statusleiste.setText("Keine Sendung ausgewaehlt");
		}
		if (e.getActionCommand().equals("Aendern")) {
			if (!sendungsnummer.getText().equals("")
					&& !(gewichtsklasse.getSelectedIndex() == 0)
					&& !(status.getSelectedIndex() == 0)) {
				for (Paket p : container) {
					if (p.getSendungsnummer().equals(sendungsnummer.getText())) {
						subject = p;
						p.setGewichtsklasse(gewichtsklasse.getSelectedIndex());
						p.setStatus(status.getSelectedItem());
						save();
						container.modifyPaket(subject);
						sendungsnummer.setEnabled(true);
						sendungsnummer.setText("");
						gewichtsklasse.select(0);
						status.select(0);
						sendungsnummer.setEnabled(false);
						gewichtsklasse.setEnabled(false);
						status.setEnabled(false);
						aktualisiereListe();
						statusleiste.setText("Sendung wurde geaendert");
						break;
					}
				}
				if (subject == null) {
					statusleiste.setText("Sendung nicht vorhanden");
				}
			} else {
				statusleiste.setText("Keine Sendung ausgewaehlt");
			}
		}
		if (e.getActionCommand().equals("Loeschen")) {
			if (!sendungsnummer.getText().equals("")) {
				for (Paket p : container) {
					if (p.getSendungsnummer().equals(sendungsnummer.getText())) {
						subject = p;
						container.deletePaket(p);
						sendungsnummer.setText("");
						gewichtsklasse.select(0);
						status.select(0);
						sendungsnummer.setEnabled(false);
						gewichtsklasse.setEnabled(false);
						status.setEnabled(false);
						aktualisiereListe();
						statusleiste.setText("Sendung "
								+ subject.getSendungsnummer() + " geloescht");
						break;
					}
				}
			} else {
				statusleiste.setText("Keine Sendung ausgewaehlt");
			}
		}
	}
}
