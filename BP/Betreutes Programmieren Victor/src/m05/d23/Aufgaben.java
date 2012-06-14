package m05.d23;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Aufgaben implements Iterable<Aufgabe>
{
    private static Aufgaben unique = null;

    private Aufgaben()
    {
        aufgaben = new PriorityQueue<Aufgabe>(10, new AufgComp());
    }

    public static Aufgaben instance()
    {
        if (unique == null)
            unique = new Aufgaben();

        return unique;
    }

    PriorityQueue<Aufgabe> aufgaben;

    public void addAufgabe(Aufgabe aufgabe)
    {
        if (!aufgaben.contains(aufgabe))
            aufgaben.offer(aufgabe);
    }

    public Aufgabe popAufgabe()
    {
        return aufgaben.poll();
    }

    public Iterator<Aufgabe> iterator()
    {
        return aufgaben.iterator();
    }
}
