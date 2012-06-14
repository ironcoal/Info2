package m05.d23;

import java.awt.*;
import java.awt.event.*;

public class TopAufgabe extends Dialog
                        implements ActionListener
{
    static final long serialVersionUID = 0;

    public TopAufgabe(Frame owner, Aufgabe aufgabe)
    {
        super(owner, "Aufgabe!!!", true);

        this.setLayout(new GridLayout(2, 1, 5, 5));

        if (aufgabe != null)
            this.add(new Label(aufgabe.getBeschreibung()));
        else
            this.add(new Label("Nichts zu tun!"));

        Button erledigt;

        if (aufgabe != null)
            erledigt = new Button("Erledigt!");
        else
            erledigt = new Button("Juhu!");

        this.add(erledigt);

        this.setLocation(600, 300);

        erledigt.addActionListener(this);

        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        dispose();
    }
}
