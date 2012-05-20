class Main {
    public static void main(String[] args) {
        Paket p1 = new Paket(15, 58, 13, 24);
        System.out.println(p1);
        Paket p2 = new Paket(17, 55, 13, 20);
        System.out.println(p2);
        if (p2.equals(p1)) 
        	System.out.println("Gleiche Paketklasse!");
    }
}