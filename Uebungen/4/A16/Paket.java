class Paket {

    public int laenge;
    public int breite;
    public int hoehe;
    public int gewicht;
    
    public Paket(int laenge, int breite, int hoehe, int gewicht) {
        if (this.checkPaketdaten(laenge, breite, hoehe, gewicht)) {
            this.laenge = laenge;
            this.breite = breite;
            this.hoehe = hoehe;
            this.gewicht = gewicht;
        } else
            System.out.println("Fehler - Paketattribute entsprechen nicht den Vorgaben!");
    }
    public boolean checkPaketdaten(int laenge, int breite, int hoehe, int gewicht) {
        return (laenge > 0 && breite > 0 && hoehe > 0 && gewicht > 0);
    }
    private int calcPaketklasse() {
        if (gewicht >= 25)
            return 0;
        int temp = Math.min(laenge, breite);
        int min = Math.min(temp, hoehe);
        temp = Math.max(laenge, breite);
        int max = Math.max(temp, hoehe);
        int sum = min + max;
        if (sum < 50)
            return 1;
        else if (sum < 100)
            return 2;
        else if (sum < 150)
            return 3;
        else
            return 4;
    }
    public boolean equals(Object o) {
        return ((o instanceof Paket) && (((Paket) o).calcPaketklasse() == this.calcPaketklasse()));
    }
    public String toString() {
        int klasse = calcPaketklasse();
        if (klasse == 0)
            return "Sperrgut: Gewicht zu hoch";
        else if (klasse == 4)
            return "Sperrgut: Paket zu gross";
        else 
            return "Paketklasse: " + klasse;
    }
}