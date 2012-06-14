package m05.d16;

public class ToDo
{
    public static void main(String[] args)
    {
        Aufgaben aufgaben = Aufgaben.instance(); 

        for (int i = 0; i < 10; i++)
            try {
                aufgaben.addAufgabe(new Aufgabe("Ich bin eine Aufgabe. Blub. " + i,
                                                (int) (Math.random() * 6)));
            } catch (LeereAufgabeException e) {
                System.out.println(e.getMessage());
            }

        for (Aufgabe a: aufgaben)
            System.out.println(a.getBeschreibung() + " Prioritaet: " + a.getPrioritaet());

        Aufgabe tmp;
        while ((tmp = aufgaben.popAufgabe()) != null) {
            System.out.println("Popping...");
            System.out.println(tmp.getBeschreibung() + " Prioritaet: " + tmp.getPrioritaet());
        }
    }
}
