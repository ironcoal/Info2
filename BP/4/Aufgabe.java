

public class Aufgabe {
    private String beschreibung = "";
    private int prioritaet = 0;

    public Aufgabe(String beschreibung, int prioritaet) {
        if (beschreibung == null)
            beschreibung = "keine Angabe";
        this.beschreibung = beschreibung;
        if (prioritaet < 0)
            prioritaet = 0;
        else if (prioritaet > 5) 
            prioritaet = 5;
        this.prioritaet = prioritaet;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public int getPrioritaet() {
        return prioritaet;
    }

    public boolean equals(Object o) {
        return ( ((Aufgabe) o).beschreibung.equalsIgnoreCase(beschreibung) && 
            (((Aufgabe) o).prioritaet == prioritaet) );
    }
    
}
