import java.awt.*;
import java.awt.event.*;

public class GrAendernDialog extends Dialog implements ActionListener
{
    private Grundstueck grundstueck;

    private TextField lageTF,
                      flaecheTF;

    private Choice eiC;

    private Label eiL;

    public GrAendernDialog(Frame owner, Grundstueck g)
    {
        super(owner, "Grundstueck aendern");

        this.lageTF    = new TextField(20);
        this.flaecheTF = new TextField(10);
        this.eiC       = new Choice();
        this.eiL       = new Label("                                                            ");

        Panel[] panel = new Panel[5];

        for (int i = 0; i < 5; i++) {
            panel[i] = new Panel();
            panel[i].setLayout(new FlowLayout(FlowLayout.LEFT));
        }

        Label lageL        = new Label("Lage:");
        Label flaecheL     = new Label("Flaeche:");
        Label eigentuemerL = new Label("Eigentuemer:");

        Button[] buttons = new Button[4];

        for (int i = 0; i < 4; i++) {
            buttons[i] = new Button();
            buttons[i].addActionListener(this);
        }

        buttons[0].setLabel("Hinzufuegen");
        buttons[1].setLabel("Loeschen");
        buttons[2].setLabel("Aendern");
        buttons[3].setLabel("Schliessen");

        panel[0].add(lageL);
        panel[0].add(this.lageTF);

        panel[1].add(flaecheL);
        panel[1].add(this.flaecheTF);

        /* this.eiC.setSize(300, 10); */
        panel[2].add(eiC);

        panel[3].add(eigentuemerL);
        panel[3].add(eiL);

        for (int i = 0; i < 4; i++) {
            panel[4].add(buttons[i]);
        }

        this.setLayout(new GridLayout(5, 1, 5, 0));

        for (int i = 0; i < 5; i++) {
            this.add(panel[i]);
        }

        this.grundstueck = g;

        this.setPreferredSize(new Dimension(350, 150));

        loadGrundstueck();
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
            this.grundstueck.linkEigentuemer(this.getEigentuemerAuswahl());
            this.aktualisieren();
        }
        else if (e.getActionCommand().equals("Loeschen")) {
            this.grundstueck.unlinkEigentuemer();
            this.aktualisieren();
        }
        else if (e.getActionCommand().equals("Aendern")) {
            this.grundstueck.setLage(this.lageTF.getText());
            this.grundstueck.setFlaeche(this.flaecheTF.getText());
            ((Grundstueckverwaltung) this.getOwner()).aktualisieren();
            dispose();
        }
    }

    private void loadGrundstueck()
    {
        this.lageTF.setText(this.grundstueck.getLage());
        this.flaecheTF.setText(this.grundstueck.getFlaeche());
    }

    public void aktualisieren()
    {
        this.eiC.removeAll();
        this.eiL.setText("                                                            ");
        for (Eigentuemer e: EigentuemerContainer.instance()) {
            if (this.grundstueck.getLinkEigentuemer() == null || !this.grundstueck.getLinkEigentuemer().equals(e))
                this.eiC.add(e.toString());
            else {
                this.eiL.setText(e.toString());
            }
        }
    }

    public Eigentuemer getEigentuemerAuswahl()
    {
        for (Eigentuemer e: EigentuemerContainer.instance())
            if (e.toString().equals(eiC.getSelectedItem()))
                return e;
            else
                return null;
        return null;
    }
}
