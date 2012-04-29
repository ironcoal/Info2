import java.util.*;
public class A6 {
	public static void main(String[] args) {
		Vector<Integer> vec = new Vector<Integer>(1,1);
		if (args.length != 0) {
			for (int i = 0; i < args.length; i++) {
				vec.addElement(new Integer(args[i]));
			}
			System.out.println("Groesse des Vektors: " + vec.size());
			for (int i = 0; i < vec.size(); i++) {
				System.out.println("Element an " + (i + 1) + ". Stelle: " + vec.elementAt(i));
			}	
			vec.removeElementAt(2);
			System.out.println("Neue Groesse des Vektors (Loeschen an 2. Stelle): " + vec.size());
			System.out.println("Erstes Element: " + vec.firstElement());
			System.out.println("Letztes Element: " + vec.lastElement());
			vec.clear();
			System.out.println("Groesse nach Loeschvorgang: " + vec.size());
		}
	}
}