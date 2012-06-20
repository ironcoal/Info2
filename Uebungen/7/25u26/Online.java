import java.sql.*;
import java.text.*;
import java.util.*;

public class Online
{
	private static Online unique;
	private Connection c;
	private int userId;
	private boolean isLoggedIn;
	private Statement abfrage;
	private String befehl;
	
	private Online() 
	{
		connect();
	}

	public void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.c = DriverManager.getConnection("jdbc:mysql://aiomr.informatik." +
				"uni-augsburg.de:3306/pong","user","password");
			abfrage = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			System.out.println("Problem beim Verbinden mit der Datenbank!");
		}
	}

	public static Online instance()
	{
		if (unique == null)
			unique = new Online();
		return unique;
	}

	public boolean login(String user, String password) 
	{
      	try {
	      	befehl = "SELECT id FROM Users WHERE username = '" + user + "' AND password = '" + password + "'";
	      	ResultSet ergebnis = abfrage.executeQuery(befehl);
	    	
	      	if (ergebnis.next()) {
	      		Configuration.instance().setPlayer1Name(user);
	      		userId = ergebnis.getInt("id");
	      		isLoggedIn = true;
	      		System.out.print(userId);
	      		return true;
	      	}
	      	System.out.println("Name oder Passwort falsch");
	      	return false;
	    } catch (Exception e) {
	    	System.out.println("Fehler bei der Datenbankverbindung!");
	    	return false;
	    }

      
	}
	public boolean addUser(String user, String password) {
		try {
	      	befehl = "select * from Users where " + 
                "username = '" + user + "'";
	      	ResultSet ergebnis = abfrage.executeQuery(befehl);
	    	
	      	if (!ergebnis.next()) {
	      		befehl = "insert into Users values (0,'" + user + "','"+ password + "')";
		        abfrage.executeUpdate(befehl);
		        return true;
	      	} else {
	      		System.out.println("User schon vorhanden!");
	      		return false;
	      	}
	    } catch (Exception e) {
	    	System.out.print("blub");
	    	System.out.println("Fehler bei der Datenbankverbindung");
	    	return false;
	    }
	}

	public boolean sendHighscore(Highscore hs) {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String sdate = sdformat.format(hs.getDate());
		try {
			befehl = "insert into Highscores values (0,'" + userId + 
				"','" + hs.getScore() + "','" + sdate + "')";
			abfrage.executeUpdate(befehl);
			return true;
		} catch(Exception e) {
			System.out.println("Fehler beim Einfuegen der Highscore");
			return false;
		}
	}

	public ArrayList<Highscore> getHighscores()
	{
		try {
			ArrayList<Highscore> al = new ArrayList<Highscore>();
			befehl = "select userid,score,date from Highscores";
			ResultSet hs = abfrage.executeQuery(befehl);
			while (hs.next()) {
				befehl = "select username from Users where id = " + hs.getString("userid");
				Statement abf = c.createStatement();
				ResultSet ns = abf.executeQuery(befehl);
				ns.next();
				String name = ns.getString("username");
				System.out.println(hs.getString("date"));
				al.add(new Highscore(name, hs.getInt("score"), hs.getDate("date")));
			}
			return al;
		} catch(Exception e) {
			System.out.println("Problem beim Anlegen der Highscore-Liste");
			return null;
		}
	}
	public boolean isLoggedIn()
	{
		return isLoggedIn;
	}
}
