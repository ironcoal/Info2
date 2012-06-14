package m05.d09;

import java.text.DecimalFormat;

public class FlascheBier
{
    private String marke;
    private boolean geoeffnet;
    private double fuellmenge;

    public FlascheBier()
    {
        this.geoeffnet = false;
        this.fuellmenge = 0.5;
        this.marke = "Augustiner Hell";

        System.out.println("Frisches Bier! Prost!");
    }

    public FlascheBier(String marke)
    {
        this.geoeffnet = false;
        this.fuellmenge = 0.5;
        this.marke = marke;

        System.out.println("Frisches Bier! Prost!");
    }

    public void machAuf()
    {
        this.geoeffnet = true;
        
        System.out.println("Oeffne gutes, frisches " + this.marke + "!");
    }

    public boolean trinkeSchluck()
    {
        if (this.geoeffnet &&
            this.fuellmenge > 0.0) {
            this.fuellmenge -= 0.1;

            System.out.println("*schluck*");

            return true;
        } else {
            System.out.println("Flasche noch zu oder leer.");

            return false;
        }
    }

    public boolean isSchoLeer()
    {
        if (this.fuellmenge <= 0.05)
            return true;
        else
            return false;
    }

    public double wieVielIsNoDrin()
    {
        return Double.valueOf(new DecimalFormat("#.#").format(this.fuellmenge));
    }
}
