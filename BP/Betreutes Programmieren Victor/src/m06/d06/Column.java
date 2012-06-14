package m06.d06;

import java.sql.*;

public class Column
{
    private String name;
    private String type;

    public Column(ResultSet description)
    {
    }

    public String getName()
    {
        return this.name;
    }

    public String getType()
    {
        return this.type;
    }
}
