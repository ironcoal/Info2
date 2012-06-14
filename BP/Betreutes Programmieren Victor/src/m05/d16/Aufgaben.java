package m05.d16;

import java.util.Iterator;
import java.util.Vector;

public class Aufgaben implements Iterable<Aufgabe>
{
    private static Aufgaben unique = null;
    private Vector<Aufgabe> aufgaben;

    private Aufgaben()
    {
        aufgaben = new Vector<Aufgabe>();
    }

    public static Aufgaben instance()
    {
        if (unique == null)
            return unique = new Aufgaben();
        else
            return unique;
    }

    public void addAufgabe(Aufgabe aufgabe)
    {
        boolean isIn = false;

        for (Aufgabe a: aufgaben)
            isIn = aufgabe.equals(a);

        if (!isIn)
            aufgaben.add(aufgabe);
    }

    public Aufgabe popAufgabe() throws ArrayIndexOutOfBoundsException
    {
        int tmpPriotaet = 0;
        Aufgabe tmpAufgabe;

        if (!aufgaben.isEmpty()) {
            tmpPriotaet = aufgaben.firstElement().getPrioritaet();
            tmpAufgabe  = aufgaben.firstElement();

            for (Aufgabe a: aufgaben) {
                if (a.getPrioritaet() > tmpPriotaet) {
                    tmpPriotaet = a.getPrioritaet();
                    tmpAufgabe  = a;
                }
            }

            aufgaben.remove(tmpAufgabe);

            return tmpAufgabe;
        } else
            return null;
    }

    public Iterator<Aufgabe> iterator()
    {
        return new Iterator<Aufgabe>()
        {
            private int index = 0;

            public boolean hasNext()
            {
                return index < aufgaben.size();
            }

            public Aufgabe next()
            {
                return aufgaben.get(index++);
            }

            public void remove() throws UnsupportedOperationException
            {
                throw new UnsupportedOperationException();
            }
        };
    }
}
