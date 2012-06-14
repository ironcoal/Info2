package m05.d23;

import java.awt.*;
import java.awt.event.*;

public class ToDoManager extends Frame
                         implements AdjustmentListener,
                                    ActionListener
{
    static final long serialVersionUID = 0;

    private Aufgaben aufgaben;

    private TextField beschreibungTF;
    private Scrollbar prioritaetSB;
    private Label     prioritaetL;

    public ToDoManager()
    {
        super("Odot");

        aufgaben = Aufgaben.instance();

        Button eintragenB    = new Button("eintragen"),
               aufgabeB      = new Button("Aufgabe!!!");
        Label  beschreibungL = new Label("Beschreibung: ");

        beschreibungTF = new TextField(15);
        prioritaetSB   = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 6);
        prioritaetL    = new Label("Prioritaet: 0");

        this.setLayout(new GridLayout(3, 2, 5, 5));

        this.add(beschreibungL);
        this.add(beschreibungTF);
        this.add(prioritaetL);
        this.add(prioritaetSB);
        this.add(eintragenB);
        this.add(aufgabeB);

        prioritaetSB.addAdjustmentListener(this);
        eintragenB.addActionListener(this);
        aufgabeB.addActionListener(this);

        this.setPreferredSize(new Dimension(750, 150));

        this.pack();
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                dispose();
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("eintragen")) {
            aufgaben.addAufgabe(new Aufgabe(beschreibungTF.getText(), prioritaetSB.getValue()));
            beschreibungTF.setText("");
            prioritaetSB.setValue(0);
        }
        else if (e.getActionCommand().equals("Aufgabe!!!")) {
            new TopAufgabe(this, aufgaben.popAufgabe());
        }
    }

    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        prioritaetL.setText("Prioritaet: " + prioritaetSB.getValue());
    }
}
