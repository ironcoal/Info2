import java.awt.Dialog.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

class VerteilerDialog extends Dialog implements ActionListener {
	
	private Label lab;
	private TextField tfname;
	private List ltadress;
	private List ltverteiler;
	private Button save;
	private Button arrow;
	public Dialog verteiler; 

	public VerteilerDialog(Frame f, Adressbuch adress) {
		super(f, "Mailverteiler erstellen");
		setSize(500, 300);
		
		/* Initialisieren der Dialogkomponenten */
		verteiler = new Dialog(f, "Mailverteiler erstellen");
		lab = new Label("Name des Verteilers");
		tfname = new TextField();
		ltadress = new List(10, false);
		ltverteiler = new List(10, false);
		save = new Button("Speichern");
		arrow = new Button(">>");

		Iterator it = adress.iterator();
		while (it.hasNext()) {
			System.out.print(it.next().getName());
			//ltadress.add(it.next().getName());
		}


	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == arrow) {

		}
	}

}