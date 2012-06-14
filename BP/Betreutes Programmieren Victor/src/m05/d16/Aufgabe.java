package m05.d16;

public class Aufgabe
{
    private String beschreibung;
    private int prioritaet;
    
    public Aufgabe(String beschreibung, int prioritaet) throws LeereAufgabeException
    {
        if (!beschreibung.isEmpty() &&
            prioritaet >= 0 &&
            prioritaet <= 5) {
            this.beschreibung = beschreibung;
            this.prioritaet   = prioritaet;
        } else
            throw new LeereAufgabeException();
    }

    public String getBeschreibung()
    {
        return this.beschreibung;
    }

    public int getPrioritaet()
    {
        return this.prioritaet;
    }

    public boolean equals(Object o)
    {
        if (o instanceof Aufgabe &&
            this.getBeschreibung().equalsIgnoreCase(((Aufgabe) o).getBeschreibung()) &&
            this.getPrioritaet() == ((Aufgabe) o).getPrioritaet())
            return true;
        else
            return false;
    }
}
