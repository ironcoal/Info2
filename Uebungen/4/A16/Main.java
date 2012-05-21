class Main {
    public static void main(String[] args) {
        Paket p1 = new Paket(15, 58, 13, 24);
        System.out.println(p1);
        Paket p2 = new Paket(17, 20, 13, 18);
        System.out.println(p2);
        if (p2.equals(p1)) 
        	System.out.println("Gleiche Paketklasse!");
        else
        	System.out.println("Unterschiedliche Paketklasse!");
        Sperrgut s1 = new Sperrgut(2,2,2,3);
        Sperrgut s2 = new Sperrgut(20,20,30,5);
        System.out.println(s1);
        System.out.println(s2);
        
    }
}