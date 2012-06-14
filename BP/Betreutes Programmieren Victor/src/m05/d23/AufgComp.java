package m05.d23;

import java.util.Comparator;

public class AufgComp implements Comparator<Aufgabe>
{
    public int compare(Aufgabe a1, Aufgabe a2)
    {
        if (a1.getPrioritaet() == a2.getPrioritaet())
            return a1.getBeschreibung().compareToIgnoreCase(a2.getBeschreibung());

        return a2.getPrioritaet() - a1.getPrioritaet();
    }
}
