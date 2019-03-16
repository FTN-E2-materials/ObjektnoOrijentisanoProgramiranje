package z5;

public class Stavka {
	
	private String naziv;
	private double cena;
	
	public Stavka(String naziv, double cena) {
		this.naziv = naziv;
		this.cena = cena;
	}

	public String getNaziv() {
		return naziv;
	}

	public double getCena() {
		return cena;
	}

	@Override
	public String toString() {
		return naziv + " " + cena;
	}

}
