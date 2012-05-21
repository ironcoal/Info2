import java.awt.*;

class A18 {
	public static void main(String[] args) {
		Kontakt k1 = new Kontakt("Max Mueller");
		Kontakt k2 = new Kontakt("Petra Schmid");
		k1.setEmail("maxller@gmail.com");
		k2.setEmail("petra@gmx.de");
		Adressbuch adressbuch = new Adressbuch("Professoren");
		adressbuch.add(k1);
		adressbuch.add(k2);
		VerteilerDialog dia = new VerteilerDialog(new Frame(), adressbuch);
		dia.setVisible(true);
	}
}
