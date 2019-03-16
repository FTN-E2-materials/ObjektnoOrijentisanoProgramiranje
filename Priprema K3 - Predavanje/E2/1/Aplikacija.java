package podaci;

public class Aplikacija {

	private String naziv;
	private double zauzetaMemorija;
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getZauzetaMemorija() {
		return zauzetaMemorija;
	}
	public void setZauzetaMemorija(double zauzetaMemorija) {
		this.zauzetaMemorija = zauzetaMemorija;
	}
	@Override
	public String toString() {
		return "Naziv - " + naziv + " Memorija - " + zauzetaMemorija;
	}
	public Aplikacija(String naziv, double zauzetaMemorija) {
		super();
		this.naziv = naziv;
		this.zauzetaMemorija = zauzetaMemorija;
	}
	public Aplikacija() {
		super();
		naziv = "Nova aplikacija";
		zauzetaMemorija = 123.4;
		// TODO Auto-generated constructor stub
	}
	
	
}
