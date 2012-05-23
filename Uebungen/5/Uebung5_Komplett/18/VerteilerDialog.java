import java.awt.Dialog.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

class VerteilerDialog extends Dialog implements ActionListener
{
    private TextField tf_name;
    private List lt_adress;
    private List lt_verteiler;
    private Button save;
    private Button arrow;
    public Dialog verteiler; 

    public VerteilerDialog(Frame f, Adressbuch adress)
    {
        super(f, "Mailverteiler erstellen");
        
        /* Initialisieren der Dialogkomponenten */
        setLayout(new BorderLayout());
        Panel pan1 = new Panel();
        Panel pan2 = new Panel();

        verteiler = new Dialog(f, "Mailverteiler erstellen");
        tf_name = new TextField();
        lt_adress = new List(10, false);
        lt_verteiler = new List(10, false);
        save = new Button("Speichern");
        arrow = new Button(">>");
        arrow.addActionListener(this);
        save.addActionListener(this);
        lt_adress.addActionListener(this);

        tf_name.setPreferredSize(new Dimension(80,25));

        pan1.add(new Label("Name des Verteilers"));
        pan1.add(tf_name);
        pan1.add(save);

        Iterator<Kontakt> it = adress.iterator();
        Kontakt k;
        /* Nur Kontakte anzeigen, die eine Emailadresse haben */
        while (it.hasNext()) {
            k = it.next();
            if (k.getEmail() != null) {
                lt_adress.add(k.getName());
            }
        }

        pan2.add(lt_adress);
        pan2.add(arrow);
        pan2.add(lt_verteiler);

        add(pan1, BorderLayout.NORTH);
        add(pan2, BorderLayout.CENTER);

        addWindowListener(new Closer());
    }

    public void actionPerformed(ActionEvent e)
    {
        if ((e.getSource() == arrow) || (e.getSource() == lt_adress)) {
            if (lt_adress.getSelectedItem() != null) {
                lt_verteiler.add(lt_adress.getSelectedItem());
                lt_adress.remove(lt_adress.getSelectedItem());
            } else {
                /* Hier Fehlerbehandlung möglich, wenn erwünscht */
            }
        } else if (e.getSource() == save) {
            /* Hier Ereignisbehandlung für Button "Speichern" */
        }
    }

    protected static final class Closer extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }



}