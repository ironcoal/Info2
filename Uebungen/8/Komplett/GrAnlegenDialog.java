import java.awt.*;
import java.awt.event.*;

public class GrAnlegenDialog extends Dialog implements ActionListener
{
    private TextField lageTF,
                      flaecheTF;

    public GrAnlegenDialog(Frame owner)
    {
        super(owner, "Grundstueck anlegen", true);
        
        this.lageTF    = new TextField(20);
        this.flaecheTF = new TextField(10);

        Label lageL    = new Label("Lage:"),
              flaecheL = new Label("Flaeche:");

        Button anlegenB    = new Button("Anlegen"),
               schliessenB = new Button("Schliessen");

        Panel oberesP    = new Panel(),
              mittleresP = new Panel(),
              unteresP   = new Panel();

        oberesP.setLayout(new BorderLayout());
        mittleresP.setLayout(new BorderLayout());
        unteresP.setLayout(new FlowLayout());

        this.setLayout(new GridLayout(3, 1, 10, 10));

        oberesP.add(lageL, BorderLayout.WEST);
        oberesP.add(this.lageTF, BorderLayout.CENTER);

        mittleresP.add(flaecheL, BorderLayout.WEST);
        mittleresP.add(this.flaecheTF, BorderLayout.CENTER);
        
        unteresP.add(anlegenB);
        unteresP.add(schliessenB);

        this.add(oberesP);
        this.add(mittleresP);
        this.add(unteresP);

        this.setPreferredSize(new Dimension(270, 150));

        anlegenB.addActionListener(this);
        schliessenB.addActionListener(this);

        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Schliessen"))
            dispose();
        else if (e.getActionCommand().equals("Anlegen")) {
            GrundstueckContainer.instance().addGrundstueck(new Grundstueck(this.lageTF.getText(), this.flaecheTF.getText()));
            ((Grundstueckverwaltung)this.getOwner()).aktualisieren();
            dispose();
        }
    }
}
