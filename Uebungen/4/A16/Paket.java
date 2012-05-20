class Paket() {
    private int laenge;
    private int breite;
    private int hoehe;
    private int gewicht;
    
    public Paket(int laenge, int breite, int hoehe, int gewicht) {
    
    }
    private boolean checkPaketdaten(int laenge, int breite, int hoehe, int gewicht) {
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
        return (o.typeOf(Paket) && (o.calcPaketklasse() == calcPaketklasse()));
    }
    public String toString() {
        int klasse = calcPaketklasse();
        if (klasse == 0)
            return "Sperrgut: Gewicht zu hoch";
        else if (klasse == 4)
            return "Sperrgut: Paket zu groß";
        else 
            return "Paketklasse: " +  klasse.toString();
    }