
public class Paket {

	private String sendungsnummer;
	private int gewichtsklasse;
	private String status;
	
	public Paket(String sendungsnummer){
		setSendungsnummer(sendungsnummer);
	}

	public String getSendungsnummer() {
		return sendungsnummer;
	}

	public void setSendungsnummer(String sendungsnummer) {
		this.sendungsnummer = sendungsnummer;
	}
	
	public String toString(){
		return getSendungsnummer() + " (Gewichtsklasse: " + getGewichtsklasse() + " - Status: "+getStatus()+")";
	}
	
	public boolean equals(Object o){
		if(o instanceof Paket){
			Paket s = (Paket) o;
			if (s.getSendungsnummer().equals(this.getSendungsnummer())){
				return true;
			}
		}
		return false;
	}

	public int getGewichtsklasse() {
		return gewichtsklasse;
	}

	public void setGewichtsklasse(int gewichtsklasse) {
		this.gewichtsklasse = gewichtsklasse;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
