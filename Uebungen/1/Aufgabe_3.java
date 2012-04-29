import java.text.*;
import java.util.*;
class Aufgabe_3 {

    public static void main(String[] args) {
        if (args.length == 0) {
        	System.out.println(Math.E);
        } else if (args.length == 1) {
        	double d = Double.parseDouble(args[0]);
        	System.out.println("Der Kreisumfang bei einem Radius von " + 
        		d + " betraegt " + 2 * d * Math.PI);
        } else {
                Calendar cal = Calendar.getInstance();
                System.out.println("Fehler zum Zeitpunkt: " + cal.getTime());
        	Date dt = new Date();
                /* Oder, schoener formatiert: */
        	SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        	System.out.println("Fehler zum Zeitpunkt: " + df.format(dt));
        }
    }
}


















