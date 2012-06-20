import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
import java.util.Iterator;

public class Grundstueckverwaltung extends Frame implements ActionListener, Observer {
	public static final long serialVersionUID = 1L;
	Button b_g_anl, b_g_aen, b_g_loe, b_e_anl, b_e_aen, b_e_loe;
	List l_g, l_e;

	public Grundstueckverwaltung() {
		super("Grundstueckverwaltung");
		setLayout(new GridLayout(0,1));
		Panel p_g = new Panel(new BorderLayout());
		Panel p_e = new Panel(new BorderLayout());
		Panel p_g_b = new Panel(new FlowLayout());
		Panel p_e_b = new Panel(new FlowLayout());
		
		p_g.add(new Label("Grundstuecke"), BorderLayout.NORTH);
		l_g = new List();
		p_g.add(l_g, BorderLayout.CENTER);

		b_g_anl = new Button("Grundstuecke anlegen");
		b_g_aen = new Button("Grundstuecke aendern");
		b_g_loe = new Button("Grundstuecke loeschen");
		p_g_b.add(b_g_anl);
		p_g_b.add(b_g_aen);
		p_g_b.add(b_g_loe);
		p_g.add(p_g_b, BorderLayout.SOUTH);

		add(p_g);

		p_e.add(new Label("Eigentuemer"), BorderLayout.NORTH);
		l_e = new List();
		p_e.add(l_e, BorderLayout.CENTER);

		b_e_anl = new Button("Eigentuemer anlegen");
		b_e_aen = new Button("Eigentuemer aendern");
		b_e_loe = new Button("Eigentuemer loeschen");
		p_e_b.add(b_e_anl);
		p_e_b.add(b_e_aen);
		p_e_b.add(b_e_loe);
		p_e.add(p_e_b, BorderLayout.SOUTH);
		
		add(p_e);

		b_g_anl.addActionListener(this);
		b_g_aen.addActionListener(this);
		b_g_loe.addActionListener(this);
		b_e_anl.addActionListener(this);
		b_e_aen.addActionListener(this);
		b_e_loe.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		GrundstueckContainer.instance().addObserver(this);
		EigentuemerContainer.instance().addObserver(this);
		
		aktualisieren();

		setSize(600,300);
		setLocation(200,200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if (o.equals(b_g_anl)) {
			Grundstueck g = this.getGrundstueck();
			new GrAnlegenDialog(this, g);
		} else if (o.equals(b_g_aen)) {
			Grundstueck g = this.getGrundstueck();
			if (g != null)
				new GrAendernDialog(this, g);
		} else if (o.equals(b_g_loe)) {
			Grundstueck g = this.getGrundstueck();
			if (g != null)
				GrundstueckContainer.instance().removeGrundstueck(g);
		} else if (o.equals(b_e_anl)) {
			Eigentuemer e = this.getEigentuemer();
			new EigAnlegenDialog(this, e);
		} else if (o.equals(b_e_aen)) {
			Eigentuemer e = this.getEigentuemer();
			if (e != null)
				new EigAendernDialog(this, e);
		} else if (o.equals(b_e_loe)) {
			Eigentuemer e = this.getEigentuemer();
			if (e != null)
				EigentuemerContainer.instance().removeEigentuemer(e);
		}
	}

	public Eigentuemer getEigentuemer() {
		if (l_e.getItemCount() == 0 || l_e.getSelectedIndex() == -1)
			return null;
		else
			return EigentuemerContainer.instance().getEigentuemer(l_e.getSelectedIndex());
	}
	public Grundstueck getGrundstueck() {
		if (l_g.getItemCount() == 0 || l_g.getSelectedIndex() == -1)
			return null;
		else
			return GrundstueckContainer.instance().getGrundstueck(l_g.getSelectedIndex());
	}

	public void update(Observable obs, Object o) {
		aktualisieren();
	}

	public void aktualisieren() {
		l_g.removeAll();
		l_e.removeAll();
		for (Grundstueck g: GrundstueckContainer.instance())
			l_g.add(g.toString());
		for (Eigentuemer e: EigentuemerContainer.instance())
			l_e.add(e.toString());
	}
}