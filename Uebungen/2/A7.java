public class A7 {

	public static void main(String[] args) {
		String s;
		s = copy(args);
		System.out.println(s);
		s = backwards(s);
		System.out.println(s);
		s = code(s);
		System.out.println(s);
	}
	public static String copy(String[] liste) {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < liste.length; i++) {
			s.append(liste[i]);
			if (i < liste.length - 1)
				s.append(" ");
		}
		return s.toString();
	}
	public static String backwards(String s) {
		StringBuffer b = new StringBuffer(s);
		b.reverse();
		return b.toString();
	}
	public static String code(String s) {
		StringBuffer b = new StringBuffer();
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (Character.isLetter(c))
				if (c == 'Z' || c == 'z')
					c = (char) ((int) c - 25);
				else
					c++; 
			b.append(c);	
		}	
		return b.toString();
	}
}