import java.sql.*;
import java.util.*;

public class Column {
	private String name;
	private String type;

	public Column(ResultSet description) {
		try {
			name = description.getString(4);
	        type = description.getString(6);
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
}


