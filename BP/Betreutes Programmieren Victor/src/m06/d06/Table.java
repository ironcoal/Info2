package m06.d06;

import java.sql.*;
import java.util.Iterator;
import java.util.Vector;

public class Table implements Iterable<Column>
{
    private String name;
    private Vector<Column> columns;

    public Table(ResultSet description, DatabaseMetaData information)
    {
        this.columns = new Vector<Column>();

        try {
            description.next();
            this.name = description.getString(3);
            this.columns.add(new Column(description.getString(4)));
            // System.out.println(description.getString(1));
            // System.out.println(description.getString(2));
            // System.out.println(description.getString(3));
            // System.out.println(description.getString(4));
            // System.out.println(description.getString(5));
            // System.out.println(description.getString(6));
            // System.out.println(description.getString(7));
            // System.out.println(description.getString(8));
            // System.out.println(description.getString(9));
            // System.out.println(description.getString(10));
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getName()
    {
        return this.name;
    }

    public Iterator<Column> iterator()
    {
        return null;
    }
}
