package m06.d06;

import java.sql.*;
import java.util.Iterator;
import java.util.Vector;

public class DataBase implements Iterable<Table>
{
    private String driver   = "com.mysql.jdbc.Driver",
                   protocol = "jdbc:mysql",
                   server   = "aiomr.informatik.uni-augsburg.de",
                   port     = "3306",
                   name,
                   username = "user",
                   password = "password";

    private Connection connection;
    private Vector<Table> tables;

    public DataBase(String name)
    {
        this.tables = new Vector<Table>();
        this.name   = name;
    }

    public boolean connectToDataBase()
    {
        try {
            Class.forName(this.driver);
            this.connection = DriverManager.getConnection(this.protocol + "://" + this.server + ":" +
                                                          this.port + "/" + this.name,
                                                          this.username, this.password);
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public void collectInformationFromDataBase()
    {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            // String[] types = {"TABLES"};
            ResultSet rs = metaData.getTables(null, null, "%", null);

            while (rs.next()) {
                this.tables.add(new Table(metaData.getColumns(null, null, rs.getString(3), null), metaData));
            }
        }
        catch(Exception e) {
            System.out.println("pupu");
        }
    }

    public String getName()
    {
        return this.name;
    }

    public Iterator<Table> iterator()
    {
        return null;
    }
}
