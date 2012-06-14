import java.util.Vector;
import java.util.Iterator;


public class PaketeContainer implements Iterable<Paket>{

	private PaketeDatenhaltung store;
	private boolean isFirstLoad = true;
	private static PaketeContainer unique=null;
	public Vector<Paket> allePakete = new Vector<Paket>();
	
	private PaketeContainer(){
		store = new PaketeDatenbank();
		store.load(this);
		isFirstLoad=false;
	}
	
	public static PaketeContainer instance(){
		if (unique == null){
			unique = new PaketeContainer();
		}
		return unique;
	}
	
	public void addPaket(Paket p){
		if(!allePakete.contains(p)){
			allePakete.addElement(p);
			if(!isFirstLoad)
				store.add(p);
		}
		else
			System.out.println("Die Sendungsnummer "+p.getSendungsnummer()+" ist bereits vorhanden!");
	}
	
	public void deletePaket(Paket p){
		if(allePakete.removeElement(p)){
			store.delete(p);
		}
	}
	
	public void modifyPaket(Paket p){
		store.modify(p);
	}

	public Paket getPaket(int pos){
		return allePakete.elementAt(pos);
	}
	
	public Iterator<Paket> iterator(){
		return allePakete.iterator();
	}

	public PaketeDatenhaltung getStore() {
		return store;
	}

	public void setStore(PaketeDatenhaltung store) {
		this.store = store;
	}
	
}
