import java.awt.*;
import java.awt.event.*;

public class EigAnlegenDialog extends Dialog implements ActionListener {
	public static final long serialVersionUID = 1L;
	private TextField tfName, tfGeburtsdatum;
	private Button bAnlegen, bSchliessen;

	public EigAnlegenDialog(Frame ow, Eigentuemer g) {
		super(ow, "Eigentuemer anlegen", true);
		setLayout(new BorderLayout());

		tfName = new TextField(20);
		tfGeburtsdatum = new TextField(10);

		bAnlegen = new Button("Anlegen");
		bSchliessen = new Button("Schliessen");

		Panel top = new Panel(new FlowLayout());
		top.add(new Label("Name: "));
		top.add(tfName);
		add(top, BorderLayout.NORTH);

		Panel mid = new Panel(new FlowLayout());
		mid.add(new Label("Geburtsdatum: "));
		mid.add(tfGeburtsdatum);
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
			if (tfName.getText().equals(""))
				tfName.setText("Bitte ausfuellen");
			else if (tfGeburtsdatum.getText().equals(""))
				tfGeburtsdatum.setText("Bitte ausfuellen");
			else {
				Eigentuemer eig = new Eigentuemer(tfName.getText(), tfGeburtsdatum.getText());
				EigentuemerContainer.instance().addEigentuemer(eig);
				dispose();
			}
		}
	}
}