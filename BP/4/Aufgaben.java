 import java.util.*;

 public class Aufgaben implements Iterable {

    private static Aufgaben unique = null;
    PriorityQueue<Aufgabe> aufgabenliste;

    private Aufgaben() {
        aufgabenliste = new PriorityQueue<Aufgabe>(10, new AufgComp());
    }

    public static Aufgaben instance() {
        if (unique == null) {
            unique = new Aufgaben();
        }
        return unique;
    }

    public void addAufgabe(Aufgabe aufgabe) {
        if (!aufgabenliste.contains(aufgabe))
            aufgabenliste.offer(aufgabe);
    }

    public Aufgabe popAufgabe()  {
        int groesste = 0;
        Aufgabe aufgabe = null;
        for (Aufgabe a: aufgabenliste) {
            if (a.getPrioritaet() > groesste) {
                groesste = a.getPrioritaet();
            }
        }
        for (Aufgabe a: aufgabenliste) {
            if (a.getPrioritaet() == groesste) {
                aufgabe = a;
                aufgabenliste.remove(a);
                break;
            }
        }
        return aufgabe;
    }
    public Iterator<Aufgabe> iterator() {
        return aufgabenliste.iterator();
    }
 }

