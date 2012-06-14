import java.awt.*;
import java.awt.event.*;

public class Grundstueckverwaltung extends Frame implements ActionListener
{
    private List grundstueckList,
                 eigentuemerList;

    public Grundstueckverwaltung()
    {
        super("Grundstueckverwaltung");

        this.grundstueckList = new List(5);
        this.eigentuemerList = new List(5);

        Label grundstueckeL = new Label("Grundstuecke"),
              eigentuemerL  = new Label("Eigentuemer");

        Button grAnlegenB  = new Button("Grundstueck anlegen"),
               grAendernB  = new Button("Grundstueck aendern"),
               grLoeschenB = new Button("Grundstueck loeschen"),
               eiAnlegenB  = new Button("Eigentuemer anlegen"),
               eiAendernB  = new Button("Eigentuemer aendern"),
               eiLoeschenB = new Button("Eigentuemer loeschen");

        Panel oberesP         = new Panel(),
              unteresP        = new Panel(),
              oberesUnteresP  = new Panel(),
              unteresUnteresP = new Panel();

        oberesUnteresP.setLayout(new FlowLayout());
        unteresUnteresP.setLayout(new FlowLayout());
        oberesP.setLayout(new BorderLayout());
        unteresP.setLayout(new BorderLayout());
        this.setLayout(new GridLayout(2, 1, 5, 5));

        oberesUnteresP.add(grAnlegenB);
        oberesUnteresP.add(grAendernB);
        oberesUnteresP.add(grLoeschenB);

        unteresUnteresP.add(eiAnlegenB);
        unteresUnteresP.add(eiAendernB);
        unteresUnteresP.add(eiLoeschenB);

        oberesP.add(grundstueckeL, BorderLayout.NORTH);
        oberesP.add(this.grundstueckList, BorderLayout.CENTER);
        oberesP.add(oberesUnteresP, BorderLayout.SOUTH);

        unteresP.add(eigentuemerL, BorderLayout.NORTH);
        unteresP.add(this.eigentuemerList, BorderLayout.CENTER);
        unteresP.add(unteresUnteresP, BorderLayout.SOUTH);

        this.add(oberesP);
        this.add(unteresP);

        this.setPreferredSize(new Dimension(650, 350));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        grAnlegenB.addActionListener(this);
        grAendernB.addActionListener(this);
        grLoeschenB.addActionListener(this);
        eiAnlegenB.addActionListener(this);
        eiAendernB.addActionListener(this);
        eiLoeschenB.addActionListener(this);

        this.pack();
        this.setVisible(true);
        this.aktualisieren();
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Grundstueck anlegen")) {
            new GrAnlegenDialog(this);
        }
        else if (e.getActionCommand().equals("Grundstueck aendern")) {
            Grundstueck g = this.getGrundstueck();
            if (g != null)
                new GrAendernDialog(this, this.getGrundstueck());
        }
        else if (e.getActionCommand().equals("Grundstueck loeschen")) {
            Grundstueck g = this.getGrundstueck();
            if (g != null) {
                GrundstueckContainer.instance().removeGrundstueck(this.getGrundstueck());
                this.aktualisieren();
            }
        }
        else if (e.getActionCommand().equals("Eigentuemer anlegen")) {
            new EiAnlegenDialog(this);
        }
        else if (e.getActionCommand().equals("Eigentuemer aendern")) {
            Eigentuemer ei = this.getEigentuemer();
            if (ei != null)
                new EiAendernDialog(this, this.getEigentuemer());
        }
        else if (e.getActionCommand().equals("Eigentuemer loeschen")) {
            Eigentuemer ei = this.getEigentuemer();
            if (ei != null) {
                EigentuemerContainer.instance().removeEigentuemer(this.getEigentuemer());
                this.aktualisieren();
            }
        }
    }


    public Eigentuemer getEigentuemer()
    {
        if (this.eigentuemerList.getItemCount() == 0 || this.eigentuemerList.getSelectedIndex() == -1)
            return null;
        else
            return EigentuemerContainer.instance().getEigentuemer(this.eigentuemerList.getSelectedIndex());
    }

    public Grundstueck getGrundstueck()
    {
        if (this.grundstueckList.getItemCount() == 0 || this.grundstueckList.getSelectedIndex() == -1)
            return null;
        else
            return GrundstueckContainer.instance().getGrundstueck(this.grundstueckList.getSelectedIndex());
    }

    public void aktualisieren()
    {
        grundstueckList.removeAll();
        eigentuemerList.removeAll();

        for (Grundstueck g: GrundstueckContainer.instance())
            grundstueckList.add(g.toString());

        for (Eigentuemer e: EigentuemerContainer.instance())
            eigentuemerList.add(e.toString());
    }
}
