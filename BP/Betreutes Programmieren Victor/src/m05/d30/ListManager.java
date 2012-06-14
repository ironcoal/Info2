// DO NOT WANT.

package m05.d30;

import java.awt.*;
import java.awt.event.*;

public class ListManager extends Frame
                         implements ActionListener
{
    private static final long serialVersionUID = 8543163427037645l;

    private Liste liste = Liste.instance();

    private TextField knotenTF;
    private Button zurueckB,
                   weiterB;

    public ListManager()
    {
        super("ListManager");
        
        knotenTF = new TextField(20);

        Panel einsP = new Panel(),
              zweiP = new Panel();

        zurueckB = new Button("+");
        weiterB  = new Button("+");

        this.setLayout(new GridLayout(2, 1));
        zweiP.setLayout(new GridLayout(1, 2));

        einsP.add(knotenTF);

        zweiP.add(zurueckB);
        zweiP.add(weiterB);

        this.add(einsP);
        this.add(zweiP);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                dispose();
                System.exit(0);
            }
        });

        this.pack();
        this.setVisible(true);

        zurueckB.addActionListener(this);
        weiterB.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        System.out.println(this.liste);

        if (source == this.zurueckB) {
            if (e.getActionCommand().equals("<")) {
                if (this.weiterB.getLabel().equals("+")) {
                    this.weiterB.setLabel(">");
                    this.knotenTF.setText(this.liste.gibAktuellen().gibWert());
                    this.liste.gibAktuellen().setzeWert(this.knotenTF.getText());
                    this.knotenTF.setText(this.liste.gibAktuellen().gibWert());
                }
                else {
                    String text = this.knotenTF.getText();

                    System.out.println("----- zurueck");

                    if (this.liste.kannZurueck()) {
                        this.liste.gibAktuellen().setzeWert(text);
                        this.liste.bewegeZurueck();
                        this.knotenTF.setText(this.liste.gibAktuellen().gibWert());
                    }
                    else {
                        this.knotenTF.setText("");
                        this.zurueckB.setLabel("+");
                    }
                }
            }
            else {
                this.liste.erweitereVorne(new Knoten(this.knotenTF.getText()));
                this.knotenTF.setText(this.liste.gibAktuellen().gibWert());
                zurueckB.setLabel("<");
                weiterB.setLabel(">");
            }
        }
        else if (source == this.weiterB) {
            if (e.getActionCommand().equals(">")) {
                if (this.zurueckB.getLabel().equals("+")) {
                    this.zurueckB.setLabel("<");
                    this.knotenTF.setText(this.liste.gibAktuellen().gibWert());
                    this.liste.gibAktuellen().setzeWert(this.knotenTF.getText());
                    this.knotenTF.setText(this.liste.gibAktuellen().gibWert());
                }
                else {
                    String text = this.knotenTF.getText();

                    System.out.println("----- weiter");

                    if (this.liste.kannWeiter()) {
                        this.liste.gibAktuellen().setzeWert(text);
                        this.liste.bewegeWeiter();
                        this.knotenTF.setText(this.liste.gibAktuellen().gibWert());
                    }
                    else {
                        this.knotenTF.setText("");
                        this.weiterB.setLabel("+");
                    }
                }
            }
            else {
                this.liste.erweitereHinten(new Knoten(this.knotenTF.getText()));
                this.knotenTF.setText(this.liste.gibAktuellen().gibWert());
                zurueckB.setLabel("<");
                weiterB.setLabel(">");
            }
        }
    }
}
