package m04.d25;

public class Palindrom 
{
  public static void main(String[] args)
  {
    int i = 0;

    if (args.length == 0)
      System.out.println("Keine Parameter uebergeben.\n");
    else {
      int j;

      for (i = 0; i < args.length; i++) {
        j = palindrom(args[i]);

        if (j == 0)
          System.out.println(args[i] + " ist kein Palindrom.\n");
        else
          System.out.println(args[i] + " ist ein Palindrom.");
      }
    }
  }

  static int palindrom(String string)
  {
    int laenge = string.length(),
        vorne  = 0,
        hinten = laenge - 1;

    while (vorne <= hinten &&
           string.charAt(vorne) == string.charAt(hinten)) {
      vorne++;
      hinten--;
    }

    if (vorne > hinten)
      return 1;
    else
      return 0;
  }
}
