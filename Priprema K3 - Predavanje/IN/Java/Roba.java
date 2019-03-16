public class Roba {
	private String marka = "Nike";
	private String naziv = "patike";
	private int tezinaKG = 1;
	
	public String getMarka() {
		return marka;
	}

	public String getNaziv() {
		return naziv;
	}

	public int getTezinaKG() {
		return tezinaKG;
	}
	
	public Roba() {
	}

	public Roba(String marka, String naziv, int tezinaKG) {
		this.marka = marka;
		this.naziv = naziv;
		this.tezinaKG = tezinaKG;
	}

	@Override
	public String toString() {
		return "(\"" + this.marka + "\", \"" + this.naziv + "\", " + this.tezinaKG + ")";       
	}
}
