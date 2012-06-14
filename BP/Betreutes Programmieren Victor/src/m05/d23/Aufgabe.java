package m05.d23;

public class Aufgabe
{
    private String beschreibung;
    private int prioritaet;

    public Aufgabe(String beschreibung, int prioritaet)
    {
        this.beschreibung = beschreibung;
        if (beschreibung == null ||
            beschreibung.length() == 0) {
            this.beschreibung = "Keine Beschreibung";
        }

        this.prioritaet = prioritaet;

        if (prioritaet > 5)
            this.prioritaet = 5;

        if (prioritaet < 0)
            this.prioritaet = 0;
    }

    public String getBeschreibung()
    {
        return beschreibung;
    }

    public int getPrioritaet()
    {
        return prioritaet;
    }

    public boolean equals(Object o)
    {
        if (o instanceof Aufgabe &&
            prioritaet == ((Aufgabe) o).prioritaet)
            return beschreibung.equalsIgnoreCase(((Aufgabe) o).beschreibung);

        return false;
    }
}
