class Bier {
	private String marke;
	private boolean geoeffnet;
	private double fuellmenge;

	public Bier () {
		geoeffnet = false;
		fuellmenge = 0.5;
		marke = "Augustiner Hell";
		System.out.println("Frisches Bier! Prost!");
	}

	public Bier (String marke) {
		geoeffnet = false;
		fuellmenge = 0.5;
		this.marke = marke;
		System.out.println("Frisches Bier! Prost!");		
	}
	public void machAuf() {
		geoeffnet = true;
		System.out.println("Öffne gutes, frisches " + marke);
	}
	public boolean trinkeSchluck() {
		if ((geoeffnet = true) && !(isSchoLeer())) {
			fuellmenge *= 10;
			fuellmenge = Math.round(fuellmenge);
			fuellmenge -= 1;
			fuellmenge /= 10;
			System.out.println("*Schluck*");
			return true;
		} else {
			System.out.println("Flasche ist entweder noch zu oder schon leer.");
			return false;
		}
	}
	public boolean isSchoLeer() {
		if (fuellmenge <= 0)
			return true;
		else
			return false;
	}
	public double wievielIsNoDrin() {
		return fuellmenge;
	}

}