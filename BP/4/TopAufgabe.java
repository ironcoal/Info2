import java.awt.*;
import java.awt.event.*;


public class TopAufgabe extends Dialog implements ActionListener
{
	public TopAufgabe(Frame owner, Aufgabe aufgabe)
	{
		super(owner, "Aufgabe!!!", true);
		setLayout(new GridLayout(2, 1, 5, 5));
		if (aufgabe != null) add(new Label(aufgabe.getBeschreibung()));
		else add(new Label("Nichts zu tun!"));
		Button erledigt;
		if (aufgabe != null) erledigt = new Button("Erledigt!");
		else erledigt = new Button("Juhu!");
		add(erledigt);
		erledigt.addActionListener(this);

		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		dispose();
	}
}

