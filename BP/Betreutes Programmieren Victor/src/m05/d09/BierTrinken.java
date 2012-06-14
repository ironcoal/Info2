package m05.d09;

public class BierTrinken
{
  public static void main(String[] args)
  {
      FlascheBier meinBier = new FlascheBier("Oettinger Export");

      meinBier.machAuf();
      meinBier.trinkeSchluck();

      System.out.println(meinBier.wieVielIsNoDrin());

      while (!meinBier.isSchoLeer()) {
          meinBier.trinkeSchluck();
          System.out.println(meinBier.wieVielIsNoDrin());
      }

      System.out.println("Bier leer. ;(");
  }
}
