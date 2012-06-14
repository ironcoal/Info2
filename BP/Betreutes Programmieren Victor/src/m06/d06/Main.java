package m06.d06;

public class Main
{
    public static void main(String[] args)
    {
        DataBase db = new DataBase("theOtherDatabase");

        if (db.connectToDataBase()) {
            db.collectInformationFromDataBase();
        }
    }
}
