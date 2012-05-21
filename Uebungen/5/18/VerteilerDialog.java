import java.awt.Dialog.*;
import java.awt.*;
import java.awt.event.*;

class VerteilerDialog extends Dialog implements ActionListener {
	
	private Label lab;
	private TextField tfname;
	private List ltadress;
	private List ltverteiler;
	private Button save;
	private Button arrow;
	public Dialog verteiler; 

	public VerteilerDialog(Frame f, Adressbuch adress) {
		super(f, "Mailverteilererstellen", true);
		setSize(500, 300);
		Container cp = getContentPain();
		verteiler = new Dialog("Mailverteiler erstellen");
		lab = new Label("Name des Verteilers");
		tfname = new TextField();
		ltadress = new List();
		ltverteiler = new List();
		save = new Button("Speichern");
		arrow = new Button(">>");

		list
	}

	public static List showDialog(Frame f, Adressbuch adress) {
		VerteilerDialog verteilerDialog = new VerteilerDialog()
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == arrow) {

		}
	}

}