import java.sql.*;
import java.util.*;

public class Column implements Iterable<Cell> {
	private String name;
	private String type;
	public Vector<Cell> cell_list = new Vector<Cell>();
	
	public Column(ResultSet description, Connection con, String table_name, int column_num)
	{
		try {
			name = description.getString(4);
	        type = description.getString(6);
        	Statement abfrage = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String befehl = "select * from " + table_name;
			ResultSet table_content = abfrage.executeQuery(befehl);
			table_content.beforeFirst();
			int rows = 0;
			while (table_content.next()) {
				table_content.absolute(++rows);
				String content = table_content.getString(column_num);
				cell_list.addElement(new Cell(content));
			}
        } catch(Exception e) {
			System.out.println("Fehler beim Anlegen der Spalten");
		}
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public Iterator<Cell> iterator() {
		return cell_list.iterator();
	}
}


