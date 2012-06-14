import java.awt.*;
import java.awt.event.*;

public class EiAnlegenDialog extends Dialog implements ActionListener
{
    private TextField nameTF,
                      geburtsdatumTF;


    public EiAnlegenDialog(Frame owner)
    {
        super(owner, "Eigentuemer anlegen", true);
        
        this.nameTF         = new TextField(20);
        this.geburtsdatumTF = new TextField(10);

        Label nameL    = new Label("Name:"),
              geburtsdatumL = new Label("Geburtsdatum:");

        Button anlegenB    = new Button("Anlegen"),
               schliessenB = new Button("Schliessen");

        Panel oberesP    = new Panel(),
              mittleresP = new Panel(),
              unteresP   = new Panel();

        oberesP.setLayout(new BorderLayout());
        mittleresP.setLayout(new BorderLayout());
        unteresP.setLayout(new FlowLayout());

        this.setLayout(new GridLayout(3, 1, 10, 10));

        oberesP.add(nameL, BorderLayout.WEST);
        oberesP.add(this.nameTF, BorderLayout.CENTER);

        mittleresP.add(geburtsdatumL, BorderLayout.WEST);
        mittleresP.add(this.geburtsdatumTF, BorderLayout.CENTER);
        
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
            EigentuemerContainer.instance().addEigentuemer(new Eigentuemer(this.nameTF.getText(), this.geburtsdatumTF.getText()));
            ((Grundstueckverwaltung)this.getOwner()).aktualisieren();
            dispose();
        }
    }
}
