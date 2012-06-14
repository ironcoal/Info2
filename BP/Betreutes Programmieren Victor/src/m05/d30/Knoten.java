package m05.d30;

public class Knoten
{
    private Knoten naechster  = null,
                   vorheriger = null;

    private String wert;

    public Knoten(String wert)
    {
        this.wert = wert;
    }

    public String gibWert()
    {
        return this.wert;
    }

    public void setzeWert(String wert)
    {
        this.wert = wert;
    }

    public Knoten gibNaechsten()
    {
        return this.naechster;
    }
    
    public void setzeNaechsten(Knoten naechster)
    {
        this.naechster = naechster;
    }

    public Knoten gibVorherigen()
    {
        return this.vorheriger;
    }

    public void setzeVorherigen(Knoten vorheriger)
    {
        this.vorheriger = vorheriger;
    }
}
