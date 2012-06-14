public class Main
{
    public static void main(String[] args)
    {
    	/* Testobjekte */
        GrundstueckContainer.instance().addGrundstueck(new Grundstueck("HS1","400 m2"));
        EigentuemerContainer.instance().addEigentuemer(new Eigentuemer("Max Mustermann", "01.01.1970"));
        new Grundstueckverwaltung();
    }
}
