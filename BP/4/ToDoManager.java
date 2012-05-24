import java.awt.*;
import java.awt.event.*;

public class ToDoManager extends Frame implements AdjustmentListener, ActionListener {
	private Aufgaben aufgaben;
	private TextField beschreibung;
	private Label prioritaet;
	private Scrollbar schieber;

	public ToDoManager() {
		super("Todo-List");
		aufgaben = Aufgaben.instance();
		setLayout(new GridLayout(3, 2, 5, 5));
		add(new Label("Beschreibung:"));
		beschreibung = new TextField(40);
		add(beschreibung);

		prioritaet = new Label("Priorität: 0");
		add(prioritaet);
		schieber = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 6);
		add(schieber);
		Button eintragen = new Button("eintragen");
		add(eintragen);
		Button aufgabe = new Button("Aufgabe!!!");
		add(aufgabe);

		eintragen.addActionListener(this);
		aufgabe.addActionListener(this);
		schieber.addAdjustmentListener(this);


		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
				System.exit(0);
			}
		});

		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("eintragen"))
		{
		aufgaben.addAufgabe(new Aufgabe(beschreibung.getText(),
		schieber.getValue()));
		beschreibung.setText("");
		schieber.setValue(0);
		prioritaet.setText("Priorität: 0");
		}
		else new TopAufgabe(this, aufgaben.popAufgabe());
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		prioritaet.setText("Priorität: " + e.getValue());
	}

	public static void main(String[] args)
	{
	new ToDoManager();
	}


}