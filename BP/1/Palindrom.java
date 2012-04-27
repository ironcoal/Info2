class Palindrom {
	public static void main(String[] args) {
		int i = 0;
		if (args.length == 0)
			System.out.println("\nKeine Parameter übergeben!");
		else {
			int j;
			for (i = 0; i < args.length; i++) {
			j = palindrom(args[i]);
			if (j == 0)
				System.out.println(args[i] + " ist kein Palindrom\n");
			else 
				System.out.println(args[i] + " ist ein Palindrom\n");
			}
		}		
	}

	static int palindrom(String str) {
	int laenge = str.length();
	int vorne = 0;
	int hinten = laenge - 1;
	if (vorne >= hinten)
		return 1;
	else
		return 0;

	while (str.charAt(vorne) == str.charAt(hinten) && vorne <= hinten) {
		vorne++;
		hinten--;
	}

	}
}
