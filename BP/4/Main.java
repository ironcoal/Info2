import java.util.*;

public class Main {
	public static void main(String[] args) {
		Aufgaben todo = Aufgaben.instance();
		Aufgabe a1 = new Aufgabe("Zuhoeren", 0);
		Aufgabe a2 = new Aufgabe("Programmieren", 3);
		todo.addAufgabe(a1);
		todo.addAufgabe(a2);
		Iterator<Aufgabe> it = todo.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getBeschreibung());
		}
		System.out.print(todo.popAufgabe().getBeschreibung());
	}
}