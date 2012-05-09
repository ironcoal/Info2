class BierTrinken {
	public static void main(String[] args) {
		Bier bier = new Bier("Riegele");
		bier.machAuf();
		bier.trinkeSchluck();
		System.out.println(bier.wievielIsNoDrin());
		while(bier.trinkeSchluck()) {
			System.out.println(bier.wievielIsNoDrin());
		}
	}
}