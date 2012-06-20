

public class Trinker {
	private double bierResistenz;
	private double getrunkeneBier;
	private String name;

	public Trinker(String name, double bierResistenz) {
		this.name = name;
		this.bierResistenz = bierResistenz;
	}
	public String getName() {
		return this.name;
	}
	public double getGetrunkeneBier() {
		return this.getrunkeneBier;
	}
	public void trinke(double mengeInLiter) throws BetrunkenException {
		getrunkeneBier += mengeInLiter;
		System.out.println("  - " + getName() + " trinkt: " + mengeInLiter + " Liter");
		if (getGetrunkeneBier() > bierResistenz)
			throw new BetrunkenException(getName(), (int) getGetrunkeneBier());
	}
}