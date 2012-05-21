import java.util.*;

public class Adressbuch implements Iterable<Kontakt> {
    private String name;
    private ArrayList<Kontakt> kontakte;
    public Adressbuch(String name) {
        setName(name);
        kontakte = new ArrayList<Kontakt>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void add(Kontakt k) {
        kontakte.add(k);
    }
    public boolean delete(Kontakt k) {
        return kontakte.remove(k);
    }
    public Iterator<Kontakt> iterator() {
        return kontakte.iterator();
    }
}