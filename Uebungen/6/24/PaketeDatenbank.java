import java.sql.*;

public class PaketeDatenbank implements PaketeDatenhaltung {

	private String treiber = "com.mysql.jdbc.Driver";
	private String datenbankURL = "jdbc:mysql://aiomr.informatik.uni-augsburg.de:3306/theDatabase";
	private String benutzername = "user";
	private String passwort = "passwort";
	Connection connection;

	public PaketeDatenbank() {
		try {
			Class.forName(treiber);
			connection = DriverManager.getConnection(datenbankURL,benutzername,passwort);

		} catch(Exception e) {
			System.out.println("Problem beim Verbinden mit der Datenbank!");
		}
	}
	public void add(Paket paket) {
		try {
			Statement s = connection.createStatement();
			String abfrage = "insert into Paket values ('" 
				+ paket.getSendungsnummer() + "','" 
				+ paket.getGewichtsklasse() + "','"
				+ paket.getStatus() + "')";
			s.executeUpdate(abfrage);
		} catch(Exception e) {
			System.out.println("Fehler beim Hinzufuegen des Pakets");
		}
	}
	public void delete(Paket paket) {
		try {
			Statement s = connection.createStatement();
			String abfrage = "delete from Paket where sendungsnummer =" 
				+ paket.getSendungsnummer() + ")";
			s.executeUpdate(abfrage);
		} catch(Exception e) {
			System.out.println("Fehler beim Loeschen des Pakets");
		}
	}
	public void modify(Paket paket) {
		try {
			Statement s = connection.createStatement();
			String abfrage = "update from Paket set gewichtsklasse =" 
				+ paket.getGewichtsklasse() + ", status ="
				+ paket.getStatus() + " where sendungsnummer =" 
				+ paket.getSendungsnummer() + ")";
			s.executeUpdate(abfrage);
		} catch(Exception e) {
			System.out.println("Fehler beim Loeschen des Pakets");
		}
	}
	public void load(PaketeContainer cont) {
		try {
			String abfrage = "select * from Paket";
			ResultSet ergebnis = abfrage.executeQuery();
			Paket p;
			while (ergebnis.next()) {
				p = new Paket (ergebnis.getString(0),ergebnis.getString(1),ergebnis.getString(2));
				cont.addPaket(p);
			}
		} catch(Exception e) {
			System.out.println("Fehler beim Loeschen des Pakets");
		}
	}
	public void save(PaketeContainer cont) {
		System.out.println("Hier gehoert ein Save-Vorgang hin");
	}
}