package m05.d30;

public class Liste
{
    private static Liste unique = null;

    private Knoten anfang,
                   ende,
                   aktueller;

    private Liste()
    {
        anfang = ende = aktueller = null;
    }

    public static Liste instance()
    {
        if (unique == null)
            return unique = new Liste();
        else
            return unique;
    }

    public void erweitereVorne(Knoten neuer)
    {
        if (anfang != null) {
            neuer.setzeNaechsten(this.anfang);
            this.anfang.setzeVorherigen(neuer);
            this.anfang    = neuer;
            this.aktueller = this.anfang;
        }
        else {
            this.anfang    = neuer;
            this.ende      = this.anfang;
            this.aktueller = this.anfang;
        }

        System.out.println(neuer.gibWert());
    }

    public void erweitereHinten(Knoten neuer)
    {
        if (ende != null) {
            neuer.setzeVorherigen(this.ende);
            this.ende.setzeNaechsten(neuer);
            this.ende = neuer;
            this.aktueller = this.ende;
        }
        else {
            this.ende      = neuer;
            this.anfang    = this.ende;
            this.aktueller = this.ende;
        }
    }

    public boolean kannWeiter()
    {
        if (this.aktueller.gibNaechsten() == null)
            return false;
        else
            return true;
    }

    public void bewegeWeiter()
    {
        if (this.kannWeiter())
            this.aktueller = this.aktueller.gibNaechsten();
    }

    public boolean kannZurueck()
    {
        if (this.aktueller.gibVorherigen() == null)
            return false;
        else
            return true;
    }

    public void bewegeZurueck()
    {
        if (this.kannZurueck())
            this.aktueller = this.aktueller.gibVorherigen();
    }

    public Knoten gibAktuellen()
    {
        return this.aktueller;
    }

    public String toString()
    {
        String butter = "";

        for (Knoten k = this.anfang; k != null; k = k.gibNaechsten())
            butter += k.gibWert() + " ";

        return butter;
    }
}
