
interface PaketeDatenhaltung {
	public void save(PaketeContainer cont);
	public void load(PaketeContainer cont);
	public void modify(Paket p);
	public void add(Paket p);
	public void delete(Paket p);
}