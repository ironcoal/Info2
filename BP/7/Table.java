import java.sql.*;
import java.util.*;

public class Table implements Iterable<Column> {
	private String name;
	private Vector<Column> column_list = new Vector<Column>();

	public Table(ResultSet description, DatabaseMetaData information) {
		try {
			name = description.getString(3);
			ResultSet columns = information.getColumns(null, null, name, null);
			while (columns.next()) {
				column_list.addElement(new Column(columns));
			}
		} catch(Exception e) {
			System.out.println("Fehler beim Anlegen der Tabelle");
		}
	}
	public String getName() {
		return name;
	}
	public Iterator<Column> iterator() {
		return column_list.iterator();
	}
}
