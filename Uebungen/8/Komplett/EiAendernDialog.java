import java.awt.*;
import java.awt.event.*;

public class EiAendernDialog extends Dialog implements ActionListener
{
    private Eigentuemer eigentuemer;

    private TextField nameTF,
                      geburtsdatumTF;

    private Choice grC;

    private List grL;

    public EiAendernDialog(Frame owner, Eigentuemer e)
    {
        super(owner, "Eigentuemer aendern");

        this.nameTF         = new TextField(20);
        this.geburtsdatumTF = new TextField(10);
        this.grC            = new Choice();
        this.grL            = new List(7);

        Panel[] panel = new Panel[5];

        for (int i = 0; i < 5; i++) {
            panel[i] = new Panel();
            panel[i].setLayout(new FlowLayout(FlowLayout.LEFT));
        }

        panel[3].setLayout(new BorderLayout());
        panel[4].setLayout(new FlowLayout(FlowLayout.CENTER));

        Label nameL         = new Label("Name:");
        Label geburtsdatumL     = new Label("Geburtsdatum:");

        Button[] buttons = new Button[4];

        for (int i = 0; i < 4; i++) {
            buttons[i] = new Button();
            buttons[i].addActionListener(this);
        }

        buttons[0].setLabel("Hinzufuegen");
        buttons[1].setLabel("Loeschen");
        buttons[2].setLabel("Aendern");
        buttons[3].setLabel("Schliessen");

        panel[0].add(nameL);
        panel[0].add(this.nameTF);

        panel[1].add(geburtsdatumL);
        panel[1].add(this.geburtsdatumTF);

        panel[2].add(grC);

        panel[3].add(grL, BorderLayout.CENTER);

        for (int i = 0; i < 4; i++) {
            panel[4].add(buttons[i]);
        }

        this.setLayout(new GridLayout(2, 1, 0, 0));

        Panel outer1P = new Panel();
        outer1P.setLayout(new GridLayout(2, 1, 0, 0));
        outer1P.add(panel[0]);
        outer1P.add(panel[1]);

        Panel outer2P = new Panel();
        outer2P.setLayout(new BorderLayout());
        outer2P.add(panel[2], BorderLayout.NORTH);
        outer2P.add(panel[3], BorderLayout.CENTER);
        outer2P.add(panel[4], BorderLayout.SOUTH);

        this.add(outer1P);
        this.add(outer2P);

        this.eigentuemer = e;

        this.setPreferredSize(new Dimension(450, 300));

        loadEigentuemer();
        aktualisieren();

        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Schliessen")) {
            dispose();
        }
        else if (e.getActionCommand().equals("Hinzufuegen")) {
            this.eigentuemer.linkGrundstueck(this.getGrundstueckAuswahl());
            this.aktualisieren();
        }
        else if (e.getActionCommand().equals("Loeschen")) {
            this.eigentuemer.unlinkGrundstueck(this.getGrundstueckListe());
            this.aktualisieren();
        }
        else if (e.getActionCommand().equals("Aendern")) {
            this.eigentuemer.setName(this.nameTF.getText());
            this.eigentuemer.setGeburtsdatum(this.geburtsdatumTF.getText());
            ((Grundstueckverwaltung) this.getOwner()).aktualisieren();
            dispose();
        }
    }

    private void loadEigentuemer()
    {
        this.nameTF.setText(this.eigentuemer.getName());
        this.geburtsdatumTF.setText(this.eigentuemer.getGeburtsdatum());
    }

    public void aktualisieren()
    {
        this.grC.removeAll();
        this.grL.removeAll();
        for (Grundstueck g: GrundstueckContainer.instance()) {
            if (eigentuemer.getLinkGrundstuecke().contains(g))
                this.grL.add(g.toString());
            else {
                this.grC.add(g.toString());
            }
        }
    }

    public Grundstueck getGrundstueckAuswahl()
    {
        for (Grundstueck g: GrundstueckContainer.instance()) {
            if (g.toString().equals(grC.getSelectedItem()))
                return g;
        }
        return null;
    }

    public Grundstueck getGrundstueckListe()
    {

        for (Grundstueck g: GrundstueckContainer.instance()) {
            if (g.toString().equals(grL.getSelectedItem()))
                return g;
        }
        return null;
    }
}
