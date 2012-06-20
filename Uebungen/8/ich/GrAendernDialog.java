import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;

public class GrAendernDialog extends Dialog implements ActionListener, Observer {
	public static final long serialVersionUID = 1L;
	private TextField tfLage, tfFlaeche;
	private Button bHinzufuegen, bLoeschen, bAendern, bSchliessen;
	private Choice cEigentuemer;
	private Label lEigentuemer;
	Grundstueck gr;


	public GrAendernDialog(Frame ow, Grundstueck g) {
		super(ow, "Grundstueck aendern", false);
		setLayout(new GridLayout(0,1,10,10));
		gr = g;

		tfLage = new TextField(g.getLage(), 20);
		tfFlaeche = new TextField(g.getFlaeche(), 10);

		bHinzufuegen = new Button("Hinzufuegen");
		bSchliessen = new Button("Schliessen");
		bLoeschen = new Button("Loeschen");
		bAendern = new Button("Aendern");

		Panel pLage = new Panel(new FlowLayout());
		pLage.add(new Label("Lage: "));
		pLage.add(tfLage);
		add(pLage);

		Panel pFlaeche = new Panel(new FlowLayout());
		pFlaeche.add(new Label("Flaeche: "));
		pFlaeche.add(tfFlaeche);
		add(pFlaeche);

		cEigentuemer = new Choice();
		add(cEigentuemer);

		lEigentuemer = new Label();
		add(lEigentuemer);

		Panel pButtons = new Panel(new FlowLayout());
		pButtons.add(bHinzufuegen);
		pButtons.add(bLoeschen);
		pButtons.add(bAendern);
		pButtons.add(bSchliessen);
		
		add(pButtons);

		GrundstueckContainer.instance().addObserver(this);

		bHinzufuegen.addActionListener(this);
		bLoeschen.addActionListener(this);
		bAendern.addActionListener(this);
		bSchliessen.addActionListener(this);

		gr.addObserver(this);

		aktualisieren();
		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Schliessen"))
			dispose();
		else if (s.equals("Hinzufuegen")) {
			gr.linkEigentuemer(getEigentuemerAuswahl());
		}
	}

	public void aktualisieren() {
		cEigentuemer.removeAll();
		for (Eigentuemer e: EigentuemerContainer.instance()) {
			cEigentuemer.add(e.getName() + " (geb. " + e.getGeburtsdatum() + ")");
		}
		Eigentuemer eig = gr.getLinkEigentuemer();
		if (eig != null) {
			String name = eig.getName();
			lEigentuemer.setText("Eigentuemer: " + name);
		} else {
			lEigentuemer.setText("Eigentuemer: (kein Eigentuemer)");
		}
	}

	public void update(Observable obs, Object o) {
		aktualisieren();
	}

	public Eigentuemer getEigentuemerAuswahl() {
		int index = cEigentuemer.getSelectedIndex();
		return EigentuemerContainer.instance().getEigentuemer(index);
	}
}