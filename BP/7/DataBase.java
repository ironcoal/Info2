import java.sql.*;
import java.util.*;

public class DataBase implements Iterable<Table>
{
	private String driver = "com.mysql.jdbc.Driver";
	private String protocol = "jdbc:mysql";
	private String server = "aiomr.informatik.uni-augsburg.de";
	private String port = "3306";
	private String name;
	private String username = "user";
	private String password = "password";
	private Connection connection;
	Vector<Table> table_list = new Vector<Table>();

	public DataBase(String name) {
		this.name = name;
		if(!connectToDataBase())
			System.out.println("Fehler beim Verbinden mit der Datenbank");
		else {
			System.out.println("Verbindung erfolgreich!\n");
			System.out.println("Datenbank \"" + name + "\" hat folgenden Inhalt: ");
			collectInformationFromDataBase();
			for (Table t: table_list) {
				
				System.out.println(t.getName());
				
				for (Column co: t.column_list) {
					System.out.println("  - " + co.getName());

					for (Cell cl: co.cell_list)					
						System.out.println("    - " + cl.getContent());
				}
			}
		}
	}

	public boolean connectToDataBase() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(protocol + 
				"://" + server + ":" + port + "/" + 
				this.name, username, password);

			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public void collectInformationFromDataBase() {
		try {
			DatabaseMetaData meta = connection.getMetaData();
			ResultSet tables = meta.getTables(null, null, null, null);
			while (tables.next()) {
				table_list.addElement(new Table(tables, meta, connection));
			}
		} catch(Exception e) {
			System.out.println("Fehler beim holen der Datenbank");
		}		
	}
	public String getName() {
		return this.name;
	}

	public Iterator<Table> iterator() {
		return table_list.iterator();
	}
}