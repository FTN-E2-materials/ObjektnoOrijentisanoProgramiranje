package model;

public class Predmet {

	private String naziv; 
	private int osvojeniBrojPoena; 
	
	public Predmet() {
		this.naziv="Objektno programiranje";
		this.osvojeniBrojPoena=100;
	}
	
	public Predmet(String naziv, int osvojeniBrojPoena) {
		this.naziv=naziv;
		this.osvojeniBrojPoena=osvojeniBrojPoena;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getOsvojeniBrojPoena() {
		return osvojeniBrojPoena;
	}

	public void setOsvojeniBrojPoena(int osvojeniBrojPoena) {
		this.osvojeniBrojPoena = osvojeniBrojPoena;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Predmet : "+naziv + " osvojeni broj poena : "+osvojeniBrojPoena;
		
	}
	
}
