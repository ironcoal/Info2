import java.awt.*;
import java.awt.event.*;

public class GrAnlegenDialog extends Dialog implements ActionListener {
	public static final long serialVersionUID = 1L;
	private TextField tfLage, tfFlaeche;
	private Button bAnlegen, bSchliessen;

	public GrAnlegenDialog(Frame ow, Grundstueck g) {
		super(ow, "Grundstueck anlegen", true);
		setLayout(new BorderLayout());

		tfLage = new TextField(20);
		tfFlaeche = new TextField(10);

		bAnlegen = new Button("Anlegen");
		bSchliessen = new Button("Schliessen");

		Panel top = new Panel(new FlowLayout());
		top.add(new Label("Lage: "));
		top.add(tfLage);
		add(top, BorderLayout.NORTH);

		Panel mid = new Panel(new FlowLayout());
		mid.add(new Label("Flaeche: "));
		mid.add(tfFlaeche);
		add(mid, BorderLayout.CENTER);

		Panel down = new Panel(new FlowLayout());
		down.add(bAnlegen);
		down.add(bSchliessen);
		add(down, BorderLayout.SOUTH);

		bAnlegen.addActionListener(this);
		bSchliessen.addActionListener(this);
		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Schliessen"))
			dispose();
		else {
			if (tfLage.getText().equals(""))
				tfLage.setText("Bitte ausfuellen");
			else if (tfFlaeche.getText().equals(""))
				tfFlaeche.setText("Bitte ausfuellen");
			else {
				Grundstueck g = new Grundstueck(tfLage.getText(), tfFlaeche.getText());
				GrundstueckContainer.instance().addGrundstueck(g);
				dispose();
			}
		}
	}
}