import java.sql.*;
import java.util.*;

public class Table implements Iterable<Column>
{
	public Vector<Column> column_list = new Vector<Column>();
	private String name;

	public Table(ResultSet description, DatabaseMetaData information, Connection con)
	{
		try {
			name = description.getString(3);
			ResultSet columns = information.getColumns(null, null, name, null);
			int i = 1;
			while (columns.next()) {
				column_list.addElement(new Column(columns, con, name, i));
				i++;
			}
		} catch(Exception e) {
			System.out.println("Fehler beim Anlegen der Tabelle");
		}
	}
	public String getName()
	{
		return name;
	}
	public Iterator<Column> iterator()
	{
		return column_list.iterator();
	}
}
